package StepDefinition;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestSteps {

	static WebDriver driver;
	
	@Given("^User opens a browser \"([^\"]*)\"$")
	public static void setBrowser(String browserName) {
		
		if (browserName.equalsIgnoreCase("ff")) {
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("cr")) {
			
			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
			driver = new ChromeDriver();
			
		} else if (browserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", "drivers/chromedriver");
			driver = new ChromeDriver();
		} else {
			System.out.print("Please specify browser name");
	
		}

	}
	
	@And("^Navigates to the app \"([^\"]*)\"$")
	public static void navigatesToApp(String url) {
		driver.get("http://www.google.com");
		driver.navigate().to(url);
	}
	@And("^User clicks login$")
	public static void clickLogin() {
		
		WebElement loginBtn = driver.findElement(By.xpath("//a[@id='login-header']"));
		
		Assert.assertTrue(loginBtn.isDisplayed());
		loginBtn.click();
	}
	@When("^User enters information")
	public static void enterUsername(DataTable listOfUsers) {
		
		List<List<String>> data = listOfUsers.raw();
		driver.findElement(By.id("edit-mail")).sendKeys(data.get(1).get(0));
		driver.findElement(By.id("edit-pass")).sendKeys(data.get(1).get(1));
		driver.findElement(By.id("edit-submit")).click();
		
	}
	
	@And("^User is able to see home page$")
	public static void loginSuccess() {
	
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		Assert.assertTrue(driver.getTitle().contains("Home"));
	
	}
	
	@And("^User is asked to login$")
	public static void loginFail() {
	
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		Assert.assertTrue(driver.getTitle().contains("Login"));
	}
	
	
	@And("^User closes browser$")
	public static void closeBrowser() {
		
		driver.close();
		
	}
	
	@When("^user clicks on a news link from cnn$")
	public static void userClicksLink() {
		
		driver.findElement(By.partialLinkText("Disney gator attack")).click();
		
	}
	
	@Then("^user is on cnn webpage$")
	public static void verifyPageOnCnn() {
		
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		
		driver.switchTo().window(tabs.get(1));
		Assert.assertTrue(driver.getCurrentUrl().contains("google"));
		
	}
	
}
