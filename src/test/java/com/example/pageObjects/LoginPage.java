package com.example.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	 WebDriver ldriver;
	 public LoginPage(WebDriver rdriver)
	 {
		 ldriver=rdriver;
		 PageFactory.initElements(ldriver, this);
	 }
	 
	 @FindBy(id="user-name")
	 @CacheLookup
	 WebElement txtUserName;
	 

	 @FindBy(id="password")
	 @CacheLookup
	 WebElement txtPassword;

	 @FindBy(id="login-button")
	 @CacheLookup
	 WebElement LoginBTN;
	 
	
	 /**
	  * Action Methods
	  */
	 
	 public void setUserName(String uName)
	 {
		 txtUserName.sendKeys(uName);
	 }
	 
	 public void setPassword(String password)
	 {
		 txtPassword.sendKeys(password);
	 }

	 public void login()
	 {
		 LoginBTN.click();
	 }
	 
	 

}
