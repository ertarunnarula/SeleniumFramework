package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePage extends Base{
	WebDriver driver;
	
	@BeforeTest
	public void setup() throws IOException {
		
		driver = initializeBrowser();
		
	}
	
	
	@Test(dataProvider = "getData")
	public void basePagenavigation(String Username, String Password, String text) throws IOException {
		
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		LandingPage lp = new LandingPage(driver);
		lp.getLogin().click();
		
		LoginPage login = new LoginPage(driver);
		login.getUser().sendKeys(Username);
		login.getPassword().sendKeys(Password);
		System.out.println(text);
		
		login.getLoginButton().click();
		
	}
	
	
	@DataProvider
	public Object[][] getData() {
		
		//Row stands for how many different data sets we want to send
		// Column stands for how many values to be sent per data set 
		
		Object[][] data = new Object[2][3];
		// 0th Row
		data[0][0] = "non-restricted_user@gmail.com";
		data[0][1] = "123456";
		data[0][2] = "Non-Restricted User";
		
		// 1st Row 
		data[1][0] = "restricted_user@gmail.com";
		data[1][1] = "password";
		data[1][2] = "Restricted User";
		
		return data;
		
	}
	
	
	@AfterTest
	public void teardown() {
		driver.close();
	}
	

}
