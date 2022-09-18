package com.cucumber.Assignment.base_files.page_objects;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.aventstack.extentreports.model.Report;
import com.cucumber.Assignment.base_files.framework.ParentPage;
import com.cucumber.listener.Reporter;
import io.cucumber.java.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class dailymail_gallery_page extends ParentPage {

    WebDriver driver;

    By gallery_button = By.xpath("//div[contains(@class, 'mobile-gallery-icon')]");
    By gallery_count = By.xpath("//div[contains(@class, 'mobile-gallery-icon')]/../span");
    By view_gallery = By.xpath("//button[contains(@class, 'openGalleryButton-2CswR')]/div[contains(@class, 'viewGalleryText-2XMcO')]");
    By gallery_fullscreen = By.xpath("//div[@id='mobileGalleryModal']");
    By previous_button = By.xpath("//div[@id='mobileGalleryModal']//div[contains(@class, 'navigation-arrow') and contains(@class, 'left')]");
    By next_button = By.xpath("//div[@id='mobileGalleryModal']//div[contains(@class, 'navigation-arrow') and contains(@class, 'right')]");
    By image_counter = By.xpath("//div[@id='mobileGalleryModal']//div[contains(@class, 'title')]");
    By image_share = By.xpath("//div[contains(@class, 'container-3zJLP')]");
    By embeded_video = By.xpath("//div[contains(@class, 'vjs-video-container')]");
    By video_fullscreen_collapse = By.xpath("//div[contains(@class, 'vjs-video-container')]//div[contains(@class, 'vjs-fullscreen-control')]//span[text()='Non-Fullscreen']");
    By league_table = By.xpath("//div[contains(@class, 'season_at_glance')]//table");
    By team_name = By.xpath("//div[contains(@class, 'season_at_glance')]//table//td[contains(@class, 'team')]");

    public dailymail_gallery_page(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public void click_first_gallery(){

        List<WebElement> lisElement = get_Element_List(gallery_button);

        if (lisElement.size() > 0) {

            script_click(lisElement.get(0));
            wait_Specific_Seconds(5000);

        } else {
            Assert.assertTrue(false, "No galleries displayed on page");
        }
    }

    public void verify_gallery_fullscreen(){
        verify_Element_displayed(gallery_fullscreen);
    }

    public void click_facebook_share_modal(){
        wait_Specific_Seconds(5000);
        List<WebElement> lisElement = get_Element_List(image_share);
        click(lisElement.get(0));
        wait_Specific_Seconds(5000);
        lisElement.get(0).findElement(By.xpath(".//li[@data-social-scope='facebook']")).click();
        wait_Specific_Seconds(5000);
    }

    public void verify_facebook_share_modal(){
        String winHandleBefore = driver.getWindowHandle();
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        Assert.assertTrue(driver.getCurrentUrl().contains("www.facebook.com"), "New window URL does not matches with Facebook");
        driver.close();
        driver.switchTo().window(winHandleBefore);
    }

    public void click_video_fullscreen(){
        wait_Specific_Seconds(5000);
        List<WebElement> lisElement = get_Element_List(embeded_video);

        if (lisElement.size() > 0) {
            lisElement.get(0).findElement(By.xpath(".//div[contains(@class, 'vjs-fullscreen-control') and @role='button']")).click();
            wait_Specific_Seconds(5000);
        } else {
            Assert.assertTrue(false, "No videos displayed on page");
        }
    }

    public void verify_video_fullscreen(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement fullScreen = (WebElement) js.executeScript("var element = document.fullscreenElement; return element");
        Assert.assertNotNull(fullScreen, "Video is not running in fullscreen");
    }

    public void collapse_video_fullscreen(){
        script_click(driver.findElement(video_fullscreen_collapse));
        wait_Specific_Seconds(5);
    }

    public void verify_collapsed_video_fullscreen(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement fullScreen = (WebElement) js.executeScript("var element = document.fullscreenElement; return element");
        Assert.assertEquals(fullScreen, null, "Fullscreen is not collapsed");
    }

    public void verify_gallery_arrows(){
        String strCounter;
        wait_Specific_Seconds(5000);
        verify_Element_displayed(previous_button);
        verify_Element_displayed(next_button);
        verify_Element_displayed(image_counter);

        strCounter = get_Element_Text(image_counter);
        Assert.assertTrue(strCounter.contains("1 of"),"Image number is not correct");

        click(next_button);
        wait_Specific_Seconds(5000);
        strCounter = get_Element_Text(image_counter);
        Assert.assertTrue(strCounter.contains("2 of"),"Image number is not correct");

        click(previous_button);
        wait_Specific_Seconds(5000);
        strCounter = get_Element_Text(image_counter);
        Assert.assertTrue(strCounter.contains("1 of"),"Image number is not correct");
    }

    public void verify_gallery_displayed(){

        List<WebElement> lisElement = get_Element_List(gallery_button);

        if (lisElement.size() > 0) {
            String count = lisElement.get(0).findElement(By.xpath("../span")).getText();
            count = count.replace("+", "");
            int num = 0;
            try {
                num = Integer.parseInt(count);
            } catch (NumberFormatException nfe) {
                Assert.assertTrue(false, "Image count is not numeric");
            }
            if (num > 0) {
                Assert.assertTrue(true, "Image count is numeric");
            } else {
                Assert.assertTrue(false, "Image count is displayed zero");
            }

        } else {
            Assert.assertTrue(false, "No galleries displayed on page");
        }

    }

    public void verify_league_table(){
        verify_Element_displayed(league_table);
    }

    public String display_team_ranking(String strTeam){

        String teamName = "";
        String teamPosition = "";
        boolean result = false;
        List<WebElement> lisElement = get_Element_List(team_name);

        for (int num=0; num<lisElement.size(); num++){
            teamName = lisElement.get(num).getText();
            if (teamName.equalsIgnoreCase(strTeam)){
                teamPosition = lisElement.get(num).findElement(By.xpath("../td[contains(@class, 'position')]")).getText();
                result =  true;
                break;
            }
        }

        Assert.assertTrue(result, "Team not found");
        return teamPosition;
    }

}
