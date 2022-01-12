package pageObjects.LasVegasMarket;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UXPFooterLinksNavigationPage {

	public WebDriver driver;
	public WebDriverWait wait;

	By HighPointMarket = By.xpath("//nav[@class='imc-footer-links imc-content imc-content--invert']/div[1]/div[2]/div[1]/div[1]/a[1]"); //Locator for High Point Market in footer links
	By AtlantaMarket = By.xpath("//nav[@class='imc-footer-links imc-content imc-content--invert']/div[1]/div[2]/div[2]/div[1]/a[1]"); //Locator for Atlanta Matket in footer links
	By AtlantaApparel = By.xpath("//nav[@class='imc-footer-links imc-content imc-content--invert']/div[1]/div[2]/div[3]/div[1]/a[1]"); //Locator for Atlanta Apparel in footer links
	By AmericasMart = By.xpath("//nav[@class='imc-footer-links imc-content imc-content--invert']/div[1]/div[2]/div[4]/div[1]/a[1]"); //Locator for Americas Mart in footer links
	By InternationalMarketCenters = By.xpath("//nav[@class='imc-footer-links imc-content imc-content--invert']/div[1]/div[2]/div[5]/div[1]/a[1]"); //Locator for International Market Centers in footer links
	By DownloadTheApp = By.xpath("//nav[@class='imc-footer-links imc-content imc-content--invert']/div[1]/div[3]/div[1]/div[1]/a[1]"); //Locator for Download The App in footer links
	By ContactUs = By.xpath("//nav[@class='imc-footer-links imc-content imc-content--invert']/div[1]/div[3]/div[2]/div[1]/a[1]"); //Locator for Contact Us in footer links
	By Careers = By.xpath("//nav[@class='imc-footer-links imc-content imc-content--invert']/div[1]/div[3]/div[3]/div[1]/a[1]"); //Locator for Careers in footer links
	By TermsAndConditions = By.xpath("//nav[@class='imc-footer-links imc-content imc-content--invert']/div[1]/div[3]/div[4]/div[1]/a[1]"); // Locator for Terms and Conditions in footer links
	By PrivacyPolicy = By.xpath("//nav[@class='imc-footer-links imc-content imc-content--invert']/div[1]/div[3]/div[5]/div[1]/a[1]"); // Locator for Privacy Policy in footer links
	By VerifyCareers = By.xpath("//div[@id = 'content']/div[1]/div[1]/h1[1]"); //Locator for verify Careers
	By ClosePopUpAmericasmart = By.xpath("//div[@class = ' contact-exit']"); //Locatory for Close Pop Up after opening Americas Mart footer link
	By VerifyTermsOfUse = By.xpath("//div[@id = 'page']/div[2]/div[1]/div[1]div[1]/h1[1]"); //Locator for Terms of Use
	By VerifyPrivacyPolicy = By.xpath("//*[contains (text(), 'WEB PRIVACY STATEMENT']"); //Locator for porivacy Policy
	
	public UXPFooterLinksNavigationPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
	} 

	public WebElement getHighPointMarket() throws InterruptedException {
		//Wait till Sign In page is displayed
		Thread.sleep(10000);
		return driver.findElement(HighPointMarket);

	}

	public WebElement getAtlantaMarket() throws InterruptedException {
		//Wait till Sign In page is displayed
		Thread.sleep(10000);
		return driver.findElement(AtlantaMarket);

	}

	public WebElement getAtlantaApparel() throws InterruptedException {
		//Wait till Sign In page is displayed
		Thread.sleep(10000);
		return driver.findElement(AtlantaApparel);

	}

	public WebElement getAmericasMart() throws InterruptedException {
		//Wait till Sign In page is displayed
		Thread.sleep(10000);
		return driver.findElement(AmericasMart);

	}

	public WebElement getInternationalMarketCenters() throws InterruptedException {
		//Wait till Sign In page is displayed
		Thread.sleep(10000);
		return driver.findElement(InternationalMarketCenters);

	}

	public WebElement getDownloadTheApp() throws InterruptedException {
		//Wait till Sign In page is displayed
		Thread.sleep(10000);
		return driver.findElement(DownloadTheApp);

	}

	public WebElement getContactUs() throws InterruptedException {
		//Wait till Sign In page is displayed
		Thread.sleep(10000);
		return driver.findElement(ContactUs);

	}

	public WebElement getCareers() throws InterruptedException {
		//Wait till Sign In page is displayed
		Thread.sleep(10000);
		return driver.findElement(Careers);

	}

	public WebElement getTermsAndConditions() throws InterruptedException {
		//Wait till Sign In page is displayed
		Thread.sleep(10000);
		return driver.findElement(TermsAndConditions);

	}

	public WebElement getPrivacyPolicy() throws InterruptedException {
		//Wait till Sign In page is displayed
		Thread.sleep(10000);
		return driver.findElement(PrivacyPolicy);

	}
	
	public WebElement getVerifyCareers() throws InterruptedException {
		//Wait till Sign In page is displayed
		Thread.sleep(10000);
		return driver.findElement(VerifyCareers);

	}
	
	public WebElement getClosePopUpAmericasmart() throws InterruptedException {
		//Wait till Sign In page is displayed
		Thread.sleep(10000);
		return driver.findElement(ClosePopUpAmericasmart);

	}
	
	public WebElement getVerifyTermsOfUse() throws InterruptedException {
		//Wait till Sign In page is displayed
		Thread.sleep(10000);
		return driver.findElement(VerifyTermsOfUse);

	}
	
	public WebElement getVerifyPrivacyPolicy() throws InterruptedException {
		//Wait till Sign In page is displayed
		Thread.sleep(10000);
		return driver.findElement(VerifyPrivacyPolicy);

	}
}



