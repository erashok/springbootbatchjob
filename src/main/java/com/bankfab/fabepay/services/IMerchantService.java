package com.bankfab.fabepay.services;

import java.util.ArrayList;
import java.util.List;

import com.bankfab.fabepay.domain.MerchantSS;





public interface IMerchantService {
	public void createMerchantSS(MerchantSS user);
	public List<MerchantSS> saveAll(ArrayList<MerchantSS> userList);
}
