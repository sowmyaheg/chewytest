package com.webapp.automation;

import org.testng.annotations.*;

import com.webapp.automation.src.HomePage;

public class LoginPageTests {
	
	@BeforeTest
	

		
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
