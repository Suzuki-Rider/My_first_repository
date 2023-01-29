package neoStoxPOMclass_MVN;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;



public class NeoStoxDashBoardPageOriginal 
{
	//1 Data member should be declared globally with access level private using @findBy Annotation
	@FindBy(xpath = "(//a[text()='OK'])[2]") private WebElement okPopupButton;
	@FindBy(xpath = "(//a[text()='Close'])[5]") private WebElement closePopupButton;
	@FindBy(id = "lbl_username") private WebElement myUserName;
	@FindBy(xpath = "//span[text()='Logout']") private WebElement logOutButton;
	
	//2 Initialize within a constructor with access level public using PageFactory
	public NeoStoxDashBoardPageOriginal(WebDriver driver)
	{
	PageFactory.initElements(driver, this);
	}
	
	//3 Utilize within a method with access level public
	public void handlePopUp(WebDriver driver) throws InterruptedException
	{
	Thread.sleep(5000);
	//Utility.scrollIntoView(driver, okPopupButton);
	okPopupButton.click();
	Reporter.log("clicking on PopUp OK button", true);
	Thread.sleep(500);
	//Utility.scrollIntoView(driver, closePopupButton);
    //closePopupButton.click();
    //Reporter.log("clicking on PopUp close button", true);
	}
	
	public void logOutFromNeoStox() throws InterruptedException
	{
	myUserName.click();
	Thread.sleep(1000);
	logOutButton.click();
	Reporter.log("Logging out from neoStox", true);
	Thread.sleep(1000);
	}
	public String getActualUserName()
	{
	String actualUserName = myUserName.getText();
	Reporter.log("getting actual user Name", true);
	Reporter.log("Actual user name is --> "+actualUserName, true);
	return actualUserName;
	}
}
