package com.cucumber.Assignment.base_files.glue;

import com.cucumber.Assignment.base_files.framework.ParentScenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

/**
 * Created by shirkandea on 12/06/2017.
 */
public class homepage extends ParentScenario {

    @Given("I am on dailymail website home page")
    public void navigate_to_homepage(){
        String url = "https://www.dailymail.co.uk/home/index.html";
        launch_URL(url);
        objHomePage.accept_cookie();
    }

    @When("I see date component at top of home page")
    public void verify_date_component(){
        objHomePage.verify_date_component();
    }

    @Then("Current date should be displayed")
    public void verify_date_value(){
        objHomePage.verify_date();
    }

    @Then("I navigate to {string} Page")
    public void navigate_to_index_page(String strChannel){
        objHomePage.navigate_to_channel_page(strChannel);
    }

}