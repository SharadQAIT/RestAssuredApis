package Day4;

import static io.restassured.RestAssured.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;



public class CokiesDemo {

	@Test
	void getCoockies()
	{
		
	Response res=given()
		
		.when()
			
		.get("https://www.google.com/");
	
		//.getCoockie - It is fetch single cookie
		String Cookice_value=res.getCookie("AEC");	;
		//Get Single Cookie info
		System.out.println("Value of cookie"+Cookice_value);
		
		//get all cookies info
		//.getCookies - It is fetch all the records
		Map<String,String> all_coockies=res.getCookies(); 
		System.out.println("Geting all the cockies"+ all_coockies);
		
		for(String k:all_coockies.keySet())
			{
				String cookie_value=res.getCookie(k);
				System.out.println(k+"   "+cookie_value);
			}
			
		
	}
}
