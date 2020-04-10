package com.htcindia.orange.pageobjects;

import org.openqa.selenium.By;

public interface AdminUserManagementPageObjects 
{
	 //  By linkadmin=By.xpath("//a[@id='menu_admin_viewAdminModule']//b"); 
	   By txtuname=By.cssSelector("input#searchSystemUser_userName"); 
	   By dropdwnuserrole=By.cssSelector("select#searchSystemUser_userType"); 
	   By txtempname=By.className("inputFormatHint ac_input"); 
	   By dropdwnstatus=By.cssSelector("select#searchSystemUser_status"); 
	   By btnsearch=By.id("searchBtn"); 
	   By btnreset=By.id("resetBtn");
	   By btnadd=By.cssSelector("input#btnAdd");
	   By btndelete=By.id("btnDelete");
}
