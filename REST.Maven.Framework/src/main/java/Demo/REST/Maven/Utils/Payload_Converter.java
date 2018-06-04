package Demo.REST.Maven.Utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Payload_Converter {
	
	public static String Convert_Payload(String filename) throws IOException {
		String filePath = System.getProperty("user.dir")+"\\resources\\payloads\\+filename";
		return new String(Files.readAllBytes(Paths.get(filePath)));
	}

}
