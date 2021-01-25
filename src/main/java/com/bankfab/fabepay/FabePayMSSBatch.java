package com.bankfab.fabepay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.bankfab")
@EntityScan(basePackages = "com.bankfab")
@SpringBootApplication
public class FabePayMSSBatch {

	public static void main(String[] args) {
		SpringApplication.run(FabePayMSSBatch.class, args);
	}
}
