package Parameter;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class FormParameter {

	@Test
	public void formParameter()
	{
		baseURI="http://localhost";
		port=8084;
		
		given()
		.formParam("createdBy", "Shreyas")
		.formParam("projectName","JayjatJaykara")
		.formParam("status","on_going")
		.formParam("teamSize",10)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/addProject")
		
		.then()
		.log().all();
	}
}
