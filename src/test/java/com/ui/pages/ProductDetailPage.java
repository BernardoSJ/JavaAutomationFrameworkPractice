package com.ui.pages;

import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage extends BrowserUtility {

    private static final By SIZE_DROPDOWN_LOCATOR = By.id("group_1");
    private static final By ADD_TO_CART_BUTTON_LOCATOR = By.name("Submit");
    private static final By PROCEED_TO_CHECKOUT_BUTTON_LOCATOR = By.xpath("//a[@title='Proceed to checkout']");

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    public ProductDetailPage changeSize(String value){
        selectFromDropdown(SIZE_DROPDOWN_LOCATOR, value);
        ProductDetailPage productDetailPage = new ProductDetailPage(getDriver());
        return productDetailPage;
    }

    public ProductDetailPage addProductToCart(){
        clickOn(ADD_TO_CART_BUTTON_LOCATOR);
        ProductDetailPage productDetailPage = new ProductDetailPage(getDriver());
        return productDetailPage;
    }

    public ShoppingCartPage proceedToCheckout(){
        clickOn(PROCEED_TO_CHECKOUT_BUTTON_LOCATOR);
        ShoppingCartPage shoppingcartPage = new ShoppingCartPage(getDriver());
        return shoppingcartPage;
    }

}
