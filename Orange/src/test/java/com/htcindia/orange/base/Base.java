package com.htcindia.orange.base;

import java.io.File;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.htcindia.orange.config.properties.ConfigHolder;
import com.htcindia.orange.drivers.DriverFactory;
import com.htcindia.orange.helpers.ExcelUtility;
import com.htcindia.orange.helpers.MyException;
import com.htcindia.orange.helpers.SnapShot;
import com.htcindia.orange.pages.AdminUserManagementPage;
import com.htcindia.orange.pages.DashboardPage;
import com.htcindia.orange.pages.LoginPage;

public class Base 
{

	/* <---------- Page objects ---------> */
	protected static LoginPage loginPage;
	protected static DashboardPage dashboardpage;
	protected static AdminUserManagementPage adminusermanagementPage;
	
	

	/* <---------- Log4j Instance ---------> */
	public static Logger Log;

	/* <---------- Configuration Properties Instance ---------> */
	public static ConfigHolder config;

	/* <---------- Driver Instances ---------> */
	public  DriverFactory dFactory;
	private WebDriver webDriver;
	
	/* <---------- Database Instances ---------> 
	public static Connection connect;
	public static Statement stment;*/
	
	/*<--No instance required for Excel sheet reader since all methods are static. 
	 * Call methods with class name -->*/

	/* <---------- Property Variables ---------> */
	public static String typeOfBrowser;
	public static String nameOfBrowser;
	public static String driverFilesDirectory;
	public static String snapShotsDirectory;

	public ThreadLocal<WebDriver> browser = new ThreadLocal<WebDriver>();

	/* <---------- SnapShot Instance ---------> */
	
	public static ThreadLocal<SnapShot> snap=new ThreadLocal<SnapShot>();
	
	/* <---------- ExcelUtility Instance ---------> */
	public static ExcelUtility excelReader;
	
	/* <---------- Extent report Instance ---------> */
	protected static String customValue;
	protected ExtentHtmlReporter htmlReporter;
	
	protected static  ExtentReports extentReport ;
	protected static ThreadLocal<ExtentTest> parentTestCase = new ThreadLocal<>();
	protected static ThreadLocal<ExtentTest> testCase = new ThreadLocal<>();
	
	File file;

	/* <---------- Set Current Date ---------> */
	protected void setDate() {
		Date lDate = new Date();
		System.setProperty("date", lDate.toString().replace(":", "_").replace(" ", "_"));
	}

	protected void setLog4j(String projName) {
		/* <---------- Initializing Log4j ---------> */
		Log = LogManager.getLogger(projName);
	}

	protected void gatherConfigProperties() throws MyException {
		Log.info("Gathering Configuration Properties...");

		/* <---------- ConfigHolder Singleton Instance ---------> */
		config = ConfigHolder.getInstance();
		/* <---------- User Properties ---------> */
		typeOfBrowser = config.properties.get("browserType");
		nameOfBrowser = config.properties.get("browserName");
		driverFilesDirectory = config.properties.get("driverFilesPath");
		snapShotsDirectory = config.properties.get("snapShotsPath");

		Log.info("Successfully Gathered Configuration Properties...");
	}

	protected void trigger(String browserType, String browserName, String driverPathOrHubURL)
			throws MalformedURLException, MyException {
		Log.info("Initialization Of Driver Factory Begins...");
	
		/* <---------- DriverFactory Singleton Instance ---------> */
		dFactory = DriverFactory.getInstance();
		/* <---------- Launch Local (Or) Remote Browser Session ---------> */
		webDriver = dFactory.getDriver(browserType, driverPathOrHubURL).launch(browserName);
		setBrowser(webDriver);
		getBrowser().manage().window().maximize();
		snap.set(new SnapShot(snapShotsDirectory, getBrowser()));
		Log.info("Successfully Launched " + browserType + ":" + browserName);
	}
	
	

	protected void initializeTestReport() throws MyException {
		setCustomValue(config.properties.get("reportName") + "_" + getdate());
		/* <---------- Creating extent report in specified location ---------> */
		htmlReporter = new ExtentHtmlReporter(config.properties.get("reportPath")
				+ getCustomValue() + ".html");
		htmlReporter.config().setReportName(config.properties.get("reportDocumentName"));
		htmlReporter.config().setTheme(Theme.STANDARD);
		extentReport = new ExtentReports();
		extentReport.attachReporter(htmlReporter);
	}
	
	
	public String getProjectPath() {
		return System.getProperty("user.dir");
	}


	public static String getdate() {
		String dateName = new SimpleDateFormat("ddMMyyyy-HH.mm.ss").format(new Date());
		return dateName;
	}
	
	private void setBrowser(WebDriver driver) {
		browser.set(driver);
		Log.info("Thread Safe WebDriver Instance is Set...");
	}

	public WebDriver getBrowser() {
		return browser.get();
	}
	

	public ExtentTest getParentTestCase() {
		return parentTestCase.get();
	}

	public void setParentTestCase(ExtentTest parentTest) {
		parentTestCase.set(parentTest); 
	}

	public ExtentTest getTestCase() {
		return testCase.get();
	}

	public void setTestCase(ExtentTest test) {
		testCase.set(test);
	}
	
	public static String getCustomValue() {
		return customValue;
	}

	public static void setCustomValue(String customValue) {
		Base.customValue = customValue;
	}

}
