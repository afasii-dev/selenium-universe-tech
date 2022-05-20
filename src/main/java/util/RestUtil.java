package util;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Map;

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

    public static Response getUser(String id) {
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

    public static String generateBody(Map<String, String> dataTable) {
        String username = dataTable.get("username");
        String password = dataTable.get("password");

        String bodyTemplate = """
                {
                     "username": "%s",
                     "password": "%s"
                }
                """;

        return String.format(bodyTemplate, username, password);
    }
}
