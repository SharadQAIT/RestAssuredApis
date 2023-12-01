package Day7;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.hamcrest.core.IsEqual;
import org.testng.annotations.Test;

import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.equalTo;


public class Authentications {

	@Test
	void testBasicAuthentication() {
		
		given()

		.auth().basic("postman", "password")
		
		.when()
		.get("https://postman-echo.com/basic-auth")

		.then()
		.statusCode(200)
		.body("authenticated",equalTo(true))
		.log().all();
	}
}
