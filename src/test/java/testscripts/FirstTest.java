package testscripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;


public class FirstTest extends BaseClass {
 
	@Test
	
	public void firstTest() throws InterruptedException {
		
		SoftAssert soft = new SoftAssert();
		
		home.clickGears();
		home.clickSkillraryDemoApp();
		web.switchToChildBrowser();
		
		soft.assertEquals(demoApp.getPageHeader(),"SkillRary-ECommerce");
		demoApp.mouseHoverToCourse(web);
		demoApp.clickSeleniumTraining();
		
		soft.assertEquals(selenium.getPageHeader(),"Selenium Training");
		selenium.doubleClickPlusButton(web);
		selenium.clickAddToCart();
		web.handleAlert();
		Thread.sleep(2000);
		soft.assertTrue(selenium.getItemAddedMessage().isDisplayed());
		
		soft.assertAll();
	}
	
}
