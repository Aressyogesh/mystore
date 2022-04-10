package com.hemsweb.pageobjects;

import org.openqa.selenium.support.PageFactory;

import com.hemsweb.actiondriver.Action;
import com.hemsweb.base.BaseClass;

public class DashboardPage extends BaseClass{

	Action action = new Action();
	
	
	public DashboardPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public String getCurrentURL() throws Throwable {
		String dashboardPageURL=action.getCurrentURL(getDriver());
		return dashboardPageURL;
	}
}
