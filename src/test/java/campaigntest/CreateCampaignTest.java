package campaigntest;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericutility.BaseClass;
import genericutility.ExcelFileUtility;
import genericutility.JavaUtility;
import genericutility.PropertyFileUtility;
import genericutility.Webdriverutility;
import objectrepository.CampaignsPage;
import objectrepository.createcampaignpage;
import objectrepository.Homepage;
import objectrepository.LoginPage;

@Listeners(genericutility.ListnerImplementation.class)
public class CreateCampaignTest extends BaseClass {

	@Test(groups = "smoke")
	public void CreateCampaignWithMandatoryFieldsTest() throws InterruptedException, IOException {

		//PropertyFileUtility pLib = new PropertyFileUtility();
		//String BROWSER = pLib.readDataFromPropertyFile("Browser");
		//String URL = pLib.readDataFromPropertyFile("URL");
		//String USERNAME = pLib.readDataFromPropertyFile("Username");
		//String PASSWORD = pLib.readDataFromPropertyFile("Password");

		// Reading data from excel file
		//ExcelFileUtility eLib = new ExcelFileUtility();
		ExcelFileUtility eLib = new ExcelFileUtility();
		String CAMPAIGN_NAME = eLib.readDataFromExcelFile("Campaign", 1, 2);
		String TARGET_SIZE = eLib.readDataFromExcelFile("Campaign", 1, 3);
  
		//ChromeOptions settings =new ChromeOptions();
		//Map<String,Object> prefs= new HashMap<>();
	//prefs.put("profile.password_manager_leak_detection", false);
	//settings.setExperimentalOption("prefs", prefs);  
	
	
		// Launch the browser
		//WebDriver driver = null;
		 //if (BROWSER.equalsIgnoreCase("edge"))
			//driver = new EdgeDriver();
		//else if (BROWSER.equalsIgnoreCase("firefox"))
			//driver = new FirefoxDriver();
		//else if (BROWSER.equalsIgnoreCase("safari"))
			//driver = new SafariDriver();

		//driver.manage().window().maximize();
		//Webdriverutility wLib = new Webdriverutility();
		//wLib.implicitWait(driver);

		//Homepage hp = new Homepage(driver);

		// Login to Ninza_CRM
		//LoginPage lp = new LoginPage(driver);
		//lp.loginToApp(USERNAME, PASSWORD,URL);
		
		JavaUtility jLib = new JavaUtility();
		int randomInt = jLib.getRandomNumber();
		String campaignName = CAMPAIGN_NAME + randomInt;
		
		Webdriverutility wLib = new Webdriverutility();
		 Homepage hp1 = new Homepage(driver);
		CampaignsPage campaignPage = new
		CampaignsPage(driver);

		// Create Campaign with Mandatory Fields
		//CampaignsPage cp = new CampaignsPage(driver);
		//cp.getAddCreateCampaignBtn().click();
		
		// Create Campaign
		campaignPage.createCampaign(campaignName,
		TARGET_SIZE);
		campaignPage.getCreateCampaignSubmitBtn().click();
		
		//createcampaignpage ccp=new createcampaignpage(driver);
		//ccp.getCampaignNameTF().sendKeys(CAMPAIGN_NAME);
		//ccp.getTargetSizeTF().clear();
		//ccp.getTargetSizeTF().sendKeys(TARGET_SIZE);
		//ccp.getCreateCampaignBtn().click();

		// Validation
		wLib.waitForVisibilityOfWebElement(driver,
		hp1.getToastmsg());
		String msg = hp1.getToastmsg().getText();
		Assert.assertEquals( msg,"Campaign"+campaignName+"Successfully Added");
		hp1.getCloseToastMsg().click();
		
		// Validation
		//Homepage hp1= new Homepage(driver);
		//wLib.waitUntilElementToBeVisible(driver, hp1.getToastmsg());
		//if (hp1.getToastmsg().getText().contains(CAMPAIGN_NAME))
			//System.out.println("Campaign Created");
		//else
			//System.out.println("Campaign Not Created");
		//hp1.getCloseToastMsg().click();
		//System.out.println("From new workspace");

		// Logout
		//hp.logout();

		// Close the browser
		//driver.quit();
	}
	
