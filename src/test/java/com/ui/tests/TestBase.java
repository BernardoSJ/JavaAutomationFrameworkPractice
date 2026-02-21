package com.ui.tests;

import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import org.testng.annotations.BeforeMethod;

import static com.constants.Browser.EDGE;

public class TestBase {

    protected HomePage homePage;

    @BeforeMethod(description = "Load the Homepage of the website")
    public void setup(){
        homePage = new HomePage(EDGE);
    }

    public BrowserUtility getInstance() {
        return homePage;
    }

}
