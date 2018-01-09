package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage 
{
	//declaration
	@FindBy (id="username")
	private WebElement unTB;
	
	@FindBy (name="pwd")
	private WebElement pwTB;
	
	@FindBy (xpath="//div[.='Login ']")
	private WebElement LoginBTN;
	
	@FindBy (xpath="span[contains(.,'invalid')]")
	private WebElement errmsg;

	//initialization
	public Loginpage(WebDriver driver)
	{
		
	}
	
}
