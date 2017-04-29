package com.mcmcg.gbs.bluefin.service.factory;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class WebDriverService {

	public static boolean captureScreenShot(String FileName, WebDriver baseDriver) throws IOException {
	    File screenshotFile=((TakesScreenshot)baseDriver).getScreenshotAs(OutputType.FILE);
	    if (UtilService.isWindows()) {
	    	  FileUtils.copyFile(screenshotFile,new File("screenshots\\"+FileName+""+getTimeStampValue()+".png"), true);
		}else if (UtilService.isUnix()) {
			  FileUtils.copyFile(screenshotFile,new File("screenshots/"+FileName+""+getTimeStampValue()+".png"), true);
		}
	    return true;
	}
	
	public static boolean captureScreenShot(String FileName, String ClassName, WebDriver baseDriver) throws IOException {
	    File screenshotFile=((TakesScreenshot)baseDriver).getScreenshotAs(OutputType.FILE);
	    if (UtilService.isWindows()) {
	    	 FileUtils.copyFile(screenshotFile,new File("screenshots\\"+ ClassName +"\\"+FileName+""+getTimeStampValue()+".png"), true);
		}else if (UtilService.isUnix()) {
			 FileUtils.copyFile(screenshotFile,new File("screenshots/"+ ClassName +"/"+FileName+""+getTimeStampValue()+".png"), true);
		}
	    return true;
	}
	
	public static String takeScreenShot(String FileName, String FolderName, WebDriver baseDriver) throws IOException {
		File file = new File("Screenshots\\");
		String fileName = FileName + getTimeStampValue()+".png";
		String dir =  null;
		if (UtilService.isWindows()) {
			dir = file.getCanonicalPath().replace("\\", "\\\\").concat("\\\\")+FolderName+"\\\\";
		}else if (UtilService.isUnix()) {
			dir = file.getCanonicalPath().replace("\\", "/")+FolderName+"/";
		}
	    File screenshotFile=((TakesScreenshot)baseDriver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(screenshotFile,new File(dir+fileName), true);
	    String destination = dir + fileName;
	    return destination;
	}
	
	public static String getTimeStampValue()throws IOException{
	    Calendar cal = Calendar.getInstance();       
	    Date time=cal.getTime();
	    String timestamp = time.toString().replace(":", "-").replaceAll("\\s+","");
	    return timestamp;
	}
	
}
