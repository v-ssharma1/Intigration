package com.org.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.org.URIs.BaseUri;
//import org.testng.annotations.DataProvider;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.restassured.RestAssured;

public class TestBase {
	public static final Logger log = Logger.getLogger(TestBase.class.getName());
	public static TestBase dataSetup;
	public static Properties prop = new Properties();
	public static ExtentReports extent;
	public static ExtentTest test;
	public static int propSize;
	public static int countryID;
	public static String state;
	public static String city;
	public static String countryName;
	public static int id;
	public static String author;
	public static Double price;
	public static String title;
	public static int commentId;
	public static int postId;
	public static String body;
	public static String name;
	public static String firstName;
	public static String lastName;
	public static int age;
	public static String streetAddress;
	public static String City;
	public static String postalCode;
	public static String type;
	public static String number;

	// This method will be called in for every e2e test cases in before class.
	public void init() {
		String log4jConfPath = "log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
	}

	// Read Property file
	public static void loadData() throws IOException {
		String filepath = System.getProperty("user.dir") + "/src/main/java/com/org/Resources/Data/data.properties";
		try {
			FileInputStream inputStream = new FileInputStream(filepath);
			prop.load(inputStream);
			propSize = prop.size();
			countryID = Integer.parseInt(prop.getProperty("countryID"));
			state = prop.getProperty("state");
			city = prop.getProperty("city");
			countryName = prop.getProperty("country_name");
			id = Integer.parseInt(prop.getProperty("id"));
			author = prop.getProperty("author");
			title = prop.getProperty("title");
			price = Double.parseDouble(prop.getProperty("price"));
			commentId = Integer.parseInt(prop.getProperty("commentId"));
			postId = Integer.parseInt(prop.getProperty("postId"));
			author = prop.getProperty("body");
			name = prop.getProperty("name");
			firstName = prop.getProperty("firstName");
			lastName = prop.getProperty("LastName");
			age = Integer.parseInt(prop.getProperty("age"));
			streetAddress = prop.getProperty("streetAddress");
			City = prop.getProperty("City");
			postalCode = prop.getProperty("postalCode");
			type = prop.getProperty("type");
			number = prop.getProperty("number");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	// Static block to make single new Extent report for every class
	static {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		// here you are passing the path of the folder where you want to create Extent
		// report and boolean value true means you wants to override your report for
		// every run.
		extent = new ExtentReports(System.getProperty("user.dir") + "/src/main/java/com/org/ExtentReport/"
				+ formater.format(calendar.getTime()) + ".html", true);
	}

	// get result method for extent class
	public void getResult(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(LogStatus.PASS, result.getName() + " test is passed.");
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(LogStatus.SKIP,
					result.getName() + " test is skiped and the reason is :--> " + result.getThrowable());
		} else if (result.getStatus() == ITestResult.FAILURE) {
			test.log(LogStatus.ERROR,
					result.getName() + " test is failed and the reason is :-->" + result.getThrowable());
		} else if (result.getStatus() == ITestResult.STARTED) {
			test.log(LogStatus.INFO, result.getName() + " test is started.");
		}
	}

	// @DataProvider(name = "Auth")
	// public static Object[][] dataProvider() throws IOException {
	// dataSetup = new TestBase();
	// loadData();
	// Object[][] dataproviderForAuths = new Object[1][propSize];
	// dataproviderForAuths[0][0] = consumerKey;
	// dataproviderForAuths[0][1] = consumerSecret;
	// dataproviderForAuths[0][2] = AccessToken;
	// dataproviderForAuths[0][3] = AccessTokenSecret;
	// dataproviderForAuths[0][4] = baseURI.baseUri;
	// return dataproviderForAuths;
	// }

	@BeforeClass
	public void setBaseURI() throws IOException {
		RestAssured.baseURI = BaseUri.baseUri;
		//bacis Authentication 
		RestAssured.authentication = RestAssured.preemptive().basic("ToolsQA", "TestPassword");
		try {
			loadData();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@AfterMethod()
	public synchronized void afterMethod(ITestResult result) {
		getResult(result);
	}

	@BeforeMethod()
	public synchronized void beforeMethod(Method result) {
		test = extent.startTest(result.getName());
		test.log(LogStatus.INFO, result.getName() + " test Started");
	}

	@AfterClass(alwaysRun = true)
	public synchronized void endTest() {
		extent.endTest(test);
		extent.flush();
	}
}
