package definitions;

import com.example.fragrance_customizer_api.FragranceCustomizerApiApplication;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = FragranceCustomizerApiApplication.class)
public class UserCartItemTestDefs {
    private static final String BASE_URL = "http://localhost:";
    private final Logger logger = LoggerFactory.getLogger(UserCartItemTestDefs.class);
    private static final String Base_URL = "http://localhost:";
    private static Response response;
    private String token;
    private static RequestSpecification request;
    private String message;


    @LocalServerPort
    String port;

    /**
     * Retrieves a JWT (JSON Web Token) key by sending a POST request to the authentication endpoint.
     * This method sets up the necessary HTTP request with user credentials and sends it to the
     * authentication endpoint to obtain a JWT key for user authentication.
     *
     * @return The JWT key (token) received from the authentication response.
     * @throws JSONException If there is an issue with JSON processing.
     */

    public static String getJWTKey(String port) throws JSONException {
        // Set the base URI and create a request
        try {

            RestAssured.baseURI = BASE_URL;
            RequestSpecification request = RestAssured.given();

            // Set the content-type header to indicate JSON data
            request.header("Content-Type", "application/json");

            // Create a JSON request body with user email and password
            JSONObject requestBody = new JSONObject();
            requestBody.put("emailAddress", "bethel@ga.com");
            requestBody.put("password", "bethel123");

            // Send a POST request to the authentication endpoint
            response = request.body(requestBody.toString()).post(BASE_URL + port + "/auth/users/login/");

            // Extract and return the JWT key from the authentication response
            return response.jsonPath().getString("jwt");
        } catch (Exception e) {
            // Log the exception
            e.printStackTrace();
            return null; // Return null to indicate failure
        }
    }

    public void createRequest() {
        try {
            System.out.println("Before getting token: " + token);
            if (token == null) {

                token = getJWTKey(port);
            }
            System.out.println("After getting token: " + token);
            RestAssured.baseURI = BASE_URL;
            request = RestAssured.given();
            request.header("Content-Type", "application/json");
            request.header("Authorization", "Bearer " + token);
        } catch (JSONException e) {
            logger.info("Json issue " + e.getMessage());
        }
    }
}
