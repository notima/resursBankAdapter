package org.notima.businessobjects.adapter.resurs;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.notima.resurs.ResursReport;
import org.notima.resurs.ResursReportRow;

class TestResursReport {

	@Test
	void testParseFile() throws Exception {
		
		ResursReport report = TestResursUtil.getTestReport();
		
		List<ResursReportRow> rows = report.getReportRows();
		
        for(ResursReportRow row : rows) {
            System.out.printf(
                "%s\t%s\t%s\t%.2f\t%.2f\t%.2f\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t\n", 
                row.getShopId(),
                row.getPaymentDate() == null ? "" : row.getPaymentDate().toString(),
                row.getShopName(),
                row.getPurchaseAmount(),
                row.getDiscountFee(),
                row.getNetAmount(),
                row.getReceiptIdentity(),
                row.getBatchIdentity(),
                row.getCustomerIdentityOriginal(),
                row.getCustomerName(),
                row.getPostingDate() == null ? "" : row.getPostingDate().toString(),
                row.getPaymentDate() == null ? "" : row.getPaymentDate().toString(),
                row.getAccountNumber(),
                row.getSubType()
            );
        }
        
        if (rows.size()>0) {
	        assertEquals("12345678", rows.get(0).getShopId());
	        assertEquals("shop.com", rows.get(1).getShopName());
	        assertEquals(-10617.00, rows.get(2).getNetAmount(), 0.0);
        } else {
        	fail("No rows");
        }
	}

}
