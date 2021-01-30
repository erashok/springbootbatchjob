package com.bankfab.fabepay.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "TBL_FP_Merchant_Settlement")
public class MerchantSS implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2176412110226428775L;
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator", parameters = {
			@Parameter(name = "uuid_gen_strategy_class", value = "org.hibernate.id.uuid.CustomVersionOneStrategy") })
	private String MERCHANT_SETL_ID;

	@Column(name = "MERCHANT_NO")
	private String merchantNumber;
	@Column(name = "MERCHANT_SUFFIX")
	private String merchantSuffix;
	@Column(name = "TERMINAL")
	private String terminal;

	@Column(name = "TXN_DATE")
	private String txnDate;
	@Column(name = "RRN_NUMBER")
	private String rrnNumber;
	@Column(name = "CARD_TYPE")
	private String cardType;
	@Column(name = "CARD_NO")
	private String cardNo;
	@Column(name = "AUTH_ID")
	private String authId;
	@Column(name = "TXN_AMOUNT")
	private String txnAmount;
	@Column(name = "COMM_AMOUNT")
	private String commAmount;
	@Column(name = "VAT_AMOUNT")
	private String vatAmount;
	@Column(name = "NET_AMOUNT")
	private String netAmount;
	@Column(name = "TXN_CCY")
	private String txnCcy;
	@Column(name = "BILL_CCY")
	private String billCcy;
	@Column(name = "BILL_AMOUNT")
	private String billAmount;
	@Column(name = "SETTLEMENT_STATUS")
	private String settlementStatus;
	@Column(name = "CREATED_DATE")
	private String createdDate;

	@Column(name = "COMMERCIAL_NAME")
	private String commercialName;

	public String getMERCHANT_SETL_ID() {
		return MERCHANT_SETL_ID;
	}

	public void setMERCHANT_SETL_ID(String mERCHANT_SETL_ID) {
		MERCHANT_SETL_ID = mERCHANT_SETL_ID;
	}
	/*
	 * public User(Integer id, String name, String dept, Integer salary, Date time)
	 * { this.id = id; this.name = name; this.dept = dept; this.salary = salary;
	 * this.time = time; }
	 */

	/*
	 * public User() { }
	 */

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("User{");
		sb.append("MERCHANT_NO=").append(merchantNumber);
		sb.append(", MERCHANT_SUFFIX='").append(merchantSuffix).append('\'');
		sb.append(", RRN_NUMBER='").append(rrnNumber).append('\'');
		sb.append(", CARD_NO=").append(cardNo).append('\''); // AUTH_ID
		sb.append(", AUTH_ID=").append(authId);
		sb.append('}');
		return sb.toString();
	}

	public String getMerchantNumber() {
		return merchantNumber;
	}

	public void setMerchantNumber(String merchantNumber) {
		this.merchantNumber = merchantNumber;
	}

	public String getMerchantSuffix() {
		return merchantSuffix;
	}

	public void setMerchantSuffix(String merchantSuffix) {
		this.merchantSuffix = merchantSuffix;
	}

	public String getTerminal() {
		return terminal;
	}

	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}

	public String getTxnDate() {
		return txnDate;
	}

	public void setTxnDate(String txnDate) {
		this.txnDate = txnDate;
	}

	public String getRrnNumber() {
		return rrnNumber;
	}

	public void setRrnNumber(String rrnNumber) {
		this.rrnNumber = rrnNumber;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getAuthId() {
		return authId;
	}

	public void setAuthId(String authId) {
		this.authId = authId;
	}

	public String getTxnAmount() {
		return txnAmount;
	}

	public void setTxnAmount(String txnAmount) {
		this.txnAmount = txnAmount;
	}

	public String getCommAmount() {
		return commAmount;
	}

	public void setCommAmount(String commAmount) {
		this.commAmount = commAmount;
	}

	public String getVatAmount() {
		return vatAmount;
	}

	public void setVatAmount(String vatAmount) {
		this.vatAmount = vatAmount;
	}

	public String getNetAmount() {
		return netAmount;
	}

	public void setNetAmount(String netAmount) {
		this.netAmount = netAmount;
	}

	public String getTxnCcy() {
		return txnCcy;
	}

	public void setTxnCcy(String txnCcy) {
		this.txnCcy = txnCcy;
	}

	public String getBillCcy() {
		return billCcy;
	}

	public void setBillCcy(String billCcy) {
		this.billCcy = billCcy;
	}

	public String getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(String billAmount) {
		this.billAmount = billAmount;
	}

	public String getSettlementStatus() {
		return settlementStatus;
	}

	public void setSettlementStatus(String settlementStatus) {
		this.settlementStatus = settlementStatus;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getCommercialName() {
		return commercialName;
	}

	public void setCommercialName(String commercialName) {
		this.commercialName = commercialName;
	}

}
