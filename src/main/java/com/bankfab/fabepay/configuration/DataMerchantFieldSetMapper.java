package com.bankfab.fabepay.configuration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.bankfab.fabepay.domain.MerchantSS;

public class DataMerchantFieldSetMapper<T> implements FieldSetMapper<MerchantSS> {

	@Override
	public MerchantSS mapFieldSet(FieldSet fldSet) throws BindException {
		MerchantSS merchantss = new MerchantSS();
		merchantss.setMERCHANT_NO(fldSet.readString("Main Merchant No"));
		merchantss.setMERCHANT_SUFFIX(fldSet.readString("Suffix"));
		merchantss.setTERMINAL(fldSet.readString("Terminal"));
		merchantss.setCOMMERCIAL_NAME(fldSet.readString("Commercial Name"));
		merchantss.setTXN_DATE(fldSet.readString("Txn Date"));
		merchantss.setRRN_NUMBER(fldSet.readString("Voucher Nbr / RRN"));
		merchantss.setCARD_TYPE(fldSet.readString("Card Type"));
		merchantss.setCARD_NO(fldSet.readString("Card No"));// AUTH_ID TXN_AMOUNT
		merchantss.setAUTH_ID(fldSet.readString("Auth Id"));
		merchantss.setCOMM_AMOUNT(fldSet.readString("Comm Amount"));
		merchantss.setVAT_AMOUNT(fldSet.readString("Vat Amount"));
		merchantss.setNET_AMOUNT(fldSet.readString("Net Amount"));
		merchantss.setTXN_CCY(fldSet.readString("Txn Ccy"));
		// BILL_CCY
		merchantss.setBILL_CCY(fldSet.readString("Bill Ccy"));
		merchantss.setBILL_AMOUNT(fldSet.readString("Bill Amount"));
		merchantss.setSETTLEMENT_STATUS("".equals(fldSet.readString("Main Merchant No").trim()) ? "" : "0");
		merchantss.setCREATED_DATE("".equals(fldSet.readString("Main Merchant No").trim()) ? "" : getCurrentDate());
		if ("".equals(fldSet.readString("Main Merchant No").trim())) {
			return null;
		}
		return merchantss;
	}

	private String getCurrentDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();

		return now.toString();
	}

}
