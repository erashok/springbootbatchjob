package com.bankfab.fabepay.batch;
import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bankfab.fabepay.domain.MerchantSS;
import com.bankfab.fabepay.repository.MerchantSSRepository;

@Component
public class DBWriter implements ItemWriter<MerchantSS> {

    private MerchantSSRepository merchantRepository;

    @Autowired
    public DBWriter (MerchantSSRepository merchantRepository) {
        this.merchantRepository = merchantRepository;
    }

    @Override
    public void write(List<? extends MerchantSS> merchants) throws Exception{
        System.out.println("Data Saved for Users: " + merchants);
        merchantRepository.saveAll(merchants);
    }
}
