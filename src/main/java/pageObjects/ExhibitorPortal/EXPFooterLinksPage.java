package pageObjects.ExhibitorPortal;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EXPFooterLinksPage {
	
	public WebDriver driver;
	public WebDriverWait wait;

	By ExhibitorPortalSymbol = By.xpath("//a[@href='/']/img"); // Locator for EXP Symbol
	By AmericasMart = By.xpath("//div[@id = 'root']/footer[1]/div[1]/div[2]/div[1]/div[1]/a[1]"); // Locator for Americas Mart link
	By AtlantaMarket = By.xpath("//div[@id = 'root']/footer[1]/div[1]/div[2]/div[1]/div[1]/a[2]"); // Locator for Atlanta Market link
	By AtlantaApparel = By.xpath("//div[@id = 'root']/footer[1]/div[1]/div[2]/div[1]/div[1]/a[3]"); // Locator for Atlanta Apparel link
	By ADAC = By.xpath("//div[@id = 'root']/footer[1]/div[1]/div[2]/div[1]/div[1]/a[4]"); // Locator for ADAC link
	By HighPointMarket = By.xpath("//div[@id = 'root']/footer[1]/div[1]/div[2]/div[1]/div[1]/a[5]"); // Locator for High Point Market link
	By LasVegasMarket = By.xpath("//div[@id = 'root']/footer[1]/div[1]/div[2]/div[1]/div[1]/a[7]"); // Locator for Las Vegas Market link
	By LasVegasDesignCenter = By.xpath("//div[@id = 'root']/footer[1]/div[1]/div[2]/div[1]/div[1]/a[8]"); // Locator for Las Vegas Design Center link
	By PrivacyPolicy = By.xpath("//div[@id = 'root']/footer[1]/div[1]/div[2]/div[1]/div[2]/a[1]"); // Locator for Privacy Policy link
	By TermsAndConditions = By.xpath("//div[@id = 'root']/footer[1]/div[1]/div[2]/div[1]/div[2]/a[2]"); // Locator for Terms And Conditions link
	By AboutIMC = By.xpath("//div[@id = 'root']/footer[1]/div[1]/div[2]/div[1]/div[2]/a[3]"); // Locator for About IMC link
	By LasVegasApparel = By.xpath("//div[@id='root']/footer/div/div[2]/div/div[1]/a[6]"); // Locator for Las Vegas Market link
	By andmore = By.xpath("//div[@id = 'root']/footer[1]/div[1]/div[2]/div[1]/div[2]/a[3]"); //Locator for ANDMORE in footer links

	
	public EXPFooterLinksPage(WebDriver driver) {
		this.driver = driver; 			
	} 

	public WebElement getExhibitorPortalSymbol() throws InterruptedException {
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(ExhibitorPortalSymbol));
		return driver.findElement(ExhibitorPortalSymbol);

	}
	
	public WebElement getAmericasMart() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(AmericasMart));
		return driver.findElement(AmericasMart);

	}
	
	public WebElement getAtlantaMarket() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(AtlantaMarket));
		return driver.findElement(AtlantaMarket);

	}
	
	public WebElement getAtlantaApparel() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(AtlantaApparel));
		return driver.findElement(AtlantaApparel);

	}
	
	public WebElement getADAC() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(ADAC));
		return driver.findElement(ADAC);

	}
	
	public WebElement getHighPointMarket() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(HighPointMarket));
		return driver.findElement(HighPointMarket);

	}
	
	public WebElement getLasVegasMarket() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(LasVegasMarket));
		return driver.findElement(LasVegasMarket);

	}
	
	public WebElement getLasVegasDesignCenter() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(LasVegasDesignCenter));
		return driver.findElement(LasVegasDesignCenter);

	}
	
	public WebElement getPrivacyPolicy() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(PrivacyPolicy));
		return driver.findElement(PrivacyPolicy);

	}
	
	public WebElement getTermsAndConditions() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(TermsAndConditions));
		return driver.findElement(TermsAndConditions);

	}
	
	public WebElement getAboutIMC() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(AboutIMC));
		return driver.findElement(AboutIMC);

	}
	
	public WebElement getLasVegasApparel() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(LasVegasApparel));
		return driver.findElement(LasVegasApparel);

	}
	
	public WebElement getandmore() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(andmore));;
		return driver.findElement(andmore);
	}
}
