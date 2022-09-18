package com.cucumber.Assignment.base_files.glue;

import com.cucumber.Assignment.base_files.framework.ParentScenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

/**
 * Created by shirkandea on 12/06/2017.
 */
public class indexpage extends ParentScenario {

    @Then("Primary nav bar and secondary nav bar should have background colour for channel {string}")
    public void verify_background_colour_nav_bar(String strChannel){
        objIndexPage.verify_background_colour_of_nav_bars(strChannel);
    }

}