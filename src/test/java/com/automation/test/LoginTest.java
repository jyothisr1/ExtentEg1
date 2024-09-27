package com.automation.test;

import com.automation.utils.AllureReportManager;
import com.automation.utils.ConfigReader;
import com.automation.utils.ExtentReportManager;
import com.aventstack.extentreports.Status;
import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest extends BaseTest{
    @Test
    public void verifyUserCanLogOut() throws IOException {



//        LoginPage loginPage=new LoginPage(driver);

        loginPage.openWebsite();
        ExtentReportManager.getTest().pass("openWebsite");
//        AllureReportManager.attachScreenshot();
//        Allure.addAttachment();
//        test.addScreenCaptureFromPath(screenshot());
        loginPage.doLogin(ConfigReader.getConfigValue("login.username"),ConfigReader.getConfigValue("login.password"));

        test.addScreenCaptureFromPath(screenshot());

//        HomePage homePage=new HomePage(driver);
        Assert.assertTrue(homePage.isHomePageDisplayed(),"not displayed");

        homePage.clickOnBurgerMenu();
        homePage.clickOnLogoutLink();
//        AllureReportManager.attachScreenshot();

        Assert.assertTrue(loginPage.isLoginPageDisplayed(),"login page is not displayed");


//        test.log(Status.INFO, "Logged out successfully");
//        test.log(Status.PASS, "User logout test passed");

    }
}
