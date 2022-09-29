package com.cucumber.Assignment.base_files.page_objects;

import com.cucumber.Assignment.base_files.framework.ParentPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class dailymail_home_page extends ParentPage {

    WebDriver driver;

    By date_field = By.xpath("//div[@id='weather-wrapper']/strong");
    By accpet_cookie = By.xpath("//div[contains(@class, 'overlay_el5_B')]//button[text()= 'Got it']");

    public dailymail_home_page(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public void accept_cookie(){
        wait_Specific_Seconds(5000);
        if(return_element_displayed_value(accpet_cookie)){
            click(accpet_cookie);
        }
    }

    public void navigate_to_channel_page(String strChannel){
        By channel_name = By.xpath("//ul[contains(@class, 'nav-primary')]/li[contains(@class, '"+strChannel.toLowerCase()+"')]");
        click(channel_name);
    }

    public void verify_date_component(){
        verify_Element_displayed(date_field);
    }

    public void verify_date(){

        String[] suffixes = {  "0th",  "1st",  "2nd",  "3rd",  "4th",  "5th",  "6th",  "7th",  "8th",  "9th",
                        "10th", "11th", "12th", "13th", "14th", "15th", "16th", "17th", "18th", "19th",
                        "20th", "21st", "22nd", "23rd", "24th", "25th", "26th", "27th", "28th", "29th",
                        "30th", "31st" };

        Date date = new Date();
        SimpleDateFormat formatDayOfWeek  = new SimpleDateFormat("EEEEEEEE");
        SimpleDateFormat formatMonthOfYear  = new SimpleDateFormat("MMM");
        SimpleDateFormat formatDateOfMonth  = new SimpleDateFormat("d");
        SimpleDateFormat formatYear  = new SimpleDateFormat("YYYY");

        String dayOfWeek = formatDayOfWeek.format(date);
        String monthOfYear = formatMonthOfYear.format(date);
        int dateOfMon = Integer.parseInt(formatDateOfMonth.format(date));
        String dateOfMonth = suffixes[dateOfMon];
        String year = formatYear.format(date);

        DateFormat dateFormat = new SimpleDateFormat("EEEEE,MMM MM/dd/yyyy ");

        String strDate = dayOfWeek + ", " + monthOfYear + " " + dateOfMonth + " " + year;

        System.out.println("strDate="+strDate);

        Assert.assertEquals(strDate, driver.findElement(date_field).getText(), "Date displayed on homepage does not match with current date");

    }
}
