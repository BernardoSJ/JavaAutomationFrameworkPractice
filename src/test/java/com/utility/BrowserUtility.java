package com.utility;

import com.constants.Browser;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public abstract class BrowserUtility {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    Logger logger = LoggerUtility.getLogger(this.getClass());

    public BrowserUtility(WebDriver driver){
        this.driver.set(driver);
    }

    public BrowserUtility(Browser browserName) {
        logger.info("Launching Browser for " + browserName);
        if(browserName == Browser.CHROME){
            driver.set(new ChromeDriver());
        }else if(browserName == Browser.EDGE){
            driver.set(new EdgeDriver());
        }else if(browserName == Browser.FIREFOX){
            driver.set(new FirefoxDriver());
        }
    }

    public void goToWebsite(String url){
        logger.info("Visiting the website " + url);
        driver.get().get(url);
    }

    public void maximizeWindow(){
        logger.info("Maximizing the browser window");
        driver.get().manage().window().maximize();
    }

    public void clickOn(By locator){
        logger.info("Finding Element with the locator " + locator);
        WebElement element = driver.get().findElement(locator);
        logger.info("Element Found and now performing Click");
        element.click();
    }

    public void enterText(By locator, String textToEnter){
        logger.info("Finding Element with the locator " + locator);
        WebElement element = driver.get().findElement(locator);
        logger.info("Element Found and now Enter text "+ textToEnter);
        element.sendKeys(textToEnter);
    }

    public WebDriver getDriver() {
        return driver.get();
    }

    public String getVisibleText(By locator) {
        logger.info("Finding Element with the locator " + locator);
        WebElement element = driver.get().findElement(locator);
        logger.info("Element Found and now returning the visible text " + element.getText());
        return element.getText();
    }

    public String takeScreenShot(String name){
        TakesScreenshot screenshot = (TakesScreenshot) driver.get();
        File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
        String timeStamp = format.format(date);
        String path = System.getProperty("user.dir") + "//screenshots//"+name+" - "+timeStamp+".png";
        File screenshotFile = new File(path);
        try {
            FileUtils.copyFile(screenshotData, screenshotFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return path;
    }

}
