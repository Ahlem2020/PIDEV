package tn.esprit.spring.entities;

import java.util.Date;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableScheduling
@RequiredArgsConstructor
@Configuration
@ConditionalOnProperty(value = "spring.batch.job.scheduled", havingValue = "true")
public class JobFilterScheduler {
	private final JobFilterScheduler JobFilterBatch;

    /**
     * Scheduled method used to launch the configured batch job for processing job from a defined directory.
     * The scheduler is based on a cron execution, based on the provided configuration
     * @throws Exception
     *  exception description
     */
    @Scheduled(cron = "${batchConfiguration.JobFilterBatch.cron}")
    public void launchJob() throws Exception {

        Date interview_date = new Date();
        log.info("CsvJobReader scheduled job started at {}", interview_date);

     //  JobFilterBatch.executeBatchJob(startDate);

        Date endDate = new Date();

        log.info("CsvJobReader scheduled job ended at {}", endDate);
        log.info("Completed in: {} (ms)", (endDate.getTime() - interview_date.getTime()));

    }
}
