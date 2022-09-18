package com.cucumber.Assignment.base_files.framework;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;


public class Utils {

    private WebDriver driver;

    public Utils(WebDriver driver){
        this.driver=driver;
    }

    public void click(By by){ driver.findElement(by).click();}

    public void script_click(WebElement objElement){
        System.out.println("objElement"+objElement);
        JavascriptExecutor ex=(JavascriptExecutor)driver;
        ex.executeScript("arguments[0].click()", objElement);
    }

    public WebElement getElement(By by){ return driver.findElement(by);}

    public String getPageTitle(){

        return  driver.getTitle();
    }

    public void verify_Element_displayed(By by){

        boolean result =driver.findElement(by).isDisplayed();

        Assert.assertEquals(result, true, "Element not displayed");

    }

    public boolean return_element_displayed_value(By by){

        boolean result =driver.findElement(by).isDisplayed();

        return result;

    }

    public String get_background_colour(By by){
        return driver.findElement(by).getCssValue("background-color");
    }

    public void verify_Element_displayed(By by, String msg){

        boolean result =driver.findElement(by).isDisplayed();

        Assert.assertEquals(result, true, "Element not displayed. "+msg);

    }

    public String get_Element_Text(By by){
        return  driver.findElement(by).getText();
    }

    public void verify_Element_Text(By by, String text){

        String strExpected = driver.findElement(by).getText().toLowerCase().trim();
        Assert.assertEquals(strExpected, text.toLowerCase().trim(), "Element text not displayed as expected .Expected: "+text.toLowerCase()+" and Actual is : "+strExpected);

    }

    public String get_Attribute_Value(By by, String strAttribute){

        String result = driver.findElement(by).getAttribute(strAttribute);
        return  result;
    }


    public Date get_Current_Date(){

        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        //getTime() returns the current date in default time zone
        Date date = calendar.getTime();
        return date;
    }




    //*******************************************************//
    public void enterText(By by, String text) {

        WebElement objInput = driver.findElement(by);

        objInput.clear();
        objInput.sendKeys(text);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        objInput.sendKeys(Keys.ENTER);
    }

    public List get_Element_List(By by) {

        List<WebElement> lisElement = driver.findElements(by);

        return lisElement;
    }

    public void click(WebElement objElement) {
        objElement.click();
    }

    public void wait_Specific_Seconds(long sec) {

        try {
            Thread.sleep(sec);
        } catch (Exception e) {

        }
        driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
    }


}
