package neoStoxPOMclass_MVN;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class NeoStoxSignInPageOriginal 
{
	//1 Data member should be declared globally with access level private using @findBy Annotation
	@FindBy(id = "MainContent_signinsignup_txt_mobilenumber") private WebElement mobileNoButton;
	@FindBy(id = "lnk_signup1") private WebElement mobileNoClickButton;
	
	//2 Initialize within a constructor with access level public using PageFactory
	public NeoStoxSignInPageOriginal(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//3 Utilize within a method with access level public
	public void enterMobileNumber(String MobNum) 
	{
		mobileNoButton.sendKeys(MobNum);
		Reporter.log("Entering mobile number", true);
	}
	public void clickOnMobileSignInButton()
	{
		mobileNoClickButton.click();
		Reporter.log("Clicking on Mobile sign in button", true);
	}
}
