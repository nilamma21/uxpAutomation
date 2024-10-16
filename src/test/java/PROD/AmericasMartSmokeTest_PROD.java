package PROD;

import java.io.IOException;
import java.time.Duration;
import org.testng.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.AmericasMart.AMAboutTabPage;
import pageObjects.AmericasMart.AMExhibitTabPage;
import pageObjects.AmericasMart.AMFooterLinksNavigationPage;
import pageObjects.AmericasMart.AMHeaderLinksPage;
import pageObjects.AmericasMart.AMMarketsAndEventsPage;
import pageObjects.AmericasMart.AMOpenYearRoundPage;
import pageObjects.AtlantaMarket.ATLAllChannelsLinksPage;
import pageObjects.AtlantaMarket.ATLAttendPage;
import pageObjects.AtlantaMarket.ATLExhibitPage;
import pageObjects.AtlantaMarket.ATLExhibitorDirectoryPage;
import pageObjects.AtlantaMarket.ATLExhibitorsAndProductsTabPage;
import pageObjects.AtlantaMarket.ATLFooterLinksNavigationPage;
import pageObjects.AtlantaMarket.ATLGlobalSearchPage;
import pageObjects.AtlantaMarket.ATLMarketInfoPage;
import pageObjects.AtlantaMarket.ATLNewsAndTrendsTabPage;
import pageObjects.AtlantaMarket.ATLProfileAndSettingsPage;
import pageObjects.AtlantaMarket.ATLRegistrationsPage;
import pageObjects.LasVegasMarket.UXPExhibitorDirectoryPage;
import pageObjects.LasVegasMarket.UXPExhibitorsAndProductsTabPage;
import pageObjects.LasVegasMarket.UXPExploreMarketPage;
import pageObjects.LasVegasMarket.UXPFooterLinksNavigationPage;
import pageObjects.LasVegasMarket.UXPGlobalSearchPage;
import pageObjects.LasVegasMarket.UXPHeaderChannelLinksPage;
import pageObjects.LasVegasMarket.UXPLandingPage;
import pageObjects.LasVegasMarket.UXPLoginPage;
import pageObjects.LasVegasMarket.UXPMarketInfoPage;
import resources.GenerateData;
import resources.SendEmail;
import resources.Utility;
import resources.base;

@Listeners({TestListeners.class})
public class AmericasMartSmokeTest_PROD extends base {
	public WebDriverWait wait;
	public GenerateData genData;
	public Utility utl;
	UXPLandingPage lap;
	UXPLoginPage lp;
	ATLProfileAndSettingsPage atlps;
	ATLGlobalSearchPage atlgs;
	ATLExhibitorsAndProductsTabPage atlexhp;
	ATLExhibitorDirectoryPage atled;
	ATLRegistrationsPage atlregp;
	ATLMarketInfoPage atlmi;
	ATLExhibitPage atlexh;
	ATLAllChannelsLinksPage atlch;
	ATLFooterLinksNavigationPage atlfl;
	UXPExhibitorsAndProductsTabPage exhp;
	UXPMarketInfoPage mi;
	UXPFooterLinksNavigationPage fl;
	ATLAttendPage atat;
	ATLNewsAndTrendsTabPage atlnt;
	AMHeaderLinksPage amhe;
	UXPExhibitorDirectoryPage ed;
	UXPGlobalSearchPage gs;
	AMFooterLinksNavigationPage amfl;
	AMAboutTabPage amab;
	UXPHeaderChannelLinksPage hd;
	UXPExploreMarketPage expmrkt;
	AMMarketsAndEventsPage amme;
	AMExhibitTabPage amexh;
	AMOpenYearRoundPage amoyr;

	SendEmail se;

	@BeforeClass
	public void initialize() throws IOException, InterruptedException
	{
		driver = initializeDriver(); //requires for Parallel text execution
		utl = new Utility(driver);
		lap = new UXPLandingPage(driver);

		//Navigate to Atlanta Market site
		driver.manage().window().maximize();
		driver.get(prop.getProperty("ammarturl"));
		Thread.sleep(5000);
		lap.getIUnderstandBtn().click();
		Thread.sleep(5000);
		//utl.verifyCloseBtnPopup();
	}


	@Test(priority=1)
	public void TS001_AMC_VerifyAllHeaderChanelLinksTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T101: To verify the Market Planner overview and it's functionality

