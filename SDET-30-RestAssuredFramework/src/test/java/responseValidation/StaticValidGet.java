package responseValidation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.testng.Assert;
import org.testng.annotations.Test;

import ProjectLibrary.ProjectLibrary;
import commonLibrary.JavaLibrary;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class StaticValidGet {

	@Test
	public void staticResValid()
	{
		baseURI ="http://localhost";
		port=8084;
		String ecpData = "TY_PROJ_1002";
		
		
		 Response resp = when().post("/projects");
		
		String act = resp.jsonPath().get("[2].projectId");
		Assert.assertEquals(act,ecpData);
		
		resp.then().log().all();
		
	
		
	}

	private RestAssured when() {
		// TODO Auto-generated method stub
		return null;
	}

}


