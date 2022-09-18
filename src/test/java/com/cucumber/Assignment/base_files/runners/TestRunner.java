package com.cucumber.Assignment.base_files.runners;


import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.BeforeClass;
import com.cucumber.listener.Reporter;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;



@CucumberOptions(
        features = "src/test/resources/features/",
        glue = "com.cucumber.Assignment.base_files.glue",
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        tags = "@runSmoke",
        monochrome = true,
        publish = true
)
public class TestRunner extends AbstractTestNGCucumberTests{

}
