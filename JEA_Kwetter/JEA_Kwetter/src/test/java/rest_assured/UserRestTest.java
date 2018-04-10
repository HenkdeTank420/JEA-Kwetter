package rest_assured;

import domain.User;
import org.junit.Assert;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class UserRestTest extends BaseRestTest{

    @Test
    public void createUserTest(){
        User user = new User();
        user.setUsername("test2");
        user.setEmail("test2@email.com");
        user.setPassword("test");

        given()
                .contentType("application/json")
                .body(user).when().post("/api/user/")
                .then()
                .statusCode(200);
    }

    @Test(timeout = 100000)
    public void createUserStressTest(){
        for(int i = 0; i < 1000; i++) {
            User user = new User();
            user.setUsername("test");
            user.setEmail("test@email.com");
            user.setPassword("test");

            given()
                    .contentType("application/json")
                    .body(user).when().post("/api/user/")
                    .then()
                    .statusCode(200);
        }
        Assert.assertTrue(true);
    }
}
