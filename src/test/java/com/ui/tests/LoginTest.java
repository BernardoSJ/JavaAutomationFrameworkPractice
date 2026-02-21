package com.ui.tests;


import static org.testng.Assert.*;

import com.ui.pojo.User;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({com.ui.listeners.TestListener.class})
public class LoginTest extends TestBase {

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
