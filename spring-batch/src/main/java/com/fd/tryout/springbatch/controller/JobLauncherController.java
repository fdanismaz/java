package com.fd.tryout.springbatch.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author furkand
 * 10/26/2018 6:51 PM
 */
@Slf4j
@RestController
@RequestMapping("/job")
public class JobLauncherController {

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    @Qualifier("toUpperCaseJob")
    Job toUpperCaseJob;

    @GetMapping("/run")
    public String runJob() {
        try {
            log.info("Starting job...");
            JobParameters jobParameters = new JobParametersBuilder()
                    .addLong("time", System.currentTimeMillis())
                    .toJobParameters();
            this.jobLauncher.run(this.toUpperCaseJob, jobParameters);
        }
        catch (Exception e) {
            log.error(e.getMessage());
        }

        return "DONE!";
    }
}
