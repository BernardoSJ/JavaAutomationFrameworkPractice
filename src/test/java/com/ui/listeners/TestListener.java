package com.ui.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ui.tests.TestBase;
import com.utility.BrowserUtility;
import com.utility.ExtentReportsUtility;
import com.utility.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;

public class TestListener implements ITestListener {

    Logger logger = LoggerUtility.getLogger(this.getClass());

    ExtentSparkReporter extentSparkReporter;
    ExtentReports extentReports;
    ExtentTest extentTest;

    public void onTestStart(ITestResult result){
        logger.info(result.getMethod().getMethodName());
        logger.info(result.getMethod().getDescription());
        logger.info(Arrays.toString(result.getMethod().getGroups()));
        ExtentReportsUtility.createExtentTest(result.getMethod().getMethodName());
    }

    public void onTestSuccess(ITestResult result) {
        logger.info(result.getMethod().getMethodName() + " PASSED");
        ExtentReportsUtility.getTest().log(Status.PASS, result.getMethod().getMethodName() + " PASSED");
    }

    public void onTestFailure(ITestResult result) {
        logger.error(result.getMethod().getMethodName() + " FAILED");
        logger.error(result.getThrowable().getMessage());
        ExtentReportsUtility.getTest().log(Status.FAIL, result.getMethod().getMethodName() + " FAILED");
        ExtentReportsUtility.getTest().log(Status.FAIL, result.getThrowable().getMessage());

        Object testClass = result.getInstance();
        BrowserUtility browserUtility = ((TestBase)testClass).getInstance();
        logger.info("Capturing Screenshot for the failed tests");

        String screenshotPath = browserUtility.takeScreenShot(result.getMethod().getMethodName());
        logger.info("Attaching the Screenshot to the HTML File");
        ExtentReportsUtility.getTest().addScreenCaptureFromPath(screenshotPath);
    }

    public void onTestSkipped(ITestResult result) {
        logger.warn(result.getMethod().getMethodName() + " SKIPPED");
        ExtentReportsUtility.getTest().log(Status.SKIP, result.getMethod().getMethodName() + " SKIPPED");
    }

    public void onStart(ITestContext context) {
        logger.info("Test Suite Started");
        ExtentReportsUtility.setupSpartReporter("report.html");
    }

    public void onFinish(ITestContext context) {
        logger.info("Test Suite Completed");
        ExtentReportsUtility.flushReport();
    }

}