		lap = new UXPLandingPage(driver);
		lp = new UXPLoginPage(driver);
		amhe = new AMHeaderLinksPage(driver);
		hd = new UXPHeaderChannelLinksPage(driver);
		atlch = new ATLAllChannelsLinksPage(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		utl.verifyCloseBtnPopup();
		
		//Old code for Header Channel Links
/*		//Click on Atlanta Market 
		hd.getAtlantaMarket().click();
		//Verify that Atlanta Market Home page should be displayed
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Atlanta Market at AmericasMart"));
		driver.get(prop.getProperty("ammarturl"));
		utl.verifyCloseBtnPopup();
		//Click on Atlanta Apparel 
		hd.getAtlantaApparel().click();
		//Verify that Atlanta App Home page should be displayed
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Atlanta Apparel at AmericasMart"));
		driver.get(prop.getProperty("ammarturl"));
		utl.verifyCloseBtnPopup();
		//Click on AmericasMart 
		hd.getAmericasMart().click();
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Wholesale Gift, Home, Rug and Apparel Markets"));
		System.out.println("Americas Mart channel link is working properly.");
		driver.get(prop.getProperty("ammarturl"));
		utl.verifyCloseBtnPopup();
		//Click on High Point Market 
		hd.getHighPoint().click();
		Thread.sleep(5000);
		Assert.assertTrue(driver.getTitle().contains("High Point"));
		driver.get(prop.getProperty("ammarturl"));
		utl.verifyCloseBtnPopup();
		//Click on Las Vegas Market 
		hd.getLasVegas().click();
		Assert.assertTrue(driver.getTitle().contains("Las Vegas"));
		driver.get(prop.getProperty("ammarturl"));
		utl.verifyCloseBtnPopup();
		//Click on Las Vegas Apparel
		atlch.getLasVegasApp().click();
		Assert.assertTrue(driver.getTitle().contains("Las Vegas Apparel"));
*/		
		
		//New Code for Header Channel Links

		//Verify that Atlanta link is present
		Assert.assertTrue(hd.getAtlanta().getText().equalsIgnoreCase("ATLANTA"));
		
		//Check Atlanta Apparel
		hd.getAtlanta().click();
		Assert.assertTrue(hd.getAtlantaApparel().getText().equalsIgnoreCase("Atlanta Apparel"));
		hd.getAtlantaApparel().click();
		Assert.assertTrue(driver.getTitle().contains("Atlanta Apparel"));
		driver.navigate().back();
		Thread.sleep(2000);

		// Check Casual Market Atlanta
		hd.getAtlanta().click();
		Assert.assertTrue(hd.getCasualMarketAtlanta().getText().equalsIgnoreCase("Fall Casual Market Atlanta"));
		String casualURl = hd.getCasualMarketAtlantaURL().getAttribute("href");
		hd.getCasualMarketAtlanta().click();
		Thread.sleep(3000);
		Assert.assertTrue(driver.getCurrentUrl().contains(casualURl));

		driver.get(prop.getProperty("lvmappurl"));
		Thread.sleep(7000);

		// Check Atlanta Market
		hd.getAtlanta().click();
		Assert.assertTrue(hd.getAtlantaMarket().getText().equalsIgnoreCase("Atlanta Market"));
		hd.getAtlantaMarket().click();
		Assert.assertTrue(driver.getTitle().contains("Atlanta Market"));
		driver.navigate().back();
		Thread.sleep(2000);
		
/*		//Check Formal Markets
		hd.getAtlanta().click();
		Thread.sleep(500);
		Assert.assertTrue(hd.getFormalMarkets().getText().equalsIgnoreCase("Formal Markets"));
		hd.getFormalMarkets().click();
		Assert.assertTrue(driver.getTitle().contains("Formal Markets"));
		driver.navigate().back();
		Thread.sleep(2000);
		*/
		//Check Mid-Season Buying Event: Fall Market
		hd.getAtlanta().click();
		Assert.assertTrue(hd.getMidSeasonBuyingEventFallMarket().getText().equalsIgnoreCase("Mid-Season Buying Event: Fall Market"));
		hd.getMidSeasonBuyingEventFallMarket().click();
		Assert.assertTrue(driver.getTitle().contains("Fall Market at AmericasMart"));
		driver.navigate().back();
		Thread.sleep(2000);
		
		hd.getAtlanta().click();
		try {
		Assert.assertTrue(hd.getCashAndCarryMarketsSpringandFall().getText().equalsIgnoreCase("Cash & Carry Markets: Spring and Fall"));
		hd.getCashAndCarryMarketsSpringandFall().click();
		Assert.assertTrue(driver.getTitle().contains("Spring Cash & Carry"));
		driver.get(prop.getProperty("lvmappurl"));
		Thread.sleep(2000);
		}catch (Exception e) {
			Assert.assertTrue(hd.getFllCashAndCarryMarketsSpringandFall().getText().equalsIgnoreCase("Fall Cash & Carry"));
			hd.getFllCashAndCarryMarketsSpringandFall().click();
			Assert.assertTrue(driver.getTitle().contains("Fall Cash & Carry"));
			driver.get(prop.getProperty("lvmappurl"));
			Thread.sleep(2000);
		}
		
		//Check ADAC
		hd.getAtlanta().click();
		Assert.assertTrue(hd.getADAC().getText().equalsIgnoreCase("ADAC"));
		hd.getADAC().click();
		Assert.assertTrue(driver.getTitle().contains("ADAC"));
		driver.navigate().back();
		Thread.sleep(2000);
		
		//Check AmericasMart
		hd.getAtlanta().click();
		Assert.assertTrue(hd.getAmericasMart().getText().equalsIgnoreCase("AmericasMart"));
		hd.getAmericasMart().click();
		Assert.assertTrue(driver.getTitle().contains("Wholesale Gift, Home, Rug and Apparel Markets"));
		driver.get(prop.getProperty("ammarturl"));
		Thread.sleep(2000);
		
		//Check Atlanta Convention Center
		hd.getAtlanta().click();
		Assert.assertTrue(hd.getAtlantaConventionCenter().getText().equalsIgnoreCase("Atlanta Convention Center"));
		hd.getAtlantaConventionCenter().click();
		Assert.assertTrue(driver.getTitle().contains("Atlanta Convention Center"));
		driver.navigate().back();
		Thread.sleep(2000);
		
		//Verify that Las Vegas link is present
		Assert.assertTrue(hd.getLasVegas().getText().equalsIgnoreCase("LAS VEGAS"));
		
		//Check Las Vegas Market
		hd.getLasVegas().click();
		Assert.assertTrue(hd.getLasVegasMarket().getText().equalsIgnoreCase("Las Vegas Market"));
		hd.getLasVegasMarket().click();
		Assert.assertTrue(driver.getTitle().contains("Las Vegas Market"));
		driver.navigate().back();
		Thread.sleep(2000);
		
		//Check Formal Markets
		hd.getLasVegas().click();
		Assert.assertTrue(hd.getFormalMarkets().getText().equalsIgnoreCase("Formal Markets"));
		hd.getFormalMarkets().click();
		Assert.assertTrue(driver.getTitle().contains("Formal Markets"));
		driver.navigate().back();
		Thread.sleep(2000);
		
		//Check Las Vegas Apparel
		hd.getLasVegas().click();
		Assert.assertTrue(hd.getLasVegasApparel().getText().equalsIgnoreCase("Las Vegas Apparel"));
		hd.getLasVegasApparel().click();
		Assert.assertTrue(driver.getTitle().contains("Las Vegas Apparel"));
		driver.navigate().back();
		Thread.sleep(2000);
		
		//Check Las Vegas Design Center (LVDC)
		hd.getLasVegas().click();
		Assert.assertTrue(hd.getLasVegasDesignCenter().getText().equalsIgnoreCase("Las Vegas Design Center (LVDC)"));
		hd.getLasVegasDesignCenter().click();
		Assert.assertTrue(driver.getTitle().contains("Las Vegas Design Center"));
		driver.navigate().back();
		Thread.sleep(2000);
		
		//Check EXPO at World Market Center Las Vegas
		hd.getLasVegas().click();
		Assert.assertTrue(hd.getEXPOatWorldMarketCenterLasVegas().getText().equalsIgnoreCase("EXPO at World Market Center Las Vegas"));
		hd.getEXPOatWorldMarketCenterLasVegas().click();
		Assert.assertTrue(driver.getTitle().contains("The Expo At World Market Center"));
		driver.navigate().back();
		Thread.sleep(2000);
		
		//Verify that High Point link is present
		Assert.assertTrue(hd.getHighPoint().getText().equalsIgnoreCase("HIGH POINT"));
		
		//Check ANDMORE at High Point Market
		hd.getHighPoint().click();
		Assert.assertTrue(hd.getANDMOREatHighPointMarket().getText().equalsIgnoreCase("ANDMORE at High Point Market"));
		hd.getANDMOREatHighPointMarket().click();
		Thread.sleep(4000);
		Assert.assertTrue(driver.getCurrentUrl().contains("andmorehighpointmarket.com"));
		driver.navigate().back();
		Thread.sleep(2000);
		
		//Check SHOPPE OBJECT High Point
		hd.getHighPoint().click();
		Assert.assertTrue(hd.getSHOPPEOBJECTHighPoint().getText().equalsIgnoreCase("SHOPPE OBJECT High Point"));
		hd.getSHOPPEOBJECTHighPoint().click();
		Assert.assertTrue(driver.getTitle().contains("High Point Market | Shoppe Object - High Point"));
		driver.navigate().back();
		Thread.sleep(2000);
		
		//Verify that New York link is present
		Assert.assertTrue(hd.getNewYork().getText().equalsIgnoreCase("NEW YORK"));
		
		//Check SHOPPE OBJECT
		hd.getNewYork().click();
		Assert.assertTrue(hd.getSHOPPEOBJECT().getText().equalsIgnoreCase("SHOPPE OBJECT"));
		hd.getSHOPPEOBJECT().click();
		Assert.assertTrue(driver.getTitle().contains("Shoppe Object"));
		driver.navigate().back();
		Thread.sleep(2000);
		
	}
	
