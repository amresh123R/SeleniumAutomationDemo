package com.automationdemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver lDriver) {
		this.driver = lDriver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "loginlabel")
	WebElement loginclick;
	@FindBy(id = "user_login")
	WebElement uname;
	@FindBy(id = "user_pass")
	WebElement pword;
	@FindBy(id = "wp-submit")
	WebElement loginbutton;
	@FindBy(id = "gk-login-toggle")
	WebElement loginIconClick;

	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	WebElement logoutClick;

	public void loginPortal(String username, String password) {
		loginclick.click();
		uname.sendKeys(username);
		pword.sendKeys(password);
		loginbutton.click();

	}
	
	public void logoutPortal () {
		loginIconClick.click();
		logoutClick.click();
	}
}
