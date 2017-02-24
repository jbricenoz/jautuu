package com.jautuu.driver.factory;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.jautuu.service.factory.UtilService;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;

public class WebDriverFactory {

	protected static final String USERNAME = "josemara";
	protected static final String AUTOMATE_KEY = "ET2reGrGWyNyJMTm5vv3";
	private static Process proccessBrowserStackLocal;
	private static String fileLocation;
	private static String fileLocationLinux;

	public static enum Browser {
		FIREFOX, CHROME, IE, SAFARI
	}

	public static enum Environment {
		DEV("http://www.google.com"), QA("http://ms-dev.internal.mcmcg.com/"), QA_AUTO("http://localhost:3000");

		private final String url;

		private Environment(final String url) {
			this.url = url;
		}

		public String getUrl() {
			return url;
		}
	}

	public static WebDriver createDriver(Environment environment, Browser browser) throws Exception {
		WebDriver driver = null;
		switch (browser) {
		case CHROME:
			ChromeDriverManager.getInstance().setup("2.21");
			driver = new ChromeDriver();
			break;
		case FIREFOX:
			driver = new FirefoxDriver();
			break;
		case IE:
			InternetExplorerDriverManager.getInstance().setup("2.51");
			driver = new InternetExplorerDriver();
			break;
		default:
			throw new Exception("Option Not Available");
		}
		driver.manage().window().maximize();
		driver.get(environment.getUrl());
		return driver;
	}

	public static WebDriver createDriver(String environment, Browser browser) throws Exception {
		WebDriver driver = null;
		switch (browser) {
		case CHROME:
			ChromeDriverManager.getInstance().setup("2.21");
			driver = new ChromeDriver();
			break;
		case FIREFOX:
			driver = new FirefoxDriver();
			break;
		case IE:
			InternetExplorerDriverManager.getInstance().setup("2.51");
			driver = new InternetExplorerDriver();
			break;
		default:
			throw new Exception("Option Not Available");
		}
		driver.manage().window().maximize();
		driver.get(environment);
		return driver;
	}

	public static WebDriver createRemoteDriver(URL targetUrl, Browser browser, String browserVersion, String OS,
			String OSVersion) throws Exception {
		String BrowserStackConectionUrl = "http://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
		DesiredCapabilities caps = new DesiredCapabilities();
		WebDriver driver = null;
		switch (browser) {
		case CHROME:
			caps.setCapability("browser", "Chrome");
			caps.setCapability("browser_version", browserVersion);
			break;
		case FIREFOX:
			caps.setCapability("browser", "Firefox");
			caps.setCapability("browser_version", browserVersion);
			break;
		case IE:
			caps.setCapability("browser", "IE");
			caps.setCapability("browser_version", browserVersion);
			caps.setCapability("ie.usePerProcessProxy", true);
			break;
		default:
			throw new Exception("Option Not Available");
		}
		caps.setCapability("browserstack.local", "true");
		caps.setCapability("os_version", OSVersion.toUpperCase());
		caps.setCapability("os", OS);
		caps.setCapability("resolution", "1024x768");
		caps.setCapability("browserstack.debug", "true");
		try {
			driver = new RemoteWebDriver(new URL(BrowserStackConectionUrl), caps);
			driver.manage().window().maximize();
			driver.get(targetUrl.toString());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return driver;
	}

	private static boolean isPortAvailable(int port) {
		try (Socket ignored = new Socket("localhost", port)) {
			return true;
		} catch (IOException ignored) {
			return false;
		}
	}

	public static void setUpLocalRemote() throws InterruptedException, IOException {
		if (isPortAvailable(45691)) {
			System.out.println("Browser Stack tool started successfully ...");
			return;
		}
		fileLocation = new File("src/test/resources/").getCanonicalPath().replace("\\", "\\\\").concat("\\\\");
		fileLocationLinux = new File("src/test/resources/").getCanonicalPath().replace("\\", "/").concat("/");
		System.out.println(fileLocationLinux.toString());
		Runnable task = () -> {
			ProcessBuilder builder = null;
			String command = null;
			try {
				if (UtilService.isWindows()) {
					command = "cd " + fileLocation.concat(" && BrowserStackLocal.exe " + AUTOMATE_KEY + " -forcelocal");
					builder = new ProcessBuilder("cmd.exe", "/c", command);
				} else {
					command = "cd " + fileLocationLinux.concat(
							" && chmod 777 BrowserStackLocal && ./BrowserStackLocal --key " + AUTOMATE_KEY );
					builder = new ProcessBuilder("bash", "-c", command);
				}
				builder.redirectErrorStream(true);

				proccessBrowserStackLocal = builder.start();

				try (BufferedReader r = new BufferedReader(
						new InputStreamReader(proccessBrowserStackLocal.getInputStream()));) {
					String line;
					while ((line = r.readLine()) != null) {
						System.out.println(line);
						if (line.contains("Press Ctrl-C")) {
							break;
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Unable to start Browser Stack tool.  Exception: [" + e.getMessage() + "]");
			}
		};
		task.run();
		if (UtilService.isWindows()) {
			while (!isPortAvailable(45691)) {
				System.out.println("Waiting for Browser Stack tool to start...");
				Thread.sleep(1000);
			}
		}
		System.out.println("Browser Stack tool started successfully...");
	}

	public static void shutdownLocalRemote() throws IOException, InterruptedException {
		if (proccessBrowserStackLocal != null && proccessBrowserStackLocal.isAlive()) {
			System.out.println("Browser Stack tool is shutting down... ");
			if (UtilService.isWindows()) {
				Runtime.getRuntime().exec("taskkill /f /im BrowserStackLocal.exe");
			} else {
				Runtime.getRuntime().exec("pkill -9 -f BrowserStackLocal");
			}
			proccessBrowserStackLocal.waitFor();
			System.out.println("Browser Stack tool is closed... ");
		}
	}
}
