package definitions;

import com.example.fragrance_customizer_api.FragranceCustomizerApiApplication;
import com.example.fragrance_customizer_api.model.UserCartItem;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import java.text.MessageFormat;
import java.util.List;

@CucumberContextConfiguration()
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


    @Given("a shopping cart is empty")
    public void aShoppingCartIsEmpty() {
        createRequest();
        response = request.get(BASE_URL + port + "/api/user-cart-items/");

        List<UserCartItem> userCartItems = response.jsonPath().getList("data", UserCartItem.class);
        message = response.jsonPath().get("message");
        Assert.assertEquals(HttpStatus.OK.value(), response.getStatusCode());
        Assert.assertEquals("Success", message);
        Assert.assertTrue("User's cart is not empty", userCartItems.isEmpty());
    }

    @When("the user adds item to their cart")
    public void theUserAddsItemToTheirCart() {
        try {
            createRequest();
            JSONObject requestBody = new JSONObject();
            requestBody.put("perfume", "Chanel");

            response = request.body(requestBody.toString())
                    .post(BASE_URL + port + "/api/user-cart-items/");
        } catch (JSONException e) {
            logger.error("Error while creating JSON request: {}", e.getMessage());
        }
    }
//    @Then("the item is created to the user's cart")
//    public void theItemIsCreatedToTheUserSCart() {
//
//        System.out.println("Response Body: " + response.getBody().asString());
//        message = response.jsonPath().get("message");
//        Assert.assertEquals(HttpStatus.CREATED.value(), response.getStatusCode());
//        Assert.assertEquals("Successfully added Chanel Perfume", message);
//    }

//    @When("the user removes item from their cart")
//    public void theUserRemovesItemFromTheirCart() {
//       UserCartItem deleteUserCart = response.jsonPath().getObject("data", UserCartItem.class);
//
//        createRequest();
//        response = request.delete(BASE_URL + port + MessageFormat.format("/api/user-cart-items/{0}/", deleteUserCart.getId()));
//
//
//    }

//    @Then("the item is removed from the user's cart")
//    public void theItemIsRemovedFromTheUserSCart() {
//        message = response.jsonPath().get("message");
//        Assert.assertEquals(HttpStatus.OK.value(), response.getStatusCode());
//        Assert.assertEquals("Successfully deleted perfume named Chanel", message);
//    }

}

