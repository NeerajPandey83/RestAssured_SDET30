package CrudOpretionwithoutBDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetSingleProject {
	@Test
	public void getSingleProject()
	{
		//step 1- create pre-requisite
		
		//step 2- perform action
		Response rsg = RestAssured.get("http://localhost:8084/projects/TY_PROJ_810");
		
		//step 3- validations
		rsg.then().log().all();
		int stc = rsg.getStatusCode();
		String ct = rsg.getContentType();
		Assert.assertEquals(stc, 200);
		Assert.assertEquals(ct, "application/json");
	}

}
