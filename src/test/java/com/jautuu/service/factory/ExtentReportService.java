package com.jautuu.service.factory;

import java.io.IOException;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentReportService {
	
	public static ExtentReports getInstance() throws IOException {
		ExtentReports extent;
		String path = UtilService.savePath().concat("ExecutionReport.html");
		extent = new ExtentReports(path, false);
		extent.addSystemInfo("Selenium ", "V 2.52.0");
		extent.addSystemInfo("Platform ", "Windows 7");
		return extent;
	}
	

}
