package commonFunction;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminLogoutPage {
@FindBy(xpath = "(//a[starts-with(text(),' Logout')])[2]")
WebElement ObjLogout;
public void adminLogout()
{
	ObjLogout.click();
}

}
