package com.weibo.dip.durian;

import com.weibo.dip.durian.util.DatetimeUtil;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** @author yurun */
public class QuartzSchedulerTester {
  private static final Logger LOGGER = LoggerFactory.getLogger(QuartzSchedulerTester.class);

  public static class QuartzJob extends QuartzScheduler.CronJob {
    @Override
    public void run(JobExecutionContext context) {
      String scheduledFireTime =
          DatetimeUtil.COMMON_DATETIME_FORMAT.format(context.getScheduledFireTime());

      LOGGER.info("{} job started", scheduledFireTime);

      try {
        Thread.sleep(17 * 1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      LOGGER.info("{} job stoped", scheduledFireTime);
    }
  }

  public static void main(String[] args) throws Exception {
    QuartzScheduler scheduler = new QuartzScheduler();
    scheduler.setThreadCount(2);
    scheduler.start();

    String name = "test";
    LOGGER.info("name: {}", name);

    String cron = "0/10 * * * * ? *";
    LOGGER.info("cron: {}", cron);

    Class<? extends Job> jobClass = QuartzJob.class;

    scheduler.schedule(name, cron, jobClass);

    Runtime.getRuntime()
        .addShutdownHook(
            new Thread(
                () -> {
                  try {
                    scheduler.shutdown();
                  } catch (SchedulerException e) {
                    LOGGER.error(
                        "scheduler shutdown error: {}", ExceptionUtils.getFullStackTrace(e));
                  }
                }));
  }
}
