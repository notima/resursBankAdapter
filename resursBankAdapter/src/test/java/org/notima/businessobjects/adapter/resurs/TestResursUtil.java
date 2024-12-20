package org.notima.businessobjects.adapter.resurs;

import org.notima.resurs.ResursReport;
import org.notima.resurs.ResursReportParser;

public class TestResursUtil {

	public static ResursReport getTestReport() throws Exception {
		
		String filename = "src/test/resources/SI_1234_SE_ExampleChain_T10_20241219_00000.csv";
		ResursReport report = ResursReportParser.createFromFile(filename);
		return report;
		
	}
	
}
