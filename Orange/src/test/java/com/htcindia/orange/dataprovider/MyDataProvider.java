package com.htcindia.orange.dataprovider;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import com.htcindia.orange.base.Base;
import com.htcindia.orange.helpers.ExcelUtility;

public class MyDataProvider extends Base
{

	@DataProvider(name = "AdminUserManagementData")
	public static Object[][] adMasterDataProvider(Method method) throws Exception {
		try {
			Object[][] testDataArray = null;
			ExcelUtility.setExcelFile(
					config.properties.get("testDataFilesPath") + config.properties.get("testDataFile"), "AdminUserManagement");
			/* Test method name and value in test data should be same(value highlighted) */
			testDataArray = ExcelUtility.getTestData(method.getName());
			return testDataArray;
		} catch (Exception e) {
			throw new Exception("Failed to Read AdminUserManagement Details Test Data");
		}
	}
}
