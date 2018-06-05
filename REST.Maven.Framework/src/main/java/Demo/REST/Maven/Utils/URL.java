package Demo.REST.Maven.Utils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import Demo.REST.Maven.Framework.REST_Calls;

public class URL {
	
	private static Logger log = LogManager.getLogger(URL.class.getName());
	
	public static final String URI = "http://localhost:9090";
	
	public static String getURI() {
		log.info("Base URI: " + URI);
		return URI;
	}
	
	public static String getURI(String resource) {
		log.info("URI endpoint: " + URI + resource);
		return URI + resource;
	}
}
