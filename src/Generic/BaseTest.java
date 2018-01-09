package Generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest implements IAutoConst
{
private static final String GECKO_KEY = null;
private static final String GECKO_VALUE = null;
public WebDriver driver;

static
{
	//System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	System.setProperty(CHROME_KEY, CHROME_VALUE);
	System.setProperty(GECKO_KEY, GECKO_VALUE);	
}

@Parameters({"browser"})
@BeforeMethod(alwaysRun=true)

public void openApp(String browser)
{
	if(browser.equals("chrome"))
	{
		driver=new ChromeDriver();
	}
	else
	{
		driver=new FirefoxDriver();
	}
	
     String url = AL.getproperty(settings_path, "URL");
     driver.get(url);
     String strITO = AL.getproperty(settings_path, "ITO");
     long ITO = Long.parseLong(strITO);
//	driver=new ChromeDriver();
//	driver.get("http:/localhost");
    driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.SECONDS);
}

@AfterMethod(alwaysRun=true)
public void closeApp(ITestResult res)
{
	String name = res.getName();
	int status = res.getStatus();
	if (status==2)
	{
		String imgpath = AL.getphoto(driver, Photo_path, name);
		Reporter.log("Imgpath:" + imgpath,true);
	}
	driver.quit();
}

}