	@Test(groups = "regression")
	public void CreateCampaignWithStatusTest() throws IOException {

		//PropertyFileUtility pLib = new PropertyFileUtility();
		//String BROWSER = pLib.readDataFromPropertyFile("Browser");
		//String URL = pLib.readDataFromPropertyFile("URL");
		//String USERNAME = pLib.readDataFromPropertyFile("Username");
		//String PASSWORD = pLib.readDataFromPropertyFile("Password");

		// Reading data from excel file
		//ExcelFileUtility eLib = new ExcelFileUtility();
		String CAMPAIGN_NAME = eLib.readDataFromExcelFile("Campaign", 4, 2);
		String TARGET_SIZE = eLib.readDataFromExcelFile("Campaign", 4, 3);
		String STATUS = eLib.readDataFromExcelFile("Campaign", 4, 4);

		//ChromeOptions settings =new ChromeOptions();
		//Map<String,Object> prefs= new HashMap<>();
	//prefs.put("profile.password_manager_leak_detection", false);
	//settings.setExperimentalOption("prefs", prefs);  
	
		// Launch the browser
		//WebDriver driver = null;
		
		 //if (BROWSER.equalsIgnoreCase("edge"))
			//driver = new EdgeDriver();
		//else if (BROWSER.equalsIgnoreCase("firefox"))
			//driver = new FirefoxDriver();
		//else if (BROWSER.equalsIgnoreCase("safari"))
			//driver = new SafariDriver();
		//driver.manage().window().maximize();
		//Webdriverutility wLib = new Webdriverutility();
		//wLib.implicitWait(driver);

		//Homepage hp = new Homepage(driver);

		// Login to Ninza_CRM
		//LoginPage lp = new LoginPage(driver);
		//lp.loginToApp(USERNAME, PASSWORD,URL);

		// Create Campaign with Mandatory Fields
		CampaignsPage cp = new CampaignsPage(driver);
		cp.getAddCreateCampaignBtn().click();
		
		createcampaignpage ccp=new createcampaignpage(driver);
		ccp.getCampaignNameTF().sendKeys(CAMPAIGN_NAME);
		ccp.getTargetSizeTF().clear();
		ccp.getTargetSizeTF().sendKeys(TARGET_SIZE);
		ccp.getCampaignstatusTF().sendKeys(STATUS);
		ccp.getCreateCampaignBtn().click();

		// Validation
		//WebElement toastMsg = hp.getToastmsg();
		//wLib.waitUntilElementToBeVisible(driver, toastMsg);
		//if (toastMsg.getText().contains(CAMPAIGN_NAME))
			//System.out.println("Campaign Created");
		//else
			//System.out.println("Campaign Not Created");
		//hp.getCloseToastMsg().click();
		
		Homepage hp = new Homepage(driver);
		WebElement toastMsg = hp.getToastmsg();
		wLib.waitUntilElementToBeVisible(driver, toastMsg);
		if (toastMsg.getText().contains(CAMPAIGN_NAME))
			System.out.println("Campaign Created");
		else
			System.out.println("Campaign Not Created");
		hp.getCloseToastMsg().click();
		System.out.println("Createcampaignwithstatustest");

		// logout
		//hp.logout();

		// Close the browser
		//driver.quit();
	}
	
	@Test(groups = "regression")
	public void  CreateCampaignWithExpectedCloseDateTest()throws InterruptedException, IOException {

		//PropertyFileUtility pLib = new PropertyFileUtility();
		//String BROWSER = pLib.readDataFromPropertyFile("Browser");
		//String URL = pLib.readDataFromPropertyFile("URL");
		//String USERNAME = pLib.readDataFromPropertyFile("Username");
		//String PASSWORD = pLib.readDataFromPropertyFile("Password");

		//ExcelFileUtility eLib = new ExcelFileUtility();
		String CAMPAIGN_NAME = eLib.readDataFromExcelFile("Campaign", 7, 2);
		String TARGET_SIZE = eLib.readDataFromExcelFile("Campaign", 7, 3);

		// Get Date after 30 days
		//JavaUtility jLib = new JavaUtility();
		String expectedCloseDate = jLib.getRequiredDate(100);
		//System.out.println(expectedCloseDate);

		//ChromeOptions settings =new ChromeOptions();
		//Map<String,Object> prefs= new HashMap<>();
	//prefs.put("profile.password_manager_leak_detection", false);
	//settings.setExperimentalOption("prefs", prefs);  
	
		// Launch the browser
		//WebDriver driver = null;
		//if (BROWSER.equalsIgnoreCase("edge"))
			//driver = new EdgeDriver();
		//else if (BROWSER.equalsIgnoreCase("firefox"))
			//driver = new FirefoxDriver();
		//else if (BROWSER.equalsIgnoreCase("safari"))
			//driver = new SafariDriver();

		//driver.manage().window().maximize();
		//Webdriverutility wLib = new Webdriverutility();
		//wLib.implicitWait(driver);
		
		//Homepage hp=new Homepage(driver);

		// Login to Ninza_CRM
		//LoginPage lp = new LoginPage(driver);
		//lp.loginToApp(USERNAME, PASSWORD,URL);

		// Create Campaign with Mandatory Fields along with expected close date
		CampaignsPage cp = new CampaignsPage(driver);
		cp.getAddCreateCampaignBtn().click();
		//driver.findElement(By.name("campaignName")).sendKeys(CAMPAIGN_NAME);
		//WebElement targetSizeTF = driver.findElement(By.name("targetSize"));
		//targetSizeTF.clear();
		//targetSizeTF.sendKeys(TARGET_SIZE);

		//driver.findElement(By.name("expectedCloseDate")).sendKeys(jLib.getRequiredDate(30));
		//driver.findElement(By.xpath("//button[text()='Create Campaign']")).click();
		
		//CampaignsPage cp = new CampaignsPage(driver);
		//cp.getAddCreateCampaignBtn().click();
		createcampaignpage ccp = new createcampaignpage(driver);
		ccp.getCampaignNameTF().sendKeys(CAMPAIGN_NAME);
		ccp.getTargetSizeTF().clear();
		ccp.getTargetSizeTF().sendKeys(TARGET_SIZE);
		ccp.getExpectedcloseDateTF().sendKeys(expectedCloseDate);
		ccp.getCreateCampaignBtn().click();

		// Validation
		//WebElement toastMsg = driver.findElement(By.xpath("//div[@role='alert']"));
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		//wait.until(ExpectedConditions.visibilityOf(toastMsg));
		//if (toastMsg.getText().contains("test")) 
			//System.out.println("Campaign Created");
		
		//else 
			//System.out.println("Campaign Not Created");
		
		//driver.findElement(By.xpath("//button[@aria-label='close']")).click();
		
		Homepage hp = new Homepage(driver);
		WebElement toastMsg = hp.getToastmsg();
		wLib.waitUntilElementToBeVisible(driver, toastMsg);
		if (toastMsg.getText().contains(CAMPAIGN_NAME))
			System.out.println("Campaign Created");
		else
			System.out.println("Campaign Not Created");
		hp.getCloseToastMsg().click();

		// Logout
		//hp.logout();

		// Close the browser
		//driver.quit();
	}
}