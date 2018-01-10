package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class EnterTimeTrackpage 
{
	//declaration
	@FindBy(xpath="//div[contains(text(),'Help')]")
	private WebElement help;
	
	@FindBy(linkText="About your actiTIME")
	private WebElement aboutactiTIME;
	
	@FindBy(xpath="//span[contains(.,'actiTIME')]")
	private WebElement version;
	
	@FindBy(id="aboutpopupcloseButtonId")
	private WebElement closeBTN;
	
	@FindBy(id="logoutLink")
	private WebElement logout;
	
	//initialization
	public EnterTimeTrackpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public void verifyTitle(WebDriver driver, String eTitle)
	{
		WebDriverWait wait=new WebDriverWait(driver,10);
		try
		{
			wait.until(ExpectedConditions.titleIs(eTitle));
			Reporter.log("Pass: Home page is displayed");
		}
		catch(Exception e)
		{
			Reporter.log("Fail: Home page is not displayed");
			Assert.fail();
		}
	}
	
	public void clickHelp()
	{
		help.click();
	}
	
	public void clickAboutactiTIME()
	{
		aboutactiTIME.click();
	}
	
	public void verifyVersion(String eVersion)
	{
		String aVersion = version.getText();
		Assert.assertEquals(aVersion, eVersion);
	}
	
    public void clickCloseButton()
    {
    	closeBTN.click();
    }
    
    public void clickLogout()
    {
    	logout.click();
    }
}
