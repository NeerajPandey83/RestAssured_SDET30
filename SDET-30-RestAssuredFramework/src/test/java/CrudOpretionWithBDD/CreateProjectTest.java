package CrudOpretionWithBDD;



import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import commonLibrary.JavaLibrary;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectTest {
	@Test
	public void createProject()
	{
		baseURI ="http://localhost";
		port =8084;
		JavaLibrary jLib = new JavaLibrary();
		
		//step 1: create pre-requisite
		JSONObject job = new JSONObject();
		job.put("createdBy", "Neeraj Pandey"+jLib.getRandomNumber());
		job.put("projectName", "Xylem_214");
		job.put("status", "completed");
		job.put("teamSize", 12);
		
		given()
		.body(job)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/addProject")
		
		.then()
		.assertThat()
		
		.log().all();
		
		
		
		
		
	}

}
