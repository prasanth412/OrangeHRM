package com.htcindia.orange.pages;

import org.openqa.selenium.WebDriver;

import com.htcindia.orange.base.BasePage;
import com.htcindia.orange.helpers.MyException;
import com.htcindia.orange.pageobjects.DashboardPageObjects;

public class DashboardPage extends BasePage implements DashboardPageObjects {

	public DashboardPage(WebDriver driver) throws MyException 
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public AdminUserManagementPage navigateToAdminn() throws MyException 
	{
	    
		clickOn(linkadmin);
		return new AdminUserManagementPage(lDriver);
	}

	
}
