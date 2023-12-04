package Day8;

import org.json.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import com.github.javafaker.Faker;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class CreateUser {
int id;
	
	@Test(priority = 1)
	void createUser() {

//	Faker faker=new Faker();

		JSONObject data = new JSONObject();
		data.put("email", "sharadkhairnar15@gmail.com");
		data.put("name", "sharad");
		data.put("gender", "male");
		data.put("status", "active");

		String Bearer = "7e15c6be7e653d6bf2abcc31bb66b95e85d814d021e4fd43b86f97b1264037ee";

		id=given().header("Authorization", "Bearer" + Bearer).contentType("application/json").body(data.toString())

				.when().post("https://gorest.co.in/public/v2/users").jsonPath().getInt("id");
		// System.out.println("Generated Id is:"+id);
	}

}
