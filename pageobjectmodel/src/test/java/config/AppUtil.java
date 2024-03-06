package config;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import commonFunction.AdminLoginPage;
import commonFunction.AdminLogoutPage;

public class AppUtil {
public static Properties conpro;
public static WebDriver driver;
@BeforeTest
public static void setUp()throws Throwable
{
	conpro = new Properties();
	conpro.load(new FileInputStream("C:\\Users\\rksai\\OneDrive\\Documents\\febmavenframework\\propertyFile\\Login.properties"));
	if(conpro.getProperty("Browser").equalsIgnoreCase("chrome"))
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(conpro.getProperty("Url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		AdminLoginPage login =PageFactory.initElements(driver, AdminLoginPage.class);
		login.adminLogin("admin", "master");
	}
	else if(conpro.getProperty("Browser").equalsIgnoreCase("firefox"))
	{
		driver = new FirefoxDriver();
		driver.get(conpro.getProperty("Url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		AdminLoginPage login = PageFactory.initElements(driver, AdminLoginPage.class);
		login.adminLogin("admin", "master");
	}
	else
	{
		Reporter.log("Browser value is Not Matching",true);
	}
	
}
@AfterTest
public static void tearDown()
{
	AdminLogoutPage logout =PageFactory.initElements(driver, AdminLogoutPage.class);
	logout.adminLogout();
	driver.quit();
}
}



