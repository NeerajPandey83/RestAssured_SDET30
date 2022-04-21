package requestChainning;

import static  io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import ProjectLibrary.ProjectLibrary;
import commonLibrary.JavaLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateAndDelete {
	
	@Test
	public void createAndDelet()
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
				
				//create delet
				given()
				.pathParam("pid", proId)
				
				.when()
				.delete("/projects/{pid}")
				
				.then()
				.assertThat().statusCode(204).log().all();
	}

}
