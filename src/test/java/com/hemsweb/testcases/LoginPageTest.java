/**
 * 
 */
package com.hemsweb.testcases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.hemsweb.base.BaseClass;
import com.hemsweb.dataprovider.DataProviders;
import com.hemsweb.pageobjects.DashboardPage;
import com.hemsweb.pageobjects.LoginPage;
import com.hemsweb.utility.Log;

/**
 * @author 
 *
 */
public class LoginPageTest extends BaseClass {
	
	private LoginPage loginPage;
	DashboardPage dashboardpage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser); 
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	@Test(groups = {"Smoke","Sanity"},dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void loginTest(String uname, String pswd) throws Throwable {
		Log.startTestCase("loginTest");
		Log.info("Enter Username and Password");
		loginPage.login(uname, pswd, dashboardpage);
		String actualURL=dashboardpage.getCurrentURL(); 
	    String expectedURL="http://40.75.76.166/hemsweb/home/Dashboard";
	    Log.info("Verifying if user is able to login");
	    Assert.assertEquals(actualURL, expectedURL);
	   	Log.info("Login is Success");
	    Log.endTestCase("loginTest");
	}

}
