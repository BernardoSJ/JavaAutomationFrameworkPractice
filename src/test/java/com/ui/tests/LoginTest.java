package com.ui.tests;

import static com.constants.Browser.*;
import com.ui.pages.HomePage;
import static org.testng.Assert.*;

import com.ui.pojo.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {

    HomePage homePage;

    @BeforeMethod(description = "Load the Homepage of the website")
    public void setup(){
        homePage = new HomePage(EDGE);
    }

    @Test(description = "Verifies with the valid user is able to login into the application",
            groups = {"e2e", "sanity"},
            dataProviderClass = com.ui.dataproviders.LoginDataProvider.class,
            dataProvider = "LoginTestDataProvider")
    public void loginTest(User user){
        String userName = homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName();
        assertEquals(userName, "Bernardo Salinas");
    }

    @Test(description = "Verifies with the valid user is able to login into the application using CSV File",
            groups = {"e2e", "sanity"},
            dataProviderClass = com.ui.dataproviders.LoginDataProvider.class,
            dataProvider = "LoginTestCSVDataProvider")
    public void loginCSVTest(User user){
        String userName = homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName();
        assertEquals(userName, "Bernardo Salinas");
    }

    @Test(description = "Verifies with the valid user is able to login into the application using Excel File",
            groups = {"e2e", "sanity"},
            dataProviderClass = com.ui.dataproviders.LoginDataProvider.class,
            dataProvider = "LoginTestExcelDataProvider",
            retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
    public void loginExcelTest(User user){
        String userName = homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName();
        assertEquals(userName, "Bernardo Salinas");
    }

}
