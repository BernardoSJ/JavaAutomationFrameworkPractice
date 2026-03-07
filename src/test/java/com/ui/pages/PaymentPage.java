package com.ui.pages;

import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage extends BrowserUtility {

    private static final By NO_PAYMENT_MODULES_WARNING_LOCAROR = By.xpath("//p[contains(@class, 'alert-warning')]");

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public String getWarningMessage(){
        return getVisibleText(NO_PAYMENT_MODULES_WARNING_LOCAROR);
    }

}
