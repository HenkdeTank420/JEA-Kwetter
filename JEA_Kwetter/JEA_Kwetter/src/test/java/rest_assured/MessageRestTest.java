package rest_assured;

import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.IsEqual.equalTo;

public class MessageRestTest extends BaseRestTest {

    @Test
    public void getAllMessages() {
        given().when().get("/api/message").then().statusCode(200);
    }

    @Test
    public void getAllMessagesOfUser() {
        given().when().get("/api/message/Violet").then().statusCode(200);
    }

    @Test
    public void getMessageWithWord() {
        given().when().get("/api/message/first").then()
                .body(containsString(""));
    }
}
