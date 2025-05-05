package com.parabank.utilities;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;


import static com.parabank.base.BaseTest.driverThreadLocal;

public class TestExecutionListener implements ITestListener {


    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("on Test sucess");
        WebDriver driver = driverThreadLocal.get();
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Screenshot of " + result.getName(), new ByteArrayInputStream(screenshot));
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("on Test fail");

        WebDriver driver = driverThreadLocal.get();
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Screenshot of " + result.getName(), new ByteArrayInputStream(screenshot));
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("on Test skip");
        WebDriver driver = driverThreadLocal.get();
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Screenshot of " + result.getName(), new ByteArrayInputStream(screenshot));
    }

    @Override
    public void onTestStart(ITestResult result) {
        // TODO Auto-generated method stub

    }


    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub
        WebDriver driver = driverThreadLocal.get();
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Screenshot of " + result.getName(), new ByteArrayInputStream(screenshot));


    }

    @Override
    public void onStart(ITestContext context) {
        // TODO Auto-generated method stub
        Allure.addAttachment("Environment", "DEV");

    }

    @Override
    public void onFinish(ITestContext context) {
        // TODO Auto-generated method stub


    }

}