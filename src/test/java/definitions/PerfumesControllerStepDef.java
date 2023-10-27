package definitions;
import com.example.fragrance_customizer_api.FragranceCustomizerApiApplication;
import com.example.fragrance_customizer_api.controller.PerfumeController;
import com.example.fragrance_customizer_api.model.Perfume;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.logging.Logger;

import static definitions.UserCartItemTestDefs.getJWTKey;
import static java.util.logging.Logger.getLogger;

//@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = FragranceCustomizerApiApplication.class)
public class PerfumesControllerStepDef {
    private static final String BASE_URL = "http://localhost:";

    // Logger initialization
    private static final Logger log = getLogger(PerfumesControllerStepDef.class.getName());

    @LocalServerPort
    String port;

    private static Response response;

    @Given("A list of perfumes are available in the system")
    public void aListOfPerfumesAreAvailableInTheSystem() {
        log.info("Calling aListOfPerfumesAreAvailable");
        try {
            RestAssured.baseURI = BASE_URL;
            RequestSpecification request = RestAssured.given();
            request.header("Authorization", "Bearer " + getJWTKey(port));
            request.header("Content-Type", "application/json");
            // Send a GET request to retrieve the list of perfumes
            response = request.get(BASE_URL + port + "/api/perfumes/");
            log.info(request.toString());
            List<Perfume> perfumes = response.jsonPath().get("data");
            Assert.assertEquals(response.getStatusCode(), HttpStatus.OK.value()); //status is OK (200)
            Assert.assertTrue(perfumes.size() > 0); //list of perfumes is not empty
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

//    @When("The user requests to get a list of perfumes")
//    public void theUserRequestsToGetAListOfPerfumesBy() {
//
//    }

    @When("The user requests to get songs by perfume Family")
    public void theUserRequestsToGetSongsByPerfumeFamily() {
        try {
            RestAssured.baseURI = BASE_URL;
            RequestSpecification request = RestAssured.given();
            request.header("Authorization", "Bearer " + getJWTKey(port));
            request.header("Content-Type", "application/json");

            Long perfumeId = 1L; //testing

            log.info("Requesting Perfume by Family: " + perfumeId);

            response = request.get(BASE_URL + port + "/api/perfumes/Family/" + perfumeId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String getJWTKey(String port) throws JSONException {
        // Set the base URI and create a request

        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();

        // Set the content-type header to indicate JSON data
        request.header("Content-Type", "application/json");

        // Create a JSON request body with user email and password
        JSONObject requestBody = new JSONObject();
        requestBody.put("emailAddress", "suresh@ga.com");
        requestBody.put("password", "suresh123");

        // Send a POST request to the authentication endpoint
        response = request.body(requestBody.toString()).post(BASE_URL + port + "/auth/users/login/");

        // Extract and return the JWT key from the authentication response
        return response.jsonPath().getString("jwt");
    }
}