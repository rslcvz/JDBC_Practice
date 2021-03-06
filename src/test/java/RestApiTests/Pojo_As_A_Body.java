package RestApiTests;

import Utils.ConfigurationReader;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Pojo_As_A_Body {
    @BeforeClass
    public static void setUp() {
        RestAssured.baseURI = ConfigurationReader.get("spartan.base_url");
    }

    @Test
    public void Add_NewSpartan_WithPojo_AsBody_Test() {
        /*
        --> You must have GSOn or jackson DataBind dependencies to convert java Obj to Json.
        There are 3 ways to post (create new item), you can create a Spartan in the body, or you can create a spartan
        inside of a Map(HashMap) than provide the variable inside of the body, or you can create a class make credentials private, generate
        Constructors and getter-setters by right clicking and Generating

         */

                                                                            // Number was complaining I put L at the end
        Spartan spartan = new Spartan(13, "Fenevbahce", "Male", 635262536298L);


        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(spartan).when()
                .post("/spartans")
                .then()
                .statusCode(201)
                .contentType(ContentType.JSON)
                .body("success", is("A Spartan is Born!"))
                .body("data.name", equalToIgnoringCase("Fenevbahce"))
                .body("data.phone", hasToString("635262536298"));   // 201  Created
    }
    @Test
    public void Add_NewSpartan_Negative_Test() {


        Spartan spartan = new Spartan(13, "M", "F", 638L);


        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(spartan).when()
                .post("/spartans")
                .then()
                .log().all()
                .assertThat()
                .statusCode(400)
                .body("error", is("Bad Request"))
                .body("errors.defaultMessage", hasSize(3))
                 .body("errors.defaultMessage"
                         , hasItems("Gender should be either Male or Female"
                                 , "name should be at least 2 character and max 15 character"))
                     .body("message", containsString("Error count: 3"))

                    ;

        List<String> str = new ArrayList<String>();
        Map<Integer, String> abc = new HashMap<Integer, String>();
    }
}