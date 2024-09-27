package com.automation.listerner;
import com.automation.utils.ExtentReportManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReportListerner implements ITestListener{



//        private static ExtentReports extentReports;
//        private static ExtentTest test;

        @Override
        public void onFinish(ITestContext context) {
//            extentReports.flush();
            ExtentReportManager.flush();
        }

        public void onStart(ITestContext context) {
//            String path = System.getProperty("user.dir") + "\\extentReports\\extentReport.html";
//            extentReports = new ExtentReports();
//            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(path);
//            sparkReporter.config().setTheme(Theme.DARK);
//            extentReports.attachReporter(sparkReporter);
            ExtentReportManager.initExtentReporter();
        }

        public void onTestStart(ITestResult result) {
//            test = extentReports.createTest("testCreated");
            ExtentReportManager.createTest(result.getMethod().getMethodName());
        }

        public void onTestSuccess(ITestResult result) {
//            test.pass("Passed");
            ExtentReportManager.getTest().pass("test pass");
        }

        public void onTestFailure(ITestResult result) {
//            test.fail("Failed");
            ExtentReportManager.getTest().fail("test failed \n"+result.getThrowable().getMessage());
        }

        public void onTestSkipped(ITestResult result) {
//            test.skip("Skipped");
            ExtentReportManager.getTest().skip("skipped");
        }

}
