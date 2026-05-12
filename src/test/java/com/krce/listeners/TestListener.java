package com.krce.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.krce.base.BaseTest;

import com.krce.reports.ExtentManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

public class TestListener
        extends BaseTest
        implements ITestListener {

    ExtentReports extent = ExtentManager.getReport();

    ExtentTest test;

    @Override
    public void onTestStart(
            ITestResult result) {

        test = extent.createTest(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass("Test Passed");
    }

    @Override
    public void onTestFailure(
            ITestResult result) {

        test.fail("Test Failed");

        try {

            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File folder =
                    new File("screenshots");

            if (!folder.exists()) {

                folder.mkdir();
            }

            File dest =
                    new File(
                            "screenshots/"
                                    + result.getName()
                                    + ".png");

            FileHandler.copy(src, dest);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(
            ITestContext context) {

        extent.flush();
    }
}