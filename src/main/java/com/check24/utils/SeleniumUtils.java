package com.check24.utils;

import com.check24.config.ConfigFactory;
import com.check24.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtils {


    public static void click(By element)
    {
        waitUntilElementPresent(element);
        DriverManager.getDriver().findElement(element).click();
    }

    public static void sendKeys(By element,String value)
    {
        waitUntilElementPresent(element);
        DriverManager.getDriver().findElement(element).sendKeys(value);
    }

    public static void waitUntilElementPresent(By element)
    {
        WebDriverWait wait=new WebDriverWait(DriverManager.getDriver(), ConfigFactory.getConfig().timeout());
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }
}
