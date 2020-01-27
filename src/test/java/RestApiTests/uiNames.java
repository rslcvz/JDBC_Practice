package RestApiTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import javafx.beans.binding.When;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;

public class uiNames {

    @Test
    public void getUiNames(){
        Response response = get("https://uinames.com/api/");
        response.prettyPrint();
        Assert.assertEquals(200, response.statusCode());
        Assert.assertEquals("application/json; charset=utf-8", response.contentType());


        System.out.println(response.path("gender").toString());
        // Verify that name, surname, gender, region fields have value
        Assert.assertNotNull(response.path("gender").toString());
        Assert.assertNotNull(response.path("surname").toString());
        Assert.assertNotNull(response.path("name").toString());
        Assert.assertNotNull(response.path("region").toString());

//        Assert.assertNull(response.path("region").toString());

    }
}
