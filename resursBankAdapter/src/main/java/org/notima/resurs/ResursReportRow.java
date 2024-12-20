package org.notima.resurs;

import java.time.LocalDate;

public interface ResursReportRow {

	String getShopId();

	void setShopId(String shopId);

	String getShopName();

	void setShopName(String shopName);

	String getShopTaxId();

	void setShopTaxId(String shopTaxId);

	double getPurchaseAmount();

	void setPurchaseAmount(double purchaseAmount);

	double getDiscountFee();

	void setDiscountFee(double discountFee);

	double getDiscountFeePercent();

	void setDiscountFeePercent(double discountFeePercent);

	double getNetAmount();

	void setNetAmount(double netAmount);

	LocalDate getPaymentDate();

	void setPaymentDate(LocalDate paymentDate);

	LocalDate getPostingDate();

	void setPostingDate(LocalDate postingDate);

	LocalDate getTransactionDate();

	void setTransactionDate(LocalDate transactionDate);

	String getBatchIdentity();

	void setBatchIdentity(String batchIdentity);

	String getAccountNumber();

	void setAccountNumber(String accountNumber);

	String getReceiptIdentity();

	void setReceiptIdentity(String receiptIdentity);

	String getCustomerName();

	void setCustomerName(String customerName);

	String getCustomerIdentity();

	void setCustomerIdentity(String customerIdentity);

	String getCustomerIdentityOriginal();

	void setCustomerIdentityOriginal(String customerIdentityOriginal);

	String getStreetAddress();

	void setStreetAddress(String streetAddress);

	String getZipCode();

	void setZipCode(String zipCode);

	String getCity();

	void setCity(String city);

	String getSubType();

	void setSubType(String subType);

}