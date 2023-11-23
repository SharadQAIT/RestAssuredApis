package OmniAPIs;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class OmniAPIs 

{
	    @Test
		public void login()
		{
			given()

			.when()
				.get("https://reqres.in/api/users?page=2")
			.then()
				.statusCode(200)
				.body("page",equalTo(2))
				.log().all();
			
			
		}
}
