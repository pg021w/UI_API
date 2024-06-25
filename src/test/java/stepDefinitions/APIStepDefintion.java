package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import utils.APIResources;
import utils.GenericUtils;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class APIStepDefintion {

    RequestSpecification req;
    ResponseSpecification resspec;
    Response response;
    public static String id;

    @Given("When user hits Reqres API with payload {string} and {string}")
    public void whenUserHitsReqresAPIWithPayload(String name, String job) throws IOException {
        RestAssured.baseURI = GenericUtils.getbaseURL();
        req = given().body(GenericUtils.createPayload(name, job));

    }

    @When("user hits {string} for {string}")
    public void userHitsFor(String HTTPMethod, String api) throws IOException {
        APIResources resource = APIResources.valueOf(api);
        if (HTTPMethod.equalsIgnoreCase("POST")) {
            response = req.log().all().when().post(resource.getResource());
        } else if (HTTPMethod.equalsIgnoreCase("GET") && (api.equalsIgnoreCase("GetorPutorDeleteResource"))) {
            response = given().pathParam("path", 2).log().all().when().get(resource.getResource());
        } else if (HTTPMethod.equalsIgnoreCase("PUT")) {

            response = req.pathParam("path", id).when().log().all().put(resource.getResource());
        } else if (HTTPMethod.equalsIgnoreCase("DELETE")) {
            response = given().pathParam("path", id).log().all().when().delete(resource.getResource());
        }else if (HTTPMethod.equalsIgnoreCase("GET") && (api.equalsIgnoreCase("GetList"))) {
            RestAssured.baseURI = GenericUtils.getbaseURL();
            response = given().queryParam("page",2).log().all().when().get(resource.getResource());
        }
    }

    @Then("Validate user is getting status code as {int}")
    public void validateUserIsGettingStatusCodeAs(int status) {
        response.then().log().all().assertThat().statusCode(status);
    }

    @And("Validate values in response")
    public void validateValuesInResponse() {
        String response1 = response.then().extract().asString();
        id = GenericUtils.getJson(response1, "id").toString();
        System.out.println(id);
    }

    @And("Store first id to delete")
    public void storeFirstIdToDelete() {
        String response1 = response.then().extract().asString();
        id = GenericUtils.getJson(response1, "data[0].id").toString();
        System.out.println(id);
    }
}
