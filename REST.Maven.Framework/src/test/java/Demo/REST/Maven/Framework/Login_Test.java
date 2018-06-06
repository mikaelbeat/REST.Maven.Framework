package Demo.REST.Maven.Framework;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;



import Demo.REST.Maven.Utils.Payload_Converter;
import Demo.REST.Maven.Utils.Test_Utils;
import Demo.REST.Maven.Utils.URL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Login_Test {
	
	Response response;
	
	private static Logger log = LogManager.getLogger(Login_Test.class.getName());
	
	@Test
	public void Login() throws IOException {
		
		log.info("*** STARTING LOGIN TEST ***");
		String loginPayload = Payload_Converter.Convert_Payload("Jira_Login.json");
		String endpointURI = URL.getURI("/rest/auth/1/session");
		response = REST_Calls.POST_Request(endpointURI, loginPayload);
		log.info("*** RESPONSE *** " + response.getBody().asString());
		
		String strResponse = Test_Utils.Get_Response_String(response);

		
		JsonPath jsonRes = new JsonPath(strResponse);
		String sessionID = jsonRes.getString("session.value");
		log.info("*** JIRA SESSION ID *** " + sessionID);
		Base_Assertions.Verify_Status_Code(response, 200);
	}

}
