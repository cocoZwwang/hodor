package org.dromara.hodor.scheduler.quartz;

import java.util.Date;
import lombok.Setter;
import org.dromara.hodor.core.JobDesc;
import org.dromara.hodor.scheduler.api.HodorJobExecutionContext;
import org.dromara.hodor.scheduler.api.JobExecutor;
import org.quartz.Job;
import org.quartz.JobExecutionContext;

/**
 *  hodor job
 *
 * @author tomgs
 * @version 2020/6/24 1.0 
 */
public class HodorJob implements Job {

    @Setter
    private JobExecutor jobExecutor;

    @Setter
    private JobDesc jobDesc;

    @Override
    public void execute(JobExecutionContext context) {
        Date fireTime = context.getFireTime();
        Date scheduledFireTime = context.getScheduledFireTime();
        Date previousFireTime = context.getPreviousFireTime();
        Date nextFireTime = context.getNextFireTime();

        jobExecutor.execute(new HodorJobExecutionContext(jobDesc, fireTime, scheduledFireTime, previousFireTime, nextFireTime));
    }

}
