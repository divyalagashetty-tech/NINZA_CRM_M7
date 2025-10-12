package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class CreateCampaignTest {

	@Test(invocationCount = 5, threadPoolSize =2 )
	public void createCampaignWithMandatoryFields() {
		WebDriver driver= new EdgeDriver();
		
		System.out.println("createCampaignWithMandatoryFields");
	}
	
	@Test(priority = -2, invocationCount = 0 )
	public void createCampaignWithStatus() {
		WebDriver driver= new EdgeDriver();
		
		System.out.println("createCampaignWithStatus");
	}
	
	@Test(priority = -2, invocationCount = 1 )
	public void createCampaignWithExpectedCloseDate() {
		WebDriver driver= new EdgeDriver();
		
		System.out.println("createCampaignWithExpectedCloseDate");
	}
}