package com.jautuu.test.suite;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import org.testng.annotations.Test;

import com.jautuu.service.factory.UtilService;

public class Cleanner {

	private static String pathWindows;
	private static String pathLinux;
	private static Process proccess;

	@Test
	public void clean() throws IOException {
		pathWindows = new File("/").getCanonicalPath().replace("\\", "\\\\").concat("\\\\");
		pathLinux = new File("./").getCanonicalPath().replace("\\", "/").concat("/");
		System.out.println(pathLinux.toString());
		Runnable task = () -> {
			ProcessBuilder builder = null;
			String command = null;
			try {
				if (UtilService.isWindows()) {
					command = "cd " + pathWindows.concat(" && rmdir screenshots && rmdir reports");
					builder = new ProcessBuilder("cmd.exe", "/c", command);
				} else if (UtilService.isUnix()) {
					command = "cd " + pathLinux.concat(" && rm -R screenshots && rm -R reports");
					// command = "cd " + pathLinux.concat(" && rm -rvf ExecutionReport.html");
					builder = new ProcessBuilder("bash", "-c", command);
				}
				builder.redirectErrorStream(true);

				proccess = builder.start();

				try (BufferedReader r = new BufferedReader(new InputStreamReader(proccess.getInputStream()));) {
					String line;
					while ((line = r.readLine()) != null) {
						System.out.println(line);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Ok we have a problem.  Exception: [" + e.getMessage() + "]");
			}
		};
		task.run();
	}
}
