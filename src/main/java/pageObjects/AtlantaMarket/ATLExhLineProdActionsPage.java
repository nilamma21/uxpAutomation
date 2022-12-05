package pageObjects.AtlantaMarket;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import resources.base;

public class ATLExhLineProdActionsPage extends base{

	public WebDriver driver;
	public WebDriverWait wait;

	By addfavicon = By.xpath("(//li[@class='imc-exhibitorcard--action imc-exhibitorcard--contact imc-exhibitorcard--contact--heart'])[position()=1]"); // Locator of add to Favorite icon
	By exhibitorname = By.xpath("//div[@class='imc-gallery__item imc-exhibitorcard imc-line'][1]/div/div/div/div/a/h2"); //Locator for 1st Exhibitor name from Search results grid
	By searchresultmoreicon = By.xpath("//div[@class='imc-gallery__item imc-exhibitorcard imc-line'][1]/div/div/div/div[2]/div[2]/ul/li[3]"); //Locator for More icon for 1st item in search result
	By addtolistoptn = By.xpath("//div[@class='imc-popup--container']/div/label"); //Locator for Add to List option for 1st Search result item
	By contactexhibitoricon = By.xpath("//div[@class='imc-gallery__item imc-exhibitorcard imc-line'][1]/div/div/div/div[2]/div[2]/ul/li[1]/div/button"); //Locator for Contact Exhibitor icon of 1st Exhibitor
	By contactexhibitormodal = By.xpath("//div[@class='imc-modal--content imc-contactexhibitormodal--position']"); //Locator for Contact Exhibitor Modal
	By postalcodetxtbx = By.xpath("//input[@data-xpath='contactexhibitormodal.postalCode']"); //Locator for Postal Code text field
	By messagetxtbx = By.xpath("//textarea[@data-xpath='contactexhibitormodal.message']"); //Locator for Message Text field
	By prodcatg1 = By.xpath("//div[@class='imc-formfield imc-content formfield-contact-exhibitor']/div[2]/div[1]"); //Locator for 1st Product Category on Contact Exhibitor form
	By prodcatg2 = By.xpath("//div[@class='imc-formfield imc-content formfield-contact-exhibitor']/div[2]/div[2]"); //Locator for 2nd Product Category on Contact Exhibitor form
	By sendmessagebtn = By.xpath("//input[@data-xpath='contactExhibitor.send']"); //Locator for end Message button
	By locationlinkinexhcard = By.xpath("//div[@class='imc-gallery__item imc-exhibitorcard imc-line'][1]/div/div/div/div[2]/div[1]/div[1]/a"); //Locator for 1st Location link of an Exhibitor
	By lineshownseealllink = By.xpath("//div[@class='imc-gallery__item imc-exhibitorcard imc-line'][1]/div/div/div/div/div/a[contains(text(), 'See All')]"); //Locator for Lines Shown-See All link for 1st Exhibitor
	By validatelinespage = By.xpath("//div[@id='Lines']"); //Locator for Lines tab on Lines page
	By totalprodseealllink = By.xpath("//div[@class='imc-gallery__item imc-exhibitorcard imc-line'][1]/div[2]/div[2]/div/div[2]/p[2]"); //Locator for Total Products-See All link for 1st Exhibitor
	By validateproductspage = By.xpath("//div[@id='Products']"); //Locator for Products tab on Exhibitor products page
	By totalprodcountonsearchgrid = By.xpath("//div[@class='imc-gallery__item imc-exhibitorcard imc-line'][1]/div[2]/div[2]/div/div[2]/p[1]"); //Locator for Total Products count on Search Results grid
	By matchingprodcountonsearchgrid = By.xpath("//div[@class='imc-gallery__item imc-exhibitorcard imc-line'][1]/div[2]/div[2]/div/div[1]/p[1]"); //Locator for Matching Products count on Search Results grid
	By matchingprodseealllink = By.xpath("//div[@class='imc-gallery__item imc-exhibitorcard imc-line'][1]/div[2]/div[2]/div/div[1]/p[2]"); //Locator for Matching Products-See All link for 1st Exhibitor
	By matchingprodaddnoteicon = By.xpath("//button[@class='imc-addnote__openModal imc-addnote__openModal--hideafter imc-link--alt-darkred imc-content imc-content--delta imc-expand-collapse__heading']"); //Locator for Add Note icon on Matching products page
	By popupclosebtn = By.xpath("//button[@class='imc-modal--close imc-button--modal-close imc-button--round']"); //Locator for Close pop-up button
	By notetitletxtbx = By.xpath("//div[@class='modal-wrapper']/div[1]/form[1]/div[1]/input[1]"); //Locator for Note title text field
	By notecontenttxtbx = By.xpath("//div[@class='modal-wrapper']/div[1]/form[1]/div[2]/textarea[1]"); //Locator for Note Content text field
	By notesavebtn = By.xpath("//input[@value='Save']"); //Locator for Save Note button
	By viewallnoteslink = By.xpath("//a[@href='#list']"); //Locator for View All Notes link
	By savednotenameinallnoteslist = By.xpath("//ul[@class='imc-market-planner-list imc-addnote-modal__list']/li/a"); //Locator for Saved Note name in All Notes list
	By noteforanexhibitormodal = By.xpath("//h4[contains(text(),'Note For exhibitor')]"); //Locator for Note for an Exhibitor modal
	By deletenotebtn = By.xpath("//a[@href='#delete']"); //Locator for Delete note button
	By orderOnJuniperMarketBtn = By.xpath("//div[@class='imc-vr--xxlarge']/div[1]/div[2]/div[2]/a[1]"); //Locator for Order On Juniper Market Btn
	By exhibitorNameLink = By.xpath("//div[@class='imc-vr--xxlarge']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/p[1]/a[1]"); //Locator for Order On Juniper Market Btn
	By lineLocationLink = By.xpath("//div[@class='imc-vr--xxlarge']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/a[1]"); //Locator for Location
	By seealllink = By.xpath("//div[@class = 'imc-exhibitorcard--text-container-row']/a[1]"); //Locator for Sell All link for exhibitors to find LInes
	By createlistbtn = By.xpath("//div[@class = 'imc-market-planner-quick-add-modal__content']/div[1]/div[2]/form[1]/div[2]/div[2]/div[1]/input[1]"); //Locator for Create and Add form for Add New List to Line page
	By seedetailsbtn = By.xpath("(//div[@class='imc-gallery__item imc-exhibitorcard imc-line'][1]/div[2]/div/div/div/div/div/div[2]/div[2]/a)[1]"); //Locator for See Details button
	By exhibitorProdcut = By.xpath("//div[@class='imc-vr--xxlarge']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]"); //Locator for product
	By exhibitorProdcut_ATLPROD = By.xpath("//div[@class='imc-vr--xxlarge']/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]"); //Locator for product
	By exhproductnameonsearchgrid = By.xpath("//div[@class='imc-vr--xxlarge']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/p[1]"); //Locator for productName
	By productaddtofavbtn = By.xpath("(//div[@class='imc-gallery__item imc-exhibitorcard imc-line'][1]/div[2]/div/div/div/div/div/div/div/div/span/div/button)[1]"); //Locator for Add to Favorite button for Product on Search Results grid
	By productaddtofavbtn_ATLPROD = By.xpath("(//div[@class='imc-gallery__item imc-exhibitorcard imc-line'][1]/div[2]/div/div/div/div/div/div/div/div/span/div/button)[2]"); //Locator for Add to Favorite button for Product on Search Results grid
	By seeDetailsBtn = By.xpath("(//div[@class='imc-gallery imc-gallery--80-20 imc-exhibitorcard--gallery-nowrap'])[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/a[1]"); //Locator for See Details button
	By productmorebtn = By.xpath("(//div[@class='imc-gallery__item imc-exhibitorcard imc-line'][1]/div[2]/div/div/div/div/div/div/div/div/span[2]/div)[1]"); //Locator for Add to List button for Product on Search Results grid
	By productformultiplecatg = By.xpath("//div[@class='imc-vr--xxlarge']/div[4]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]"); //Locator for product to verify multiple Prod categ selection
	By seedetailsbtn3rdexhproduct = By.xpath("(//div[@class='imc-gallery imc-gallery--80-20 imc-exhibitorcard--gallery-nowrap'])[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/a[1]"); //Locator for See Details button of 3rd exh product
	By imcexhibitorname = By.xpath("//h2[contains(text(),'IMC test company')]"); //Locator for IMC Exhibitor name from Search results grid
	By productFevBtn = By.xpath("//div[@class='imc-vr--xxlarge']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]/div[1]/button[1]"); //Locator for Fev Btn
	By catalogstab = By.xpath("//a[@id='Catalogs']"); //Locator for Catalogs tab on Exhibitor products page
	By catalogitem = By.xpath("//div[@class='imc-catalog__item_title multiSelectItem']/div/span/span"); //Locator for Catalog item
	By eventcardinsearch = By.xpath("//div[@class='imc-vr--xlarge imc-eventcard']");//Locator for Event card in search results
	By eventcardtitle = By.xpath("//span[contains(@class,'imc-eventcard__title')]"); //Locator for Event Card title
	By eventdetailsheader = By.xpath("//h1[contains(@class,'imc-heading')]"); //Locator for header of Events details btn
	By eventdetailstag = By.xpath("//a[contains(@class,'imc-eventdetail--tag')]"); //Locator for tag on Event Details
	By eventcardtag = By.xpath("//ul[@class='imc-cardtags imc-content--light imc-eventcard__tag']/li/button"); //Locator for Event Card tag
	
