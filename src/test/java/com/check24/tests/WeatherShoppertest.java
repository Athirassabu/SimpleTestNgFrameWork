package com.check24.tests;

import com.check24.config.ConfigFactory;
import com.check24.config.FrameworkConfig;
import com.check24.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class WeatherShoppertest extends BaseTest{
    HomePage homepage;

    @Test(description="Complete end to end flow to check weather shopper application")
    public void endToEndFlowWeatherShopper()  {
        SoftAssert softassert=new SoftAssert();
        homepage=new HomePage();
        String actualTitle=homepage.getHomePageTitle();
        softassert.assertEquals(actualTitle, ConfigFactory.getConfig().homePageTitle());
        String paymentSuccessMessage= homepage.checkTemperature().getCheckOutPageTitle().clickPayWithCard().enterCardDetails(ConfigFactory.getConfig().email(),ConfigFactory.getConfig().card(),ConfigFactory.getConfig().date(),ConfigFactory.getConfig().cvv(),ConfigFactory.getConfig().zip()).verifySuccessMessage();
        softassert.assertEquals(paymentSuccessMessage, ConfigFactory.getConfig().paymentSuccessMessage());
        softassert.assertAll();
    }
}
