package DataDrivenTesting;

import static io.restassured.RestAssured.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ProjectLibrary.ProjectLibrary;
import commonLibrary.JavaLibrary;
import io.restassured.http.ContentType;

public class CreateProjectWithMultipleData {

	@Test(dataProvider = "getData")
	
		public void createProjectWithMultipleData(String createdBy,String projectName,String status,int teamSize)
		{
			//pre-requisite
		baseURI="http://localhost";
		port=8084;
		JavaLibrary jLib= new JavaLibrary();
		ProjectLibrary pLib = new ProjectLibrary(createdBy, projectName+jLib.getRandomNumber(), status, teamSize);
		
		given()
		.body(pLib)
		.contentType(ContentType.JSON)
		
		//action
		.when()
		.post("/addProject")
		
		//validation
		.then()
		.log().all();
		
		
		
		
		}


	@DataProvider(name="getData")
	public Object[][] data()
	{
		Object[][] data = new Object[3][4];
		data[0][0]="Pandey";
		data[0][1]="HP";
		data[0][2]="completed";
		data[0][3]=10;
		
		data[1][0]="Nrj";
		data[1][1]="Dell";
		data[1][2]="con-going";
		data[1][3]=12;
		
		data[2][0]="Ali";
		data[2][1]="TCS";
		data[2][2]="completed";
		data[2][3]=17;
		return data;
		
		
	}
		
	
	
	
}

