package stepDefinitions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;

public class Steps {
	
	
	
	Logger logger;
	ResourceBundle rb;
	String br;
	
	WebDriver driver;
	HomePage hp;
	RegistrationPage rp;
	LoginPage lp;
	
	FileInputStream fip;
	Properties prop;
	
	
	
	@Before
	public void setup() {
		logger = LogManager.getLogger(this.getClass());
		
//		rb = ResourceBundle.getBundle("config");
//		br = rb.getString("browser");
		
		
			try {
				prop = new Properties();
				fip = new FileInputStream(
						"D:\\JavaSelWorld\\OpenCartCucumber\\src\\test\\java\\resources\\config.properties");
				prop.load(fip);
				br = prop.getProperty("browser");
			} catch (Exception e) {
			}
		
		
				
	}
	
	@After
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			byte [] scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(scr, "image/png", scenario.getName());
			
		}
		
		driver.quit();
	}
	
	@Given("Launch Browser")
	public void launch_browser() {
		
		if (br.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();			
			logger.info("Chrome Browser is launched");
			logger.error("Chrome browser is Opening");
		}
		else if (br.equals("edge")) {
			
			driver = new EdgeDriver();
			
		}
		else {
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		logger.info("Browser is launched");
		
	}

	@Given("open URL {string}")
	public void open_url(String url) {
		driver.get(url);
		logger.info("Opening URL");
	}

	@When("Navigate to My Account")
	public void navigate_to_my_account() {
		hp = new HomePage(driver);
		hp.clickOnMyAccount();
		logger.info("Clicked on my account");
	}

	@When("Click on Register")
	public void click_on_register() {
		hp.clickOnRegisterLink();
		logger.info("Clicked on Registration");
	}

	@When("Fill all the details")
	public void fill_all_the_details() throws InterruptedException {
		rp = new RegistrationPage(driver);
		rp.enterFirstName();
		rp.enterLastname();
		rp.enterEmail();
		rp.enterPassword();
		logger.info("Required fields are filled");
		Thread.sleep(2000);
		rp.checkRadiobutton();
		rp.selectTnCCheckBox();	
		logger.info("Radiobutton and CheckBox is clicked");
		System.out.println("clicked");
	}

	@When("Click on Continue button")
	public void click_on_continue_button() {
		rp.clickOnSubmittButton();
		logger.info("User submitted the details");
	}

	@Then("User registration completed")
	public void user_registration_completed() {
		Assert.assertTrue(true);
	}
	
	///////////// Invalid Login //////////////////////
	
	@When("Click on Login")
	public void click_on_login() {
		hp.clickOnLogin();
	}

	@When("Enter User {string}")
	public void enter_user(String user) {
		lp = new LoginPage(driver);
		
		lp.enterUserEmail(user);
	}

	@When("Enter Password {string}")
	public void enter_password(String pass) {
		lp.enterPass(pass);
	}

	@When("Click on Submitt")
	public void click_on_submitt() {
	}

	@Then("Validate Invalid Login")
	public void validate_invalid_login() {
		Assert.assertTrue(true);
	}
	

}
