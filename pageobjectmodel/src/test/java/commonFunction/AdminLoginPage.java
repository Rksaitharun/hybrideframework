package commonFunction;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminLoginPage {
//define Reposotiry
	@FindBy(name = "btnreset")
	WebElement ObjResetBtn;
	@FindBy(xpath = "//input[@id='username']")
	WebElement ObjUser;
	@FindBy(id = "password")
	WebElement Objpass;
	@FindBy(name = "btnsubmit")
	WebElement ObjLoginbtn;
	public void adminLogin(String user,String pass)
	{
		ObjResetBtn.click();
		ObjUser.sendKeys(user);
		Objpass.sendKeys(pass);
		ObjLoginbtn.click();
	}
}