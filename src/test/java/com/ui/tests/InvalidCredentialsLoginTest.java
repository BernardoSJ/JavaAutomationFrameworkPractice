package com.ui.tests;


import com.utility.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Listeners({com.ui.listeners.TestListener.class})
public class InvalidCredentialsLoginTest extends TestBase {

    Logger logger = LoggerUtility.getLogger(this.getClass());
    private static final String INVALID_EMAIL_ADDRESS = "fake@email.com";
    private static final String INVALID_PASSWORD = "password";

    @Test(description = "Verify if the proper error message is shown for the user when they enter invalid credentials",
            groups = {"e2e", "sanity"})
    public void loginTest(){
        String errorMessage = homePage.goToLoginPage().doLoginWithInvalidCredentials(INVALID_EMAIL_ADDRESS, INVALID_PASSWORD).getErrorMessage();
        assertEquals(errorMessage, "Authentication failed.");
    }



}
