package step_definitions;

import Utils.ConfigurationReader;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class PracticeWithMustafa {
    RequestSpecification requestSpecification;
    Response response;
    @Before
    public void setUp() {

        RestAssured.baseURI = ConfigurationReader.get("spartan.base_url");

    }
    @Given("User has the required end point and access token")
    public void user_has_the_required_end_point_and_access_token() {

        given()
                .contentType(ContentType.JSON)
                .log().all();

    }
    @When("User sends a get request to the <{string}>")
    public void userSendsAGetRequestToThe(String arg0) {

        response =  when().get("/spartans");
        response.prettyPrint();


    }

    @Then("User should get <{string}> status code")
    public void userShouldGetStatusCode(String arg0) {

        response.then().statusCode(200).log().all();
    }



    @And("Content type should be in <{string}> format")
    public void contentTypeShouldBeInFormat(String arg0) {
        response.then().contentType(ContentType.JSON).log().all();
    }
}
