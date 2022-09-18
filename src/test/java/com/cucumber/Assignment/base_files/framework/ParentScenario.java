package com.cucumber.Assignment.base_files.framework;

import com.cucumber.Assignment.base_files.page_objects.*;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class ParentScenario {


  private static WebDriver driver;
  protected static Scenario scenario;
  protected static dailymail_home_page objHomePage;
  protected static dailymail_index_page objIndexPage;
  protected static dailymail_gallery_page objGalleryPage;
  protected static PetsController objPetStore;

  public void before_Setup(Scenario scenario){

    System.setProperty("webdriver.chrome.driver","src/test/java/com/cucumber/Assignment/base_files/resources/chrome_mac/chromedriver");
    System.out.println("11111 =");
    this.scenario = scenario;
    try{
      driver = new ChromeDriver();
    } catch (Exception e){
      System.out.println("e ="+e);
    }
    objHomePage = new dailymail_home_page(driver);
    objIndexPage = new dailymail_index_page(driver);
    objGalleryPage = new dailymail_gallery_page(driver);
    objPetStore = new PetsController(driver);
  }

  public void after_Setup(){
    driver.quit();
  }

  public void launch_URL(String url){

    System.out.println("In launch url setup"+driver);
    driver.get(url);
  }


}
