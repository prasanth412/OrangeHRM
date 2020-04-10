package com.htcindia.orange.pages;

import org.openqa.selenium.WebDriver;

import com.htcindia.orange.base.BasePage;
import com.htcindia.orange.helpers.MyException;
import com.htcindia.orange.pageobjects.LoginPageObjects;

public class LoginPage extends BasePage implements LoginPageObjects 
{

	public LoginPage(WebDriver driver) throws MyException 
	{
		super(driver);
	}

	public DashboardPage User_Login(String username, String passwWord) throws MyException 
	{
		
			if (identify(txtusername).isDisplayed()) 
			{
				type(username, txtusername);
				type(passwWord, txtpassword);
				clickOn(btnlogin);
			}
			return new DashboardPage(lDriver);
}
}
