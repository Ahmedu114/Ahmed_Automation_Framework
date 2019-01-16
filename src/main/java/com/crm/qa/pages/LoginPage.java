package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;

public class LoginPage extends TestBase {
//Page Factory or Object Repository
@FindBy(name="username")
WebElement username;
@FindBy(name ="password")
WebElement password;
@FindBy (xpath ="//input[@class='btn btn-small']")
WebElement loginBtn;
@FindBy (xpath="//button[contains(text(),'Sign Up')]")
WebElement SignupBtn;
//Initialize page objects

@FindBy(xpath = "/html/body/div[2]/div/div[1]/a/img")
WebElement crmlogo;






//initializing the page objects
public LoginPage () {
PageFactory.initElements(driver, this);
}
// Actions
public String validateloginpagetitel() {
return driver.getTitle();
}


public boolean validateCRMImage() {
	return crmlogo.isDisplayed();
}






public HomePage login (String un,String pwd) throws InterruptedException {
username.sendKeys(un);
password.sendKeys(pwd);
Thread.sleep(2000);
loginBtn.click();
return new HomePage();
}

}

