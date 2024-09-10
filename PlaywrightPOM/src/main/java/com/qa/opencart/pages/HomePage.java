package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class HomePage {
	
	Page page;
	//1. Srting Locators
	private String search = "input[name='search']";
	private String searchIcon = "div#search button";
	private String searchPageHeader = "div#content h1";
	private String loginLink ="a:text('Login')";
	private String AccountLink ="//i[@class='fa fa-user']";
	
	//2. Page Constructor
	public HomePage(Page page) {
		this.page = page ;
	}

	//3.Page actions/methods
	public String getHomePageTitle() {
		String title = page.title();
		System.out.println("Home page title is :"+title);
		return title;
	}
	
	public String getHomePageUrl() {
		String url = page.url();
		System.out.println("Page URL is :"+url);
		return url;
	}
	
	public String doSearch(String productName) {
		page.fill(search, productName);
		page.click(searchIcon);
		String header = page.textContent(searchPageHeader);
		System.out.println("Header is :"+header);
		return header;
	}
	
	public LoginPage navigateToLoginPage() {
		page.click(AccountLink);
		page.click(loginLink);
		return new LoginPage(page);
		
	}
}
