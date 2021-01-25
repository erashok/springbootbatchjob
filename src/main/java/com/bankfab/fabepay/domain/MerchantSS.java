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
	@GeneratedValue( generator="uuid" )
	@GenericGenerator(
			name="uuid",
			strategy="org.hibernate.id.UUIDGenerator",
			parameters = {
					@Parameter(
							name="uuid_gen_strategy_class",
							value="org.hibernate.id.uuid.CustomVersionOneStrategy"
					)
			}
	)
	private String MERCHANT_SETL_ID;
	
	
	@Column
	private String MERCHANT_NO;
	@Column
	private String MERCHANT_SUFFIX;
	@Column
	private String  TERMINAL;
	
	@Column
	private String COMMERCIAL_NAME;
	public String getMERCHANT_SETL_ID() {
		return MERCHANT_SETL_ID;
	}

	public void setMERCHANT_SETL_ID(String mERCHANT_SETL_ID) {
		MERCHANT_SETL_ID = mERCHANT_SETL_ID;
	}

	public String getMERCHANT_NO() {
		return MERCHANT_NO;
	}

	public void setMERCHANT_NO(String mERCHANT_NO) {
		MERCHANT_NO = mERCHANT_NO;
	}

	public String getMERCHANT_SUFFIX() {
		return MERCHANT_SUFFIX;
	}

	public void setMERCHANT_SUFFIX(String mERCHANT_SUFFIX) {
		MERCHANT_SUFFIX = mERCHANT_SUFFIX;
	}

	public String getTERMINAL() {
		return TERMINAL;
	}

	public void setTERMINAL(String tERMINAL) {
		TERMINAL = tERMINAL;
	}

	public String getCOMMERCIAL_NAME() {
		return COMMERCIAL_NAME;
	}

	public void setCOMMERCIAL_NAME(String cOMMERCIAL_NAME) {
		COMMERCIAL_NAME = cOMMERCIAL_NAME;
	}

	public String getTXN_DATE() {
		return TXN_DATE;
	}

	public void setTXN_DATE(String tXN_DATE) {
		TXN_DATE = tXN_DATE;
	}

	public String getRRN_NUMBER() {
		return RRN_NUMBER;
	}

	public void setRRN_NUMBER(String rRN_NUMBER) {
		RRN_NUMBER = rRN_NUMBER;
	}

	public String getCARD_TYPE() {
		return CARD_TYPE;
	}

	public void setCARD_TYPE(String cARD_TYPE) {
		CARD_TYPE = cARD_TYPE;
	}

	public String getCARD_NO() {
		return CARD_NO;
	}

	public void setCARD_NO(String cARD_NO) {
		CARD_NO = cARD_NO;
	}

	public String getAUTH_ID() {
		return AUTH_ID;
	}

	public void setAUTH_ID(String aUTH_ID) {
		AUTH_ID = aUTH_ID;
	}

	public String getTXN_AMOUNT() {
		return TXN_AMOUNT;
	}

	public void setTXN_AMOUNT(String tXN_AMOUNT) {
		TXN_AMOUNT = tXN_AMOUNT;
	}

	public String getCOMM_AMOUNT() {
		return COMM_AMOUNT;
	}

	public void setCOMM_AMOUNT(String cOMM_AMOUNT) {
		COMM_AMOUNT = cOMM_AMOUNT;
	}

	public String getVAT_AMOUNT() {
		return VAT_AMOUNT;
	}

	public void setVAT_AMOUNT(String vAT_AMOUNT) {
		VAT_AMOUNT = vAT_AMOUNT;
	}

	public String getNET_AMOUNT() {
		return NET_AMOUNT;
	}

	public void setNET_AMOUNT(String nET_AMOUNT) {
		NET_AMOUNT = nET_AMOUNT;
	}

	public String getTXN_CCY() {
		return TXN_CCY;
	}

	public void setTXN_CCY(String tXN_CCY) {
		TXN_CCY = tXN_CCY;
	}

	public String getBILL_CCY() {
		return BILL_CCY;
	}

	public void setBILL_CCY(String bILL_CCY) {
		BILL_CCY = bILL_CCY;
	}

	public String getBILL_AMOUNT() {
		return BILL_AMOUNT;
	}

	public void setBILL_AMOUNT(String bILL_AMOUNT) {
		BILL_AMOUNT = bILL_AMOUNT;
	}

	public String getSETTLEMENT_STATUS() {
		return SETTLEMENT_STATUS;
	}

	public void setSETTLEMENT_STATUS(String sETTLEMENT_STATUS) {
		SETTLEMENT_STATUS = sETTLEMENT_STATUS;
	}

	public String getCREATED_DATE() {
		return CREATED_DATE;
	}

	public void setCREATED_DATE(String cREATED_DATE) {
		CREATED_DATE = cREATED_DATE;
	}

	@Column
	private String TXN_DATE;
	@Column
	private String RRN_NUMBER;
	@Column
	private String CARD_TYPE;
	@Column
	private String CARD_NO;
	@Column
	private String AUTH_ID;
	@Column
	private String TXN_AMOUNT;
	@Column
	private String COMM_AMOUNT;
	@Column
	private String VAT_AMOUNT;
	@Column
	private String NET_AMOUNT;
	@Column
	private String TXN_CCY;
	@Column
	private String BILL_CCY;
	@Column
	private String BILL_AMOUNT;
	@Column
	private String SETTLEMENT_STATUS;
	@Column
	private String CREATED_DATE;

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
		sb.append("MERCHANT_NO=").append(MERCHANT_NO);
		sb.append(", MERCHANT_SUFFIX='").append(MERCHANT_SUFFIX).append('\'');
		sb.append(", RRN_NUMBER='").append(RRN_NUMBER).append('\'');
		sb.append(", CARD_NO=").append(CARD_NO).append('\''); //AUTH_ID
		sb.append(", AUTH_ID=").append(AUTH_ID);
		sb.append('}');
		return sb.toString();
	}

}
