package Day4;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class HeadersDemo {

	@Test(priority=1)
	void header() {
		given()

				.when().get("https://www.google.com/")

				.then()

				// get single header info
				.header("Content-Type", "text/html; charset=ISO-8859-1").header("Server", "gws")
				.header("Content-Encoding", "gzip");

	}

	@Test(priority=2)
	void getheaders()
	{
		Response res= given()
		
		.when()
		
		.get("https://www.google.com/");

		String HeadersValue=res.getHeader("Content-type");
		System.out.println("The value of content-type"+HeadersValue);
		
		Headers myheaders=res.getHeaders();
		
		for(Header hd:myheaders)
			System.out.println(hd.getName()+"-----------"+hd.getValue());
	}
	}

