package practice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Robotclass {

	public static void main(String[] args) throws AWTException, InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.edge.driver", "C:\\Users\\TEMP\\Downloads\\edgedriver_win64\\msedgedriver.exe\\");
 WebDriver driver =  new EdgeDriver();
 driver.get("https://www.instagram.com/");
 Robot rob=new Robot();
	rob.keyPress(KeyEvent.VK_CAPS_LOCK);
	rob.keyRelease(KeyEvent.VK_CAPS_LOCK);
	Thread.sleep(2000);
	driver.findElement(By.name("username")).click();
	rob.keyPress(KeyEvent.VK_B);
	rob.keyRelease(KeyEvent.VK_B);
}
}
 
	