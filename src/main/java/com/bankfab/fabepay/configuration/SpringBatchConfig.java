package com.bankfab.fabepay.configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import com.bankfab.fabepay.controller.LoadController;
import com.bankfab.fabepay.domain.MerchantSS;


@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringBatchConfig.class);

	@Bean
	public Job job(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory,
			ItemReader<MerchantSS> itemReader, ItemProcessor<MerchantSS, MerchantSS> itemProcessor, ItemWriter<MerchantSS> itemWriter) {

		Step step = stepBuilderFactory.get("ETL-file-load").<MerchantSS, MerchantSS>chunk(100).reader(itemReader)
				.processor(itemProcessor).writer(itemWriter).build();

		return jobBuilderFactory.get("ETL-Load").incrementer(new RunIdIncrementer()).start(step).build();
	}

	@Bean
	@StepScope
	public FlatFileItemReader<MerchantSS> itemReader(@Value("#{jobParameters[fmrinput]}") String str) {
//@StepScope
		LOGGER.debug(" Item Reader Started for "+str);
		FlatFileItemReader<MerchantSS> flatFileItemReader = new FlatFileItemReader<>();
		flatFileItemReader.setResource(new FileSystemResource(str));
		flatFileItemReader.setName("CSV-Reader");
		flatFileItemReader.setLinesToSkip(1);
		flatFileItemReader.setLineMapper(lineMapper());
		//flatFileItemReader.setRecordSeparatorPolicy(new BlankLineRecordSeparatorPolicy());
		return flatFileItemReader;
	}

	@Bean
	public LineMapper<MerchantSS> lineMapper() {

		DefaultLineMapper<MerchantSS> defaultLineMapper = new DefaultLineMapper<>();
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();

		lineTokenizer.setDelimiter(",");
		lineTokenizer.setStrict(false);
		lineTokenizer.setNames("Main Merchant No", "Suffix", "Terminal", "Commercial Name","Txn Date","Voucher Nbr / RRN","Card Type","Card No","Auth Id","Txn Amount","Comm Amount","Vat Amount","Net Amount","Txn Ccy","Bill Ccy","Bill Amount");

		DataMerchantFieldSetMapper<MerchantSS> fieldSetMapper = new DataMerchantFieldSetMapper<MerchantSS>();
		//fieldSetMapper.setTargetType(MerchantSS.class);

		defaultLineMapper.setLineTokenizer(lineTokenizer);
		defaultLineMapper.setFieldSetMapper(fieldSetMapper);

		return defaultLineMapper;
	}

}
