package com.bankfab.fabepay.batch;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.bankfab.fabepay.domain.MerchantSS;

@Component
public class Processor implements ItemProcessor<MerchantSS, MerchantSS> {

	
	public Processor() {
		
	}

	@Override
	public MerchantSS process(MerchantSS user) throws Exception {
		String merchantNumber = user.getMerchantNumber();
		String authid = user.getAuthId();
		System.out.println(String.format("Converted from [%s] to [%s]", authid, user.getTxnAmount()));
		/*
		 * if (null == merchantNumber && null == authid) { return null; } else { return
		 * user; }
		 */
		return user;
	}

	private String getCurrentDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();

		return now.toString();
	}

}
