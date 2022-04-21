package CrudOpretionWithBDD;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class GetSingleProject {

	@Test
	public void getSingleProjects()
	{
		baseURI ="http://localhost";
		port=8084;
		
		when()
		.get("/rojects/TY_PROJ_1205")
		
		.then()
		.statusCode(200)
		.log().all();
	}
}
