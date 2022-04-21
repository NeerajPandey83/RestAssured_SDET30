package CrudOpretionwithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import commonLibrary.JavaLibrary;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreatProjectTest {

	@Test
	public void createProjectTest()
	{
		JavaLibrary jLib = new JavaLibrary();
		//step 1-create pre-requisite -response body
		JSONObject job = new JSONObject();
		job.put("createdBy", "Neeraj Pandey");
		job.put("projectName", "Xylem"+jLib.getRandomNumber());
		job.put("status", "completed");
		job.put("teamSize", 7);
		
		RequestSpecification req= RestAssured.given();
		req.body(job);
		req.contentType(ContentType.JSON);
		
		//step 2-perform the action
		Response response = req.post("http://localhost:8084/addProject");
		
		//step 3- validate the response
		
		System.out.println(response.getContentType());
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody());
		System.out.println(response.prettyPrint());
		System.out.println(response.prettyPeek());
	}
}
