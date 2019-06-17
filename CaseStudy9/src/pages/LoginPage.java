package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy(xpath="//input[@type=\'email\' and @class=\'form-control padding-10\'] ")
	WebElement txtEmailAddress;
	@FindBy(xpath="//button[@type=\'submit\' and @class=\'btn btn-action btn-lg btn-block loginbtn\']")
	WebElement btnLogIn;
	@FindBy(xpath="//input[@type=\'password\' and @class=\'form-control padding-10\']")
	WebElement txtPassword;
	
	public LoginPage(WebDriver driver)
	{
		// "this" keyword is used here to distinguish global and local varaible "driver"
		PageFactory.initElements(driver, this);
	}

	public void singIn(String email, String pass) {
		
		System.out.println("Input data");
		txtEmailAddress.clear();
		txtEmailAddress.sendKeys(email);
		txtPassword.clear();
		txtPassword.sendKeys(pass);
	}
}
