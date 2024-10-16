package pageObjects.LasVegasMarket;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UXPLoginPage {
	public WebDriver driver;
	public WebDriverWait wait;
	
	By emailaddress = By.xpath("//input[@id='signInName']"); //Locator for field to enter Email Address from Login Page
	By password= By.xpath("//input[@id='password']"); //Locator for field to enter Password from Login Page
	By signinbtn= By.xpath("//button[@id='next']"); //Locator for field to click on Sign In button from Login Page
	
	public UXPLoginPage(WebDriver driver) {
		this.driver = driver; 			
	} 
	
	public WebElement getEmailAddress() {
		//Wait till Sign In page is displayed
	  wait = new WebDriverWait(driver, Duration.ofSeconds(40));
      wait.until(ExpectedConditions.elementToBeClickable(emailaddress));
		return driver.findElement(emailaddress);		
	}
	
	public WebElement getPassword() {
		//Wait till Sign In page is displayed
	  wait = new WebDriverWait(driver, Duration.ofSeconds(40));
      wait.until(ExpectedConditions.elementToBeClickable(password));
		return driver.findElement(password);		
	}
	
	public WebElement getSignInBtn() {
		//Wait till Sign In page is displayed
	  wait = new WebDriverWait(driver, Duration.ofSeconds(40));
      wait.until(ExpectedConditions.elementToBeClickable(signinbtn));
		return driver.findElement(signinbtn);		
	}

}


