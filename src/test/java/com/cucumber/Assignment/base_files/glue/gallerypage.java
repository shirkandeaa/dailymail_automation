package com.cucumber.Assignment.base_files.glue;

import bsh.util.JConsole;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.cucumber.Assignment.base_files.framework.ParentScenario;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.messages.Messages;

public class gallerypage extends ParentScenario {

    @Given("I am on gallery page")
    public void navigate_to_gallery(){
        String url = "https://www.dailymail.co.uk/sport/football/article-11059935/Cristiano-Ronaldo-tells-Manchester-United-DOES-offer-rival-club.html";
        launch_URL(url);
        objHomePage.accept_cookie();
    }

    @And("I can see atleast one gallery icon with count of images displayed")
    public void verify_gallery_displayed(){
        objGalleryPage.verify_gallery_displayed();
    }

    @When("I click on first gallery icon")
    public void click_first_gallery(){
        objGalleryPage.click_first_gallery();
    }

    @And("Gallery is loaded with full screen")
    public void verify_gallery_loaded_fullscreen(){
        objGalleryPage.verify_gallery_fullscreen();
    }

    @And("Gallery has Previous and Next arrows")
    public void verify_gallery_arrows(){
        objGalleryPage.verify_gallery_arrows();
    }

    @And("I click on facebook share icon")
    public void click_on_facebook_icon(){
        objGalleryPage.click_facebook_share_modal();
    }

    @And("Facebook modal dialog should open")
    public void verify_facebook_modal(){
        objGalleryPage.verify_facebook_share_modal();
    }

    @And("I click on full screen button of first video")
    public void click_fullscreen_button(){
        objGalleryPage.click_video_fullscreen();
    }

    @And("Video is displayed in fullscreen")
    public void verify_fullscreen(){
        objGalleryPage.verify_video_fullscreen();
    }

    @And("I click on collapse fullscreen button")
    public void collapse_fullscreen(){
        objGalleryPage.collapse_video_fullscreen();
    }

    @And("Video is not displayed in fullscreen")
    public void verify_collapsed_screen(){
        objGalleryPage.verify_collapsed_video_fullscreen();
        scenario.log("hhh");
    }

    @When("I see premier league table at bottom right side")
    public void verify_league_table(){
        objGalleryPage.verify_league_table();
    }

    @Then("I can see ranking for team {string}")
    public void display_ranking_for_team(String strTeam){
        String teamPosition = objGalleryPage.display_team_ranking(strTeam);
        scenario.log(strTeam+" team has rankins as "+teamPosition);
    }
}
