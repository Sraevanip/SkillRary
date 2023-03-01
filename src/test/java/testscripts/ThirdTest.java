package testscripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;

public class ThirdTest extends BaseClass{
	
	@Test	
	public void thirdTest() throws InterruptedException {
		SoftAssert soft = new SoftAssert();
		
		home.searchFor("core java for selenium");
		soft.assertEquals(coreJava.getPageHeader(),"CORE JAVA FOR SELENIUM");
		
		coreJava.clickCoreJavaForSeleniumLink();
		soft.assertEquals(javaVideo.getPageHeader(),"Core Java For Selenium Training ");
		
		javaVideo.clickCloseCookies();
		web.switchToFrame();
		javaVideo.clickPlayButton();
		Thread.sleep(2000);
		javaVideo.clickPauseButton();
		
		web.switchBackFromFrame();
		
		javaVideo.clickAddToWishList();
		
		soft.assertAll();
		
		
		
	}

}
