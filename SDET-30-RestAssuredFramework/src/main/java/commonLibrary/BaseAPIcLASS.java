package commonLibrary;

import java.sql.SQLException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.*;

public class BaseAPIcLASS {

	public DatabaseLibrary dLib = new DatabaseLibrary();
	public JavaLibrary jLib = new JavaLibrary();
	public RestAssuredLibrary rLib = new RestAssuredLibrary();
	
	@BeforeSuite
	public void bsConfig() throws Throwable
	{
		//Establish database connection
		dLib.connectToDB();
		System.out.println("=====Database Connectin Establish====");
		
		//set base uri and por
		baseURI="http://localhost";
		port=8084;
	}
	
	@AfterSuite
	public void asConfig() throws Throwable
	{
		dLib.closeDB();
	}
	
	
	
	
}
