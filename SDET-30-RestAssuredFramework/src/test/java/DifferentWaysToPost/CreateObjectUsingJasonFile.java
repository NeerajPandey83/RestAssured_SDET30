package DifferentWaysToPost;

import static io.restassured.RestAssured.*;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateObjectUsingJasonFile {
	
	@Test
	public void createObjJsonFile()
	{
		File fLib = new File(".\\Data.json");
		
		basePath="http://localhost";
		port=8084;
		
		given()
		.body(fLib)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/addProject")
		
		.then()
		.assertThat().statusCode(201)
		.log().all();
	}

}
