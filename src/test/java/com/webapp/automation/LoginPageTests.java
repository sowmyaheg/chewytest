package com.webapp.automation;

import org.testng.annotations.*;

import com.webapp.automation.src.HomePage;

public class LoginPageTests {

	String usrName="sowmya";
	String password="test";
	
//	@Test
	public void testPageLaunch(){
		HomePage.launchPage();
	}
	
//	@Test
//	public void testLogin(){
//		HomePage.userLogin(usrName, password);
//		
//	}
	
//	@Test
	public void testSearchItem(){
		HomePage.launchChewy();
		HomePage.searchItem("Cat Food");
		HomePage.searchbyPrice();
	}
	
//	@Test
	public void testTodaysDeal(){
		HomePage.launchChewy();
		HomePage.clickButton("todaysDeal");
	}
	
	@Test
	public void testHelpLink(){
		HomePage.launchChewy();
		HomePage.clickOnLink();
	}
}
