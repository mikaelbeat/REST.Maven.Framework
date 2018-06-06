package Demo.REST.Maven.Framework;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import Demo.REST.Maven.Utils.Payload_Converter;
import Demo.REST.Maven.Utils.Test_Utils;
import Demo.REST.Maven.Utils.URL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Base_Test {
	
	private static Logger log = LogManager.getLogger(Base_Test.class.getName());
	
	public static String Do_Login() {
		
		Response response;
		log.info("Starting test case: Do_Login");
		String loginPayload = Payload_Converter.Convert_Payload("Jira_Login.json");
		
		String endpointURI = URL.getURI("/rest/auth/1/session");
		response = REST_Calls.POST_Request(endpointURI, loginPayload);
		log.info("Response -> " + response.getBody().asString());
		String strResponse = Test_Utils.Get_Response_String(response);
		
		JsonPath jsonRes = Test_Utils.Json_Parser(strResponse);
		String sessionID = jsonRes.getString("session.value");
		log.info("Jira session ID -> " + sessionID);
		return sessionID;
	}
}
