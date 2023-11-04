package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath = "//span[text()='My Account']")
	WebElement myAccountLink;
	
	@FindBy(linkText = "Register")
	WebElement registerLink;
	
	@FindBy(linkText = "Login")
	WebElement loginLink;
	
	
	public void clickOnMyAccount() {
		myAccountLink.click();
	}
	
	public void clickOnRegisterLink() {
		registerLink.click();
	}
	
	public void clickOnLogin() {
		loginLink.click();
	}

}
