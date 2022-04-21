package CrudOpretionwithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SampleProjectTest {
	
	@Test
	public void sampleProjectTest()
	{
		Response resp = RestAssured.get("http://localhost:8084/projects");
//		System.out.println(resp.asString());
//		resp.prettyPrint();
		resp.then().log().all();
	}

}
