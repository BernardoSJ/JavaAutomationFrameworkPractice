package com.ui.tests;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LambdaTestUtility;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


public class TestBase {

    protected HomePage homePage;
    private boolean isLambdaTest;

    @Parameters( {"browser", "isLambdaTest", "isHeadless"} )
    @BeforeMethod(description = "Load the Homepage of the website")
    public void setup(
            @Optional("chrome") String browser,
            @Optional("false") boolean isLambdaTest,
            @Optional("true") boolean isHeadless, ITestResult result){
        this.isLambdaTest = isLambdaTest;
        WebDriver lamdaDriver;
        if(isLambdaTest){
            lamdaDriver = LambdaTestUtility.initializeLambdaTestSession(browser, result.getMethod().getMethodName());
            homePage = new HomePage(lamdaDriver);
        }else{
            homePage = new HomePage(Browser.valueOf(browser.toUpperCase()),isHeadless);
        }

    }

    public BrowserUtility getInstance() {
        return homePage;
    }

   @AfterMethod(description = "Tear Down the browser")
    public void tearDown(){
        if(isLambdaTest){
            LambdaTestUtility.quitSession();
        }else{
            homePage.quit();
        }
    }

}
