package com.check24.pages;

import com.check24.driver.DriverManager;
import com.check24.reports.ExtentLogger;
import static com.check24.utils.SeleniumUtils.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SunCreamPage {
    private static final By CLICKCART   = By.xpath("//button[@class='thin-text nav-link']");

    public SunCreamPage getSunCreamPageTitle()
    {
        String title= DriverManager.getDriver().getTitle();
        ExtentLogger.pass(title+" :Title of suncream page is displayed");
        return this;
    }

    public SunCreamPage addFirstLeastExpensive() {
        List<Integer> list=new LinkedList<>();
        List<WebElement> elements = DriverManager.getDriver().findElements(By.xpath("//p[@class='font-weight-bold top-space-10']"));
        for(int i=0;i<elements.size();i++)
        {
            String text = elements.get(i).getText();
            if(text.contains("50"))
            {
                WebElement element= DriverManager.getDriver().findElement(By.xpath("//p[text()='"+text+"']/following::p[1]"));
                String text1=element.getText();
                String newPrice=text1.replaceAll("[^0-9]","");
                int priceValue=Integer.parseInt(newPrice);
                list.add(priceValue);
            }
        }
        int value= Collections.min(list);
        By leastExpensiveSunsCream = By.xpath("//p[contains(text(),'"+value+"')]//following::button");
        click(leastExpensiveSunsCream);
        ExtentLogger.pass("The least expensive suncream with spf 50 is added successfully");
        return this;
    }
    public SunCreamPage addSecondLeastExpensive()  {
        List<Integer> list=new LinkedList<>();
        List<WebElement> elements = DriverManager.getDriver().findElements(By.xpath("//p[@class='font-weight-bold top-space-10']"));
        for(int i=0;i<elements.size();i++)
        {
            String text = elements.get(i).getText();
            if(text.contains("30"))
            {
                WebElement element= DriverManager.getDriver().findElement(By.xpath("//p[text()='"+text+"']/following::p[1]"));
                String text1=element.getText();
                String newPrice=text1.replaceAll("[^0-9]","");
                int priceValue=Integer.parseInt(newPrice);
                list.add(priceValue);
            }
        }
        int value=Collections.min(list);
        By secondLeastExpensiveSunsCream = By.xpath("//p[contains(text(),'"+value+"')]//following::button");
        click(secondLeastExpensiveSunsCream);
        ExtentLogger.pass("The second least expensive suncream with spf 30 is added successfully");
        return this;
    }

    public CheckOutPage clickCart()
    {
        click(CLICKCART);
        ExtentLogger.pass("Cart button is clicked and navigates to Checkout Page");
        return new CheckOutPage();
    }
}
