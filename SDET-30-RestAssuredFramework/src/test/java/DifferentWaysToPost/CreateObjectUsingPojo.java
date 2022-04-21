package DifferentWaysToPost;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import ProjectLibrary.ProjectLibrary;
import commonLibrary.JavaLibrary;
import io.restassured.http.ContentType;

public class CreateObjectUsingPojo {
	
	@Test
	public void createObjPojo()
	{
		JavaLibrary jLib = new JavaLibrary();
		ProjectLibrary pLib = new ProjectLibrary("Ram", "RAXSON"+jLib.getRandomNumber(), "Continue", 21);
		
		baseURI="http://localhost";
		port=8084;
		given()
		.body(pLib)
		.contentType(ContentType.JSON)
		
		
		.when()
		.post("/addProject")
		
		.then()
		.assertThat().statusCode(201)
		.log().all();
	}

}
