package com.jautuu.service.factory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.UUID;

public class UtilService {

	private static String OS = System.getProperty("os.name").toLowerCase();

	public static boolean isWindows() {
		return (OS.indexOf("win") >= 0);
	}

	public static boolean isUnix() {
		return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0);
	}

	/**
	 * @return
	 * @throws IOException 
	 * @throws Exception
	 */
	public static String savePath() throws IOException {
		File file = new File("reports/");
		String path = null;
		try {
			if (isWindows()) {
				path = file.getCanonicalPath().replace("\\", "\\\\").concat("\\");
			}else {
				path = file.getCanonicalPath().replace("\\", "/").concat("/");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}

	public static String getRandomEmail() {
		return "QA-" + UUID.randomUUID() + "@TEST.COM";
	}

	public static boolean setTestDataInFile(String TestData) {
		File log = new File("log.txt");
		try {
			if (!log.exists()) {
				log.createNewFile();
			}
			FileWriter fileWriter = new FileWriter(log, true);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write(TestData);
			bufferedWriter.newLine();
			bufferedWriter.close();
		} catch (IOException e) {
			System.out.println("COULD NOT LOG!!");
		}
		return true;
	}

	/**
	 * @param value
	 *            String like: $45,225.11
	 * @return double value as: 45225.11
	 */
	public static double setStringToDouble(String value) {
		String Label = value.trim().replaceAll("[$%,]", "");
		double discount = Double.parseDouble(Label);
		return discount;
	}

	/**
	 * @param amount
	 *            as String like: $12,352.00
	 * @return String like: 12352.00
	 */
	public static String setStringToStringFormatDouble(String amount) {
		return String.format("%.2f", new BigDecimal(amount.trim().replaceAll("[$,]", "")));
	}

	/**
	 * @param amount
	 *            Example: 12350.11
	 * @return
	 */
	public static String setDoubleToString(double amount) {
		return String.valueOf(amount);
	}

	/**
	 * @param amount
	 *            String Like a In Format, Example: 12
	 * @return in value like 12
	 */
	public static int setStringToInteger(String value) {
		return Integer.parseInt(value);
	}

	public static boolean isUrlAvailable(String siteUrl) throws Exception {
		URL url = new URL(siteUrl);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		try {
			connection.connect();
			if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
				System.err.println(connection.getResponseCode());
				return false;
			}
			connection.disconnect();
		} catch (Exception exp) {
			throw new Exception(exp.getMessage());
		}
		return true;
	}

}
