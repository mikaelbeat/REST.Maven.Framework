package Demo.REST.Maven.Utils;

import com.relevantcodes.extentreports.ExtentReports;

public class Extentreporter {
	
	public static ExtentReports reportResult() {
		ExtentReports extent;
		String Path = System.getProperty("user.dir")+"\\reports\\Report.html";
		extent = new ExtentReports(Path, false);
		return extent;

	}

}