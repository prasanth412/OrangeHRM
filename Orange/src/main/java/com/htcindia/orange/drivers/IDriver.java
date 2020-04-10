package com.htcindia.orange.drivers;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;

import com.htcindia.orange.helpers.MyException;

public interface IDriver 
{

	WebDriver launch(String browserName) throws MyException, MalformedURLException;
}
