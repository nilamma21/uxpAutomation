package pageObjects.LasVegasMarket;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UXPExhibitorsAndProductsTabPage {

	public WebDriver driver;
	public WebDriverWait wait;

	By ExhibitorsAndProducts = By.xpath("//div[@class='imc-section']/div[1]/div[2]/div[1]/a[1]"); //Locator for Exhibitors and Products header tab
	By ExhibitorDirectory = By.xpath("//div[@class='imc-section']/div[1]/div[2]/div[2]/div[1]/div[1]/a[1]"); //Locator for ExhibitorDirectory header tab
	By FloorPlans = By.xpath("//a[contains(text(), 'Floor Plans')]"); //Locator for Floor Plans header tab
	By ShowSpecials = By.xpath("//a[contains(text(), 'Show Specials')]"); //Locator for ShowSpecials header tab
	By Temporaries = By.xpath("//a[contains(text(), 'Temporaries')]"); //Locator for Temporaries header tab
	By NewProductIntroductions = By.xpath("//a[contains(text(), 'New Product Introductions')]"); //Locator for NoProductIntroductions header tab
	By Categories = By.xpath("//a[contains(text(), 'Categories')]"); //Locator for Categories header tab
	By JuniperMarketProd = By.xpath("//a[contains(text(), 'JuniperMarket')]"); //Locator for Juniper Market header tab
	By VerifyExhibitorsAndProductsSection = By.xpath("//div[@class = 'imc-section']/div[1]/div[2]/div[2]"); //Locator for verification of Exhibitors and Products section
	By VerifyExhibitorDirectory = By.xpath("//ul[@class = 'imc-breadcrumb']/li[3]/a[1]"); // Locator for Exhibitor Directory text
	By VerifyFloorPlans = By.xpath("//div[@class = 'imc-campus-view']"); // Locator for floor plans map
	By exhdirectsearchbx = By.xpath("(//input[@id='input-1'])[2]"); //Locator for Exhibitor Directory Search box
	By exhdirectsearchbtn = By.xpath("(//button[@class = 'imc-searchform--button--search'])[2]"); //Locator for Exh Direct Serach btn

	public UXPExhibitorsAndProductsTabPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
	} 

	public WebElement getExhibitorsAndProducts() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ExhibitorsAndProducts));
		return driver.findElement(ExhibitorsAndProducts);
	}

	public WebElement getExhibitorDirectory() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ExhibitorDirectory));
		return driver.findElement(ExhibitorDirectory);
	}

	public WebElement getFloorPlans() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(FloorPlans));
		return driver.findElement(FloorPlans);
	}

	public WebElement getShowSpecials() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ShowSpecials));
		return driver.findElement(ShowSpecials);
	}

	public WebElement getTemporaries() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Temporaries));
		return driver.findElement(Temporaries);
	}

	public WebElement getNewProductIntroductions() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(NewProductIntroductions));
		return driver.findElement(NewProductIntroductions);
	}

	public WebElement getCategories() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Categories));
		return driver.findElement(Categories);
	}

	public WebElement getVerifyExhibitorsAndProductsSection() throws InterruptedException {
		Thread.sleep(5000);
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(VerifyExhibitorsAndProductsSection));
		return driver.findElement(VerifyExhibitorsAndProductsSection);
	}

	public WebElement getVerifyExhibitorDirectory() throws InterruptedException {
		Thread.sleep(5000);
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(VerifyExhibitorDirectory));
		return driver.findElement(VerifyExhibitorDirectory);
	}

	public WebElement getVerifyFloorPlans() throws InterruptedException {
		Thread.sleep(5000);
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(VerifyFloorPlans));
		return driver.findElement(VerifyFloorPlans);
	}

	public WebElement getJuniperMarketProd() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(JuniperMarketProd));
		return driver.findElement(JuniperMarketProd);
	}
	public WebElement getExhDirectSearchBox() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(exhdirectsearchbx));
		return driver.findElement(exhdirectsearchbx);
	}
	
	public WebElement getExhDirectSearchBtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(exhdirectsearchbtn));
		return driver.findElement(exhdirectsearchbtn);
	}
	
	
}



