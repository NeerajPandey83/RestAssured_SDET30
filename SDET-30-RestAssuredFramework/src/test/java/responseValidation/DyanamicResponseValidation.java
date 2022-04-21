package responseValidation;

import static  io.restassured.RestAssured.*;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class DyanamicResponseValidation {
	@Test
	public void dynamicRespValidation()
	{
		//pre requisite
		
		String expData = "TY_PROJ_809";
		baseURI ="http://localhost";
		port=8084;
		
		//action
		Response resp = when()
		.get("/projects");
		
		//validation
		List<String>act =resp.jsonPath().get("projectId");
		
		boolean Flag=false;
		
		for(String projectId:act)
		{
			if(projectId.equalsIgnoreCase(expData))
			{
				Flag=true;
			}
		}
		
		Assert.assertEquals(Flag, true);
		System.out.println("data varified");
		resp.then().log().all();
		
	}

}
