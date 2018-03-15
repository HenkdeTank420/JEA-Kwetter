package rest_assured;

import org.junit.Test;

import static io.restassured.RestAssured.given;

public class RoleRestTest extends BaseRestTest {

    @Test
    public void getAllRoles() {
        given().when().get("/api/role").then().statusCode(200);
    }

    @Test
    public void getAccountsWithRole() {
        given().when().get("/api/role/user").then().statusCode(200);
    }
}
