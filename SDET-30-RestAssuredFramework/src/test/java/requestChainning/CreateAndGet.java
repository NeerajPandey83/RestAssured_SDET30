package requestChainning;

import static  io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import ProjectLibrary.ProjectLibrary;
import commonLibrary.JavaLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateAndGet {

	@Test
	public void createAndGet()
	{
		// create a project using pojo
		JavaLibrary jLib= new JavaLibrary();
		ProjectLibrary pLib = new ProjectLibrary("Ramesh","SVCE"+jLib.getRandomNumber(),"completed",26);
		
		baseURI="http://localhost";
		port=8084;
		
		Response resp = given()
		.body(pLib)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/addProject");
		
		//capture the project id
		
		String proId = resp.jsonPath().get("projectId");
		System.out.println(proId);
		
		resp.then().log().all();
		
		// creat get request and pass proId as path parameter
		given()
		.pathParam("pid", proId)
		
		.when()
		.get("/projects/{pid}")
		
		.then()
		.assertThat().statusCode(200).log().all();
		
		
	}
}
