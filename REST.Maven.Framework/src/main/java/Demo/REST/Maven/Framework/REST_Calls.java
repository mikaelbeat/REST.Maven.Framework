package Demo.REST.Maven.Framework;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class REST_Calls {
	
	public static Response GET_Request(String URI) {
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.get(URI);
		return response;
	}
	
	public static Response POST_Request(String URI, String payload) {
		RequestSpecification requestSpecification = RestAssured.given().body(payload);
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.post(URI);
		return response;
	}
	
	public static Response PUT_Request(String URI, String payload) {
		RequestSpecification requestSpecification = RestAssured.given().body(payload);
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.put(URI);
		return response;
	}
	
	public static Response DELETE_Request(String URI, String payload) {
		RequestSpecification requestSpecification = RestAssured.given().body(payload);
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.delete(URI);
		return response;
	}

}
