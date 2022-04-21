package CrudOpretionwithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Cookies;
import io.restassured.response.Response;

public class getAllProjectWithoutBDD {
	
	@Test
	public void getAllProject()
	{
		Response rsp = RestAssured.get("http://localhost:8084/projects");
		String body = rsp.prettyPrint();
		System.out.println(body);
		
		
		int stc = rsp.getStatusCode();
		System.out.println(stc);
		
		
		String ct = rsp.getContentType();
		System.out.println(ct);
		
		
		Cookies dct = rsp.getDetailedCookies();
		System.out.println(dct);
		
	}

}
