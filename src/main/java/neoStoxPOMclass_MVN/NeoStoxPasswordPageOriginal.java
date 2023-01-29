package neoStoxPOMclass_MVN;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class NeoStoxPasswordPageOriginal 
{
	//1 Data member should be declared globally with access level private using @findBy Annotation
	@FindBy(id = "txt_accesspin") private WebElement passwordButton;
	@FindBy(id = "lnk_submitaccesspin") private WebElement submitButton;
	
	//2 Initialize within a constructor with access level public using PageFactory
	public NeoStoxPasswordPageOriginal(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//3 Utilize within a method with access level public
	public void enterPasswordButton(String pwd) 
	{
		passwordButton.sendKeys(pwd);
		Reporter.log("entering password", true);
	}
	public void clickOnSubmitButton() throws InterruptedException
	{
		Thread.sleep(500);
		submitButton.click();
		Reporter.log("clicking on submit button", true);
		
	}
}
