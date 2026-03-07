package com.ui.tests;

import com.ui.pages.SearchResultPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductCheckoutTest extends TestBase{

    private static final String SEARCH_TERM = "Printed Summer Dress";
    private SearchResultPage searchResultPage;

    @BeforeMethod(description = "User Logs into the application and searches for a product")
    public void setup() {
        searchResultPage = homePage.goToLoginPage().doLoginWith("repano2553@hopesx.com", "password").searchForProduct(SEARCH_TERM);
    }

    @Test(description = "Verify if the logged in User is able to buy a dress", groups = {"e2e", "smoke", "sanity"})
    public void checkoutTest(){
        String actualWarning = searchResultPage.clickOnTheProductAtIndex(0).changeSize("2").addProductToCart()
                .proceedToCheckout().goToConfirmAddressPage().goToShipmentPage()
                .goToPaymentPage().getWarningMessage();

        Assert.assertEquals(actualWarning, "No payment modules have been installed.");
    }

}
