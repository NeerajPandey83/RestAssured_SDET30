package CrudOpretionWithBDD;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class GetAllProject {
	@Test
	public void getAllProject()
	{
		baseURI ="http://localhost";
		port=8084;
		
		//step 1:perform actions
		when()
		.get("/projects")
		
		.then()
		.assertThat()
		.statusCode(201)
		.log().all();
		
	}

}
