package rmgyantraFramework;

import org.testng.annotations.Test;

import ProjectLibrary.ProjectLibrary;
import commonLibrary.BaseAPIcLASS;
import commonLibrary.EndPointsLibrary;
import commonLibrary.JavaLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static  io.restassured.RestAssured.*;

public class CreateProjectAndVarifyDataBase extends BaseAPIcLASS {

	@Test
	public void createProjectAndVarifyDataBase() throws Throwable
	{
		
		ProjectLibrary pLib = new ProjectLibrary("Jay", "PowerPlant "+jLib.getRandomNumber(), "completed", 15);
		
		Response resp = given()
		                       .body(pLib)
		                       .contentType(ContentType.JSON)
		
		                .when().post(EndPointsLibrary.CreateProject);
		  
		String expData = rLib.getJsonPath(resp, "projectId");
		System.out.println(expData);
		
		
		
		given()
		.pathParam("pid", expData)
		.when()
		.get(EndPointsLibrary.GetAllprojects+"/{pid}")
		
		.then().log().all();
		System.out.println("data is varified in response");
		
		
		String query = "select* from project";
		String value = dLib.executeQueryAndGetData(query, expData, 1);
		System.out.println(value);
		System.out.println("data succesfull varify in database");
		      
		
		
		
	}
}
