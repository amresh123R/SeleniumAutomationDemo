package com.automationdemo.testcases;

import org.testng.annotations.Test;

import com.automationdemo.pages.BaseTest;
import com.automationdemo.pages.LoginPage;
import com.automationdemo.utilities.ConfigDataProvider;

public class TestCaseDemo extends BaseTest {

	ConfigDataProvider cdp = new ConfigDataProvider();

	@Test
	public void verifyLogin() {
		LoginPage obj = new LoginPage(driver);
		obj.loginPortal(cdp.getUsername(), cdp.getPassword());
		System.out.println("Doing changes in GitHub");

	}

}
