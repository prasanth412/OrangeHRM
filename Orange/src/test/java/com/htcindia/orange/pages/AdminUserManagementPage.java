package com.htcindia.orange.pages;

import org.openqa.selenium.WebDriver;

import com.htcindia.orange.base.BasePage;
import com.htcindia.orange.helpers.MyException;
import com.htcindia.orange.pageobjects.AdminUserManagementPageObjects;

public class AdminUserManagementPage extends BasePage implements AdminUserManagementPageObjects
{
	public AdminUserManagementPage(WebDriver driver) throws MyException
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public void clickSearch(String text) throws Exception
	{
		
		type(text, txtuname);
		clickOn(btnsearch);
		Thread.sleep(2000);
	}

}
