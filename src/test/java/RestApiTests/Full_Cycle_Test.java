package RestApiTests;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class Full_Cycle_Test extends TestBase {   // In TestBase I have base URL (Spartans)

    public Spartan createRandomSpartan() {

        Spartan spartan = new Spartan(13, "Fenevbahce", "Male", 635262536298L);
                 given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(spartan)
                .when()
                .post("/spartans");

        return null;
    }
}
