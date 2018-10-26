package com.fd.tryout.springbatch.batch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;

/**
 * @author furkand
 * 10/26/2018 6:40 PM
 */
@Slf4j
public class ToUpperCaseJobExecutionListener extends JobExecutionListenerSupport {

    @Override
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            log.info("JOB COMPLETED !!! Go ahead and check the results");
        }
    }
}
