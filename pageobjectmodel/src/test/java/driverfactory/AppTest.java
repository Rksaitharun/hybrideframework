package driverfactory;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunction.CustomerPage;
import config.AppUtil;
import utilities.ExcelFileUtil;

public class AppTest extends AppUtil{
	String inputpath ="./FileInput/customer_data.xlsx";
	String outputpath ="./FileOutput/resultfeb10.xlsx";
	ExtentReports report;
	ExtentTest logger;
	@Test
	public void startTest() throws Throwable
	{
		//define path for reports
		report = new ExtentReports("./target/Reports/Customer.html");
		CustomerPage cus = PageFactory.initElements(driver, CustomerPage.class);
		ExcelFileUtil xl = new ExcelFileUtil(inputpath);
		int rc = xl.rowCount("customer");
		Reporter.log("No of rows are::"+rc,true);
		for(int i=1;i<=rc;i++)
		{
			logger = report.startTest("Customer Module");
			logger.assignAuthor("Ranga");
			String customename = xl.getCellData("customer", i, 0);
			String Address = xl.getCellData("customer", i, 1);
			String City = xl.getCellData("customer", i, 2);
			String Country = xl.getCellData("customer", i, 3);
			String contactperson = xl.getCellData("customer", i, 4);
			String phonenumber = xl.getCellData("customer", i, 5);
			String email = xl.getCellData("customer", i, 6);
			String mobilenumber = xl.getCellData("customer", i, 7);
			String Notes = xl.getCellData("customer", i, 8);
			logger.log(LogStatus.INFO, customename+"   "+Address+"    "+City+"  "+Country+"   "+contactperson+"   "+phonenumber+"    "+email+"   "+mobilenumber+"   "+Notes);
			boolean res =cus.add_Customer(customename, Address, City, Country, contactperson, phonenumber, email, mobilenumber, Notes);
			if(res)
			{
				xl.setCellData("customer", i, 9, "Pass", outputpath);
				logger.log(LogStatus.PASS, "Customer Added Success");
			}
			else
			{
				xl.setCellData("customer", i, 9, "Fail", outputpath);
				logger.log(LogStatus.FAIL, "Customer Added Fail");
			}
			report.endTest(logger);
			report.flush();
		}
	}

}