	By catalogstabPROD = By.xpath("//div[@id='Catalogs']"); //Locator for Catalogs tab on Exhibitor products page
	//img[@class='imc-saved-exhibitors__img-grid']
	
	public ATLExhLineProdActionsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
	} 

	public WebElement getcatalogstabPROD() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(catalogstabPROD));
		return driver.findElement(catalogstabPROD);
	}
	public WebElement getExhibitorName() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(exhibitorname));
		return driver.findElement(exhibitorname);
	}
	
	public WebElement getAddFavIcon() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(addfavicon));
		return driver.findElement(addfavicon);
	}
	public WebElement getSearchResultMoreicon() {
		return driver.findElement(searchresultmoreicon);
	}
	public WebElement getAddToListOptn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(addtolistoptn));
		return driver.findElement(addtolistoptn);
	}
	public WebElement getContactExhibitorIcon() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(contactexhibitoricon));
		return driver.findElement(contactexhibitoricon);
	}
	public WebElement getContactExhibitorModal() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(contactexhibitormodal));
		return driver.findElement(contactexhibitormodal);
	}
	public WebElement getPostalCodeTxtBx() {
		return driver.findElement(postalcodetxtbx);
	}
	public WebElement getMessageTxtBx() {
		return driver.findElement(messagetxtbx);
	}
	public WebElement getProductCateg1() {
		return driver.findElement(prodcatg1);
	}
	public WebElement getProductCateg2() {
		return driver.findElement(prodcatg2);
	}
	public WebElement getSendMessageBtn() {
		return driver.findElement(sendmessagebtn);
	}
	public WebElement getLocationLinkInExhCard() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locationlinkinexhcard));
		return driver.findElement(locationlinkinexhcard);
	}
	public WebElement getLinesShownSeeAlLink() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(lineshownseealllink));
		return driver.findElement(lineshownseealllink);
	}
	public WebElement getValidateLinesPage() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(validatelinespage));
		return driver.findElement(validatelinespage);
	}
	public WebElement getTotalProdSeeAllLink() {
		return driver.findElement(totalprodseealllink);
	}
	public WebElement getValidateProductsPage() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(validateproductspage));
		return driver.findElement(validateproductspage);
	}
	public WebElement getTotalProdCountOnSearchGrid() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(totalprodcountonsearchgrid));
		return driver.findElement(totalprodcountonsearchgrid);
	}
	public WebElement getMatchingProdCountOnSearchGrid() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(matchingprodcountonsearchgrid));
		return driver.findElement(matchingprodcountonsearchgrid);
	}
	public WebElement getMatchingProdSeeAllLink() {
		return driver.findElement(matchingprodseealllink);
	}
	public WebElement getMatchingProdAddNoteIcon() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(matchingprodaddnoteicon));
		return driver.findElement(matchingprodaddnoteicon);
	}
	public WebElement getPopUpCloseBtn() {
		return driver.findElement(popupclosebtn);
	}
	public WebElement getNoteTitleTxtBx() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(notetitletxtbx));
		return driver.findElement(notetitletxtbx);
	}
	public WebElement getNoteContentTxtBx() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(notecontenttxtbx));
		return driver.findElement(notecontenttxtbx);
	}
	public WebElement getNoteSaveBtn() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(notesavebtn));
		return driver.findElement(notesavebtn);
	}
	public WebElement getViewAllNotesLink() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(viewallnoteslink));
		return driver.findElement(viewallnoteslink);
	}
	public List <WebElement> getSavedNoteNameInAllNotesList() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(savednotenameinallnoteslist));
		return driver.findElements(savednotenameinallnoteslist);
	}
	public WebElement getNoteForAnExhibitorModal() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(noteforanexhibitormodal));
		return driver.findElement(noteforanexhibitormodal);
	}
	public WebElement getDeleteNoteBtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(deletenotebtn));
		return driver.findElement(deletenotebtn);
	}
	public WebElement getOrderOnJuniperMarketBtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(orderOnJuniperMarketBtn));
		return driver.findElement(orderOnJuniperMarketBtn);
	}

	public WebElement getExhibitorNameLink() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(exhibitorNameLink));
		return driver.findElement(exhibitorNameLink);
	}
	public WebElement getLineLocationLink() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(lineLocationLink));
		return driver.findElement(lineLocationLink);
	}
	
	public WebElement getseealllink() throws InterruptedException {
		Thread.sleep(5000);
		return driver.findElement(seealllink);
	}
	public WebElement getcreatelistbtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(createlistbtn));
		return driver.findElement(createlistbtn);
	}
	public WebElement getSeeDetailsbtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(seedetailsbtn));
		return driver.findElement(seedetailsbtn);
	}
	public WebElement getExhibitorProduct() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(exhibitorProdcut));
		return driver.findElement(exhibitorProdcut);
	}
	public WebElement getExhProductNameOnSearchGrid() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(exhproductnameonsearchgrid));
		return driver.findElement(exhproductnameonsearchgrid);
	}
	public WebElement getProductAddToFavBtnOnSearchGrid() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(productaddtofavbtn));
		return driver.findElement(productaddtofavbtn);
	}

	public WebElement getProdSeeDetailsBtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(seeDetailsBtn));
		return driver.findElement(seeDetailsBtn);
	}
	public WebElement getProductMoreBtnOnSearchGrid() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(productmorebtn));
		return driver.findElement(productmorebtn);
	}
	public WebElement getProductForMultipleCatg() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(productformultiplecatg));
		return driver.findElement(productformultiplecatg);
	}
	public WebElement getThirdExhProdSeeDetailsBtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(seedetailsbtn3rdexhproduct));
		return driver.findElement(seedetailsbtn3rdexhproduct);
	}
	public WebElement getIMCExhibitorName() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(imcexhibitorname));
		return driver.findElement(imcexhibitorname);
	}
	public WebElement getProductFevBtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(productFevBtn));
		return driver.findElement(productFevBtn);
	}	
	public WebElement getCatalogsTab() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(catalogstab));
		return driver.findElement(catalogstab);
	}
	public WebElement getCatalogsItem() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(catalogitem));
		return driver.findElement(catalogitem);
	}
	public WebElement getEventCardInSearch() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eventcardinsearch));
		return driver.findElement(eventcardinsearch);
	}
	public WebElement getEventCardTitle() {
		return driver.findElement(eventcardtitle);
	}
	public WebElement getEventDetailsHeader() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eventdetailsheader));
		return driver.findElement(eventdetailsheader);
	}
	public WebElement getEventDetailsTag() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eventdetailstag));
		return driver.findElement(eventdetailstag);
	}
	public WebElement getEventCardTag() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eventcardtag));
		return driver.findElement(eventcardtag);
	}
	public WebElement getproductaddtofavbtn_ATLPROD() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(productaddtofavbtn_ATLPROD));
		return driver.findElement(productaddtofavbtn_ATLPROD);
	}
	public WebElement getexhibitorProdcut_ATLPROD() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(exhibitorProdcut_ATLPROD));
		return driver.findElement(exhibitorProdcut_ATLPROD);
	}
	
	
	
}



