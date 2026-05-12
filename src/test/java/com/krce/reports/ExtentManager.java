package com.krce.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    static ExtentReports extent;

    public static ExtentReports getReport() {

        if (extent == null) {

            ExtentSparkReporter reporter =
                    new ExtentSparkReporter(
                            "Reports/ExtentReport.html");

            extent = new ExtentReports();

            extent.attachReporter(reporter);
        }

        return extent;
    }
}