package contacttest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import genericutility.BaseClass;
import objectrepository.CampaignsPage;
import objectrepository.ContactsPage;
import objectrepository.CreateContactPage;
import objectrepository.Homepage;
import objectrepository.SelectCampaignpage;
import objectrepository.createcampaignpage;

public class CreateContactTest extends BaseClass {


	@Test(groups = { "smoke","regression"})
	public void createContactWithMandatoryFieldsTest() throws EncryptedDocumentException, IOException {
		// Reading data from excel file
		String CAMPAIGN_NAME = eLib.readDataFromExcelFile("Contacts", 1, 2);
		String TARGET_SIZE = eLib.readDataFromExcelFile("Contacts", 1, 3);
		String ORGANIZATION_NAME = eLib.readDataFromExcelFile("Contacts", 1, 4);
		String TITLE = eLib.readDataFromExcelFile("Contacts", 1, 5);
		String CONTACT_NAME = eLib.readDataFromExcelFile("Contacts", 1, 6);

		// Create Campaign with Mandatory Fields
		CampaignsPage cp = new CampaignsPage(driver);
		cp.getAddCreateCampaignBtn().click();

		createcampaignpage ccp = new createcampaignpage(driver);
		ccp.getCampaignNameTF().sendKeys(CAMPAIGN_NAME);
		ccp.getTargetSizeTF().clear();
		ccp.getTargetSizeTF().sendKeys(TARGET_SIZE);
		ccp.getCreateCampaignBtn().click();

		Homepage hp = new Homepage(driver);
		WebElement toastMsg = hp.getToastmsg();
		wLib.waitUntilElementToBeVisible(driver, toastMsg);
		hp.getCloseToastMsg().click();

		// CreateContact
		hp.getContactsLink().click();
		ContactsPage contactPage = new ContactsPage(driver);
		contactPage.getAddCreateContactBtn().click();
		CreateContactPage createContactPage = new CreateContactPage(driver);
		createContactPage.getOrganizationNameTF().sendKeys(ORGANIZATION_NAME);
		createContactPage.getTitleTF().sendKeys(TITLE);
		createContactPage.getContactNameTF().sendKeys(CONTACT_NAME);
		createContactPage.getMobileTF().sendKeys("7411487441");
		String parentId = driver.getWindowHandle();
		createContactPage.getPlusBtn().click();
		wLib.switchToWindowOnTitle(driver, "Select Campaign");
		SelectCampaignpage scp = new SelectCampaignpage(driver);
		wLib.select(scp.getCampaignDD(), "campaignName");
		scp.getSearchBar().sendKeys(CAMPAIGN_NAME);
		wLib.waitUntilElementToBeVisible(driver, scp.getSelectBtn());
		scp.getSelectBtn().click();
		wLib.switchBackToParentId(driver, parentId);
		createContactPage.getCreateContactSubmitBtn().click();
		WebElement toastMsg1 = hp.getToastmsg();
		wLib.waitUntilElementToBeVisible(driver, toastMsg1);
		if (toastMsg1.getText().contains(CONTACT_NAME))
			System.out.println("Contact Created");
		else
			System.out.println("Contact Not Created");
		hp.getCloseToastMsg().click();

	
}
}