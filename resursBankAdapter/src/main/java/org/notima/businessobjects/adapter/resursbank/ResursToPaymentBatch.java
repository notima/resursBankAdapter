package org.notima.businessobjects.adapter.resursbank;

import java.util.List;

import org.notima.generic.businessobjects.Payment;
import org.notima.generic.businessobjects.PaymentBatch;
import org.notima.generic.businessobjects.PaymentWriteOff;
import org.notima.generic.businessobjects.TransactionReference;
import org.notima.resurs.ResursReport;
import org.notima.resurs.ResursReportRow;
import org.notima.util.LocalDateUtils;

/**
 * Converts a RatepayReport to a payment batch.
 * 
 * @author Daniel Tamm
 *
 */
public class ResursToPaymentBatch {

	private List<ResursReportRow> rows;
	private PaymentBatch batch;
	private ResursReport	report;
	
	public static ResursToPaymentBatch buildFromReport(ResursReport report) {
		
		ResursToPaymentBatch ratepay = new ResursToPaymentBatch();
		ratepay.rows = report.getReportRows();
		ratepay.report = report; 
		ratepay.build();
		return ratepay;
		
	}
	
	public PaymentBatch getPaymentBatch() {
		return batch;
	}
	
	private void build() {
	
		if (rows==null) return;
		batch = new PaymentBatch();
		processRows();
		
	}
	
	private void processRows() {
		
		for (ResursReportRow row : rows) {
			processRow(row);
		}
		
	}
	
	private void processRow(ResursReportRow row) {
		
		Payment<ResursReportRow> payment = convertToPayment(row);
		batch.addPayment(payment);
		
	}
	
	private Payment<ResursReportRow> convertToPayment(ResursReportRow src) {
		
		Payment<ResursReportRow> dst = new Payment<ResursReportRow>();

		dst.setNativePayment(src);
		dst.setCustomerPayment(true);
		dst.setPaymentDate(LocalDateUtils.asDate(src.getPaymentDate()));
		dst.setOriginalAmount(src.getPurchaseAmount());
		dst.setAmount(src.getNetAmount());
		dst.setOrderNo(src.getReceiptIdentity());
		dst.setComment(src.getCustomerName());
		// dst.setDestinationSystemReference(src.getTransactionId());
		// dst.setDestinationSystemReferenceField("ExternalInvoiceReference2");
		dst.setClientOrderNo(src.getReceiptIdentity());
		if (report.getCurrency()!=null) {
			dst.setCurrency(report.getCurrency());
		}

		TransactionReference trxRef = new TransactionReference();
		dst.setTransactionReference(trxRef);
		
//		trxRef.setShipDate(LocalDateUtils.asLocalDate(src.getSentDate()));
//		trxRef.setOrderDate(LocalDateUtils.asLocalDate(src.getOrderDate()));
//		trxRef.setTransactionId(src.getTransactionId());
//		if (src.getFees()!=null && src.getFees().size()>0) {
//			for (RatepayFee fee : src.getFees()) {
//				addFeeToPayment(dst, fee);
//			}
//		}
		
		dst.calculateAmountDeductingWriteOffsFromOriginalAmount();
		
		return dst;
		
	}
	
	
}
