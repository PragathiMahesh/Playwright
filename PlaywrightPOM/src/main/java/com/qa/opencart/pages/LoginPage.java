package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class LoginPage {
	
	Page page;
	
	//1.String Locators
	private String emailID = "//input[@id='input-email']";
	private String password = "//input[@id='input-password']";
	private String loginBtn = "//input[@value='Login']";
	private String forgotPwdLink = "//div[@class='form-group']//a[normalize-space()='Forgotten Password']";
	private String logoutBtn = "//a[@class='list-group-item'][normalize-space()='Logout']";
	
	
	//2.Page Constructors
	public LoginPage(Page page) {
		this.page = page;
	}
	
	//3 Page actions / method
	public String getLoginPageTitel() {
		return page.title();
	}
	
	public boolean isForgotPwdLinkExist() {
		return page.isVisible(forgotPwdLink);
	}
	
	public boolean doLogin(String appUserName, String appPassword) {
		System.out.println("App Creds: "+appUserName+":"+ appPassword );
		page.fill(emailID,appUserName);
		page.fill(password, appPassword);
		page.click(loginBtn);
		if(page.isVisible(logoutBtn)) {
			System.out.println("User is logged in successfully");
			return true;
		}
		return false;
		
	}
	
	
	
	

}
