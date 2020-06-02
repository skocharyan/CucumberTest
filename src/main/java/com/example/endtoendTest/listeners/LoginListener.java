package com.example.endtoendTest.listeners;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class LoginListener implements ITestListener {
    Logger log =  LogManager.getLogger(LoginListener.class);



    @Override
    public void onTestStart(ITestResult iTestResult) {
          log.debug("Starting test " + iTestResult.getName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        log.info("Test implements successfully " + iTestResult.getName());
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        log.error("Test " + iTestResult.getName() + " failed");

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
         log.debug("test " + iTestResult.getName() + " skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {
        log.info("test " + iTestContext.getName() + " on start ");

    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        log.info("test " + iTestContext.getName() + " on finish ");
    }
}
