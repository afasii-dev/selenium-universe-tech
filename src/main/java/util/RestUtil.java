package util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import rest.User;

import static io.restassured.RestAssured.given;

public class RestUtil {

    static {
        RestAssured.baseURI = "http://localhost/";
        RestAssured.port = 8080;
    }

    public static Response getAllUsers() {
        return given()
                .log()
                .all()
                .get("/v1/users")
                .then()
                .log()
                .body()
                .extract().response();
    }

    public static Response getUserById(String id) {
        return given()
                .log()
                .all()
                .get(String.format("/v1/users/%s", id))
                .then()
                .log()
                .body()
                .extract().response();
    }

    public static Response saveUser(String body) {
        return given()
                .header("Content-Type", "application/json")
                .body(body)
                .log()
                .all()
                .post("/v1/users")
                .then()
                .log()
                .body()
                .extract().response();
    }

    public static Response updateUser(String body) {
        return given()
                .header("Content-Type", "application/json")
                .body(body)
                .log()
                .all()
                .put("/v1/users/")
                .then()
                .log()
                .body()
                .extract().response();
    }

    public static String objectToJSON(User user) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(user);
    }
}
