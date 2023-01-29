package neoStoxTestClass_MVN;

import org.testng.annotations.Test;
import neoStoxBase_MVN.BaseClass;
import neoStoxPOMclass_MVN.NeoStoxDashBoardPageOriginal;
import neoStoxPOMclass_MVN.NeoStoxHomePageOriginal;
import neoStoxPOMclass_MVN.NeoStoxPasswordPageOriginal;
import neoStoxPOMclass_MVN.NeoStoxSignInPageOriginal;
import neoStoxPOMclass_MVN.Utility;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

@Listeners(neoStoxTestClass_MVN.Listener.class)
public class ValidateUserNameUsingDataProvider extends BaseClass
{
	NeoStoxHomePageOriginal home;
	NeoStoxSignInPageOriginal signIn;
	NeoStoxDashBoardPageOriginal dash;
	NeoStoxPasswordPageOriginal pass;
	//String s= "TCID-1919";
	
	@BeforeMethod
	  public void launchingNeoStoxSite() throws IOException 
	  {
		    launchBrowser();
			home= new NeoStoxHomePageOriginal(driver);
			signIn= new NeoStoxSignInPageOriginal(driver);
			pass= new NeoStoxPasswordPageOriginal(driver);
			dash= new NeoStoxDashBoardPageOriginal(driver);
	  }
	
	@Test(dataProvider = "loginDetailsforValidateUserName")
     public void validatingUsername(String mobNum,String password,String userName) throws InterruptedException 
	{
		home.clickOnSignInButton();
		Utility.implicitWait(1000, driver);
		
		signIn.enterMobileNumber(mobNum);
		Thread.sleep(500);
		signIn.clickOnMobileSignInButton();
		
		Utility.implicitWait(1000, driver);
		pass.enterPasswordButton(password);
		pass.clickOnSubmitButton();
		
		//Utility.implicitWait(1000, driver);
		dash.handlePopUp(driver);
		
		//Assert.fail();
		Assert.assertEquals(dash.getActualUserName(), userName,"Actual and Expected user Names are not matching TC is failed");
 
		dash.logOutFromNeoStox();
	}
  

  @AfterMethod
  public void closingBrowser() throws InterruptedException 
  {
	  driver.close();
		Reporter.log("Closing application", true);
		Thread.sleep(1000);
  }
  
  @DataProvider(name="loginDetailsforValidateUserName")
  public String[][] getLoginDetails1()
  {
  String userData[][]= {{"8208586061","8217","Hi Rahul Joge"},{"7387901637","9362","Hi Ankush More"},{"8805568380","2303","Hi Pooja Talekar"}};
  return userData;
  }

}
