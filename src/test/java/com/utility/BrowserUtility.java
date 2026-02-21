package com.utility;

import com.constants.Browser;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public abstract class BrowserUtility {

    private WebDriver driver;
    Logger logger = LoggerUtility.getLogger(this.getClass());

    public BrowserUtility(WebDriver driver){
        this.driver = driver;
    }

    public BrowserUtility(Browser browserName) {
        logger.info("Launching Browser for " + browserName);
        if(browserName == Browser.CHROME){
            driver = new ChromeDriver();
        }else if(browserName == Browser.EDGE){
            driver = new EdgeDriver();
        }else if(browserName == Browser.FIREFOX){

            driver = new FirefoxDriver();
        }
    }

    public void goToWebsite(String url){
        logger.info("Visiting the website " + url);
        driver.get(url);
    }

    public void maximizeWindow(){
        logger.info("Maximizing the browser window");
        driver.manage().window().maximize();
    }

    public void clickOn(By locator){
        logger.info("Finding Element with the locator " + locator);
        WebElement element = driver.findElement(locator);
        logger.info("Element Found and now performing Click");
        element.click();
    }

    public void enterText(By locator, String textToEnter){
        logger.info("Finding Element with the locator " + locator);
        WebElement element = driver.findElement(locator);
        logger.info("Element Found and now Enter text "+ textToEnter);
        element.sendKeys(textToEnter);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public String getVisibleText(By locator) {
        logger.info("Finding Element with the locator " + locator);
        WebElement element = driver.findElement(locator);
        logger.info("Element Found and now returning the visible text " + element.getText());
        return element.getText();
    }

}
