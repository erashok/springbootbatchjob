package com.bankfab.fabepay.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.bankfab.fabepay.repository")
public class DataSourceConfiguration {
	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String username;
	@Value("${spring.datasource.password}")
	private String password;

	@Value("${spring.datasource.driver-class-name:oracle.jdbc.pool.OracleDataSource}")
	private String driverClassName;

}
