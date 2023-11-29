package Day2;

import org.json.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import java.io.File;
import java.util.HashMap;

/* How many ways we can create request body
 using HashMap
 using Org.json
 using POJO (Plain Old Java Object)
 using external json file
*/

public class DiffWaysToCreatePostRequestBody {

	
	//1)  using HashMap post request
	
	@Test(priority = 1)
	void TestRequestBodybyusingHashMap_Login()
	 {
	HashMap<String, String> data=new HashMap<String, String>();
	data.put("email", "sharad.khairnar@solutionanalysts.com");
	data.put("password", "Admin@123");
	
		 
		
		given()
		 	
		 	.contentType("application/json")
		 	.body(data)
		 
		 .when()
		 	.post("https://omnistage-api.solutionanalysts.us/auth/login")
		 
		 .then()
		 	.statusCode(200)
		 	.log().all();
	 }

	@Test(priority = 2)
	void TestRequestBodybyusingHashMap_VerifyEmail_OTP()
	 {
	HashMap<String, String> data=new HashMap<String, String>();
	data.put("email", "sharad.khairnar@solutionanalysts.com");
	data.put("otp", "123456");
	
		 
		
		given()
		 	
		 	.contentType("application/json")
		 	.body(data)
		 
		 .when()
		 	.post("https://omnistage-api.solutionanalysts.us/auth/otpverify")
		 
		 .then()
		 	.statusCode(200)
		 	.log().all();
	 }
	
	//2) Post request by  using Org.json

	@Test (priority=3)
	void orgjson()
	{
		JSONObject data=new JSONObject();
		data.put("email", "sharad.khairnar@solutionanalysts.com");
		data.put("password", "Admin@123");
		
		
		given()
	 	
	 	.contentType("application/json")
	 	.body(data.toString())
	 
	 	.when()
	 	.post("https://omnistage-api.solutionanalysts.us/auth/login")
	 
	 	.then()
	 	.statusCode(200)
	 	.log().all();
	}
	
	//3) Post request by  using Pojo class request

	
	@Test (priority=4)
	void pojoRequest()
	{
		Pojo_PostRequest data=new Pojo_PostRequest();
		data.setEmail("sharad.khairnar@solutionanalysts.com");
		data.setPassword("Admin@123");
		
		
		given()
	 	
	 	.contentType("application/json")
	 	.body(data)
	 
	 	.when()
	 	.post("https://omnistage-api.solutionanalysts.us/auth/login")
	 
	 	.then()
	 	.statusCode(200)
	 	.log().all();
	}
	
	//4) Post request by using external json file


	
	@Test (priority=5)
	void externalJsonFile()
	{
		
		String jsonFilePath= System.getProperty("user.dir"); 
		File f=new File(jsonFilePath+"/src/test/resources/JsonDataFile/body.json");
		
		given()
	 	
	 	.contentType("application/json")
	 	.body(f)
	 	.when()
	 	.post("https://omnistage-api.solutionanalysts.us/auth/login")
	 
	 	.then()
	 	.statusCode(200)
	 	.log().all();
	}

}
