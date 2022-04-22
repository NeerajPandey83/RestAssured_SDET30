package commonLibrary;

import io.restassured.response.Response;

public class RestAssuredLibrary {

	public String getJsonPath(Response resp, String jsonPath)
	{  
		String value = resp.jsonPath().get(jsonPath);
		return value;
		
      
	}

}
