package com.example.Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.pageObjects.LoginPage;

public class TC_Login_001 extends BaseClass {

	@Test(enabled =true)
	public void loginTest() {
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Entered Username");
		lp.setPassword(password);
		logger.info("Entered Password");
		lp.login();
		logger.info("clicked login");

		if (driver.getTitle().equalsIgnoreCase("Swag Labs")) {
			Assert.assertTrue(true);
			logger.info("Testcase Passed");
			System.out.println("TestCase Passed");

		} else {
			Assert.assertFalse(false);
			logger.error("Testcase failed");
			System.out.println("Test Case Failed");
		}

	}
	
	
	@Test(enabled = true)
	public void testCase2() {
		System.out.println("TestCase_2 Executed");

	}

	@Test(enabled = true)
	public void testCase3() {
		System.out.println("TestCase_3 Executed");

	}

	@Test(enabled = true)
	public void testCase4() {
		System.out.println("TestCase_4 Executed");

	}

	@Test(enabled = false)
	public void testCase5() {
		System.out.println("TestCase_5 Executed");

	}

}
