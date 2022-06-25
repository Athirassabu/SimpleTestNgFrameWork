package com.check24.pages;

import com.check24.driver.DriverManager;
import com.check24.reports.ExtentLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static com.check24.utils.SeleniumUtils.*;

public class HomePage {
    private static final By TEMPERATURE_VALUE=By.id("temperature");
    private static final By BUTTON_SUNCREAM=By.xpath("//button[text()='Buy sunscreens']");
    private static final By BUTTON_MOISTURIZER=By.xpath("//button[text()='Buy moisturizers']");
    private  SunCreamPage suncream;
    private MoisturizerPage moisturizer;

    public  HomePage()
    {
        suncream=new SunCreamPage();
        moisturizer=new MoisturizerPage();
    }

    public String getHomePageTitle()
    {
        String title=DriverManager.getDriver().getTitle();
        ExtentLogger.pass(title+" :Title of home page is displayed");
        return title;
    }

    public  CheckOutPage checkTemperature()
    {
        WebElement element = DriverManager.getDriver().findElement(TEMPERATURE_VALUE);
        String temperature = element.getText();
        String temperatureValue=temperature.replaceAll("[^0-9]","");
        int temperatureDisplayed=Integer.parseInt(temperatureValue);
        System.out.println("Temperature displayed is:"+temperatureDisplayed);
        ExtentLogger.pass(temperatureDisplayed+" : is the temperature displayed in home page");
        if(temperatureDisplayed>34)
        {
            clickSuncream();
        }
        else if(temperatureDisplayed<19)
        {
            clickMoisturizer();
        }
        return new CheckOutPage();
    }

    public CheckOutPage clickSuncream()
    {

        click(BUTTON_SUNCREAM);
        ExtentLogger.pass("Temperature is >34 so suncream is clicked successfully");
        suncream.getSunCreamPageTitle().addFirstLeastExpensive().addSecondLeastExpensive().clickCart();
        return new CheckOutPage();
    }

    public CheckOutPage clickMoisturizer()
    {

        click(BUTTON_MOISTURIZER);
        ExtentLogger.pass("Temperature is <19 so moisturizer is clicked successfully");
        moisturizer.getMoisturizerPageTitle().addFirstLeastExpensive().addSecondLeastExpensive().clickCart();
        return new CheckOutPage();
    }

}




