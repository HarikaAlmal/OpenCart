/**
 * 
 */
package com.opencart.utility;

import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

/**
 * @author harik
 *
 */
public class ExtentManager {


		
		public static ExtentSparkReporter htmlReporter;
		public static ExtentReports extent;
		public static ExtentTest test;
		
		public static void setExtent() throws IOException {
			System.out.println("im here");
			//htmlReporter= new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/ExtentReport/"+"MyReport_"+BaseClass.getCurrentTime()+".html");
			htmlReporter= new ExtentSparkReporter(System.getProperty("user.dir")+"\\test-output\\ExtentReport\\"+"MyReport.html");
			//htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"MyReport.html");
			System.out.println("im here2");
			htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"\\extent-config.xml");
			//htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"extent-config.xml");
			//htmlReporter.config().setDocumentTitle("Automation Test Report");
			//htmlReporter.config().setReportName("OrangeHRM Test Automation Report");
			//htmlReporter.config().setTheme(Theme.DARK);
			System.out.println("im here3");
			extent = new ExtentReports();
			extent.attachReporter(htmlReporter);
			
			extent.setSystemInfo("HostName", "MyHost");
			extent.setSystemInfo("ProjectName", "OpenCart");
			extent.setSystemInfo("Tester", "Harika");
			extent.setSystemInfo("OS", "Win11");
			extent.setSystemInfo("Browser", "Chrome");
		}
		public static void endReport() {
			System.out.println("im here4");
			extent.flush();
			System.out.println("im here5");
		}
	}
	
	

