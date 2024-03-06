package commonFunction;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class CustomerPage {
//define repository
	@FindBy(xpath = "(//a[contains(text(),'Customers')])[2]")
	WebElement ObjCustomeLink;
	@FindBy(xpath = "(//span[@data-caption='Add'])[1]")
	WebElement ObjAddIcon;
	@FindBy(name = "x_Customer_Number")
	WebElement ObjCustomerNum;
	@FindBy(name = "x_Customer_Name")
	WebElement ObjCustomeName;
	@FindBy(name = "x_Address")
	WebElement ObjAddress;
	@FindBy(name = "x_City")
	WebElement ObjCity;
	@FindBy(name = "x_Country")
	WebElement ObjCountry;
	@FindBy(name = "x_Contact_Person")
	WebElement ObjContactPerson;
	@FindBy(name = "x_Phone_Number")
	WebElement ObjPhoneNumber;
	@FindBy(name = "x__Email")
	WebElement ObjEmail;
	@FindBy(name = "x_Mobile_Number")
	WebElement ObjMobileNumber;
	@FindBy(name = "x_Notes")
	WebElement ObjNotes;
	@FindBy(name = "btnAction")
	WebElement ObjClickAddBtn;
	@FindBy(xpath = "//button[contains(text(),'OK!')]")
	WebElement ObjConfirmOkbtn;
	@FindBy(xpath = "(//button[contains(text(),'OK')])[6]")
	WebElement ObjAlertOkbtn;
	@FindBy(xpath = "//span[@data-caption='Search']")
	WebElement ObjSearchPanel;
	@FindBy(xpath = "//input[@id='psearch']")
	WebElement ObjSearchTextbox;
	@FindBy(xpath = "//button[@id='btnsubmit']")
	WebElement ObjSearchBtn;
	@FindBy(xpath = "//table[@class='table ewTable']/tbody/tr[1]/td[5]/div/span/span")
	WebElement webtable;
	public boolean add_Customer(String customerName,String Address,String City,String Country,
			String conrtactperson,String Phonenumber,String Email,String MobileNumber,String Notes)throws Throwable
	{
		ObjCustomeLink.click();
		ObjAddIcon.click();
		String Exp_Num= ObjCustomerNum.getAttribute("value");
		ObjCustomeName.sendKeys(customerName);
		ObjAddress.sendKeys(Address);
		ObjCity.sendKeys(City);
		ObjCountry.sendKeys(Country);
		ObjContactPerson.sendKeys(conrtactperson);
		ObjPhoneNumber.sendKeys(Phonenumber);
		ObjEmail.sendKeys(Email);
		ObjMobileNumber.sendKeys(MobileNumber);
		ObjNotes.sendKeys(Notes);
		ObjClickAddBtn.sendKeys(Keys.ENTER);
		ObjConfirmOkbtn.click();
		Thread.sleep(2000);
		ObjAlertOkbtn.click();
		Thread.sleep(2000);
		//if search textbox not displayed then click search panel
		if(!ObjSearchTextbox.isDisplayed())
			ObjSearchPanel.click();
		ObjSearchTextbox.clear();
		ObjSearchTextbox.sendKeys(Exp_Num);
		ObjSearchBtn.click();
		Thread.sleep(3000);
		String Act_Num =webtable.getText();
		Thread.sleep(3000);
		if(Exp_Num.equals(Act_Num))
		{
			Reporter.log("Customer Number Matching::"+Exp_Num+"       "+Act_Num,true);
			return true;
		}
		else
		{
			Reporter.log("Customer Number Not Matching::"+Exp_Num+"       "+Act_Num,true);
			return false;
		}
		
	}
}




