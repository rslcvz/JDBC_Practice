package RestApiTests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.IDynamicGraph;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.xml.ws.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.testng.AssertJUnit.assertEquals;

public class HamCrestLibrary {
    @BeforeClass
    public static void setUp() {
        RestAssured.baseURI = "http://3.83.190.136";
        RestAssured.port = 8000;
        RestAssured.basePath = "/api";
    // Hamcrest is a testing library to provide many building / testing methods that comes from Hamcrest Matcher
}

    @Test
    public void Calculation_Test() {

        int a = 10, b = 20;
        assertEquals(30, a + b);

        assertThat(30, equalTo(a + b));
        assertThat(20, greaterThan(5 + 5));
        assertThat(30, is(3 * 10));

    }

    @Test
    public void DoingAssertionWithHamcrest_ForSpartan() {

        given()
                .pathParam("my_id", 3)
                .when()
                .get("/spartans/{my_id}")
                .then().assertThat()
                .statusCode(equalTo(200))
                .contentType(ContentType.JSON)
                .body("id", equalTo(3))
                .body("gender", equalToIgnoringCase("male"))
                .body("phone", hasToString("6105035231"));










    }
}