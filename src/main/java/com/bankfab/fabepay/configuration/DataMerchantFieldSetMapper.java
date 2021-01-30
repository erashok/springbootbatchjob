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
		merchantss.setMerchantNumber((fldSet.readString("Main Merchant No")));
		merchantss.setMerchantSuffix((fldSet.readString("Suffix")));
		merchantss.setTerminal((fldSet.readString("Terminal")));
		merchantss.setCommercialName((fldSet.readString("Commercial Name")));
		merchantss.setTxnDate((fldSet.readString("Txn Date")));
		merchantss.setRrnNumber(fldSet.readString("Voucher Nbr / RRN"));
		merchantss.setCardType(fldSet.readString("Card Type"));
		merchantss.setCardNo(fldSet.readString("Card No"));// AUTH_ID TXN_AMOUNT
		merchantss.setAuthId(fldSet.readString("Auth Id"));
		merchantss.setCommAmount(fldSet.readString("Comm Amount"));
		merchantss.setVatAmount(fldSet.readString("Vat Amount"));
		merchantss.setNetAmount(fldSet.readString("Net Amount"));
		merchantss.setTxnCcy(fldSet.readString("Txn Ccy"));
		// BILL_CCY
		merchantss.setBillCcy(fldSet.readString("Bill Ccy"));
		merchantss.setBillAmount(fldSet.readString("Bill Amount"));
		merchantss.setSettlementStatus("".equals(fldSet.readString("Main Merchant No").trim()) ? "" : "0");
		merchantss.setCreatedDate("".equals(fldSet.readString("Main Merchant No").trim()) ? "" : getCurrentDate());
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