	@Test(priority=2)
	public void TS002_AMC_VerifyAllSocialMediaLinksOnFooterTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-013: To verify the all social media links and it's redirection

		amfl = new AMFooterLinksNavigationPage(driver);
		utl = new Utility(driver); 
		fl = new UXPFooterLinksNavigationPage(driver);
		
		driver.get(prop.getProperty("ammarturl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//Scroll till footer links
		utl.scrollToElement(fl.marketInfoAMC());
		//Thread.sleep(5000);

		//In app footer click on 'Facebook' icon and verify results
		amfl.getFacebookIcon().click();

		//Verify that 'AMC Facebook' page should be displayed
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.facebook.com/AmericasmartAtl"));
		System.out.println("Facebook opened successfully");
		driver.get(prop.getProperty("ammarturl"));
		utl.verifyCloseBtnPopup();

		//In app footer click on 'Twitter' icon and verify results
		/*amfl.getTwitterIcon().click();

		//Verify that 'AMC Twitter' page should be displayed
		Assert.assertTrue(driver.getCurrentUrl().contains("https://twitter.com/americasmartatl"));
		System.out.println("Twitter opened successfully");
		driver.get(prop.getProperty("ammarturl"));


		//Click on Instagram icon
		amfl.getInstagramIcon().click();

		//Verify that 'AMC Instagram' page should be displayed
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.instagram.com/americasmartatl/"));
		System.out.println("Instagram opened successfully");
		driver.get(prop.getProperty("ammarturl"));

		Thread.sleep(8000);
		//Click on Youtube icon
		amfl.getYoutubeIcon().click();

		//Verify that 'AMC Instagram' page should be displayed
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.youtube.com/user/AmericasMart"));
		System.out.println("Instagram opened successfully");
		driver.get(prop.getProperty("ammarturl"));*/
	}


	@Test(priority=3)
	public void TS003_AMC_VerifyAllLinksUnderMarketsAndEventsTabTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T012: To verify links for Attend tab at Header
		mi = new UXPMarketInfoPage(driver);
		exhp = new UXPExhibitorsAndProductsTabPage(driver);
		atat = new ATLAttendPage(driver);
		amme = new AMMarketsAndEventsPage(driver);

		driver.get(prop.getProperty("ammarturl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		utl.verifyCloseBtnPopup();
		//Click Markets and Events tab at Header
		//Thread.sleep(3000);
		atat.getATLAttendTab().click();
		Thread.sleep(500);
		//Click Attend our next market tab under Markets and Events section
		String winHandleBefore = driver.getWindowHandle();
		amme.getattendournextmarket().click();
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);}
		Assert.assertTrue(driver.getCurrentUrl().contains("https://compass.onpeak.com/"));
		System.out.println("Attend our next market section is displayed properly");
		driver.close();
		driver.switchTo().window(winHandleBefore);
		
		driver.get(prop.getProperty("ammarturl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		utl.verifyCloseBtnPopup();
		
		atat.getATLAttendTab().click();
		//Click Market Dates and Hours tab under Markets and Events section

		amme.getMarketDatesAndHour().click();
		Thread.sleep(3000);
		Assert.assertEquals(exhp.getVerifyBreadcrumb().getText(), "Market Dates and Hours");
		System.out.println("Market Dates and Hours section is displayed properly");

		atat.getATLAttendTab().click();

		//Click Spring Market tab under Markets and Events section
		amme.getAMCSpringMarket().click();
		Thread.sleep(3000);
		Assert.assertTrue(driver.getCurrentUrl().contains(prop.getProperty("ammarturl")+ "Markets/Spring-Market"));
		//Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(), "Spring Market");
		System.out.println("Spring Market section is displayed properly");
		atat.getATLAttendTab().click();

		//Click Spring Cash & Carry under Markets and Events section

		amme.getAMCSpringCashnCarry().click();
		Thread.sleep(3000);
		Assert.assertEquals(exhp.getVerifyBreadcrumb().getText(), "Spring Cash & Carry");
		System.out.println("Spring Cash & Carry section is displayed properly");
		atat.getATLAttendTab().click();

		//Click Fall Market under Markets and Events section

		amme.getAMCFallMarket().click();
		Thread.sleep(3000);
		Assert.assertEquals(exhp.getVerifyBreadcrumb().getText(), "Fall Market");
		System.out.println("Fall Market section is displayed properly");
		atat.getATLAttendTab().click();

		//Click Fall Cash & Carry under Markets and Events section

		amme.getFallCashCarry().click();
		Thread.sleep(3000);
		Assert.assertTrue(driver.getCurrentUrl().contains(prop.getProperty("ammarturl")+"Markets/Fall-Cash-and-Carry"));
		System.out.println("Fall Cash & Carry section is displayed properly");
		atat.getATLAttendTab().click();

		//Click Open Year Round under Markets and Events section

		amme.getYearRoundEvents().click();
		Thread.sleep(3000);
		Assert.assertEquals(exhp.getVerifyBreadcrumb().getText(), "Calendar of Events");
		System.out.println("Open Year Round section is displayed properly");
		atat.getATLAttendTab().click();

		//Click Atlanta Market logo under Markets and Events section

		amme.getAtlantaMarket().click();
		Thread.sleep(3000);
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.atlantamarket.com/"));
		System.out.println("Atlanta Market website is displayed properly.");
		driver.get(prop.getProperty("ammarturl"));
		utl.verifyCloseBtnPopup();
		atat.getATLAttendTab().click();

		//Click Atlanta Apparel under Markets and Events section

		amme.getAtlantaApparel().click();
		Thread.sleep(3000);
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.atlanta-apparel.com/"));
		System.out.println("Atlanta Apparel website is displayed properly.");
		driver.get(prop.getProperty("ammarturl"));
	}

	@Test(priority=4)
	public void TS004_AMC_VerifyGlobalSearchFunctionalityTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T63: To verify global search functionality

		lap = new UXPLandingPage(driver);
		lp = new UXPLoginPage(driver);
		gs = new UXPGlobalSearchPage(driver);
		atlgs = new ATLGlobalSearchPage(driver);
		
		driver.get(prop.getProperty("ammarturl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		utl.verifyCloseBtnPopup();
		gs.getGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchinput")));
		Thread.sleep(5000);
		gs.getSearchButton().click();
		Thread.sleep(5000);
		String searchterm = atlgs.getATLVerifyGlobalSeacrh().getText();
		Assert.assertTrue(searchterm.contains(prop.getProperty("globalsearchinput")));
		System.out.println("Global Search functionality is working properly.");
	}
	
	@Test(priority=5)
	public void TS005_AMC_VerifyAllLinksUnderAboutTabTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T005: To verify links for Market info tab at Header

		mi = new UXPMarketInfoPage(driver);
		amab = new AMAboutTabPage(driver);
		exhp = new UXPExhibitorsAndProductsTabPage(driver);
		
		driver.get(prop.getProperty("ammarturl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		utl.verifyCloseBtnPopup();
		//Click About tab at Header
		mi.getMarketInfoHeader().click();
		Assert.assertTrue(mi.getVerifyMarketInfoSection().isDisplayed());

		//Click About Americas Mart option under About tab
		mi.getAboutLasVegasMarket().click();
		Thread.sleep(3000);
		Assert.assertEquals(mi.getVerifyContactUs().getText(), "About");
		System.out.println("About Americas Mart section is displayed properly");
		mi.getMarketInfoHeader().click();

		//Click Press Center option under About tab
		mi.getMarketDatesAndHrs().click();
		Thread.sleep(3000);
		Assert.assertEquals(exhp.getVerifyBreadcrumb().getText(), "Press Releases");
		System.out.println("Press Center section is displayed properly");
		mi.getMarketInfoHeader().click();
		
		//Due to re-branding changes
/*		//Click Atlanta Next option under About tab
		mi.getFAQs().click();
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(), "Atlanta Next");
		System.out.println("Atlanta Next section is displayed properly");
		mi.getMarketInfoHeader().click();
*/
		//Click History option under About tab
		amab.getHistory().click();
		Thread.sleep(3000);
		Assert.assertEquals(exhp.getVerifyBreadcrumb().getText(), "History");
		System.out.println("History section is displayed properly");
		mi.getMarketInfoHeader().click();

		//Click Careers option under About tab

		amab.getCareers().click();
		Thread.sleep(3000);
		Assert.assertEquals(exhp.getVerifyBreadcrumb().getText(), "Careers");
		System.out.println("Careers section is displayed properly");
		mi.getMarketInfoHeader().click();

		//Click Contact Us option under Market Info

		amab.getContactUs().click();
		Thread.sleep(3000);
		Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("ammarturl")+"About/Contact-Us");
		utl.verifyCloseBtnPopup();
		mi.getMarketInfoHeader().click();
		Thread.sleep(1000);
		//Click Industry Partners option under Market Info

		amab.getIndustryPartners().click();
		Thread.sleep(3000);
		Assert.assertEquals(exhp.getVerifyBreadcrumb().getText(), "Industry Partners");
		System.out.println("Industry Partners section is displayed properly");
	}
	
	@Test(priority=6)
	public void TS006_AMC_VerifyAllLinksUnderExhibitTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T107: To verify the Exhibit tab overview and it's functionality

		lap = new UXPLandingPage(driver);
		lp = new UXPLoginPage(driver);
		amhe = new AMHeaderLinksPage(driver);
		mi = new UXPMarketInfoPage(driver);
		amab = new AMAboutTabPage(driver);
		exhp = new UXPExhibitorsAndProductsTabPage(driver);
		amexh=new AMExhibitTabPage(driver);
		atlps = new ATLProfileAndSettingsPage(driver);
		atlexh = new ATLExhibitPage(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//Click on Exhibit Tab 
		//Thread.sleep(3000);
		//utl.verifyCloseBtnPopup();
		amexh.getamcExhibitTab().click();
		//Click Exhibit at Americas Mart Link
		amexh.getExhibitAtAmc().click();
		Thread.sleep(3000);
		//Verify that Exhibit at AmC page should be displayed
		Assert.assertEquals(amexh.getAMCExhibitBrdcrumb().getText(), "Exhibit");

		amexh.getamcExhibitTab().click();
		//Click Exhibit and Leasing Options Link
		amexh.getLeasingandExhibitOptions().click();
		Thread.sleep(3000);
		//Verify that leasing and exhibit options page should be displayed
		Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("ammarturl")+"Exhibit/Opportunities");
		utl.verifyCloseBtnPopup();

		amexh.getamcExhibitTab().click();
		//Click Advertising Link
		amexh.getAdvertising().click();
		Thread.sleep(3000);
		//Verify that Advertising page should be displayed
		Assert.assertEquals(exhp.getVerifyBreadcrumb().getText(),"Advertising");
		
		//Exhibitor Portal Login
		amexh.getamcExhibitTab().click();	
		Thread.sleep(500);
		String winHandleBefore = driver.getWindowHandle();
		amexh.getExpLogin().click();
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);}
		Thread.sleep(10000);
		Assert.assertTrue(driver.getCurrentUrl().contains("https://prodmvdp.b2clogin.com/"));
		System.out.println("Page opened successfully");
		driver.close();
		driver.switchTo().window(winHandleBefore);
		
		//Exhibitor Portal Guide
		//amexh.getamcExhibitTab().click();	
		String winHandleBefore1 = driver.getWindowHandle();
		amexh.getExpGuide().click();
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);}
		Assert.assertTrue(driver.getCurrentUrl().contains("support.andmore.com"));
		System.out.println("Page opened successfully");
		driver.close();
		driver.switchTo().window(winHandleBefore1);
		//Click Advertising Link
		amexh.getExpFAQs().click();
		Thread.sleep(3000);
		//Verify that FAQs page should be displayed
		Assert.assertEquals(exhp.getVerifyBreadcrumb().getText(), "Exhibitor FAQs");

	}

	@Test(priority=7)
	public void TS007_AMC_VerifyAllLinksUnderOpenYearRoundTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T104: To verify the Open year round links and it's functionality

		lap = new UXPLandingPage(driver);
		lp = new UXPLoginPage(driver);
		amhe = new AMHeaderLinksPage(driver);
		mi = new UXPMarketInfoPage(driver);
		amab = new AMAboutTabPage(driver);
		exhp = new UXPExhibitorsAndProductsTabPage(driver);
		amoyr=new AMOpenYearRoundPage(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		utl.verifyCloseBtnPopup();
		//Click on Open Year Round Tab 
		amoyr.getOpenYearRoundTab().click();

		//Click About Open Year Round Link
		amoyr.getAboutYearRound().click();
		Thread.sleep(5000);
		//Verify that About Open Year Round page should be displayed
		String actualHeader="Open Year Round";
		Assert.assertTrue(amoyr.getAboutYearRoundPageHeader().getText().equals(actualHeader));

		//Verify how to register 
/*		amoyr.getOpenYearRoundTab().click();
		amoyr.gethowtoregister().click();
		Thread.sleep(3000);
		Assert.assertTrue(exhp.getVerifyBreadcrumb().getText().contains("How to Register"));
		System.out.println("How to regiter opened");
*/	
		//Click on Open Year Round Tab 
		amoyr.getOpenYearRoundTab().click();
		//Click Open Year Round Showrooms Link
		amoyr.getOpenYearRoundShowrooms().click();
		Thread.sleep(3000);
		utl.scrollToElement(amoyr.getOpenYearRoundShowroomsPageHeader());
		//Verify that Open Year Round Showrooms page should be displayed
		String actualShowroomDirectHeader="Open Year Round Showrooms at AmericasMart";
		Assert.assertTrue(amoyr.getOpenYearRoundShowroomsPageHeader().getText().equalsIgnoreCase(actualShowroomDirectHeader));
		
		utl.scrollToTop();
		//Click on Open Year Round Tab 
		amoyr.getOpenYearRoundTab().click();
		//Click Exhibitor Directory Link
		amoyr.getExhibitorDirectory().click();
		Thread.sleep(3000);
		utl.scrollToElement(amoyr.getExhibitorDirectoryPageHeader());
		//Verify that Exhibitor Directory page should be displayed
		String actualExhibitorDirectoryHeader="Exhibitor Directory";
		Assert.assertTrue(amoyr.getExhibitorDirectoryPageHeader().getText().equals(actualExhibitorDirectoryHeader));

		utl.scrollToTop();
		//Click on Open Year Round Tab 
		amoyr.getOpenYearRoundTab().click();
		//Click Floor Plans Link
		amoyr.getFloorPlans().click();
		Thread.sleep(3000);
		//Verify that Floor Plans page should be displayed
		Assert.assertTrue(driver.getCurrentUrl().contains("/Market-Map"));

		utl.scrollToTop();
		amoyr.getOpenYearRoundTab().click();
		//Click Campus Overview Link
		amoyr.getCampOverview().click();
		Thread.sleep(3000);
		//Verify that Campus Overview page should be displayed	
		Assert.assertEquals(exhp.getVerifyBreadcrumb().getText(), "Campus Overview");

		utl.scrollToTop();
		amoyr.getOpenYearRoundTab().click();
		System.out.println("open Year Round DropDown");
		amoyr.getVisit().click();
		System.out.println("Visit Link");
		Thread.sleep(3000);
		Assert.assertEquals(exhp.getVerifyBreadcrumb().getText(),"Visit");

		utl.scrollToTop();
		amoyr.getOpenYearRoundTab().click();
		amoyr.getParknTranspSubmenu().click();
		Thread.sleep(3000);
		Assert.assertEquals(exhp.getVerifyBreadcrumb().getText(), "Parking & Transportation");

		amoyr.getOpenYearRoundTab().click();
		amoyr.getHotelsSubmenu().click();
		Thread.sleep(3000);
		Assert.assertTrue(driver.getCurrentUrl().contains(prop.getProperty("ammarturl")+"Markets/Hotels"));

		amoyr.getOpenYearRoundTab().click();
		amoyr.getHowToReg().click();
		Thread.sleep(3000);
		Assert.assertEquals(exhp.getVerifyBreadcrumb().getText(), "How to Register");

		amoyr.getOpenYearRoundTab().click();
		amoyr.getCalendarEvents().click();
		Thread.sleep(3000);
		Assert.assertEquals(exhp.getVerifyBreadcrumb().getText(),"Calendar of Events");

		amoyr.getOpenYearRoundTab().click();
		amoyr.getDesigners().click();
		Thread.sleep(3000);
		Assert.assertEquals(exhp.getVerifyBreadcrumb().getText(),"For Designers");
	}
	
	@Test(priority=8)
	public void TS008_AMC_VerifyExhibitorDirectoryTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T121: To verify Exhibitor Directory

		lap = new UXPLandingPage(driver);
		lp = new UXPLoginPage(driver);
		amhe = new AMHeaderLinksPage(driver);
		ed = new UXPExhibitorDirectoryPage(driver);
		gs = new UXPGlobalSearchPage(driver);
		exhp = new UXPExhibitorsAndProductsTabPage(driver);
		mi = new UXPMarketInfoPage(driver);

		driver.get(prop.getProperty("ammarturl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//utl.verifyCloseBtnPopup();
		//Verify exhibitor directory page is successfully opened
		ed.getExhibitorDirectory().click();
		Assert.assertEquals(exhp.getVerifyPgBreadcrumb().getText(), "Exhibitor Directory");

		exhp.getExhDirectSearchBox().sendKeys((prop.getProperty("exhibitordirectory")));
		exhp.getExhDirectSearchBtn().click();
		Thread.sleep(12000);

		utl.scrollToElement(mi.getVerifyContactUs());
		String searchterm = gs.getVerifyGlobalSeacrh().getText();
		Assert.assertTrue(searchterm.contains(prop.getProperty("exhibitordirectory")));
		driver.get(prop.getProperty("ammarturl"));
	}
	
	@Test(priority=9)//Previous priority is 5
	public void TS009_AMC_VerifyFooterLinksTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T69: To verify Footer Links Navigation

		exhp = new UXPExhibitorsAndProductsTabPage(driver);
		mi = new UXPMarketInfoPage(driver);
		fl = new UXPFooterLinksNavigationPage(driver);
		amfl = new AMFooterLinksNavigationPage(driver);
		atlfl = new ATLFooterLinksNavigationPage(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//	utl.verifyCloseBtnPopup();

		utl.scrollToElement(fl.marketInfoAMC());

		//Click Market Info link and verify results
		fl.marketInfoAMC().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.americasmart.com/about"));
		driver.get(prop.getProperty("ammarturl"));
		utl.scrollToElement(fl.marketInfoAMC());

		//Click on Press Center
		fl.getpressCenterAMC().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.americasmart.com/About/Press-Center"));
		driver.get(prop.getProperty("ammarturl"));
		utl.scrollToElement(fl.marketInfoAMC());
		
		// Click Download The App link and verify results
		fl.getDownloadTheApp().click();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getTitle(), "Plan Your Market");
		driver.get(prop.getProperty("ammarturl"));
		utl.scrollToElement(fl.marketInfoAMC());

		//Click on Our Brands link
		fl.getOurBrandsATL().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.americasmart.com/exhibitor/directory"));
		driver.get(prop.getProperty("ammarturl"));
		utl.scrollToElement(fl.marketInfoAMC());

		// Click Contact Us link and verify results
		fl.getContactUsATL().click();	
		Assert.assertEquals(mi.getverifyContactUsATL().getText(), "Contact Us");
		System.out.println("Contact us Page open successfully");
		driver.get(prop.getProperty("ammarturl"));
		utl.scrollToElement(fl.marketInfoAMC());

		// Click Careers link and verify results		
		fl.getCareersATL().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.andmore.com/our-team"));
		driver.get(prop.getProperty("ammarturl"));
		utl.scrollToElement(fl.marketInfoAMC());

		// Click on Terms & conditions link
		
		// Switch to new tab
		String winHandleBefore7 = driver.getWindowHandle();
		fl.getTermsAndConditions().click();
		for (String winHandle7 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle7);
		}
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.andmore.com/terms-of-use"));
		driver.close();
		driver.switchTo().window(winHandleBefore7);

		// Click Privacy Policy and verify results
		
		// Click Privacy Policy link and verify results
		
		String winHandleBefore8 = driver.getWindowHandle();
		fl.getatlprivacypolicy().click();
		for (String winHandle8 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle8);
		}
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.andmore.com/privacy-policy"));
		driver.close();
		driver.switchTo().window(winHandleBefore8);
		
		// Click Atlanta Apparel link and verify results
		
		// Switch to new tab
		String winHandleBefore9 = driver.getWindowHandle();
		fl.getAtlantaApparel().click();
		for (String winHandle9 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle9);
		}
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.atlanta-apparel.com/"));
		driver.close();
		driver.switchTo().window(winHandleBefore9);

		// Click Atlanta Market link and verify results
		
		// Switch to new tab
		String winHandleBefore1 = driver.getWindowHandle();
		fl.getAtlantaMarket().click();
		for (String winHandle1 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle1);
		}
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.atlantamarket.com/"));
		driver.close();
		driver.switchTo().window(winHandleBefore1);

		// Click on High Point Market link
		// Switch to new tab
		String winHandleBefore4 = driver.getWindowHandle();
		fl.getHighPointMarket().click();
		for (String winHandle4 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle4);
		}
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.andmorehighpointmarket.com/"));
		driver.close();
		driver.switchTo().window(winHandleBefore4);
		
		// Click on LVA Market link
		// Switch to new tab
		/*fl.getlvmlink_ATLM().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.lasvegas-apparel.com/"));
		driver.get(prop.getProperty("ammarturl"));*/
		
		String winHandleBefore5 = driver.getWindowHandle();
		fl.getlvapplink_ATL().click();
		for (String winHandle4 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle4);
		}
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.lasvegas-apparel.com/"));
		driver.close();
		driver.switchTo().window(winHandleBefore5);

		// Click on LVM Market link
		// Switch to new tab
		String winHandleBefore11 = driver.getWindowHandle();
		fl.getlvmlink_ATL().click();
		for (String winHandle11 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle11);
		}
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.lasvegasmarket.com/"));
		driver.close();
		driver.switchTo().window(winHandleBefore11);
		
		//Click International Market Centers link and verify results
		//fl.getInternationalMarketCenters().click();//Change for re-branding
		
		//Switch to new tab
		String winHandleBefore3 = driver.getWindowHandle();
		fl.getandmore().click();
		for(String winHandle3 : driver.getWindowHandles()){
			driver.switchTo().window(winHandle3);}
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.andmore.com/"));
		driver.close();
		driver.switchTo().window(winHandleBefore3);
		//utl.scrollToElement(fl.marketInfoAMC());

		//Click Juniper Market Centers link and verify results
		/*fl.getJuniperMarket().click();
		//Switch to new tab
		String winHandleBefore12 = driver.getWindowHandle();
		for(String winHandle12 : driver.getWindowHandles()){
			driver.switchTo().window(winHandle12);}
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.junipermarket.com/"));
		driver.get(prop.getProperty("ammarturl"));
		driver.close();
		driver.switchTo().window(winHandleBefore12);
		utl.scrollToElement(fl.marketInfoAMC());*/
	}
	
	//Due to re-branding changes
	@Test(enabled=false)//priority=1
	public void TS010_AMC_VerifyMarketPlannerLoginTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T101: To verify the Market Planner overview and it's functionality

		lap = new UXPLandingPage(driver);
		lp = new UXPLoginPage(driver);
		amhe = new AMHeaderLinksPage(driver);
		utl = new Utility(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		/*//Navigate to Atlanta Market site
		driver.manage().window().maximize();
		driver.get(prop.getProperty("ammarturl"));
		//Thread.sleep(5000);
		lap.getIUnderstandBtn().click();
		//Thread.sleep(5000);
		utl.verifyCloseBtnPopup();*/

		//Login to Market Planner
		utl.verifyMPLoginFunctionality();
		utl.verifyCloseBtnPopup();
		//Verify that Market Planner Home page should be displayed
		Assert.assertTrue(lap.getMPLinkText().isDisplayed());
	}

	//Due to re-branding changes
	@Test(enabled=false)//priority=2
	public void TS011_AMC_VerifyMarketPlannerProfileAndSettingsOptionTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-002: To verify Profile and Settings option in Market Planner

		lap = new UXPLandingPage(driver);
		atlps = new ATLProfileAndSettingsPage(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//Click Profile and Settings tab under Market Planner and verify result
		//Thread.sleep(5000);
		atlps.getATLWelcomeText().click();
		//Thread.sleep(5000);
		atlps.getATLProfileAndSettings().click();

		Assert.assertTrue(driver.getCurrentUrl().contains(prop.getProperty("ammarturl")+"Profile"));
		System.out.println("Profile and Settings section options are displayed properly");
	}
	
	//Due to re-branding changes
	@Test(enabled=false)//priority=3
	public void TS012_AMC_VerifyMarketPlannerExhibitorPortalOptionTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-003: To verify Exhibitor Portal option in Market Planner

		lap = new UXPLandingPage(driver);
		atlps = new ATLProfileAndSettingsPage(driver);
		atlexh = new ATLExhibitPage(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(5000);

		atlps.getATLWelcomeText().click();
		Thread.sleep(5000);
		atlps.getAMCExhibitorPortalOptn().click();

		//Verify that 'EXP Home' page should be displayed
		Assert.assertTrue(atlps.getAMCExhibitorPortalHome().isDisplayed());

		driver.get(prop.getProperty("ammarturl"));

		/*//Sign out from Market Planner
		atlps.getATLWelcomeText().click();
		lap.getMPSignOutBtn().click();
		Thread.sleep(10000);*/
	}

	/*	@AfterSuite
	public void sendEmail()
	{
		se = new SendEmail();
		se.sendEmailWithAttachment();
	}*/

	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}

}