package com.bankfab.fabepay.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankfab.fabepay.domain.MerchantSS;



@Repository
public interface MerchantSSRepository extends JpaRepository<MerchantSS, Long> {
	//public  MerchantSS save(MerchantSS user);
	//public List<MerchantSS> saveAll(List<MerchantSS> userList);
}
