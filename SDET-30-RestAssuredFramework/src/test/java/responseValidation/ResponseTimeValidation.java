package responseValidation;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class ResponseTimeValidation {

	@Test
	public void responseTimeValid()
	{
		baseURI="http://localhost";
		port=8084;
		
		//actions
		Response resp = when()
		.get("/projects");
		
		//validations
		
		resp.then()
		.assertThat().time(Matchers.lessThan(800L),TimeUnit.MILLISECONDS)
		.log().all();
		long tm = resp.time();
		System.out.println(tm);
	}
}
