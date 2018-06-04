package Demo.REST.Maven.Framework;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class Sample_1_Test {
	
	private static Logger log = LogManager.getLogger(Sample_1_Test.class.getName());
	
	@Test
	public void First_Test() {
		log.debug("My first test.");
	}
	
	@Test
	public void Second_Test() {
		log.info("My second test.");
		log.fatal("Fataali errori");
	}
	
	@Test
	public  void Third_Test() {
		int i = 10;
		try {
			int j = i / 0;;
		} catch (Exception e) {
			log.error(e);
		}
	}
	
	

}
