package org.notima.resurs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.jline.utils.InputStreamReader;

public class ResursReportParser {

	private String			filename;
	private ResursReport	report;
	
	private static final String K_STORE = "Store";
	private static final String K_STORE_NAME = "Store Name";
	private static final String K_STORE_CORPORATE_ID = "Store Corporate Identity Number";
	private static final String K_PURCHASE_AMOUNT = "Purchase Amount";
	private static final String K_DISCOUNT_FEE = "Discount Fee";
	private static final String K_DISCOUNT_FEE_PERCENT = "Discount Fee %";
	private static final String K_NET_AMOUNT = "Net Amount";
	private static final String K_PAYMENT_DATE = "Payment Date";
	private static final String K_POSTING_DATE = "Posting Date Date";
	private static final String K_TRANSACTION_DATE = "Transaction Date Date";
	private static final String K_BATCH_IDENTITY = "Batch Identity";
	private static final String K_ACCOUNT_NUMBER = "Account Number";
	private static final String K_RECEIPT_ID = "Receipt Identity";
	private static final String K_CUSTOMER_NAME = "Customer Name";
	private static final String K_IDENTITY_NUMBER = "Identity Number";
	private static final String K_IDENTITY_NUMBER_ORIGINAL = "Identity Number Original";
	private static final String K_STREET_ADDRESS = "Street Address";
	private static final String K_ZIP_CODE = "ZIP Code";
	private static final String K_CITY = "City";
	private static final String K_SUBTYPE = "Sub Type";
	
	
	DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	private List<ResursReportRow> reportLines;
	
	public static ResursReport createFromFile(String filename) throws Exception {
		ResursReportParser parser = new ResursReportParser(filename);
		return parser.parseResursFile();
	}
	
	private ResursReport parseResursFile() throws Exception {
		InputStream in = new FileInputStream(new File(filename));
		report.setReportRows(parseFile(in));
		return report;
	}
	
	private ResursReportParser(String filename) {
		this.filename = filename;
		report = new ResursReport();
	}
	
	private List<ResursReportRow> parseFile(InputStream inStream) throws Exception {
		
        BufferedReader reader = new BufferedReader(new InputStreamReader(inStream));
        reportLines = new ArrayList<ResursReportRow>();
        Iterable<CSVRecord> records = CSVFormat.DEFAULT
        		.withFirstRecordAsHeader()
        		.parse(reader);
        
        ResursReportRow row = null;
        for (CSVRecord record : records) {
        	row = parseRecord(record);
        	if (row!=null) {
        		reportLines.add(row);
        	}
        }
        
        reader.close();
        inStream.close();
        
        return reportLines;
		
	}
	
	
	private ResursReportRow parseRecord(CSVRecord record) throws ParseException {
		
		ResursReportRow row = new ResursReportRowT10();
		
		row.setShopId(record.get(0));
		
		if (row.getShopId()==null || row.getShopId().trim().length()==0)
			return null;
		
		if (record.isMapped(K_STORE_NAME)) {
			row.setShopName(record.get(K_STORE_NAME));
		}
		
		row.setShopTaxId(record.get(2));
		
		if (record.isMapped(K_STORE_CORPORATE_ID)) {
			row.setShopTaxId(record.get(K_STORE_CORPORATE_ID));
		}
		
		row.setPurchaseAmount(parseDoubleString(record.get(3)));
		
		if (record.isMapped(K_PURCHASE_AMOUNT)) {
			row.setPurchaseAmount(parseDoubleString(record.get(K_PURCHASE_AMOUNT)));
		}
		
		row.setDiscountFee(parseDoubleString(record.get(4)));
		
		if (record.isMapped(K_DISCOUNT_FEE)) {
			row.setDiscountFee(parseDoubleString(record.get(K_DISCOUNT_FEE)));
		}
		
		row.setNetAmount(parseDoubleString(record.get(6)));
		
		if (record.isMapped(K_NET_AMOUNT)) {
			row.setNetAmount(parseDoubleString(record.get(K_NET_AMOUNT)));
		}

		// Payment date is when resurs pays to us
		row.setPaymentDate(LocalDate.parse(record.get(7), dateFormat));
		
		if (record.isMapped(K_PAYMENT_DATE)) {
			row.setPaymentDate(LocalDate.parse(record.get(K_PAYMENT_DATE), dateFormat));
		}
		
		// Transaction date is order date
		row.setTransactionDate(LocalDate.parse(record.get(9)));
		
		if (record.isMapped(K_TRANSACTION_DATE)) {
			row.setTransactionDate(LocalDate.parse(record.get(K_TRANSACTION_DATE), dateFormat));
		}
		
		row.setBatchIdentity(record.get(10));
		
		if (record.isMapped(K_BATCH_IDENTITY)) {
			row.setBatchIdentity(record.get(K_BATCH_IDENTITY));
		}
		
		row.setAccountNumber(record.get(11));
		
		if (record.isMapped(K_ACCOUNT_NUMBER)) {
			row.setAccountNumber(record.get(K_ACCOUNT_NUMBER));
		}
		
		// Customer order number
		row.setReceiptIdentity(record.get(12));
		
		if (record.isMapped(K_RECEIPT_ID)) {
			row.setReceiptIdentity(record.get(K_RECEIPT_ID));
		}
		
		row.setCustomerName(record.get(13));
		
		if (record.isMapped(K_CUSTOMER_NAME)) {
			row.setCustomerName(record.get(K_CUSTOMER_NAME));
		}
		
		row.setCustomerIdentityOriginal(record.get(15));
		
		if (record.isMapped(K_IDENTITY_NUMBER_ORIGINAL)) {
			row.setCustomerIdentityOriginal(record.get(K_IDENTITY_NUMBER_ORIGINAL));
		}
		
		row.setSubType(record.get(19));
		
		if (record.isMapped(K_SUBTYPE)) {
			row.setSubType(record.get(K_SUBTYPE));
		}
		
		return row;
		
	}
	
	private double parseDoubleString(String dstr) {
		
		if (dstr==null) return 0.0;
		
		dstr = dstr.replace(",", ".");
		
		return Double.parseDouble(dstr);
		
	}
	
}
