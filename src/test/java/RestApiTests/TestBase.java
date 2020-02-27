package RestApiTests;

import Utils.ConfigurationReader;
import io.restassured.RestAssured;
import javafx.scene.layout.Priority;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestBase {
    @BeforeClass
    public static void setUp() {
        RestAssured.baseURI = ConfigurationReader.get("spartan.base_url");
    }
}
