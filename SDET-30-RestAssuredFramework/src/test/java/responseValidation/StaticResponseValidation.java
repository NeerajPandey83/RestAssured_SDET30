package responseValidation;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import ProjectLibrary.ProjectLibrary;
import commonLibrary.JavaLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class StaticResponseValidation {
	
	@Test
	public void staticResValid()
	{
		baseURI ="http://localhost";
		port=8084;
		String ecpData = "TY_PROJ_1403";
		JavaLibrary jLib = new JavaLibrary();
		ProjectLibrary pLib = new ProjectLibrary("Rajesh", "CRM" +jLib.getRandomNumber(), "COMPLETED", 10);
		
		Response resp = given()
		.body(pLib).contentType(ContentType.JSON)
		
		.when().post("/addProject");
		
		String act = resp.jsonPath().get("projectId");
		Assert.assertEquals(act,ecpData);
		
		resp.then().log().all();
		
	
		
	}

}
