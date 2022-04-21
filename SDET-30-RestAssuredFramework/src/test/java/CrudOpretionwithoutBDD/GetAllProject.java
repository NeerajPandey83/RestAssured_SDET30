package CrudOpretionwithoutBDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class GetAllProject {

	@Test
	public void getAllProject()
	{
		//step 1- create prerequisite
		
		//step 2- perform action
		Response req = RestAssured.get("http://localhost:8084/projects");
		
		
		
		//step 3- validate the response
		
		ValidatableResponse act = req.then().log().all();
		int actl = req.getStatusCode();
		Assert.assertEquals(200, actl);
	}
}
