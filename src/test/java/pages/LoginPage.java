package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(id = "input-email")
	WebElement userEmail;
	
	@FindBy(id = "input-password")
	WebElement userPwd;
	
	@FindBy(xpath = "//button[text()='Login']")
	WebElement loginButton;
	
	public void enterUserEmail(String user) {
		userEmail.sendKeys(user);
	}
	
	public void enterPass(String pass) {
		userPwd.sendKeys(pass);
	}
	

}
