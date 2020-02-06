package step_definitions;

import Utils.ConfigurationReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class MyStepdefs {

    @Before
    public void setUp(){
        RestAssured.baseURI = ConfigurationReader.get("spartan.base_url");
    }


    @Given("Credentials with USER_role is provided")
    public void credentials_with_USER_role_is_provided() {
        System.out.println("Given Part");
    }

    @When("user try to send get request on {string}")
    public void user_try_to_send_get_request_on(String string) {
        System.out.println("Step 2");
    }

    @Then("user should get status code {int}")
    public void user_should_get_status_code(Integer int1) {
        System.out.println("Step 3");
    }

    @After
    public void reset(){
        RestAssured.reset();
    }


}
