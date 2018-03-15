package rest_assured;

import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class TrendRestTest extends BaseRestTest {

    @Test
    public void getAllTrends() {
        given().when().get("/api/trend").then().statusCode(200);
    }

    @Test
    public void getTrendByName() {
        given().when().get("/api/account/puppy").then()
                .body("name",equalTo("puppy"));
    }
}
