package genericLibraries;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class contains reusable methods of WebDriver
 * @author Sulochana
 *
 */
public class WebDriverUtility {
    
	private WebDriver driver;
	
	/**
	 * this method is used to navigate to an application using user desired browser
	 * @param browser
	 * @param url
	 * @param time
	 * @return
	 */
	public WebDriver openApplication(String browser , String url , long time) {
		switch(browser){
		
		case "chrome" : driver = new ChromeDriver();break;
		case "edge" : driver = new EdgeDriver();break;
		default : System.out.println("invalid browser data");	
		}
		
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
		
		return driver;
	}
	
	/**
	 * This method is used to wait until the visibility of particular element
	 * @param element
	 * @param time
	 * @return
	 */
	public WebElement explicitWait(WebElement element, long time) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
		return wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	/**
	 * This method is used to perform mouse hover on an element
	 * @param element
	 */
	
	public void mouseHover(WebElement element) {
		Actions a = new Actions(driver);
		a.moveToElement(element).perform();
	}
	
	/**
	 * This method is used to perform double click on an element
	 * @param element
	 */
	public void doubleClickOnElement(WebElement element) {
		Actions a = new Actions(driver);
		a.doubleClick(element).perform();
	}
	
	/**
	 * this method is used to perform drag and drop of an element
	 * @param source
	 * @param target
	 */
	public void dragAndDropElement(WebElement source , WebElement target) {
		Actions a = new Actions(driver);
		a.dragAndDrop(source,target).perform();
	}
	/**
	 * this method is used to perform drop down of an element based on index
	 * @param element
	 * @param index
	 */
	
	public void dropdown(WebElement element ,int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}
	
	/**
	 * this method is used to perform drop down of an element based on text
	 * @param element
	 * @param text
	 */
	public void dropdown(WebElement element ,String text) {
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}
	
	/**
	 * this is used to perform drop down of an element based on value
	 * @param value
	 * @param element
	 */
	public void dropdown(String value ,WebElement element ) {
		Select s = new Select(element);
		s.selectByValue(value);
	}
	
	/**
	 * this method is used to perform scroll ro element
	 * @param element
	 */
	public void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}
	
	/**
	 * this method is used to take screenshot of web page
	 */
	public void takeScreenshot() {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./Screenshot/screenshot.png");
		try {
			FileUtils.copyFile(src,dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * this method id used to handle alert pop up
	 */
	public void handleAlert() {
		driver.switchTo().alert().accept();
	}
	
	/**
	 * this method is used to switch the browser to child browser
	 */
	public void switchToChildBrowser() {
		Set<String> set = driver.getWindowHandles();
		for(String windowID: set) {
			driver.switchTo().window(windowID);
		}
	}
	
	/**
	 * this method is used to switch  the frame
	 */
	public void switchToFrame() {
		driver.switchTo().frame(0);
	}
	
	/**
	 * this method is used to switch back form frame 
	 */
	public void switchBackFromFrame() {
		driver.switchTo().defaultContent();
	}
	
	/**
	 * this method is used to close the window
	 */
	public void closeCurrentWindow() {
		driver.close();
	}
	
	/**
	 * this method is used to quit the browser
	 */
	public void quitBrowser() {
		driver.quit();
	}
}
