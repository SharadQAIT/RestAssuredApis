package Day3;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class PathAndQueryParameter {
	
	
	//https://reqres.in/api/users?page=2
	
	@Test
	 void testQueryPathParameters()
	 {
		 given()
		 
		 .pathParam("mypath","users")
		 .queryParam("page", "2")
		 
		 .when()
		 	.get("https://reqres.in/api/{mypath}")
		 
		 .then()
		 
		 .statusCode(200)
		 .log().all();
	 }

}
