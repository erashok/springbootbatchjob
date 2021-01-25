package com.bankfab.fabepay.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/processMssFileETL")
public class LoadController {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoadController.class);
	
	@Autowired
    JobLauncher jobLauncher;
    
    @Autowired
    Job job;

    /**
     * This method called using the getmethod will accept the file 
     * for Batch Processing
     * @param filePath
     * @return
     */
    @GetMapping
    public String processMssFile(@RequestParam String filePath) {
    	String jobStatus="Execution Failed";
    	
    	LOGGER.debug("*Accepting the file "+filePath + "For Processing");
    	try {
    		 JobExecution jobExecution = jobLauncher.run(job, new JobParametersBuilder().addString("fmrinput", filePath).toJobParameters());
    		 jobStatus="Successfully Submitted : "+filePath;
    		 LOGGER.debug(" ##"+jobStatus);
    	}catch(Exception e) {
    		e.printStackTrace();
    	}finally {
    		
    	}
    	
    	return jobStatus;
    }
    /**
     * Below Code to be removed during cleanup
     * @param fullyFileName
     * @return
     * @throws JobParametersInvalidException
     * @throws JobExecutionAlreadyRunningException
     * @throws JobRestartException
     * @throws JobInstanceAlreadyCompleteException
     */
    public BatchStatus load(String fullyFileName) throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {

        
    	
        Map<String, JobParameter> maps = new HashMap<>();
        maps.put("time", new JobParameter(System.currentTimeMillis()));
        JobParameters parameters = new JobParameters(maps);
        JobExecution jobExecution = jobLauncher.run(job, new JobParametersBuilder().addString("fmrinput", fullyFileName).toJobParameters());

        System.out.println("JobExecution: " + jobExecution.getStatus());

        System.out.println("Batch is Running...");
        while (jobExecution.isRunning()) {
            System.out.println("...");
        }

        return jobExecution.getStatus();
    }
}
