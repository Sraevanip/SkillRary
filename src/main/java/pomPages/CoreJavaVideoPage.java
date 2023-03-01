 package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoreJavaVideoPage {

	//declaration
	@FindBy(xpath = "//h1")
	private WebElement pageHeader;
	@FindBy(xpath = "//button[@aria-label='Play']")
	private WebElement playButton;
	@FindBy(xpath = "//button[@aria-label='Pause']")
	private WebElement pauseButton;
	@FindBy(xpath = "//span[text()='Add To Wishlist']")
	private WebElement addToWishListTab;
	@FindBy(xpath = "//a[@class='close_cookies']")
	private WebElement closeCookiesIcon;
	
	//initialization
	public CoreJavaVideoPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	//utilization
	public String getPageHeader() {
		return pageHeader.getText();
	}
	
	public void clickPlayButton() {
		playButton.click();
	}
	
	public void clickPauseButton() {
		pauseButton.click();
	}
	
	
	public void clickAddToWishList() {
		addToWishListTab.click();
	}
	
	public void clickCloseCookies() {
		closeCookiesIcon.click();
	}
	
	
	
}
