package exhibitorportal;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ExhibitorPortal.EXPLoginPage;
import ExhibitorPortal.EXPNotificationsTabPage;
import pageObjects.AmericasMart.AMOpenYearRoundPage;
import pageObjects.LasVegasMarket.UXPLandingPage;
import pageObjects.LasVegasMarket.UXPLoginPage;
import resources.GenerateData;
import resources.SendEmail;
import resources.Utility;
import resources.base;

@Listeners({TestListeners.class})
public class ExhibitorPortalSmokeTest_UAT extends base {
	public WebDriverWait wait;
	public GenerateData genData;
	public Utility utl;
	UXPLandingPage lap;
	UXPLoginPage lp;
	EXPNotificationsTabPage nt;
	EXPLoginPage el;
	SendEmail se;

	@BeforeTest
	public void initialize() throws IOException, InterruptedException
	{
		driver = initializeDriver(); //requires for Parallel text execution
		utl = new Utility(driver);
		lap = new UXPLandingPage(driver);
		
		//Navigate to Exhibitor Portal
		driver.manage().window().maximize();
		driver.get(prop.getProperty("expurl"));
			
	}

	@Test(priority=1)
	public void TS001_VerifyExhibitorPortalLoginTest() throws InterruptedException, IOException
	{
		
		//The purpose of this test case to verify:-
		//UXP-T101: To verify the Market Planner overview and it's functionality

				lap = new UXPLandingPage(driver);
				lp = new UXPLoginPage(driver);
				el = new EXPLoginPage(driver);
				
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
				//Login to Market Planner
				el.getEmailAddress().sendKeys(prop.getProperty("username"));
				el.getPassword().sendKeys(prop.getProperty("password"));
				el.getSignInBtn().click();
				Thread.sleep(5000);
				lap.getIUnderstandBtn().click();
				Thread.sleep(5000);
				
				//Verify that Exhibitor Portal Home page should be displayed
				Assert.assertTrue(el.getVerifyExpHomePage().isDisplayed());
				System.out.println("Exhibitor Portal home page is displayed properly.");
	}
	
	@Test(priority=2)
	public void TS002_VerifyNotificationsTabTest() throws InterruptedException, IOException
	{
		
		//The purpose of this test case to verify:-
		//UXP-T101: To verify the Market Planner overview and it's functionality

				lap = new UXPLandingPage(driver);
				lp = new UXPLoginPage(driver);
				nt = new EXPNotificationsTabPage(driver);
				
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
				//Click Notifications icon and verify results
				nt.getNotifications().click();
				Assert.assertEquals(nt.getVeirfyNotifications().getText(), "Exhibitor Portal Message Center");
				System.out.println("Exhibitor Portal notifications page is displayed properly.");
	}
}