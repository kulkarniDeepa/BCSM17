package script;

import org.testng.annotations.Test;

import Generic.BaseTest;
import Generic.XL;
import page.EnterTimeTrackpage;
import page.Loginpage;

public class ValidLogin extends BaseTest
{
@Test(priority=1, groups= {"smoke","Login"})

public void testValidLogin()
{
	String un = XL.getcellvalue(XL_path, "ValidLogin", 1, 0);
	String pw = XL.getcellvalue(XL_path, "ValidLogin", 1, 1);
	String eTitle= XL.getcellvalue(XL_path, "ValidLogin", 1, 2);
	
	Loginpage l=new Loginpage(driver);
	l.setUserName(un);
	l.setPassword(pw);
	l.clickLogin();
	EnterTimeTrackpage e=new EnterTimeTrackpage(driver);
	
}
}
