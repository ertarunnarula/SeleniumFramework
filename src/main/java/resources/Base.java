package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeBrowser() throws IOException {
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\GUR36959\\eclipse-workspace\\E2EFramework\\src\\main\\java\\resources\\data.properties");
		
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\new chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\new geckodriver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		else if (browserName.equals("edge")) {
			driver = new EdgeDriver();
			
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver; //So that it can be used in other classes or tests

	}
	

}

