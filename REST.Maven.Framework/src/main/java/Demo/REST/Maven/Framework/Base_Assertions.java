package Demo.REST.Maven.Framework;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;

import Demo.REST.Maven.Utils.Test_Utils;
import io.restassured.response.Response;

public class Base_Assertions {
	
	private static Logger log = LogManager.getLogger(Base_Assertions.class.getName());
	
	public static void Verify_True(boolean flag) {
		Assert.assertTrue(flag);
	}
	
	public static void Verify_False(boolean flag) {
		Assert.assertTrue(flag);
	}
	
	public static void Verify_Status_Code(Response response, int statusCode) {
		Assert.assertEquals(Test_Utils.Get_Status_Code(response), statusCode);
	}
	
	public static void Verify_Status_Code(Response response, String statusMessage) {
		Assert.assertEquals(Test_Utils.Get_Status_Code(response), statusMessage);
	}
	
	

}
