package campaigntest;

import org.testng.annotations.Test;

public class createcampaign {
	
	@Test(dependsOnMethods = {"register", "openApplication"})
	
	public void login() {
		System.out.println("login");
	}
	
	@Test(dependsOnMethods = "openApplication")
	public void register() {
		System.out.println("register");

}
	@Test 
	public void openApplication() {
		System.out.println("openApplication");
	}
}
	
	
