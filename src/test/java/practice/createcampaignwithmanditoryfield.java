package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class createcampaignwithmanditoryfield {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		// Reading data from properties file
		FileInputStream fis = new FileInputStream("C:\\Users\\div31\\OneDrive\\Desktop\\commondata.properties.txt");
		Properties prop = new Properties();
		prop.load(fis);
		String URL = prop.getProperty("URL");
		String USERNAME = prop.getProperty("Username");
		String PASSWORD = prop.getProperty("Password");

		// Launch the browser
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		// Login to Ninza_CRM
		driver.get(URL);
		Thread.sleep(2000);
		driver.findElement(By.id("username")).sendKeys(USERNAME);
		Thread.sleep(2000);
		driver.findElement(By.id("inputPassword")).sendKeys(PASSWORD);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		Thread.sleep(2000);

		// Create Campaign with Mandatory Fields
		driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("campaignName")).sendKeys("test");
		Thread.sleep(2000);
		driver.findElement(By.name("campaignStatus")).sendKeys("active");
		Thread.sleep(2000);
		WebElement targetSizeTF = driver.findElement(By.name("targetSize"));
		Thread.sleep(2000);
		targetSizeTF.clear();
		Thread.sleep(2000);
		targetSizeTF.sendKeys("7");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Create Campaign']")).click();
		Thread.sleep(2000);
		// Validation
		WebElement toastMsg = driver.findElement(By.xpath("//div[@role='alert']"));
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(toastMsg));
		if (toastMsg.getText().contains("test"))
			System.out.println("Campaign Created");
		else
			System.out.println("Campaign Not Created");
		driver.findElement(By.xpath("//button[@aria-label='close']")).click();

		// Logout
		Actions action = new Actions(driver);
		Thread.sleep(2000);
		WebElement userIcon = driver.findElement(By.className("user-icon"));
		Thread.sleep(2000);
		action.moveToElement(userIcon).perform();
		Thread.sleep(2000);
		WebElement logoutBtn = driver.findElement(By.xpath("//div[text()='Logout ']"));
		action.moveToElement(logoutBtn).click().perform();

		// Close the browser
		//driver.quit();
	}

}
 



