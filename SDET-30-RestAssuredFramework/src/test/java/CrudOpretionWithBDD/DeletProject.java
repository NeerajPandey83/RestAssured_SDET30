package CrudOpretionWithBDD;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class DeletProject {

	@Test
	public void deletProject()
	{
		baseURI="http://localhost";
		port=8084;
		
		when()
		.delete("/projects/TY_PROJ_1205")
		
		.then()
		.statusCode(204)
		.log().all();
	}
}
