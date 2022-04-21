package DifferentWaysToPost;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import commonLibrary.JavaLibrary;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateObjectUsingJasonObject {
	
	@Test
	public void createProjectJsonObj() 
	{
		JavaLibrary jLib = new JavaLibrary();
		
		JSONObject job = new JSONObject();
		job.put("createdBy", "Prateek");
		job.put("projectName", "Rajnikant"+ jLib.getRandomNumber());
		job.put("status", "on_going");
		job.put("teamSize", 8);
		
		baseURI="http://localhost";
		port=8084;
		
		given()
		.body(job)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/addProject")
		
		.then()
		.assertThat().statusCode(201)
		.log().all();
		
	}
	

}
