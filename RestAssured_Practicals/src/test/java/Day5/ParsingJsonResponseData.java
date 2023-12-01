package Day5;

import static io.restassured.RestAssured.*;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ParsingJsonResponseData {

	@Test (priority=1)
	void testJsonResponse() {
//		
//		//Approach 1
//		given()
//		
//		.contentType(ContentType.JSON)
//		
//		
//		.when()
//		/*.contentType("application.json") */
//		.get("https://dummy.restapiexample.com/api/v1/employees")	
//		
//		.then()
//		.statusCode(200)
//		.header("Content-Type","application.json,charset=utf-8")
//		.body("data[1].employee_name",equals("Garrett Winters")); 
//		
//	}
		//Approach 2
		
		Response res=given()
				.contentType(ContentType.JSON)
			
		.when()
		.get("https://reqres.in/api/users?page=2");
		
		Assert.assertEquals(res.getStatusCode(), 200);
		//Assert.assertEquals(res.header("Content-Type"), "application/json");
		
		String firstname=res.jsonPath().get("data[1].first_name").toString();
		
		Assert.assertEquals(firstname, "Lindsay");
		
		

	}
	@Test (priority=2)
	void testResponseBodyData()
	{
		
		//Approach 3 
		
		Response res=given()
				.contentType(ContentType.JSON)
		
		.when()
   
        .get("https://reqres.in/api/users?page=2");

		//using JSONObject class			
		JSONObject jo=new JSONObject(res.asString()); //converting response to JSON Object'
			
		// print all titles of Employee name
		boolean status=false;	
		
		for(int i=0; i<jo.getJSONArray("data").length();i++)
		{	String firstname=jo.getJSONArray("data").getJSONObject(i).getString("first_name").toString();
		 //	System.out.println("FirstName:"+firstname);
			
			if(firstname.equals("Rachel"))
			{
				status=true;
				break;
			}
		}
		Assert.assertEquals(status, true);
	}

}
