package stepdefs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DemowebStepDefs {
	WebDriver driver;
	
	@Given("user launched chrome")
	public void user_launched_chrome() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Public\\Documents\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Given("user provides valid url")
	public void user_provides_valid_url() {
		driver.get("http://demowebshop.tricentis.com/");
	}

	@Given("clicks on login hyperlink")
	public void clicks_on_login_hyperlink() {
		driver.findElement(By.className("ico-login")).click();
	}

	@Given("the email id is {string}")
	public void the_email_id_is(String emailid) {
		driver.findElement(By.id("Email")).sendKeys(emailid);
		
	}

	@When("the password is {string}")
	public void the_password_is(String password) {
		driver.findElement(By.id("Password")).sendKeys(password);
	}

	@When("clicks on Login button")
	public void clicks_on_Login_button() {
		driver.findElement(By.cssSelector("input.button-1.login-button")).click();
	}

	@Then("clicks on Logout button")
	public void clicks_on_Logout_button() {
		driver.findElement(By.cssSelector("a.ico-logout")).click();
	}

	@Then("see welcome message")
	public void see_welcome_message() {
		System.out.println("welcome message is displayed..");
	}
}
