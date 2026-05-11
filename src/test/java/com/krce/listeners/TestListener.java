package com.krce.listeners;

import com.krce.base.BaseTest;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

public class TestListener
        extends BaseTest
        implements ITestListener {

    @Override
    public void onTestFailure(
            ITestResult result) {

        try {

            File src =
                    ((TakesScreenshot) driver)
                            .getScreenshotAs(
                                    OutputType.FILE);

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
}