package com.htcindia.orange.pageobjects;

import org.openqa.selenium.By;

public interface LoginPageObjects 
{
	By txtusername=By.cssSelector("input#txtUsername");
	By txtpassword=By.cssSelector("input#txtPassword");
	By btnlogin=By.cssSelector("input#btnLogin");
	By linkfotgot=By.cssSelector("//div[@id='forgotPasswordLink']//a");
}
