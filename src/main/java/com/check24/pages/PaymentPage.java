package com.check24.pages;

import com.check24.driver.DriverManager;
import com.check24.reports.ExtentLogger;
import org.openqa.selenium.By;
import static com.check24.utils.SeleniumUtils.*;

public class PaymentPage {

    private static final By TEXT_EMAIL=By.xpath("//input[@id='email']");
    private static final By CVC = By.id("cc-csc");
    private static final By CLICK_PAY = By.className("iconTick");
    private static final By ZIP = By.id("billing-zip");

    public PaymentPage enterEmailId(String email)  {
        DriverManager.getDriver().switchTo().frame(0);
        sendKeys(TEXT_EMAIL,email);
        ExtentLogger.pass(email+" :is entered in email text field");
        return this;
    }

    public PaymentPage enterCard(String card)
    {
        javaScriptSenkeys("card_number",card);
        ExtentLogger.pass(card+" :is entered in card number text field");
        return this;
    }

    public PaymentPage enterDate(String date)
    {
        javaScriptSenkeys("cc-exp",date);
        ExtentLogger.pass(date+" :is entered in expiry date text field");
        return this;
    }

    public PaymentPage enterCVC(String cvv)
    {
        sendKeys(CVC,cvv);
        ExtentLogger.pass(cvv+" :is entered in cvv text field");
        return this;
    }

    public PaymentPage enterZip(String zip)
    {
        sendKeys(ZIP,zip);
        ExtentLogger.pass(zip+" :is entered in zip text field");
        return this;
    }

    public PaymentSuccessPage clickPayButton()
    {
        click(CLICK_PAY);
        ExtentLogger.pass("Pay button is clicked successfully");
        return new PaymentSuccessPage();
    }

    public PaymentSuccessPage enterCardDetails(String email, String card, String date, String cv, String zip) {
        return enterEmailId(email)
                .enterCard(card)
                .enterDate(date).enterCVC(cv).enterZip(zip).clickPayButton();

    }

}
