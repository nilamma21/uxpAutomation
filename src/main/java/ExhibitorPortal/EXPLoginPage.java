package ExhibitorPortal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EXPLoginPage {

	public WebDriver driver;
	public WebDriverWait wait;
	
	By emailaddress = By.xpath("//input[@id='signInName']"); //Locator for field to enter Email Address from Login Page
	By password= By.xpath("//input[@id='password']"); //Locator for field to enter Password from Login Page
	By signinbtn= By.xpath("//button[@id='next']"); //Locator for field to click on Sign In button from Login Page
	By VerifyExpHomePage = By.xpath("//header[@class = 'EPHeader_header__bLMVK']"); //Locator for exhibitor portal header tabs
	By HomeIcon = By.xpath("//svg[contains(id(), 'Capa' ]"); //Locator for Home icon
	
	public EXPLoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
	} 
	
	public WebElement getEmailAddress() {
		//Wait till Sign In page is displayed
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(emailaddress));
		return driver.findElement(emailaddress);		
	}
	
	public WebElement getPassword() {
		//Wait till Sign In page is displayed
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(password));
		return driver.findElement(password);		
	}
	
	public WebElement getSignInBtn() {
		//Wait till Sign In page is displayed
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(signinbtn));
		return driver.findElement(signinbtn);		
	}

	public WebElement getVerifyExpHomePage() {
		//Wait till Sign In page is displayed
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(VerifyExpHomePage));
		return driver.findElement(VerifyExpHomePage);		
	}
	
	public WebElement getHomeIcon() {
		//Wait till Sign In page is displayed
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(HomeIcon));
		return driver.findElement(HomeIcon);		
	}

}
