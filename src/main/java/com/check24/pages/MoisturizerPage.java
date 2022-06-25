package com.check24.pages;

import com.check24.driver.DriverManager;
import com.check24.reports.ExtentLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import static com.check24.utils.SeleniumUtils.click;

public class MoisturizerPage {
    private static final By CLICKCART   = By.xpath("//button[@class='thin-text nav-link']");

    public MoisturizerPage getMoisturizerPageTitle()
    {
        String title= DriverManager.getDriver().getTitle();
        ExtentLogger.pass(title+" :Title of suncream page is displayed");
        return this;
    }

    public MoisturizerPage addFirstLeastExpensive() {
        List<Integer> list=new LinkedList<>();
        List<WebElement> elements = DriverManager.getDriver().findElements(By.xpath("//p[@class='font-weight-bold top-space-10']"));
        for(int i=0;i<elements.size();i++)
        {
            String text = elements.get(i).getText();
            if(text.contains("Aloe"))
            {
                WebElement element= DriverManager.getDriver().findElement(By.xpath("//p[text()='"+text+"']/following::p[1]"));
                String text1=element.getText();
                String newPrice=text1.replaceAll("[^0-9]","");
                int priceValue=Integer.parseInt(newPrice);
                list.add(priceValue);
            }
        }
        int value= Collections.min(list);
        By leastExpensiveMoisturizer = By.xpath("//p[contains(text(),'"+value+"')]//following::button");
        click(leastExpensiveMoisturizer);
        ExtentLogger.pass("The least expensive moisturizer contains Aloe is added successfully");
        return this;
    }
    public MoisturizerPage addSecondLeastExpensive()  {
        List<Integer> list=new LinkedList<>();
        List<WebElement> elements = DriverManager.getDriver().findElements(By.xpath("//p[@class='font-weight-bold top-space-10']"));
        for(int i=0;i<elements.size();i++)
        {
            String text = elements.get(i).getText();
            if(text.contains("Almond"))
            {
                WebElement element= DriverManager.getDriver().findElement(By.xpath("//p[text()='"+text+"']/following::p[1]"));
                String text1=element.getText();
                String newPrice=text1.replaceAll("[^0-9]","");
                int priceValue=Integer.parseInt(newPrice);
                list.add(priceValue);
            }
        }
        int value=Collections.min(list);
        By secondLeastExpensiveMoisturizer = By.xpath("//p[contains(text(),'"+value+"')]//following::button");
        click(secondLeastExpensiveMoisturizer);
        ExtentLogger.pass("The second least expensive moisturizer contains Almond is added successfully");
        return this;
    }

    public CheckOutPage clickCart()
    {
        click(CLICKCART);
        ExtentLogger.pass("Cart button is clicked and navigates to Checkout Page");
        return new CheckOutPage();
    }
}
