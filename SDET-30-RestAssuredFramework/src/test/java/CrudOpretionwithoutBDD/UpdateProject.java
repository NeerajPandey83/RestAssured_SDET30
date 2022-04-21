package CrudOpretionwithoutBDD;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateProject {

	@Test
	public void updatrProject()
	{
		//step 1- create pre-requisite
		
		JSONObject job = new JSONObject();
		job.put("createdBy", "Neeraj Pandey");
		job.put("projectName", "Xylem_22");
		job.put("status", "completed");
		job.put("teamSize", 23);
		
		RequestSpecification req =RestAssured.given();
		req.body(job);
		req.contentType(ContentType.JSON);
		
		//step 2- perform actions
		Response response = req.put("http://localhost:8084/projects/TY_PROJ_810");
		
		//step 3- validations
		int sc = response.getStatusCode();
		Assert.assertEquals(sc, 200);
		System.out.println(response.getContentType());
		System.out.println(response.getStatusCode());
		
		
		
		
		
	}
}
