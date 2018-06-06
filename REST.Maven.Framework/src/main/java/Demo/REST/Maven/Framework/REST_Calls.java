package Demo.REST.Maven.Framework;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class REST_Calls {
	
	private static Logger log = LogManager.getLogger(REST_Calls.class.getName());
	
	public static Response GET_Request(String URI) {
		log.info("Inside GET request call.");
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.get(URI);
		log.debug(requestSpecification.log().all());
		return response;
	}
	
	public static Response POST_Request(String URI, String payload) {
		log.info("Inside POST request call.");
		RequestSpecification requestSpecification = RestAssured.given().body(payload);
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.post(URI);
		log.debug(requestSpecification.log().all());
		return response;
	}
	
	public static Response POST_Request(String URI, String payload, String sessionID) {
		log.info("Inside POST request call.");
		RequestSpecification requestSpecification = RestAssured.given().body(payload);
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.header("cookie", "JSESSIONID=" + sessionID);
		Response response = requestSpecification.post(URI);
		log.debug(requestSpecification.log().all());
		return response;
	}
	
	public static Response PUT_Request(String URI, String payload) {
		log.info("Inside PUT request class.");
		RequestSpecification requestSpecification = RestAssured.given().body(payload);
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.put(URI);
		log.debug(requestSpecification.log().all());
		return response;
	}
	
	public static Response DELETE_Request(String URI, String payload) {
		log.info("Inside DELETE request class.");
		RequestSpecification requestSpecification = RestAssured.given().body(payload);
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.delete(URI);
		log.debug(requestSpecification.log().all());
		return response;
	}

}
