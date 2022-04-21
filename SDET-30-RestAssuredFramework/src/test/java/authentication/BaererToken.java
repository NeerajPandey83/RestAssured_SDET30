package authentication;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class BaererToken {
	
	@Test
	public void bearerToken()
	{
		baseURI="https://api.github.com";
		JSONObject job = new JSONObject();
		job.put("name","SDET30-RestAssured");
		
		
		given()
		.auth().oauth2("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")
		.body(job)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/user/repos")
		
		.then().log().all();
	}
	

}
