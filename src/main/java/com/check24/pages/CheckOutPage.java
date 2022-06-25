package com.check24.pages;

import com.check24.driver.DriverManager;
import com.check24.reports.ExtentLogger;
import org.openqa.selenium.By;
import static com.check24.utils.SeleniumUtils.*;

public class CheckOutPage {
    private static final By BUTTON_PAYWITHCARD   = By.className("stripe-button-el");

    public CheckOutPage getCheckOutPageTitle()
    {
        String title= DriverManager.getDriver().getTitle();
        ExtentLogger.pass(title+" :Title of checkout page is displayed");
        return this;
    }
    public PaymentPage clickPayWithCard()
    {
        click(BUTTON_PAYWITHCARD);
        ExtentLogger.pass("Pay with card button is clicked successfully");
        return new PaymentPage();
    }

}
