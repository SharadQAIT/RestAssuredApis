package Day6;


import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;

public class ParsingXMLResponse {
	
	@Test
	void parsingsingleXMLResponse(){
		
		given()
		
		.when()
			.get("http://restapi.adequateshop.com/api/Traveler?page=1")
			
		.then()
			.statusCode(200)
			.header("content-type","application/xml; charset=utf-8")
		//	.body("TravelerinformationResponse.page",equalTo(1))
		//	.body("TravelerinformationResponse.travelers.Travelerinformation[0].name".equals("Developer"))

	// https://youtu.be/IB3G7IbdD1k?si=8WNu_kzePGGJNH9N - Need to implement again		
			.log().all();
	}
}
