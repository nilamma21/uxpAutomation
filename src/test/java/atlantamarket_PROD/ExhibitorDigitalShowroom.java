package atlantamarket_PROD;

import java.awt.Window;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.AtlantaMarket.ATLEventsAndWebinarPage;
import pageObjects.AtlantaMarket.ATLExhDigiShowroomPage;
import pageObjects.AtlantaMarket.ATLExhLineProdActionsPage;
import pageObjects.AtlantaMarket.ATLGlobalSearchPage;
import pageObjects.AtlantaMarket.ATLLandingPage;
import pageObjects.AtlantaMarket.ATLLeftPaneFilters;
import pageObjects.AtlantaMarket.ATLLoginPage;
import pageObjects.AtlantaMarket.ATLMarketPlannerPage;
import pageObjects.AtlantaMarket.ATLProductDetailsPage;
import resources.GenerateData;
import resources.Utility;
import resources.base;

@Listeners({ TestListeners.class })
public class ExhibitorDigitalShowroom extends base {

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
	ATLLeftPaneFilters atlleftpane;
	ATLEventsAndWebinarPage atlevents;

	List<WebElement> exhlist, linelist, prodlist, searchexhtypelist, searchproducttypelist, mplists, mpeditlistoptns,
	allnoteslist, favlist, searchlinetypelist, tagBlogPost, taglist, infoFilterList,favexhlist;

	@BeforeClass
	public void initialize() throws IOException, InterruptedException {
		driver = initializeDriver(); // requires for Parallel text execution
		// chromeVersion();
		utl = new Utility(driver);
		lap = new ATLLandingPage(driver);

		// Navigate to Atlanta Market site
		driver.manage().window().maximize();
		driver.get(prop.getProperty("atlmrkturl_prod"));
		//driver.get(prop.getProperty("lvmurl_uat"));
		
		Thread.sleep(3000);
		lap.getIUnderstandBtn().click();
		Thread.sleep(3000);

		utl.verifyMPLoginFunctionality();
		Thread.sleep(5000);
		//lap.getIUnderstandBtn().click();
		//utl.CloseATLPopup();
	}
	
	@Test(priority = 1)
	public void TS001_VerifyAddToFavoritesTest() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// T294: Add To Favorites

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		lap = new ATLLandingPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Search Exhibitor in global search option
		atlgs.getATLGlobalSearchTextBox().sendKeys(prop.getProperty("exhibitor1"));
		atlgs.getATLSearchButton().click();

		// Store the 1st Exhibitor name in String variable
		String exhname = atlexhact.getExhibitorName().getText();
		System.out.println("Exhibitor name: " + exhname);

		// Click on Exhibitor name and login to market planner
		atlexhdgshw.getSearchedExhibitor().click();
		//		utl.verifyMPLoginFunctionality();
		//		lap.getCloseMarktAdBtn().click();

		//Click Market Planner's Name and go to favorites under Lists tab and verify results
		//		lap.getMPLinkText().click();
		//		atlmppge.getMPHomeListsTab().click();
		//		//atlmppge.getATLMPListsPageFavoritesMenu().click();
		//		utl.scrollToElement(atlmppge.getmplistsenentsandseminars());
		//		Thread.sleep(5000);
		//		Assert.assertTrue(atlexhdgshw.getVerifyExhibitorInFavoritesLists().getText().contains("exhibitor1"));
		//		System.out.println("Exhibitor is properly displayed at Favorites tab.");


		atlexhdgshw.getFavoriteIcon().click();

		// Click on Market Planner link
		lap.getMPLinkText().click();

		// Click on Lists tab on MP home page
		atlmppge.getMPHomeListsTab().click();
		atlmppge.getATLMPListsPageFavoritesMenu().click();
		Thread.sleep(4000);
		
		// Verify that the added favorites exhibitor should be displayed in to Favorites list
		//Assert.assertTrue(atlmppge.getATLSavedExhNameInList().getText().contains(exhname));

		favexhlist = atlmppge.getFavoriteExhibitorNames();

