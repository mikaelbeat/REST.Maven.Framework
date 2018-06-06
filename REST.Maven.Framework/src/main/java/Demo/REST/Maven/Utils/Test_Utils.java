package Demo.REST.Maven.Utils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class Test_Utils {
	
	private static Logger log = LogManager.getLogger(Test_Utils.class.getName());
	
	public static String Get_Response_String(Response response) {
		log.info("Converting response to String.");
		String strResponse = response.getBody().asString();
		log.debug(strResponse);
		return strResponse;
	}
	
	public static JsonPath Json_Parser(String response) {
		log.info("Parsing string response to JSON.");
		JsonPath jsonResponse = new JsonPath(response);
		log.debug("JSON response -> " + jsonResponse);
		return jsonResponse;
	}
	
	public static XmlPath Xml_Parser(String response) {
		log.info("Parsing string response to XML.");
		XmlPath xmlReponse = new XmlPath(response);
		log.debug("XML response -> " + xmlReponse);
		return xmlReponse;
	}
	
	public static int Get_Status_Code(Response response) {
		log.info("Getting  response status code.");
		int statusCode = response.getStatusCode();
		log.info("Response status code -> " + statusCode);
		return statusCode;
	}
	
	public static String Get_Status_Message(Response response) {
		log.info("Getting response status message.");
		String responseMessage = response.getStatusLine();
		log.info("Reponse status message -> " + responseMessage);
		return responseMessage;
	}

}
