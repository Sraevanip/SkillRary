package genericLibraries;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pomPages.ContactUsPage;
import pomPages.CoreJavaForSeleniumPage;
import pomPages.CoreJavaVideoPage;
import pomPages.HomePage;
import pomPages.SeleniumTrainingPage;
import pomPages.SkillraryDemoAppPages;
import pomPages.TestingPage;

public class BaseClass {
    
	protected PropertiesUtility property;
	protected ExcelUtility excel ;
	protected WebDriverUtility web;
	protected WebDriver driver;
	protected HomePage home;
	protected SkillraryDemoAppPages  demoApp;
	protected SeleniumTrainingPage selenium;
	protected CoreJavaForSeleniumPage coreJava;
	protected CoreJavaVideoPage javaVideo;
	protected TestingPage testing;
	protected ContactUsPage contact;
	
	
	//@BeforeSuite
	//@BeforeTest
	
	
	@BeforeClass
	public void classConfiiguration() {
		property = new PropertiesUtility();
		excel= new ExcelUtility();
		 web= new WebDriverUtility();
		 
		 property.propertiesInitialization(IConstantPath.PROPERTIES_FILE_PATH);
		 excel.excelInitialization(IConstantPath.EXCEL_FILE_PATH);
	}
	
	
	@BeforeMethod
	public void methodConfiguration() {
		long time = Long.parseLong(property.fetchProperty("timeouts"));
		driver = web.openApplication(property.fetchProperty("browser"),property.fetchProperty("url"),time);
		
		home = new HomePage(driver);
		Assert.assertTrue(home.getLogo().isDisplayed());
		demoApp = new  SkillraryDemoAppPages(driver);
		selenium = new  SeleniumTrainingPage(driver);
		testing = new  TestingPage(driver);
		coreJava = new CoreJavaForSeleniumPage(driver);
		javaVideo = new  CoreJavaVideoPage(driver);
		contact = new ContactUsPage(driver);
		      
	}
	
	
	@AfterMethod
	public void methodTeardown() {
		web.quitBrowser();
	}
	
	
	@AfterClass
	public void classTeardown() {
		excel.closeExcel();
	}
	
}
