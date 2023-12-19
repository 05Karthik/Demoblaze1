package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;

public class SignUpPage {
	
	//create a webdriver variable
	public WebDriver driver;
	
	//Initialize the pageFactory to init method
	public SignUpPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//locate the element in signupPage
	
	//signupbtn homepage
	@FindBy(id="signin2")
	WebElement signupbtnhome;
	//username
	@FindBy(id="sign-username")
	WebElement usernamefield;
	//password	
	@FindBy(id="sign-password")
	WebElement passwordfield;
	//signupbtn
	@FindBy(xpath="//button[.='Sign up']")
	WebElement signupbtn;
	//closebtn
	@FindBy(xpath="(//button[.='Close'])[2]")
	WebElement signupclosebtn;
	
	
	public void Signuphome(){
		signupbtnhome.click();
		
}
	public void getusername(String username) {
		usernamefield.sendKeys(username);
	}
	
	public void getpassword(String password) {
		passwordfield.sendKeys(password);
	}
	public void clicksignupbtn() {
		signupbtn.click();
	}
	
	
	
	


}
