package Demo.REST.Maven.Framework;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Demo.REST.Maven.Utils.Payload_Converter;
import Demo.REST.Maven.Utils.URL;
import io.restassured.response.Response;

public class Create_Issue_Test {
	
	private String sessionID;
	
	Response response;
	
	private static Logger log = LogManager.getLogger(Create_Issue_Test.class.getName());
	
	@BeforeMethod
	public void Set_Up() {
		sessionID = Base_Test.Do_Login();
	}
	
	
	@Test
	public void Create_Issue() {
		log.info("*** STARTING CREATE ISSUE TEST ***");
		String URI = URL.getURI("/rest/api/2/issue");
		String createIssuePayload = Payload_Converter.Convert_Payload("Create_Issue.json");
		response = REST_Calls.POST_Request(URI, createIssuePayload, sessionID);
		log.info("*** RESPONSE *** " + response.getBody().asString());
		Base_Assertions.Verify_Status_Code(response, 201);
	}
	
}
