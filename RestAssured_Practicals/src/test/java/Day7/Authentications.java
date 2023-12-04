package Day7;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.hamcrest.core.IsEqual;
import org.testng.annotations.Test;

import groovy.util.logging.Log;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.equalTo;

/*
 * basic 
 * digest
 * preemptive
 * 
 * Above three types of authentication is use for authentication but inside algorithm and motives are different.
 * 
 * Summary:

	Basic Authentication: Simple, credentials in Base64, less secure, often used with HTTPS.
	Digest Authentication: Challenge-response mechanism, more secure than Basic, requires HTTPS.
	Preemptive Authentication: Sending credentials without a server challenge, can reduce latency but may expose credentials,
 	use with caution.
 * 
 * 
 */

public class Authentications {

	@Test(priority=1)
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
	
	@Test(priority=2)
	void testdigestAuthentication()
	{
		given()
		
		.auth().digest("postman", "password")
		
		.when()
		.get("https://postman-echo.com/basic-auth")
		
		.then()
		.statusCode(200)
		.body("authenticated",equalTo(true))
		.log().all();

	}
	
	@Test(priority=3)
	void testpreemptiveAuthentication()
	{
		given()
		
		.auth().preemptive().basic("postman", "password")
		
		.when()
		.get("https://postman-echo.com/basic-auth")
		
		.then()
		.statusCode(200)
		.body("authenticated",equalTo(true))
		.log().all();

	}
	
	@Test(priority=4)
	void testbearertokenauthentication()
	{
		
		String bearer= "A21AAIkg7qpisDuMGeFaSQz6QiLbUnrkUKBEH3OjEjO6tmlksRQtNkTcGC29XdruvPyiFGUjagCxuRSH4DfgZ-OWzNRMjBfXg";
		
		given()
				.headers("Authorization","Bearer"+bearer)
		.when()
				.get("https://api-m.sandbox.paypal.com/v1/oauth2/token")
		.then()
				.statusCode(400)
				.log().all();
	}
	
	@Test(priority=5)
	void testAPIKeyAuthentication()
	
		//Method 1
	{
			
		given()
				.queryParam("APPID", "884e17c4f26e048f77a2275c57fc4a44")
		.when()
				.get("http://api.openweathermap.org/data/2.5/weather?q=Ahmedabad")
		.then()
				.statusCode(200)
				.log().all();
		
	}
	@Test(priority=5)
	void testAPIKeyAuthentication2()
	
		//Method 2
	{
			
		given()
				.queryParam("APPID", "884e17c4f26e048f77a2275c57fc4a44")
				.pathParam("mypath", "data/2.5/weather")
				.queryParam("q", "Ahmedabad")
		.when()
				.get("http://api.openweathermap.org/{mypath}")
		.then()
				.statusCode(200)
				.log().all();
		
	}

	
}
