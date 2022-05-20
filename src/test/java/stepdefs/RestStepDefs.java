package stepdefs;

import cucumber.ScenarioContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.util.Map;

import static enums.Data.RESPONSE_BODY_AS_STRING;
import static enums.Data.STATUS_CODE;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static util.RestUtil.*;

public class RestStepDefs {


//    @Given("user performs get request")
//    public void userPerformsGetRequest() {
//
//        RestAssured.baseURI = "http://localhost/";
//        RestAssured.port = 8080;
//        Response response = given().header("Content-Type", "application/json")
//                .body("test body")
//                .log()
//                .all()
//                .post("/v1/users")
//                .then()
//                .log()
//                .body()
//                .extract().response();
//        assertThat(response.getStatusCode(), is(200));
//    }

    ScenarioContext scenarioContext = new ScenarioContext();

    @When("^get all users endpoint is called$")
    public void endpointIsCalled() {
        Response response = getAllUsers();
        scenarioContext.saveData(STATUS_CODE, response.getStatusCode());
        scenarioContext.saveData(RESPONSE_BODY_AS_STRING, response.getBody().asPrettyString());
    }

    @Then("all users are displayed")
    public void allUsersAreDisplayed() {
        String expectedBody = """
                [
                    {
                        "id": 1,
                        "username": "Alex",
                        "password": "123-"
                    },
                    {
                        "id": 2,
                        "username": "Ivan",
                        "password": "321-"
                    }
                ]""";

        String actualBody = (String) scenarioContext.getData(RESPONSE_BODY_AS_STRING);
        int statusCode = (int) scenarioContext.getData(STATUS_CODE);
        assertThat(statusCode, is(200));
        assertThat(actualBody, equalTo(expectedBody));
    }

    @When("get user by id endpoint is called")
    public void getUserByIdEndpointIsCalled(String id) {
        Response response = getUser(id);
        scenarioContext.saveData(STATUS_CODE, response.getStatusCode());
        scenarioContext.saveData(RESPONSE_BODY_AS_STRING, response.getBody().asPrettyString());
    }

    @Then("validate user is found")
    public void validateUserIsFound() {
        String actualBody = (String) scenarioContext.getData(RESPONSE_BODY_AS_STRING);
        int statusCode = (int) scenarioContext.getData(STATUS_CODE);
        assertThat(statusCode, is(200));
        assertThat(actualBody.contains("Alex"), is(true));
    }

    @Then("validate the following error message is displayed")
    public void validateAnErrorMessageIsDisplayed(String errorMessage) {
        String actualBody = (String) scenarioContext.getData(RESPONSE_BODY_AS_STRING);
        int statusCode = (int) scenarioContext.getData(STATUS_CODE);
        assertThat(statusCode, is(500));
        assertThat(actualBody.contains(errorMessage), is(true));
    }

    @When("save new user endpoint is called")
    public void saveNewUserEndpointIsCalled(Map<String, String> dataTable) {
        String body = generateBody(dataTable);
        Response response = saveUser(body);

        scenarioContext.saveData(STATUS_CODE, response.getStatusCode());
        scenarioContext.saveData(RESPONSE_BODY_AS_STRING, response.getBody().asPrettyString());
    }
}