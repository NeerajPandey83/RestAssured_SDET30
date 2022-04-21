package DifferentWaysToPost;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

import org.testng.annotations.Test;

import commonLibrary.JavaLibrary;
import io.restassured.http.ContentType;

public class CreateObjectUsingHashMap {
	
	@Test
	public void createObjHashMap()
	{
		JavaLibrary jLib = new JavaLibrary();
		HashMap map = new HashMap();
		map.put("createdBy","Narayana");
		map.put("projectName", "Jacxson " + jLib.getRandomNumber());
		map.put("status", "Completed");
		map.put("teamSize", 10);
		
		baseURI="http://localhost";
		port=8084;
		
		given()
		.body(map)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/addProject")
		
		.then()
		.assertThat().statusCode(201)
		.log().all();
		
	}

}
