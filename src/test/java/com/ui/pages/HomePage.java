package com.ui.pages;

import com.constants.Browser;
import static com.constants.Env.*;
import com.utility.BrowserUtility;

import static com.utility.JSONUtility.*;

import com.utility.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class HomePage extends BrowserUtility {
    Logger logger = LoggerUtility.getLogger(this.getClass());

    private static final By SIGN_IN_LINK_LOCATOR = By.xpath("//a[contains(text(),'Sign')]");

    public HomePage(Browser browserName) {
        super(browserName);
        //goToWebsite(readProperty(QA,"URL"));
        goToWebsite(readJSON(QA).getUrl());
        maximizeWindow();
    }

    public LoginPage goToLoginPage() {
        logger.info("Trying to perform click to go to Sign in Page");
        clickOn(SIGN_IN_LINK_LOCATOR);
        LoginPage loginPage = new LoginPage(getDriver());
        return loginPage;
    }
}
