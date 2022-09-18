package com.cucumber.Assignment.base_files.glue;

import com.cucumber.Assignment.base_files.domain.*;
import com.cucumber.Assignment.base_files.framework.ParentScenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;

import java.util.Collections;

public class PetStore extends ParentScenario {

    Pet pet;
    User user;

    @Given("I have required pet details")
    public void create_pet_object(){
        final String PHOTO_URL = "src/test/resources/Prod5.jpeg";
         pet = new Pet.Builder()
                .withId(RandomStringUtils.randomNumeric(10))
                .withName("My pet")
                .withPhotoUrls(Collections.singletonList(PHOTO_URL))
                .withStatus(Status.available)
                .withTags(Collections.singletonList(new Tag(1, "golden-retriever")))
                .inCategory(new Category(1, "dogs")).build();

        user = new User.Builder()
                .withId(100)
                .withUsername("user"+RandomStringUtils.randomNumeric(10).toString())
                .withfirstname("Anand")
                .withlastName("Shirkande")
                .withemail("anandshirkande@gmail.com")
                .withpassword("anand")
                .withphone("7459561697")
                .withuserStatus(0).build();
        objPetStore.addNewUser(user);
    }

    @When("I add new pet to store")
    public void add_new_pet(){
        objPetStore.addNewPet(pet, user.getUserName(), user.getPassword());
    }

    @Then("New pet should be added")
    public void verify_new_added_pet(){
        Pet petResponse = objPetStore.findPet(pet);
        Assert.assertEquals(pet, petResponse, "FInd pet functiona failed." );
    }
}
