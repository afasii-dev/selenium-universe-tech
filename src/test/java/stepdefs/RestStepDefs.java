package stepdefs;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import cucumber.ScenarioContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import rest.User;

import static enums.Data.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static util.RestUtil.*;

public class RestStepDefs {

    private static final Logger logger = Logger.getLogger(RestStepDefs.class);
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
        Response response = getUserById(id);
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
    public void saveNewUserEndpointIsCalled(User user) throws JsonProcessingException {
        String jsonBody = objectToJSON(user);
        logger.warn("JSON Body generated: " + jsonBody);

        Response response = saveUser(jsonBody);
        scenarioContext.saveData(STATUS_CODE, response.getStatusCode());
        scenarioContext.saveData(RESPONSE_BODY_AS_STRING, response.getBody().asPrettyString());
        scenarioContext.saveData(JSON_BODY_SENT, jsonBody);
    }

    @Then("new user successfully added and saved")
    public void newUserSuccessfullyAddedAndSaved() throws JsonProcessingException {
        int statusCode = (int) scenarioContext.getData(STATUS_CODE);
        assertThat(statusCode, is(200));

        String expectedUser = (String) scenarioContext.getData(JSON_BODY_SENT);
        String registeredUser = (String) scenarioContext.getData(RESPONSE_BODY_AS_STRING);

        User expected = new ObjectMapper().readValue(expectedUser, User.class);
        User actual = new ObjectMapper().readValue(registeredUser, User.class);
        assertThat(expected.getUsername(), is(actual.getUsername()));
        assertThat(expected.getPassword(), is(actual.getPassword()));
    }

    @When("Updating user")
    public void updatingUser(User user) throws com.fasterxml.jackson.core.JsonProcessingException {
        String jsonBody = objectToJSON(user);
        logger.warn("JSON Body generated: " + jsonBody);

        Response response = updateUser(jsonBody);
        scenarioContext.updateData(STATUS_CODE, response.getStatusCode());
        scenarioContext.updateData(RESPONSE_BODY_AS_STRING, response.getBody().asPrettyString());
        @Then("new user successfully updated and saved")
                scenarioContext.updateData(JSON_BODY_SENT, jsonBody);
    }

//    public void newUserSuccessfullyUpdatedAndSaved() throws JsonProcessingException {
//        int statusCode = (int) scenarioContext.updateData(STATUS_CODE);
//        assertThat(statusCode, is(200));
//
//        String expectedUser1 = (String) scenarioContext.updateData(JSON_BODY_SENT);
//        String registeredUser1 = (String) scenarioContext.updateData(RESPONSE_BODY_AS_STRING);
//
//        User expected1 = new ObjectMapper().readValue(expectedUser1, User.class);
//        User actual1 = new ObjectMapper().readValue(registeredUser1, User.class);
//        assertThat(expected1.getUsername(), is(actual1.getUsername()));
//        assertThat(expected1.getPassword(), is(actual1.getPassword()));
//    }
}