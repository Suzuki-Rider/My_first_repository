package neoStoxTestClass_MVN;

import java.io.IOException;


import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import neoStoxBase_MVN.BaseClass;
import neoStoxPOMclass_MVN.Utility;

public class Listener extends BaseClass implements ITestListener
{

	public void onTestFailure(ITestResult result) 
	{
		try 
		{
			String tcName = result.getName();
			Reporter.log("TC is "+tcName+" failed & try again", true);
			Utility.takeScreenshot(driver, tcName);
		} 
		
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void onTestSuccess(ITestResult result) 
	{
		Reporter.log("TC is "+result.getName()+" passed", true);
	}
}
