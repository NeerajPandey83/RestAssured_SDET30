package Parameter;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class QueryString {
	
	@Test
	public void queryString()
	{
		baseURI="https://reqres.in";
		
		
		given()
		.queryParam("page", 2)
		
		.when()
		.get("//api/users")
		
		.then()
		.log().all();
	}

}
