package org.example.driver;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.example.driver.BaseClass.driver;

public class Listener implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("Test Started");

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

        System.out.println("Test Success");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
            String folder_name = "screenshot";
            File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            DateFormat df = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
            new File(folder_name).mkdir();
            String file_name = df.format(new Date()) + ".png";
        try {
            FileUtils.copyFile(f, new File(folder_name + "/" + file_name));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Test Failed");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("Test Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("Test Finished");
    }

}
