package steps;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import junit.framework.Assert;
import pagefactory.CommPoll;

public class CommunitypollStepdef {
	WebDriver driver;
	CommPoll Cmp;

	private static Logger logger = LogManager.getLogger(CommunitypollStepdef.class);

	public CommunitypollStepdef() {
		driver = new ChromeDriver();
		Cmp = new CommPoll(driver);
	}

	@Given("User navigate to Url")
	public void user_navigate_to_url() {
		logger.info("URL");
		Cmp.navigateToURL("https://demowebshop.tricentis.com/");
	}

	@Then("Click on vote button directly")
	public void click_on_vote_button_directly() throws InterruptedException {
		logger.info("Users direct click on vote button");
		Cmp.Click_Vote();
		// Assert.assertFalse("Please select an answer", true);
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println(alertText);
		alert.dismiss();
	}
	@Then("User select one option from given poll")
	public void user_select_one_option_from_given_poll() {
		logger.info("Users selects the poll  ");
		Cmp.select_button("1");
	}

	// @SuppressWarnings("deprecation")
	@Then("Click on vote button")
	public void click_on_vote_button() throws InterruptedException {
		logger.info("User Click on the vote button");
		Cmp.Click_Vote();
		Thread.sleep(1000);
		WebElement optionElement1 = driver.findElement(By.xpath("//div[@id='block-poll-vote-error-1']"));
		String value = optionElement1.getText();
		if (optionElement1.isDisplayed()) {
			captureScreenshot(driver, "fail2");
			System.out.println(value);
			Assert.assertFalse(value, true);
		}
	}

	@Then("User performs Login {string} {string}")
	public void user_performs_login(String string, String string2) {
		Cmp.Click_Login();
		Cmp.Login_details(string, string2);
	}

	@Then("User select one option from poll and vote")
	public void user_select_one_option_from_poll_and_vote() throws InterruptedException {
		logger.info("Users select one option from poll");
		try {
			Cmp.select_button("1");
			Cmp.Click_Vote();
		} catch (Exception e) {
			WebElement optionElement = driver.findElement(By.xpath("//span[@class='poll-total-votes']"));
			String actualvalue = Cmp.Tol_Result();
			if (optionElement.isDisplayed()) {
				System.out.println("user already votedd..");
				System.out.println(Cmp.Pol_Result());
				System.out.println(Cmp.Tol_Result());
				captureScreenshot(driver, "fail1");
				Assert.assertFalse(actualvalue, true);
			}
		}
	}

	private static void captureScreenshot(WebDriver driver, String fileName) {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File("C:\\Community_Poll\\Com_poll\\Com_ScreenShots\\" + fileName + ".png");
		try {
			FileUtils.copyFile(sourceFile, destinationFile);
			System.out.println("Screenshot captured: " + destinationFile);
		} catch (IOException e) {
			System.out.println("Unable to capture screenshot: " + e.getMessage());
		}
	}
	

	@io.cucumber.java.After
	public void afterScenario(io.cucumber.java.Scenario scenario) {
		if (scenario.isFailed()) {
			logger.error("Scenario failed. Taking a screenshot or performing cleanup if needed.");
			// Add code to capture a screenshot or perform cleanup on failure
		}
		driver.quit();
	}

}
