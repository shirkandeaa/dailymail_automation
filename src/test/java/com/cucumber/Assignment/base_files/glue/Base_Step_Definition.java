package com.cucumber.Assignment.base_files.glue;

import com.cucumber.Assignment.base_files.framework.ParentScenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Base_Step_Definition extends ParentScenario {

    @Before
    public void beforeScenario(Scenario scenario){
        before_Setup(scenario);
    }


    @After
    public void after_Scenario(){
        after_Setup();
    }

}
