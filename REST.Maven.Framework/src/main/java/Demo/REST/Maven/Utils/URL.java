package Demo.REST.Maven.Utils;

public class URL {
	
	public static final String URI = "http://localhost:8080";
	
	public static String getURI() {
		return URI;
	}
	
	public static String getURI(String resource) {
		return URI + resource;
	}
}
