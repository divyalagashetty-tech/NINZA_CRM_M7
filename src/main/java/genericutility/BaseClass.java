package genericutility;

import org.testng.annotations.Test;

import objectrepository.Homepage;
import objectrepository.LoginPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class BaseClass {
   public WebDriver driver= null;
   public PropertyFileUtility pLib= new PropertyFileUtility();
   public ExcelFileUtility eLib= new ExcelFileUtility();
   public Webdriverutility wLib= new Webdriverutility();
   public JavaUtility jLib= new JavaUtility();
   public static WebDriver sdriver = null; //listenerimplementation
   
 
  @BeforeMethod(groups = { "smoke", "regression" })
  public void beforeMethod() throws IOException {
	  System.out.println("Login");
	  String browser = pLib.readDataFromPropertyFile("Browser");
	  String url = pLib.readDataFromPropertyFile("URL");
	  String username = pLib.readDataFromPropertyFile("Username");
	  String password = pLib.readDataFromPropertyFile("Password"); 
	  
	  //String url = System.getProperty("URL");
	  //String username = System.getProperty("USERNAME");
	  //String password = System.getProperty("PASSWORD");
	  
	  LoginPage lp = new LoginPage(driver);
	  lp.loginToApp(username, password, url);
	  
  }

  @AfterMethod(groups = { "smoke", "regression" })
  public void afterMethod() {
	  System.out.println("Logout");
	  Homepage hp= new Homepage(driver);
	  hp.logout();
  }
  
  @Parameters("Browser")
  @BeforeClass(groups = { "smoke", "regression" })
  public void beforeClass() throws IOException {
	  System.out.println("Launch the browser");
	 String BROWSER = pLib.readDataFromPropertyFile("Browser");
		//String BROWSER = System.getProperty("Browser");	 
				
				if (BROWSER.equalsIgnoreCase("edge"))
			driver = new EdgeDriver();
		else if (BROWSER.equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver();
		else if (BROWSER.equalsIgnoreCase("safari"))
			driver = new SafariDriver();
		 
		 sdriver=driver; //listenerimplementation
		 
		driver.manage().window().maximize();
		Webdriverutility wLib = new Webdriverutility();
		wLib.implicitWait(driver);
		

  }

  @AfterClass(groups = { "smoke", "regression" })
  public void afterClass() {
	  System.out.println("Close the browser");
	  driver.quit();
  }

  @BeforeTest(groups = { "smoke", "regression" })
  public void beforeTest() {
	  System.out.println("Pre conditions for parallel executions");
  }

  @AfterTest(groups = { "smoke", "regression" })
  public void afterTest() {
	  System.out.println("Post conditions for parallel executions");
  }

  @BeforeSuite(groups = { "smoke", "regression" })
  public void beforeSuite() {
	  System.out.println("Connect to database");
  }

  @AfterSuite(groups = { "smoke", "regression" })
  public void afterSuite() {
	  System.out.println("Disconnect from database");
  }

}
