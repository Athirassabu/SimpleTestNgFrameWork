package com.check24.pages;

import com.check24.driver.DriverManager;
import com.check24.reports.ExtentLogger;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

public class PaymentSuccessPage {

    private static final By paymentMessage = By.xpath("//h2[text()='PAYMENT SUCCESS']"); //100 threads //1 txtboxUsername

    public String verifySuccessMessage(){
        DriverManager.getDriver().switchTo().defaultContent();
        String message=DriverManager.getDriver().findElement(paymentMessage).getText();
        ExtentLogger.pass(message + " is displayed successfully");
        return message;
    }
}
