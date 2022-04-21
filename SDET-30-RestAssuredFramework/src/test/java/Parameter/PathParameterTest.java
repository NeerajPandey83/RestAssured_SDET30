package Parameter;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class PathParameterTest {

	@Test
	public void parhParameter()
	{
		baseURI="http://localhost";
		port=8084;
		given()
		.pathParam("pId", "TY_PROJ_1410")
		
		.when()
		.get("/projects/{pId}")
		
		.then()
		.log().all();
		
	}
}
