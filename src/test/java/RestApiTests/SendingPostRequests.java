package RestApiTests;

import Utils.ConfigurationReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class SendingPostRequests {

    @BeforeClass
    public static void setUp() {
        RestAssured.baseURI = ConfigurationReader.get("spartan.base_url");
    }

    @Test
    public void Single_Spartan_LoggingAll_Details_Test() {

        given()
                .pathParam("my_id", 3)
                .log().all()   //  <--  Gives every request as a log
                .when()
                .get("/spartans/{my_id}")
                .then()
                .log().ifValidationFails()  // <-- If any validation fail, it gives us as a log.
                .statusCode(200);
    }

    @Test
    public void Add_NewSpartan_WithMap_AsBody_Test(){

        // YOU NEED JACKSON OR GSON LIBRARY(DEPENDENCY) TO COVERT JAVA OBJ TO JSON FORMAT

        Map<String, Object> bodyMap = new HashMap<String, Object>();
        bodyMap.put("id", 50);
        bodyMap.put("name", "Delikanli");
        bodyMap.put("gender", "Male");
        bodyMap.put("phone", "23422332232");

        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(bodyMap).when()
                        .post("/spartans")
                        .then()
                        .statusCode(201)
                .contentType(ContentType.JSON)
                         .body("success", is("A Spartan is Born!") )
                         .body("data.name", equalToIgnoringCase("Delikanli"))
                        .body("data.phone", hasToString("23422332232"));   // 201  Created
    }
}