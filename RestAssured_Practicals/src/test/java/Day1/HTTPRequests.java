package Day1;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

/*
 * given()
 *  Content type,set cookies,add auth,add param,set headers info etc....
 * 
 * when()
 * get,post,put,delete
 * 
 * then()
 * validate status code,extract response,extract headers cookies & response body...
 * 
 * 
 * 
 */

public class HTTPRequests {

	int id;

	@Test(priority = 1)
	void getUser() {
		given()

				.when().get("https://reqres.in/api/users?page=2")

				.then()
				// .assertThat()- that assertion, specifying that the expected status code of
				// the HTTP response should be 200.
				.statusCode(200).body("page", equalTo(2)).log().all();

		//
	}

	@Test(priority = 2)
	void createUser() {
		/* This is hard coded value is passed by hashmap */

		HashMap<String, String> data = new HashMap<String, String>();
		data.put("name", "sharad");
		data.put("email", "sharad@gmail.com");
		data.put("age", "30");

		id = given().contentType("application/json").body(data).when().post("https://reqres.in/api/users").jsonPath()
				.getInt("id");

	}

	@Test(priority=3, dependsOnMethods = "createUser") void updateUser() 
	{
			// This is hard coded value is passed by hashmap 	
			// dependsOnMethods = Once "CreateUser" method and code successfully executed then update user code run.
  
	  HashMap<String, String> data= new HashMap<String, String>(); 
	  data.put("name","Sarthak");
	  data.put("email","sarthak@gmail.com");
	  data.put("age", "35");

	 given() 
	  .contentType("application/json") 
	  .body(data)
	  
	  .when() 
	  .put("https://reqres.in/api/users/"+id)
	  
	  .then() 
	  .statusCode(200)
	  .log().all(); 

	}
	@Test(priority=4)
	void deleteUser()
	{
		given()
		
		.when()
			.delete("https://reqres.in/api/users/"+id)
		.then()
			.statusCode(204)
			.log().all();
	}
}

