package com.ui.tests;

import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    public static void main(String[] args){
        WebDriver wd = new ChromeDriver();

        /*BrowserUtility browserUtility = new BrowserUtility(wd);
        browserUtility.goToWebsite("https://automationpractice.techwithjatin.com/");
        browserUtility.maximizeWindow();


        By signInLinkLocator = By.xpath("//a[contains(text(),'Sign')]");
        browserUtility.clickOn(signInLinkLocator);

        By emailTextBoxLocator = By.id("email");
        browserUtility.enterText(emailTextBoxLocator, "repano2553@hopesx.com");

        By passwordTextBoxLocator = By.id("passwd");
        browserUtility.enterText(passwordTextBoxLocator, "password");

        By submitLoginLocator = By.id("SubmitLogin");
        browserUtility.clickOn(submitLoginLocator);*/
    }

}
