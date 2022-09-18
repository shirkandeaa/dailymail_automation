package com.cucumber.Assignment.base_files.page_objects;

import com.cucumber.Assignment.base_files.framework.ParentPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class dailymail_index_page extends ParentPage {

    WebDriver driver;

    By primary_nav_bar = By.xpath("");
    By secondary_nav_bar = By.xpath("");


    public dailymail_index_page(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public void verify_background_colour_of_nav_bars(String StrChannel){

        By channel_name = By.xpath("//ul[contains(@class, 'nav-primary')]//a[text()='"+StrChannel+"']");
        String channelColour = get_background_colour(channel_name);

        By secondary_nav_bar = By.xpath("//div[contains(@class, '"+StrChannel.toLowerCase()+"')]//div[contains(@class, 'nav-secondary')]");
        String secondaryNavColour = get_background_colour(secondary_nav_bar);

        Assert.assertEquals(channelColour, secondaryNavColour, "Primary navigation and secondary nav bar does not have same back ground colour");
    }
}
