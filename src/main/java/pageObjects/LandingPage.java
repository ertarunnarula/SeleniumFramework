package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage {
	
	public WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// PageObjects
	By signIn = By.cssSelector("a[href*='sign_in']");
	By title = By.xpath("//h2[contains(text(),'Featured Courses')]");
	By navigation = By.linkText("Home");
	
	
	public WebElement getLogin() {
		return driver.findElement(signIn);
	}
	
	public WebElement getText() {
		return driver.findElement(title);
	}
	
	public WebElement getNavigationBar() {
		return driver.findElement(navigation);
	}
	

}
