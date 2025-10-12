package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class createcampaignpage {

WebDriver driver;
	
	public createcampaignpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindAll({@FindBy(name = "campaignName"), @FindBy(name="campName")})
	private WebElement campaignNameTF;

	@FindBy(name = "targetSize")
	private WebElement targetSizeTF;
	
	@FindBy(name = "expectedCloseDate")
	private WebElement expectedcloseDateTF;
	
	@FindBy(name = "campaignStatus")
	private WebElement campaignstatusTF;
	
	@FindBy(xpath = "//button[text()='Create Campaign']")
	private WebElement CreateCampaignBtn;

	public WebElement getCampaignNameTF() {
		return campaignNameTF;
	}

	public WebElement getTargetSizeTF() {
		return targetSizeTF;
	}

	public WebElement getExpectedcloseDateTF() {
		return expectedcloseDateTF;
	}

	public WebElement getCampaignstatusTF() {
		return campaignstatusTF;
	}

	public WebElement getCreateCampaignBtn() {
		return CreateCampaignBtn;
	}
	
	
		
	}
