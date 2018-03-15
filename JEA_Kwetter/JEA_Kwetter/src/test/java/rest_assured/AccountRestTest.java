package rest_assured;

import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.StringContains.containsString;

public class AccountRestTest extends BaseRestTest {

    @Test
    public void getAllAccounts() {
        given().when().get("/api/account").then().statusCode(200);
    }

    @Test
    public void typoInUserName() {
        given().when().get("/api/account/Volet")
                .then().statusCode(500);
    }

    @Test
    public void verifyNameStructured() {
        given().when().get("/api/account/Violet").then()
                .body("username",equalTo("Violet"));
    }

    @Test
    public void getAllFollowersOfAccount() {
        given().when().get("/api/account/followers/Violet").then()
                .body("username",equalTo("Thomas"));
    }

    @Test
    public void getAllFolloweesOfAccount() {
        given().when().get("/api/account/followees/Violet").then()
                .body("username",equalTo("Thomas"));
    }
}
