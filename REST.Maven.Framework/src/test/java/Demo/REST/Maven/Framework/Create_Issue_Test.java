package Demo.REST.Maven.Framework;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Demo.REST.Maven.Utils.Extentreporter;
import Demo.REST.Maven.Utils.Payload_Converter;
import Demo.REST.Maven.Utils.Test_Utils;
import Demo.REST.Maven.Utils.URL;
import io.restassured.response.Response;

public class Create_Issue_Test {
	
	private String sessionID;
	
	Response response;
	
	private static Logger log = LogManager.getLogger(Create_Issue_Test.class.getName());
	
	ExtentReports report;
	ExtentTest test;
	
	@BeforeMethod
	public void Set_Up() {
		sessionID = Base_Test.Do_Login();
	}
	
	
	@Test
	public void Create_Issue() {
		
		report = Extentreporter.reportResult();
		test = report.startTest("Create issue");
		
		log.info("*** STARTING CREATE ISSUE TEST ***");
		String URI = URL.getURI("/rest/api/2/issue");
		test.log(LogStatus.INFO, "Getting payload");
		String createIssuePayload = Payload_Converter.Convert_Payload("Create_Issue.json");
		test.log(LogStatus.INFO, "Payload: " + createIssuePayload);
		test.log(LogStatus.INFO, "Sending POST request.");
		response = REST_Calls.POST_Request(URI, createIssuePayload, sessionID);
		log.info("*** RESPONSE *** " + response.getBody().asString());
		String strResponse = Test_Utils.Get_Response_String(response);
		test.log(LogStatus.INFO, "Response: " + strResponse);
		test.log(LogStatus.INFO, "Verifying response");
		Base_Assertions.Verify_Status_Code(response, 201);
		
		report.endTest(test);
		report.flush();
	}
	
}
