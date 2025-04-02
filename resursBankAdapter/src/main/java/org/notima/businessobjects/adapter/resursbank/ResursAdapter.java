package org.notima.businessobjects.adapter.resursbank;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.notima.generic.businessobjects.PaymentBatch;
import org.notima.generic.ifacebusinessobjects.PaymentFactory;
import org.notima.resurs.ResursReport;
import org.notima.resurs.ResursReportParser;

public class ResursAdapter implements PaymentFactory {

	public static final String SYSTEMNAME="Resurs";
	
	@Override
	public List<PaymentBatch> readPaymentBatchesFromSource(String source) throws Exception {
		
		List<PaymentBatch> batchList = new ArrayList<PaymentBatch>();
		
		// Check to see if source is a file
		File sourceFile = new File(source);
		File sourceDir = null;
		if (sourceFile.exists() && sourceFile.getParentFile().isDirectory()) {
			sourceDir = sourceFile.getParentFile();
			String filenameonly = sourceFile.getName();
			ResursDirectoryToPaymentBatch directoryReader = new ResursDirectoryToPaymentBatch(sourceDir.getCanonicalPath());
			if (!sourceFile.isDirectory()) {
				PaymentBatch result = directoryReader.createPaymentBatchFromFile(filenameonly);
				batchList.add(result);
			} else {
				batchList = directoryReader.readFilesInDirectory();
			}
			return batchList;
		} else {
			// TODO: Probably obsolete code
	        ResursReport report = ResursReportParser.createFromFile(source);
	        ResursToPaymentBatch converter = ResursToPaymentBatch.buildFromReport(report);
	        PaymentBatch pb = converter.getPaymentBatch(); 
	        batchList.add(pb);
			return batchList;
		}
		
		
	}

	@Override
	public String getSystemName() {
		return SYSTEMNAME;
	}

}
