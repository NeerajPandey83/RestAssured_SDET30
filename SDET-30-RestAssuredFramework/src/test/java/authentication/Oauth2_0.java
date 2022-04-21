package authentication;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class Oauth2_0 {

	@Test
	public void oauth2()
	{
		//create a request and generate access token
		
		 Response resp = given()
		.formParam("client_id", "SDET30aPI123")
		.formParam("client_secret", "e7677de85362a06ed240b0ea02a00801")
		.formParam("grant_type", "client_credentials")
		.formParam("redirect_uri", "http://example.com")
		.formParam("code", "authorization_code")
		
		.when()
		.post("http://coop.apps.symfonycasts.com/token");
		 
		 //capture access token
		 String token = resp.jsonPath().get("access_token");
		 System.out.println(token);
		 
		 //create another request
		 
		 given()
		 .auth().oauth2(token)
		 .pathParam("USER_ID", 3101)
		 
		 .when()
		 .post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-collect")
		 
		 .then().log().all();
		 
		 
	}
}
