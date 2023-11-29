package Day4;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class LoggingDemo {

	@Test
	void loggingdemo() {

		given()

				.when()
				
				.get("https://reqres.in/api/users?page=2")
				
				.then()
				// .log().headers();
				// .log().cookies();
				// .log().body();
				.log().all();
		
			/*
			 * Fetch different kind of individual info like headers,cookies, body by using .log() method
			 */
	}

}
