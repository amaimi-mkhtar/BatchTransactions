package com.example.BatchApp;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.Batch.BatchLauncher;

public class BacthApp {

	public static void main(String[] args) throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/example/BatchConfig/SpringConf.xml");
		Job job = (Job) ctx.getBean("importTransactions");
      JobParametersBuilder jobBuilder= new JobParametersBuilder();
      JobParameters jobParameters = jobBuilder.toJobParameters();
		JobLauncher jobLauncher = (JobLauncher) ctx.getBean("jobLauncher"); 
		JobExecution execution = jobLauncher.run(job, jobParameters);
		System.out.println("Completion Status : " + execution.getStatus());


	}

}
