package pages;

import javax.swing.Scrollable;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {

	public RegistrationPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(id = "input-firstname")
	WebElement firstNameFiled;
	
	@FindBy(name = "lastname")
	WebElement lastNameField;
	
	@FindBy(id = "input-email")
	WebElement emailField;
	
	@FindBy(id = "input-password")
	WebElement passwordInput;
	
	@FindBy(id = "input-newsletter-yes")
	WebElement radioNewsLetterYes;
	
	@FindBy(xpath = "//input[@name='newsletter' and @value='0']")
	WebElement radioNewsLetterNo;
	
	@FindBy(name = "agree")
	WebElement chechBoxTnC;
	
	@FindBy(xpath = "//button[text()='Continue']")
	WebElement submitButton;
	
	
	
	public void enterFirstName() {
		firstNameFiled.sendKeys("test1");
	}
	
	public void enterLastname() {
		lastNameField.sendKeys("Last1");
	}
	
	public void enterEmail() {
		emailField.sendKeys("test1.last1@test.com");
	}
	
	public void enterPassword() {
		passwordInput.sendKeys("Test@123");
	}
	
	public void checkRadiobutton() {
		
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
		
		radioNewsLetterNo.click();
	}
	
	public void selectTnCCheckBox() {

//		Actions act = new Actions(driver);
//		act.moveToElement(chechBoxTnC).perform();
		chechBoxTnC.click();
	}
	
	public void clickOnSubmittButton() {
		submitButton.click();
	}

}
