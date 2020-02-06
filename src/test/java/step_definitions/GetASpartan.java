package step_definitions;

import Utils.ConfigurationReader;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.*;

public class GetASpartan {

    Response response;
    @Before
    public void setUp(){

        RestAssured.baseURI = ConfigurationReader.get("spartan.base_url");
    }
    @Given("User should be able to choose the content type")
    public void user_should_be_able_to_choose_the_content_type() {

      given()
               .contentType(ContentType.JSON)
                .log().all();
    }

    @When("user need to send get request on {string}")
    public void user_need_to_send_get_request_on(String string) {

        when().get("/spartans/157").prettyPeek().then().statusCode(200);

    }

    @Then("user should be able get status code {int}")
    public void user_should_be_able_get_status_code(Integer int1) {

    }
}
