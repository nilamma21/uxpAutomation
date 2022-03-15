package pageObjects.AtlantaApparel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ATLAppExhibitorsAndProductTabPage 
{

	public WebDriver driver;
	public WebDriverWait wait;

	By atlaappfloorplans = By.xpath("//div[@class ='imc-navigation__menu imc-content imc-navigation__menu--active imc-navigation__menu--fullwidth']/div[2]/div[1]/a[1]"); //Locator for Floor Plans header tab
	By atlaappCategories = By.xpath("//div[@class ='imc-navigation__menu imc-content imc-navigation__menu--active imc-navigation__menu--fullwidth']/div[3]/div[1]/a[1]");

	public ATLAppExhibitorsAndProductTabPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
	} 

	public WebElement getATLAppFloorplans()throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlaappfloorplans));
		return driver.findElement(atlaappfloorplans);
	}
	public WebElement getATLAppatlaappCategories()throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlaappCategories));
		return driver.findElement(atlaappCategories);
	}
}
