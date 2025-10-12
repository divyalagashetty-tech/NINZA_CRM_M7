package hardcoding;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Testcase1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://49.249.28.218:8098/");
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("inputPassword"));
		username.sendKeys("rmgyantra");
		password.sendKeys("rmgy@9999");
		WebElement login = driver.findElement(By.xpath("//button[text()='Sign In']"));
		login.click();
		driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("campaignName")).sendKeys("TestUser");
		WebElement size = driver.findElement(By.name("targetSize"));
		size.clear();
		size.sendKeys("2");
		driver.findElement(By.xpath("//button[text()='Create Campaign']")).click();
		WebElement toastmsg = driver.findElement(By.xpath("//div[@role='alert']"));
		WebDriverWait wait = new  WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(toastmsg));
		String msg = toastmsg.getText();
		if(msg.contains("TestUser")) {
			System.out.println("campaign created");
		}
		else {
			System.out.println("campaign not created");
		}
		
			
		}
		
	}
