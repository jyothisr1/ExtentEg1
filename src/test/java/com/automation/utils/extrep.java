package com.automation.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extrep {

    private static ExtentReports extentReports;
    private static ExtentTest test;
    public static void initc(){
        String p=System.getProperty("user.dir")+"\\extenrep\\e.html";
        extentReports=new ExtentReports();
        ExtentSparkReporter sparkReporter=new ExtentSparkReporter(p);
        extentReports.attachReporter(sparkReporter);
    }

    public void flush(){
        extentReports.flush();
    }
    public void createTest(){
        test=extentReports.createTest("");
    }
    public ExtentTest get(){
        return test;
    }
    public void sc(){
        test.addScreenCaptureFromPath("");
    }
}
