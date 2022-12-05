package lasvegasmarket_PROD;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.AtlantaMarket.ATLExhDigiShowroomPage;
import pageObjects.AtlantaMarket.ATLExhLineProdActionsPage;
import pageObjects.AtlantaMarket.ATLGlobalSearchPage;
import pageObjects.AtlantaMarket.ATLLandingPage;
import pageObjects.AtlantaMarket.ATLLoginPage;
import pageObjects.AtlantaMarket.ATLMarketPlannerPage;
import pageObjects.AtlantaMarket.ATLProductDetailsPage;
import resources.GenerateData;
import resources.Utility;
import resources.base;

@Listeners({ TestListeners.class })
public class GlobalSearch_SuggestionList extends base {

	public WebDriverWait wait;
	public GenerateData genData;
	public Utility utl;
	public String exhname;
	ATLLoginPage lp;
	ATLLandingPage lap;
	ATLGlobalSearchPage atlgs;
	ATLExhDigiShowroomPage atlexhdgshw;
	ATLProductDetailsPage atlproddet;
	ATLExhLineProdActionsPage atlexhact;
	ATLMarketPlannerPage atlmppge;

	List<WebElement> exhlist, linelist, prodlist, searchexhtypelist, searchproducttypelist, mplists, mpeditlistoptns, allnoteslist,favlist, searchlinetypelist;

	@BeforeClass
	public void initialize() throws IOException, InterruptedException {
		driver = initializeDriver(); // requires for Parallel text execution
		//chromeVersion();
		utl = new Utility(driver);
		lap = new ATLLandingPage(driver);

		// Navigate to Atlanta Market site
		driver.manage().window().maximize();
		driver.get(prop.getProperty("lvmurl_prod"));
		lap.getIUnderstandBtn().click();
//		Thread.sleep(10000);
//		lap.getCloseMarktAdBtn().click();
	}

	@Test(priority = 1)
	public void TS001_VerifySelectionOfExhibitorFromAutoSuggestionListTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T419: The selection of an Exhibitor from Auto Suggestion List

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("autosuggestexhibitor")));

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@class='react-autosuggest__suggestions-list']/li")));

		exhlist = atlgs.getATLSearchResultsList();
		//searchexhtypelist = atlgs.getATLSearchResultExhTypeList();

		for (int i = 0; i < exhlist.size(); i++) {
			//System.out.println(exhlist.get(i).getText());
			if (exhlist.get(i).getText().contains(prop.getProperty("autosuggestexhibitor"))
					&& exhlist.get(i).getText().contains("Exhibitor")) {
				exhlist.get(i).click();
				break;
			}
		}
		Thread.sleep(8000);
		Assert.assertTrue(atlexhdgshw.getATLValidateExhDigiShowPage().isDisplayed());
	}

	@Test(priority = 2)
	public void TS002_VerifySelectionOfLineFromAutoSuggestionListTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T420: The selection of a Line from Auto Suggestion List

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get(prop.getProperty("lvmurl_prod"));
		//lap.getCloseMarktAdBtn().click();
		
		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("autosuggestline")));

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@class='react-autosuggest__suggestions-list']/li")));

		linelist = atlgs.getATLSearchResultsList();
		//searchlinetypelist = atlgs.getATLSearchResultTypeLineList();

		for (int i = 0; i < 10; i++) {
			// System.out.println(list.get(i).getText());
			if (linelist.get(i).getText().contains(prop.getProperty("autosuggestline"))
					&& linelist.get(i).getText().contains("Line")) {
				linelist.get(i).click();
				break;
			}
		}
		Thread.sleep(8000);
		Assert.assertTrue(atlexhdgshw.getATLValidateExhDigiShowPage().isDisplayed());
	}

	@Test(priority = 3)
	public void TS003_VerifySelectionOfProductFromAutoSuggestionListTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T420: The selection of a Product from Auto Suggestion List

		atlgs = new ATLGlobalSearchPage(driver);
		atlproddet = new ATLProductDetailsPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get(prop.getProperty("lvmurl_prod"));
		//lap.getCloseMarktAdBtn().click();
		
		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("autosuggestproduct_lvm")));

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@class='react-autosuggest__suggestions-list']/li")));

		prodlist = atlgs.getATLProductsSearchResultsList();
		//searchproducttypelist = atlgs.getATLSearchResultPorductTypeList();

		for (int i = 0; i < prodlist.size(); i++) {
			//System.out.println(prodlist.get(i).getText());			
			if (prodlist.get(i).getText().contains(prop.getProperty("autosuggestproduct_lvm"))
					&& prodlist.get(i).getText().contains("Product")) {	
				prodlist.get(i).click();
				break;
			}
		}
		Thread.sleep(8000);
		Assert.assertTrue(atlproddet.getATLValidateProdDetailsPage().isDisplayed());
		driver.get(prop.getProperty("lvmurl_prod"));
		//lap.getCloseMarktAdBtn().click();
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
}
