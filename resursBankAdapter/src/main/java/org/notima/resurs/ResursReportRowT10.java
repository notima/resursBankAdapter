package org.notima.resurs;

import java.time.LocalDate;

public class ResursReportRowT10 implements ResursReportRow {

	private String 	shopId;
	private String	shopName;
	private String	shopTaxId;
	
	private double	purchaseAmount;
	private double	discountFee;
	private double	discountFeePercent;
	private double	netAmount;
	
    private LocalDate paymentDate;
    private LocalDate postingDate;
    private LocalDate transactionDate;
    
    private String	batchIdentity;
    private String	accountNumber;
    
    private String	receiptIdentity;
    
    private String	customerName;
    private String	customerIdentity;
    private String	customerIdentityOriginal;
    private String	streetAddress;
    private String	zipCode;
    private String	city;
    private String	subType;
    
    
	@Override
	public String getShopId() {
		return shopId;
	}
	@Override
	public void setShopId(String shopId) {
		this.shopId = shopId;
	}
	@Override
	public String getShopName() {
		return shopName;
	}
	@Override
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	@Override
	public String getShopTaxId() {
		return shopTaxId;
	}
	@Override
	public void setShopTaxId(String shopTaxId) {
		this.shopTaxId = shopTaxId;
	}
	@Override
	public double getPurchaseAmount() {
		return purchaseAmount;
	}
	@Override
	public void setPurchaseAmount(double purchaseAmount) {
		this.purchaseAmount = purchaseAmount;
	}
	@Override
	public double getDiscountFee() {
		return discountFee;
	}
	@Override
	public void setDiscountFee(double discountFee) {
		this.discountFee = discountFee;
	}
	@Override
	public double getDiscountFeePercent() {
		return discountFeePercent;
	}
	@Override
	public void setDiscountFeePercent(double discountFeePercent) {
		this.discountFeePercent = discountFeePercent;
	}
	@Override
	public double getNetAmount() {
		return netAmount;
	}
	@Override
	public void setNetAmount(double netAmount) {
		this.netAmount = netAmount;
	}
	@Override
	public LocalDate getPaymentDate() {
		return paymentDate;
	}
	@Override
	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}
	@Override
	public LocalDate getPostingDate() {
		return postingDate;
	}
	@Override
	public void setPostingDate(LocalDate postingDate) {
		this.postingDate = postingDate;
	}
	@Override
	public LocalDate getTransactionDate() {
		return transactionDate;
	}
	@Override
	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}
	@Override
	public String getBatchIdentity() {
		return batchIdentity;
	}
	@Override
	public void setBatchIdentity(String batchIdentity) {
		this.batchIdentity = batchIdentity;
	}
	@Override
	public String getAccountNumber() {
		return accountNumber;
	}
	@Override
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	@Override
	public String getReceiptIdentity() {
		return receiptIdentity;
	}
	@Override
	public void setReceiptIdentity(String receiptIdentity) {
		this.receiptIdentity = receiptIdentity;
	}
	@Override
	public String getCustomerName() {
		return customerName;
	}
	@Override
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	@Override
	public String getCustomerIdentity() {
		return customerIdentity;
	}
	@Override
	public void setCustomerIdentity(String customerIdentity) {
		this.customerIdentity = customerIdentity;
	}
	@Override
	public String getCustomerIdentityOriginal() {
		return customerIdentityOriginal;
	}
	@Override
	public void setCustomerIdentityOriginal(String customerIdentityOriginal) {
		this.customerIdentityOriginal = customerIdentityOriginal;
	}
	@Override
	public String getStreetAddress() {
		return streetAddress;
	}
	@Override
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	@Override
	public String getZipCode() {
		return zipCode;
	}
	@Override
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	@Override
	public String getCity() {
		return city;
	}
	@Override
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String getSubType() {
		return subType;
	}
	@Override
	public void setSubType(String subType) {
		this.subType = subType;
	}
    

	
}
