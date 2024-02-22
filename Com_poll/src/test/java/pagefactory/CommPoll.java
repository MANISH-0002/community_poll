package pagefactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CommPoll {

	WebDriver driver;

	@FindBy(linkText = "Log in")
	WebElement Loginbtn;

	@FindBy(id = "Email")
	WebElement email;

	@FindBy(id = "Password")
	WebElement password;

	@FindBy(xpath = "//input[@value='Log in']")
	WebElement login;

	/*@FindBy(xpath = "//input[@type='radio']")
	List<WebElement> Rdo;*/
	
	@FindBy(name = "pollanswers-1")
	List<WebElement> Rdo;

	@FindBy(xpath="//input[@class='button-2 vote-poll-button']")
	WebElement btn_vote;
	
	@FindBy(xpath="//ul[@class='poll-results']")
	WebElement PollResult;
	
	@FindBy(xpath="//span[@class='poll-total-votes']")
	WebElement Tot_Res;

	public CommPoll(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void navigateToURL(String url) {
		driver.get(url);
		driver.manage().window().maximize();

	}

	public void Click_Login() {
		Loginbtn.click();
	}

	public void Login_details(String string, String string2) {
		email.sendKeys(string);
		password.sendKeys(string2);
		login.click();
	}

	/*public void select_button() {
		Rdo.get(3).click();
	}*/
	
	
	public void select_button(String desiredvalue ) {
		
		   //int minValue = 1;
	       //  int maxValue = 4;
		  for (WebElement radioButton : Rdo) {
			  // int radioValue = Integer.parseInt(radioButton.getAttribute("value"));
			  // Check if the value is within the desired range
	          //if (radioValue >= minValue && radioValue <= maxValue && radioButton.getAttribute("value").equals(desiredvalue)) {
	          //int radioValue = Integer.parseInt(radioButton.getAttribute("value"));
		  
	       if (radioButton.getAttribute("value").equals(desiredvalue)) {
	            radioButton.click();
	            break; // Stop iterating once the desired radio button is selected
	       }
	        else {
	            	Assert.fail("Not in range");
	    }
	}
	}
	    
	public void Click_Vote() {
		btn_vote.click();
	}
	
	public String Pol_Result() {
		
		return PollResult.getText();
	}
    public String Tol_Result() {
		
		return Tot_Res.getText();
	}

}