		for (int i = 0; i < favexhlist.size(); i++) {
			//System.out.println(favexhlist.get(i).getText());
			if (favexhlist.get(i).getText().equals(exhname)) {
				utl.scrollToElement(favexhlist.get(i));
				break;
			}
		}
		
		
		// Delete that favorites exhibitor from list
		atlmppge.getMoreBtnDeleteOptnExistingList_ATLPROD().click();
		atlmppge.getATLEditListItemDeleteOptn().click();
		Thread.sleep(6000);

		favlist = driver.findElements(By.xpath("//li[@class='imc-list-edit--draggable']/div/div/div/a"));

		//Verify that the added favorites exhibitor should be removed from Favorites list
		for(int i=1; i< favlist.size(); i++)
		{			
			//System.out.println(favlist.get(i).getText());
			Assert.assertFalse(favlist.get(i).getText().contains(exhname)); 
		}
	}
	
	@Test(priority = 2)
	public void TS002_VerifyAddToExistingListWithPlusIconTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T297: The Add to existing list functionality for an Exhibitor using Plus icon

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		lap = new ATLLandingPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("exhibitor1")));
		atlgs.getATLSearchButton().click();

		Thread.sleep(15000);
		// Store the 1st Exhibitor name in String variable
		String exhname = atlexhact.getExhibitorName().getText();
		System.out.println("Exhibitor name: " + exhname);

		// Click Exhibitor Name and click Plus icon
		atlexhdgshw.getExhibitorName().click();
		atlexhdgshw.getListButtonPlusIcon().click();
		
		/*//Login to Market Planner
		lp.getEmailAddress().sendKeys((prop.getProperty("username")));
		lp.getPassword().sendKeys((prop.getProperty("password")));
		lp.getSignInBtn().click();*/
		
		// Select Existing list name
		atlmppge.getATLMPExistingListName().click();
		
		// Store the existing list name
		String existinglistname = atlmppge.getATLMPExistingListName().getText();
		System.out.println("Existing list name: " + existinglistname);

		// Scroll till Add to Selected button
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				atlmppge.getATLMPAddToSelectedBtn());
		atlmppge.getATLMPAddToSelectedBtn().click();

		// Click on Go to Market Planner button
		atlmppge.getGoToMarketPlannerBtn().click();

		// Click on Lists tab on MP home page
		atlmppge.getMPHomeListsTab().click();
		atlmppge.getListsPageListsMenu().click();

		mplists = atlmppge.getATLMPListsNames();
		mpeditlistoptns = atlmppge.getATLMPEditListOptns();

		for (int i = 0; i < mplists.size(); i++) {
			// System.out.println(mplists.get(i).getText());
			// System.out.println(mpeditlistoptns.get(i).getText());
			if (mplists.get(i).getText().equals(existinglistname)) {
				mpeditlistoptns.get(i).click();
				break;
			}
		}
		Thread.sleep(5000);
		Assert.assertTrue(atlmppge.getATLSavedExhNameInList().getText().contains(exhname));

		// Delete that added exhibitor from list
		atlmppge.getMoreBtnDeleteOptnExistingList_ATLPROD().click();
		atlmppge.getATLEditListItemDeleteOptn().click();
		Thread.sleep(8000);

		favlist = driver.findElements(By.xpath("//li[@class='imc-list-edit--draggable']/div/div/div/a"));

		//Verify that the added exhibitor should be removed from Existing list
		for(int i=1; i< favlist.size(); i++)
		{			
			//System.out.println(favlist.get(i).getText());
			Assert.assertFalse(favlist.get(i).getText().contains(exhname)); 
		}
	}
	
	@Test(priority = 3)
	public void TS003_VerifyAddNoteListWithPlusIconTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T300: Add Note for an exhibitor

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		atlmppge = new ATLMarketPlannerPage(driver);
		lap = new ATLLandingPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);
		lp = new ATLLoginPage(driver);
		genData = new GenerateData();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(10000);
		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("exhibitor1")));
		atlgs.getATLSearchButton().click();

		Thread.sleep(15000);
		
		// Click Exhibitor Name and click Plus icon
		atlexhdgshw.getExhibitorName().click();
		Thread.sleep(10000);
		atlexhdgshw.getNoteOptn().click();
		
		// Add Note and verify Functionality for X (Close button)
		atlexhdgshw.getNoteCloseBtn().click();
		Assert.assertTrue(atlexhdgshw.getATLExhDigiShowPage().isDisplayed());
		System.out.println("Close button at Note form works properly.");
		
		
		// Verify save note option works properly
		atlexhdgshw.getNoteOptn().click();
		Thread.sleep(3000);
		atlexhact.getNoteTitleTxtBx().sendKeys(genData.generateRandomString(6));
		Thread.sleep(3000);
		// Enter Note Content
		atlexhact.getNoteContentTxtBx().sendKeys("TestNote" + genData.generateRandomString(15));
		Thread.sleep(3000);
		String NoteTitle = atlexhact.getNoteTitleTxtBx().getText();
		// Click on 'Save' button
		atlexhact.getNoteSaveBtn().click();
		Thread.sleep(10000);
		atlexhdgshw.getNoteOptn().click();
		Thread.sleep(3000);
		atlexhdgshw.getViewAllNotes().click();
		Assert.assertTrue(atlexhdgshw.getVerifyAddedNote().getText().contains(NoteTitle));
		System.out.println("Note is added successfully.");
		
	}
	
	@Test(priority = 4)
	public void TS004_VerifyClickOnLocationLinksForExhibitorDigitalShowroomTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T301: The click on 'Location Links' functionality for an Exhibitor

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		lap = new ATLLandingPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("atlmrkturl_prod"));
		Thread.sleep(6000);
		//lap.getCloseMarktAdBtn().click();

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchinput")));
		atlgs.getATLSearchButton().click();

		Thread.sleep(15000);
		// Click on any of the Location link present in Exhibitor card and verify result
		atlexhdgshw.getExhibitorName().click();
		Thread.sleep(5000);
		String locationlink = atlexhdgshw.getLocation().getAttribute("href");
		atlexhdgshw.getLocation().click();
		Thread.sleep(10000);
		String winHandleBefore = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		Assert.assertTrue(locationlink.equals(driver.getCurrentUrl()));
		System.out.println("Locations page is displayed properly.");
		driver.close();
		driver.switchTo().window(winHandleBefore);

		
	}
	
	@Test(priority = 5)
	public void TS005_VerifyClickOnTotalLinesSeeAllLinkForExhibitorTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T312: The click on 'Total lines-See All' functionality for an Exhibitor Digital Show room

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		lap = new ATLLandingPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchinput")));
		atlgs.getATLSearchButton().click();

		Thread.sleep(15000);
		// Store the 1st Exhibitor name in String variable
		exhname = atlexhact.getExhibitorName().getText();
		System.out.println("Exhibitor name: " + exhname);

		// Get the Total Lines count on Search grid
		atlexhdgshw.getExhibitorName().click();
		Thread.sleep(5000);
		utl.scrollToElement(atlexhdgshw.getLinesSection());
		String temp = atlexhdgshw.getLinesSection().getText();
		String totallinescountonsearchgrid = temp.replaceAll("[^0-9]", "");
		System.out.println("Total Products Count on Search Results grid is: " + totallinescountonsearchgrid);
		Assert.assertTrue(atlexhdgshw.getTotalLinesButton().getText().contains(totallinescountonsearchgrid));
		System.out.println("Total Lines count is same at Lines section title and See All button.");

		// Click on Total Lines-See All link for 1st Exhibitor
		atlexhdgshw.getTotalLinesButton().click();
		Thread.sleep(6000);

		// Verify that user should redirect to the Lines page
		Assert.assertTrue(atlexhdgshw.getValidateLinesPage().getText().contains("Lines"));
		System.out.println("All Lines page is displayed properly.");
		Thread.sleep(6000);

		// Get the Total Products count on Products page
		String linestabtitle = atlexhdgshw.getLinesCountAtLinesPage().getText();
		String totallinescountonprodpage = linestabtitle.replaceAll("[^0-9]", "");
 		System.out.println("Total Lines Count on Products page is: " + totallinescountonprodpage);

		//Get back to Exhibitor Showroom page and click any one product and verify if product details are displayed properly
		atlexhdgshw.getProductsPageBackButton().click();
		utl.scrollToElement(atlexhdgshw.getLinesSection());
		String linetext = atlexhdgshw.getLinesOptionText().getText();
		atlexhdgshw.getLinesOption().click();
		Assert.assertTrue(atlexhdgshw.getValidateLinesPage().getText().contains(linetext));
		System.out.println("Line Details are displayed properly.");
		
	}
	
	@Test(priority = 6)
	public void TS006_VerifyClickOnProductShownLinkForExhibitorTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T311: The click on 'Product Shown-See All' functionality for an Exhibitor Digital Showroom

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		lap = new ATLLandingPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchinput"))); 
		atlgs.getATLSearchButton().click();

		Thread.sleep(15000);
		// Store the 1st Exhibitor name in String variable
		exhname = atlexhact.getExhibitorName().getText();
		System.out.println("Exhibitor name: " + exhname);
		
		// Get the Total Products count on Search grid
		atlexhdgshw.getExhibitorName().click();
		Thread.sleep(5000);
		utl.scrollToElement(atlexhdgshw.getProductSection());
		String temp = atlexhdgshw.getProductSection().getText();
		String totalprodcountonsearchgrid = temp.replaceAll("[^0-9]", "");
		System.out.println("Total Products Count on Search Results grid is: " + totalprodcountonsearchgrid);
		Assert.assertTrue(atlexhdgshw.getAllProductsButton().getText().contains(totalprodcountonsearchgrid));
		System.out.println("Total Products count is same at Products section title and See All button.");

		// Click on Total Products-See All link for 1st Exhibitor
		atlexhdgshw.getAllProductsButton().click();
		Thread.sleep(6000);

		// Verify that user should redirect to the Lines page
		Assert.assertTrue(atlexhdgshw.getValidateLinesPage().getText().contains("Products"));
		System.out.println("All Products page is displayed properly.");
		Thread.sleep(6000);

		// Get the Total Products count on Products page
		String productstabtitle =atlexhact.getValidateProductsPage().getText();
		String totalproductscountonprodpage = productstabtitle.replaceAll("[^0-9]", "");
		System.out.println("Total Products Count on Products page is: " + totalproductscountonprodpage);

		//Get back to Exhibitor Showroom page and click any one product and verify if product details are displayed properly
		atlexhdgshw.getProductsPageBackButton().click();
		utl.scrollToElement(atlexhdgshw.getProductSection());
		String producttext = atlexhdgshw.getProductText().getText();
		System.out.println(producttext);
		atlexhdgshw.getProductsList().click();
		Thread.sleep(5000);
		Assert.assertTrue(producttext.contains(atlexhdgshw.getValidateLinesPage().getText()));
		System.out.println("Product Details are displayed properly.");

	}
	
	@Test(priority = 7)
	public void TS007_VerifyClickOnLineFiltersForExhibitorTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T315: The click on Line Filters functionality for an Exhibitor Digital Show room

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		lap = new ATLLandingPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchinput")));
		atlgs.getATLSearchButton().click();

		Thread.sleep(15000);
		// Store the 1st Exhibitor name in String variable
		exhname = atlexhact.getExhibitorName().getText();
		System.out.println("Exhibitor name: " + exhname);

		// Get the Total Lines count on Search grid
		atlexhdgshw.getExhibitorName().click();
		Thread.sleep(5000);
		utl.scrollToElement(atlexhdgshw.getLinesSection());
		
		//Verify A-Z sorting
		atlexhdgshw.getAlphabeticSorting().click();
		Assert.assertTrue(atlexhdgshw.getLinesOptionText().getText().startsWith("A"));
	}
	
	@Test(priority = 8)
	public void TS008_VerifyClickOnLineSearchForExhibitorTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T317: The click on Line Filters functionality for an Exhibitor Digital Show room

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		lap = new ATLLandingPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchinput")));
		atlgs.getATLSearchButton().click();
		Thread.sleep(8000);
		
		//Click on the 1st Exhibitor name
		atlexhdgshw.getExhibitorName().click();
		Thread.sleep(5000);
		utl.scrollToElement(atlexhdgshw.getLinesSection());
		
		//Verify Line Search functionality
		atlexhdgshw.getLineSearch().click();
		atlexhdgshw.getLineSearch().sendKeys(prop.getProperty("line2"));
		atlexhdgshw.getLineSearchButton().click();
		Thread.sleep(5000);
		Assert.assertTrue(atlexhdgshw.getVerifyLineSearch().getText().contains(prop.getProperty("line2")));	
	}
	@Test(priority = 9)
	public void TS009_VerifyExhibitorDigitalShowroomLinesComponentSeeAllLinesTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T350: Exhibitor Digital Showroom: Lines Component: See All Lines

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		lap = new ATLLandingPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchinput")));
		atlgs.getATLSearchButton().click();

		Thread.sleep(15000);
		// Store the 1st Exhibitor name in String variable
		exhname = atlexhact.getExhibitorName().getText();
		System.out.println("Exhibitor name: " + exhname);

		// Get the Total Lines count on Search grid
		atlexhdgshw.getExhibitorName().click();
		Thread.sleep(5000);
		//Scroll to Line Section
		utl.scrollToElement(atlexhdgshw.getLinesSection());
		//Click on See All Lines Btn
		atlexhdgshw.getTotalLinesButton().click();
		
		Assert.assertTrue(atlexhdgshw.getATLVerifyLinePageTitle().getText().contains("Lines"));
		System.out.println("Lines Component: See All Lines Btn functionality is working properly.");
		
		
	}
	@Test(priority = 10)
	public void TS010_VerifyExhibitorDigitalShowroomProductsComponentOrderOnJuniperMarketTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T349: Exhibitor Digital showroom: Products Component: Order on JuniperMarket

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		lap = new ATLLandingPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchinputforShowSpecials")));
		atlgs.getATLSearchButton().click();

		Thread.sleep(15000);
		// Store the 1st Exhibitor name in String variable
		exhname = atlexhact.getExhibitorName().getText();
		System.out.println("Exhibitor name: " + exhname);

	
		atlexhdgshw.getExhibitorName().click();
		Thread.sleep(5000);
		//Scroll to Line Section
		utl.scrollToElement(atlexhdgshw.getProductSection());
		//Click on Order On Juniper Market Btn
		String OrderOnJuniperMarktURL=atlexhdgshw.getOrderOnJuniperMarktBtnCatalog().getAttribute("href");
		String winHandleBefore = driver.getWindowHandle();
		atlexhdgshw.getOrderOnJuniperMarktBtnCatalog().click();
		
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		
		Assert.assertTrue(driver.getCurrentUrl().contains(OrderOnJuniperMarktURL));
	
		driver.close();
		driver.switchTo().window(winHandleBefore);
		
		System.out.println(" Products Component: Order on JuniperMarket Btn functionality is working properly.");
		
		
		
		
	}
	@Test(priority = 11)
	public void TS011_VerifyExhibitorDigitalShowroomProductsComponentSeeAllProductsTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T348: Exhibitor Digital showroom: Products Component: See All Products

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		lap = new ATLLandingPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchinput")));
		atlgs.getATLSearchButton().click();

		Thread.sleep(15000);
		// Store the 1st Exhibitor name in String variable
		exhname = atlexhact.getExhibitorName().getText();
		System.out.println("Exhibitor name: " + exhname);

		
		atlexhdgshw.getExhibitorName().click();
		Thread.sleep(5000);
		//Scroll to Product Section
		utl.scrollToElement(atlexhdgshw.getProductSection());
		//Click on All Product Btn Btn
		atlexhdgshw.getAllProductsButton().click();
		
		
		Assert.assertTrue(atlexhdgshw.getATLVerifyLinePageTitle().getText().contains("Products"));
		System.out.println("Products Component: See All Products Btn functionality is working properly.");
		
		
	}
	
	@Test(priority = 12)
	public void TS012_VerifySeeInOtherMarketsForExhibitorTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T333: The See in Other Markets functionality for an Exhibitor Digital Show room

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		lap = new ATLLandingPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchinput")));
		atlgs.getATLSearchButton().click();

		Thread.sleep(15000);
		// Store the 1st Exhibitor name in String variable
		exhname = atlexhact.getExhibitorName().getText();
		System.out.println("Exhibitor name: " + exhname);

		// Get the Total Lines count on Search grid
		atlexhdgshw.getExhibitorName().click();
		Thread.sleep(5000);
		
		
		//Click See in Other Market button and verify if the page opens
		atlexhdgshw.getSeeInOtherMarket().click();
		Assert.assertTrue(atlexhdgshw.getVerifyOtherMarketsPage().isDisplayed());
		System.out.println("See In Other Markets page is displayed properly.");
		
		//Verify Go To Showroom functionality
		String winHandleBefore = driver.getWindowHandle();
		atlexhdgshw.getClickShowroom().click();
		Thread.sleep(5000);
		
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		lap.getIUnderstandBtn().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.americasmart.com/exhibitor/"));
		System.out.println("Showroom page is displayed properly.");
		driver.close();
		driver.switchTo().window(winHandleBefore);
		
		//Verify Contact Exhibitor
		atlexhdgshw.getContactExhibitorInOtherMarket().click();
		Thread.sleep(5000);
		Assert.assertTrue(atlexhdgshw.getVerifyContactExhibitorPage().isDisplayed());
		System.out.println("Contact Exhibitor page is displayed properly.");
		//atlexhdgshw.getContactExhibitorCloseButton().click();
		driver.get(prop.getProperty("atlmrkturl_prod"));
		Thread.sleep(5000);
		
	}
	@Test(priority = 13)
	public void TS013_VerifyExhibitorDigitalShowroomCatalogsComponentSeeAllCatalogsTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T351: Exhibitor Digital Showroom: Catalogs Component: See All Catalogs

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		lap = new ATLLandingPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchCataloginput")));
		atlgs.getATLSearchButton().click();

		Thread.sleep(15000);
		// Store the 1st Exhibitor name in String variable
		exhname = atlexhact.getExhibitorName().getText();
		System.out.println("Exhibitor name: " + exhname);

		
		atlexhdgshw.getExhibitorName().click();
		Thread.sleep(5000);
		//Scroll to Catalog Section
		utl.scrollToElement(atlexhdgshw.getATLCatalogSection());
		//Click on All Catalog Btn Btn
		atlexhdgshw.getATLCatalogSeeAllBtn().click();
		
		
		Assert.assertTrue(atlexhdgshw.getATLVerifyLinePageTitle().getText().contains("Catalogs"));
		System.out.println("Catalogs Component: See All Catalogs Btn functionality is working properly.");
		
		
	}
	
	@Test(priority = 14)
	public void TS014_VerifyExhibitorDigitalShowroomCatalogsComponentOrderOnJuniperMarketTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T352: Exhibitor Digital Sowroom: Catalogs Component: Order on JuniperMarket

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		lap = new ATLLandingPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchCataloginput")));
		atlgs.getATLSearchButton().click();

		Thread.sleep(15000);
		// Store the 1st Exhibitor name in String variable
		exhname = atlexhact.getExhibitorName().getText();
		System.out.println("Exhibitor name: " + exhname);

	
		atlexhdgshw.getExhibitorName().click();
		Thread.sleep(5000);
		//Scroll to Line Section
		utl.scrollToElement(atlexhdgshw.getATLCatalogSection());
		//Click on Order On Juniper Market Btn
		
		String OrderOnJuniperMarktURL=atlexhdgshw.getOrderOnJuniperMarktBtnCatalog().getAttribute("href");
		atlexhdgshw.getOrderOnJuniperMarktBtnCatalog().click();
		
		Assert.assertTrue(driver.getCurrentUrl().contains(OrderOnJuniperMarktURL));
		System.out.println(" Catalogs Component: Order on JuniperMarket Btn functionality is working properly.");
		
		
	}
	@Test(priority = 15)
	public void TS015_VerifyExhibitorDigitalShowroomHeroComponentVisitExhibitorsiteTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T347: Exhibitor Digital showroom: Hero component: Visit <Exhibitor site>

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		lap = new ATLLandingPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchinput")));
		atlgs.getATLSearchButton().click();

		Thread.sleep(15000);
		// Store the 1st Exhibitor name in String variable
		exhname = atlexhact.getExhibitorName().getText();
		System.out.println("Exhibitor name: " + exhname);

	
		atlexhdgshw.getExhibitorName().click();
		Thread.sleep(5000);
		String visitURL=atlexhdgshw.getHeroComponentVisit().getAttribute("href");
		System.out.println(visitURL);
		//Click on Hero Component Visit
		String currentWindowID=driver.getWindowHandle();
		atlexhdgshw.getHeroComponentVisit().click();
		for (String winddowHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winddowHandle);
		}
		Thread.sleep(7000);
		String URL =driver.getCurrentUrl();
		System.out.println(URL);
		Assert.assertTrue(URL.contains(visitURL));
		driver.close();
		driver.switchTo().window(currentWindowID);
		System.out.println("Hero component: Visit <Exhibitor site> Btn functionality is working properly.");
		
		
	}
	@Test(priority = 16)
	public void TS016_VerifyExhibitorDigitalShowroomHeroComponentView3DShowroomTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T345: Exhibitor Digital showroom: Hero component: View 3D Showroom

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		lap = new ATLLandingPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("searchexhwithlinesinput")));
		atlgs.getATLSearchButton().click();

		Thread.sleep(15000);
		// Store the 1st Exhibitor name in String variable
		exhname = atlexhact.getExhibitorName().getText();
		System.out.println("Exhibitor name: " + exhname);

	

		atlexhdgshw.getExhibitorName().click();
		Thread.sleep(5000);
		
		
		//Click on Hero Component Visit
		
		atlexhdgshw.getView3DshowroomBtn().click();
		Thread.sleep(5000);
		String header3Dshowroom=atlexhdgshw.getshowroomHeader3D().getText();
		System.out.println(exhname +" 3D Showroom");
		Assert.assertTrue(header3Dshowroom.contains(exhname +" 3D Showroom"));
		
		System.out.println("Hero component: View 3D Showroom Btn functionality is working properly.");
		atlexhdgshw.getView3DshowroomClose().click();
		
		
	}
	@Test(priority = 17)
	public void TS017_VerifyExhibitorDigitalEventsComponentTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T334: Exhibitor Digital showroom: Events Component

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		lap = new ATLLandingPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);

		atlevents=new ATLEventsAndWebinarPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("globalSearchEventsInput")));
		atlgs.getATLSearchButton().click();

		Thread.sleep(15000);
		// Store the 1st Exhibitor name in String variable
		exhname = atlexhact.getExhibitorName().getText();
		System.out.println("Exhibitor name: " + exhname);

		atlexhdgshw.getExhibitorName().click();
		Thread.sleep(5000);
		// Scroll to Line Section
		utl.scrollToElement(atlexhdgshw.getEventsSection());
		// Click on See All Events Btn

		atlexhdgshw.getSeeAllEventsBtn().click();
		/*Assert.assertTrue(atlexhdgshw.getATLVerifyLinePageTitle().getText().contains("Events"));
		driver.navigate().back();
		utl.scrollToElement(atlexhdgshw.getEventsSection());*/
		String eventName=atlexhdgshw.getEventName().getText();
		atlexhdgshw.getEventName().click();
		Assert.assertTrue(atlevents.getatlEventNameOnDetailsPage().getText().contains(eventName));
		System.out.println("Events Component functionality is working properly.");	
		
	}

	@Test(priority = 18)
	public void TS018_VerifyCatalogsSectionForExhibitorTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T318: Exhibitor Digital showroom: Catalogs Component

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		lap = new ATLLandingPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);

		atlevents=new ATLEventsAndWebinarPage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("searchforCatalogsInputUAT")));
		atlgs.getATLSearchButton().click();

		Thread.sleep(15000);
		//Store the 1st Exhibitor name in String variable
		exhname = atlexhact.getExhibitorName().getText();
		System.out.println("Exhibitor name: " + exhname);

		//Get the Total Lines count on Search grid
		atlexhdgshw.getExhibitorName().click();
		Thread.sleep(5000);
		
		//Verify Catalogs section for Exhibitor
		utl.scrollToElement(atlexhdgshw.getCatalogsSection());
		atlexhdgshw.getSeeAllCatalogsButton().click();
		Assert.assertTrue(atlexhdgshw.getValidateLinesPage().getText().contains("Catalogs"));
		System.out.println("See All Catalogs is working properly.");
		atlexhdgshw.getProductsPageBackButton().click();
		utl.scrollToElement(atlexhdgshw.getCatalogsSection());
		String CatalogName = atlexhdgshw.getSelectCatalog().getText();
		System.out.println("Catalog Name : "+CatalogName);
		atlexhdgshw.getSelectCatalog().click();
		String winHandleBefore = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		Assert.assertTrue(atlexhdgshw.getValidateLinesPage().getText().contains("pdfview"));
		System.out.println("Catalog is displayed properly.");
		driver.close();
		driver.switchTo().window(winHandleBefore);
		
	}
	@Test(priority = 20)
	public void TS020_VerifyExhibitorDigitalShowroomShowSpecialsTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T319: Exhibitor Digital showroom: Show Specials

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		lap = new ATLLandingPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);

		atlevents=new ATLEventsAndWebinarPage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchinputforShowSpecials")));
		atlgs.getATLSearchButton().click();

		Thread.sleep(15000);
		//Store the 1st Exhibitor name in String variable
		exhname = atlexhact.getExhibitorName().getText();
		System.out.println("Exhibitor name: " + exhname);

		//Get the Total Lines count on Search grid
		atlexhdgshw.getExhibitorName().click();
		Thread.sleep(5000);
		
		//Verify Show Special section for Exhibitor
		utl.scrollToElement(atlexhdgshw.getshowSpecialSection());
		//Verify both count
		String shwoSpecialCount=atlexhdgshw.getShowSpecialCount().getText();
		
		String splitShwSpecialCount= shwoSpecialCount.split(" ")[0].trim();
		
		String SeeAllBtnCount=atlexhdgshw.getSeeAllshowSpecialBtn().getText();
		
		String splitSeeAllBtnCount=SeeAllBtnCount.split(" ")[2].trim();
		
		
		Assert.assertTrue(splitShwSpecialCount.contains(splitSeeAllBtnCount));
		System.out.println("Both counts are same");
		//Click on See All Show Special
		atlexhdgshw.getSeeAllshowSpecialBtn().click();
		Assert.assertTrue(atlexhdgshw.getValidateLinesPage().getText().contains("Specials"));
		System.out.println("See All Show Specials Btn is working properly.");
		atlexhdgshw.getProductsPageBackButton().click();
		utl.scrollToElement(atlexhdgshw.getshowSpecialSection());
		String ShowSpecialName = atlexhdgshw.getShowSpecialName().getText();
		System.out.println("Show Special Name : "+ShowSpecialName);
		
		
	}
	@Test(priority = 21)
	public void TS021_VerifyExhibitorDigitalShowroomHeroComponentOrderOnJuniperMarketTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// T303: Exhibitor Digital showroom: Hero component: Order on Juniper Market

		atlgs = new ATLGlobalSearchPage(driver);
		atlexhact = new ATLExhLineProdActionsPage(driver);
		lap = new ATLLandingPage(driver);
		atlexhdgshw = new ATLExhDigiShowroomPage(driver);

		atlevents=new ATLEventsAndWebinarPage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchinputforShowSpecials")));
		atlgs.getATLSearchButton().click();

		Thread.sleep(15000);
		//Store the 1st Exhibitor name in String variable
		exhname = atlexhact.getExhibitorName().getText();
		System.out.println("Exhibitor name: " + exhname);

		//Get the Total Lines count on Search grid
		atlexhdgshw.getExhibitorName().click();
		Thread.sleep(5000);
		String orderOnJuniperURL=atlexhdgshw.getheroComponentOrderOnJunperBtn().getAttribute("href");
		//Click on Juniper Market Btn
		
		String currnetWindowHanldeID=driver.getWindowHandle();
		atlexhdgshw.getheroComponentOrderOnJunperBtn().click();
		for (String  winddowHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winddowHandle);
		}
		Thread.sleep(7000);
		String URL =driver.getCurrentUrl();
		System.out.println(URL);
		Assert.assertTrue(URL.contains(orderOnJuniperURL));
		driver.close();
		driver.switchTo().window(currnetWindowHanldeID);
		System.out.println("Hero component: Order on Juniper Market Btn functionality is working properly.");
		
		
		
	}
	

	
}

