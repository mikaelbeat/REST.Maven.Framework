package Demo.REST.Maven.Utils;

import com.relevantcodes.extentreports.ExtentReports;

public class Extentreporter {
	
	public static ExtentReports reportResult() {
		ExtentReports extent;
		String Path = "C:\\Users\\petri.ryynanen\\git\\REST.Maven.Framework\\REST.Maven.Framework\\reports\\Report.html";
		extent = new ExtentReports(Path, false);
		return extent;

	}

}