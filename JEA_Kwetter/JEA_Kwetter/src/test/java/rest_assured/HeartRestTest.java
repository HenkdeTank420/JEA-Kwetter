package rest_assured;

import org.junit.Test;

import static io.restassured.RestAssured.given;

public class HeartRestTest extends BaseRestTest {

    @Test
    public void getAllHeartsOfMessage() {
        given().when().get("/api/heart/1").then().statusCode(200);
    }

    @Test
    public void getAllAccountThatGaveHeartOfMessage() {
        given().when().get("/api/heart/account/1").then().statusCode(200);
    }
}
