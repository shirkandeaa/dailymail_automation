package com.cucumber.Assignment.base_files.page_objects;

import com.cucumber.Assignment.base_files.domain.Pet;
import com.cucumber.Assignment.base_files.domain.Category;
import com.cucumber.Assignment.base_files.domain.Status;
import com.cucumber.Assignment.base_files.domain.User;
import com.cucumber.Assignment.base_files.framework.ParentPage;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.WebDriver;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

import static com.cucumber.Assignment.base_files.domain.Constants.*;
import static com.cucumber.Assignment.base_files.domain.Constants.BASE_URL;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;


public class PetsController extends ParentPage {
    WebDriver driver;
    public static String PET_ENDPOINT = BASE_URL + "/pet";
    public static String USER_ENDPOINT = BASE_URL + "/user/createUsersWithArrayInput";
    private RequestSpecification requestSpecification;

    public PetsController(WebDriver driver) {
        super(driver);
        this.driver = driver;
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri(BASE_URL);
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.log(LogDetail.ALL);
        requestSpecification = requestSpecBuilder.build();
    }

    public void addNewUser(User user) {
        System.out.println(USER_ENDPOINT);
        given(requestSpecification)
                .body(user)
                .post(USER_ENDPOINT)
                .then()
                .statusCode(HttpServletResponse.SC_OK);
    }

    public void addNewPet(Pet pet, String userName, String userPassword) {
        given(requestSpecification)
                .auth()
                .basic(userName, userPassword)
                .when()
                .body(pet)
                .post(PET_ENDPOINT)
                .then()
                .statusCode(HttpServletResponse.SC_OK);
    }


    public void deletePet(Pet pet) {
        given(requestSpecification)
                .pathParam("petId", pet.getId())
                .delete(PET_ENDPOINT + "/{petId}");
    }


    public Pet findPet(Pet pet) {
        return given(requestSpecification)
                .pathParam("petId", pet.getId())
                .get(PET_ENDPOINT + "/{petId}").as(Pet.class);
    }


}
