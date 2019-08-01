package com.weibo.dip.durian;

import com.google.common.base.Preconditions;
import com.weibo.dip.durian.util.DatetimeUtil;
import java.util.Date;
import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.quartz.CronScheduleBuilder;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Quartz scheduler.
 *
 * @author yurun
 */
public class QuartzScheduler {
  private static final Logger LOGGER = LoggerFactory.getLogger(QuartzScheduler.class);

  private Properties properties;

  private StdSchedulerFactory factory;

  private Scheduler scheduler;

  public QuartzScheduler() {
    properties = new Properties();
  }

  public void setThreadCount(int threads) {
    properties.setProperty("org.quartz.threadPool.threadCount", String.valueOf(threads));
  }

  public void start() throws SchedulerException {
    factory = new StdSchedulerFactory(properties);

    scheduler = factory.getScheduler();
    scheduler.start();
  }

  public void schedule(String name, String cron, Class<? extends Job> jobClass)
      throws IllegalStateException, SchedulerException {
    schedule(name, cron, jobClass, null);
  }

  /**
   * Schedule a job.
   *
   * @param name jobname
   * @param cron cron expression, example: 0 0/5 * * * ?(every 5 minutes)
   * @param jobClass job class implements interface Job
   * @param jobData job data
   * @throws IllegalStateException if scheduler isn't started or params aren't specified
   * @throws SchedulerException if schedule job failure
   */
  public void schedule(String name, String cron, Class<? extends Job> jobClass, JobDataMap jobData)
      throws IllegalStateException, SchedulerException {
    Preconditions.checkState(scheduler.isStarted(), "scheduler must be started");

    Preconditions.checkState(StringUtils.isNotEmpty(name), "name must be specified");
    Preconditions.checkState(StringUtils.isNotEmpty(cron), "cron must be specified");
    Preconditions.checkState(Objects.nonNull(jobClass), "jobClass must be specified");

    JobBuilder jobBuilder = JobBuilder.newJob(jobClass).withIdentity(name);

    if (Objects.nonNull(jobData)) {
      jobBuilder = jobBuilder.usingJobData(jobData);
    }

    JobDetail jobDetail = jobBuilder.build();

    Trigger trigger =
        TriggerBuilder.newTrigger()
            .withIdentity(name)
            .withSchedule(
                CronScheduleBuilder.cronSchedule(cron)
                    .withMisfireHandlingInstructionIgnoreMisfires())
            .build();

    scheduler.scheduleJob(jobDetail, trigger);
  }

  public void shutdown() throws SchedulerException {
    scheduler.shutdown(true);
  }

  @DisallowConcurrentExecution
  public abstract static class CronJob implements Job {
    public abstract void run(JobExecutionContext context) throws Exception;

    @Override
    public void execute(JobExecutionContext context) {
      String jobName = context.getJobDetail().getKey().getName();

      Date scheduledFireTime = context.getScheduledFireTime();
      Date fireTime = context.getFireTime();

      String jobAlias =
          jobName + Symbols.UNDERLINE + DatetimeUtil.DATETIME_FORMAT.format(scheduledFireTime);

      LOGGER.info(
          "{} delay {} ms", jobAlias, DatetimeUtil.diffMilliSeconds(scheduledFireTime, fireTime));

      Stopwatch stopwatch = new Stopwatch();
      stopwatch.start();

      try {
        run(context);
      } catch (Throwable t) {
        LOGGER.warn("{} run error: {}", jobAlias, ExceptionUtils.getFullStackTrace(t));
      } finally {
        stopwatch.stop();
      }

      LOGGER.info("{} consume {} ms", jobAlias, stopwatch.elapsed(TimeUnit.MILLISECONDS));
    }
  }
}
