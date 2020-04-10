package com.htcindia.orange.testcases;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.htcindia.orange.base.Base;
import com.htcindia.orange.dataprovider.MyDataProvider;
import com.htcindia.orange.helpers.MyException;

public class AdminUserManagementTest extends Base
{
	
	@Test(dataProvider = "AdminUserManagementData", dataProviderClass = MyDataProvider.class)
	public void T001_openAdmin(Map<String, String> testData, Method method) throws Exception {
		try {
			setTestCase(getParentTestCase().createNode(method.getName()));
			dashboardpage = loginPage.User_Login(testData.get("username"), testData.get("password"));
			adminusermanagementPage = dashboardpage.navigateToAdminn();
			getTestCase().log(Status.INFO, "Navigated To Admin Page");
		} 
		catch (MyException e) 
		{
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "AdminUserManagementData", dataProviderClass = MyDataProvider.class)
	public void T002_searchAdmin(Map<String, String> testData, Method method) throws MyException{
		try {
			setTestCase(getParentTestCase().createNode(method.getName()));

			adminusermanagementPage.clickSearch(testData.get("uname"));
			getTestCase().log(Status.INFO, "Detailes searched successfully");
			
			
		} catch (Exception e) 
		{
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}

}
}