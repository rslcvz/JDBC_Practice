package RestApiTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.testng.AssertJUnit.assertEquals;


public class HR_ORDS_REST_API_Test {

    @BeforeClass
    public static void setUp() {
        baseURI = "http://54.164.29.19";
        port = 1000;
        basePath = "/ords/hr";
    }
    @Test
public void test_All_regions() {

        Response response = get("/regions");

        //Getting the region index of 0, (first region)
        String first_regionName = response.jsonPath().getString("items[0].region_name");

        //  Getting all regions
        List<String> all_RegionName = response.jsonPath().getList("items.region_name");
        System.out.println("all_RegionName = " + all_RegionName);
        assertEquals(200, response.statusCode());

        // Getting one href's from the region
        String oneHref = response.jsonPath().getString("items[1].links[0].href");
        System.out.println("oneHref = " + oneHref);

        // Getting all href's

        List<String> allHref = response.jsonPath().getList("items.links.href");
        System.out.println("allHref = " + allHref);

        //Getting Rel's

        List<String> getRel = response.jsonPath().getList("items.links.rel");
        System.out.println("getRel = " + getRel);
    }
    @Test
    public void test_SingleRegion(){
        Response response = given().pathParam("my_id", 1).get("/regions/{my_id}");
        response.prettyPrint();

        // Getting my Json as a MAP, key-value format
        Map<String, ?> myJsonMap= response.jsonPath().getMap("");
        System.out.println(myJsonMap.get("region_name"));
        System.out.println(myJsonMap.get("links"));

    }

    @AfterClass
    public static void tearDown(){
        // avoid collusion between different test
//        RestAssured.reset();
    }
}
