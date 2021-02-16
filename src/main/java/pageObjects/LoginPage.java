package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	
	By username = By.id("user_email");
	By password = By.id("user_password");
	By login_btn = By.name("commit");
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getUser() {
		return driver.findElement(username);
	}
	
	public WebElement getPassword() {
		return driver.findElement(password);
	}
	
	public WebElement getLoginButton() {
		return driver.findElement(login_btn);
	}

}
