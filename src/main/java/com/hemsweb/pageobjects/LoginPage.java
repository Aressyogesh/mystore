/**
 * 
 */
package com.hemsweb.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hemsweb.actiondriver.Action;
import com.hemsweb.base.BaseClass;

/**
 * @author 
 *  
 */
public class LoginPage extends BaseClass {
	
	Action action= new Action();
	
	@FindBy(id="UserName")
	private WebElement userName;
	
	@FindBy(id="Password")
	private WebElement password;

	@FindBy(xpath="//input[@value='Log in']")
	private WebElement signInBtn;
	
	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	 
	public DashboardPage login(String uname, String pswd, DashboardPage dashboardpage) throws InterruptedException {
		 action.scrollByVisibilityOfElement(getDriver(), userName);
		 action.type(userName, uname);
		 action.type(password, pswd);
		 action.JSClick(getDriver(), signInBtn);
		 Thread.sleep(5000);
		 dashboardpage= new DashboardPage();
		 return dashboardpage;
	 }
	
		
	
}






