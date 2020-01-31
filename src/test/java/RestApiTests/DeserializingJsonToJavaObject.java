package RestApiTests;

import Utils.ConfigurationReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class DeserializingJsonToJavaObject {
    @BeforeClass
    public static void setUp() {
        RestAssured.baseURI = ConfigurationReader.get("spartan.base_url");
    }

    @Test
    public void DeserializeAnJsonTo_Object_Test() {  // These info come from Spartan page(Spartan.class)
        //first way
        Spartan sp1 = get("/spartans/12").prettyPeek()
                .jsonPath().getObject("", Spartan.class);
        System.out.println("sp1 = " + sp1);

        //second way
        Spartan sp2 = get("/spartans/19").as(Spartan.class);
        System.out.println("sp2 = " + sp2);

    }

    @Test
    public void Add_NewSpartan_WithPojo_AsBody_Test() {
        Spartan spartan = new Spartan(13, "Fenevbahce", "Male", 635262536298L);


        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(spartan)
                .when()
                .post("/spartans")
                .then()
                .statusCode(201);
    }
}