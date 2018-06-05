package Demo.REST.Maven.Framework;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;



import Demo.REST.Maven.Utils.Payload_Converter;
import Demo.REST.Maven.Utils.URL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Login_Test {
	
	Response response;
	
	private static Logger log = LogManager.getLogger(Login_Test.class.getName());
	
	@Test
	public void Login() throws IOException {
		
		log.info("Starting test case: Login_Test");
		
		String login_Payload = Payload_Converter.Convert_Payload("Jira_Login.json");
		String endpoint_URI = URL.getURI("/rest/auth/1/session");
		response = REST_Calls.POST_Request(endpoint_URI, login_Payload);
		log.info(response.getBody().asString());
		
		String str_Response = response.getBody().asString();
		System.out.println("********** RESPONSE JSON **********");
		System.out.println(str_Response);
		
		JsonPath jsonRes = new JsonPath(str_Response);
		String sessionID = jsonRes.getString("session.value");
		System.out.println("Session ID is: " + sessionID);
		log.info("Jira session ID: " + sessionID);
		
		
	}

}
