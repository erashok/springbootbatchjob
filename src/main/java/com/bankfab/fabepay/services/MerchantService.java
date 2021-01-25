package com.bankfab.fabepay.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.bankfab.fabepay.domain.MerchantSS;
import com.bankfab.fabepay.repository.MerchantSSRepository;



@Service
@ComponentScan({"com.bankfab.fabepay.repository","com.bankfab.fabepay.repository"})
public class MerchantService implements IMerchantService{
@Autowired 
MerchantSSRepository merchantRepository;
	 
	public void createMerchantSS(MerchantSS user) {
		merchantRepository.save(user);
		
		System.out.println("Simply Describe the Objects meaning");
		
	}

	@Override
	public List<MerchantSS> saveAll(ArrayList<MerchantSS> userList) {
		// TODO Auto-generated method stub
		return merchantRepository.saveAll(userList);
	}
}
