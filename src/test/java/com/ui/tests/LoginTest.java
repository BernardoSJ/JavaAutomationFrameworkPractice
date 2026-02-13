package com.ui.tests;

import static com.constants.Browser.*;
import com.ui.pages.HomePage;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {

    HomePage homePage;

    @BeforeMethod(description = "Load the Homepage of the website")
    public void setup(){
        homePage = new HomePage(EDGE);
    }

    @Test(description = "Verifies with the valid user is able to login into the application", groups = {"e2e", "sanity"})
    public void loginTest(){
        String userName = homePage.goToLoginPage().doLoginWith("repano2553@hopesx.com", "password").getUserName();
        assertEquals(userName, "Bernardo Salinas");
    }

}
