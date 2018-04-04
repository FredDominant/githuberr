package com.example.andeladeveloper.githuberr.utils;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE)
public class NetworkJobSchedulerTest {
    private JobScheduler jobScheduler;
    private static int jobId = 100;

    @Before
    public void setUp() throws Exception {
        jobScheduler = (JobScheduler)
                RuntimeEnvironment.application.getSystemService(Context.JOB_SCHEDULER_SERVICE);
    }

    @Test
    public void scheduledJobShouldExist() { //failing
        ComponentName componentName =
                new ComponentName(RuntimeEnvironment.application, NetworkJobScheduler.class);
        JobInfo.Builder builder = new JobInfo.Builder(jobId, componentName);
        builder.setPeriodic(1000);
        JobInfo jobInfo = builder.build();
        jobScheduler.schedule(jobInfo);
        assertThat(jobScheduler.getAllPendingJobs()).contains(jobInfo);
    }

    @Test
    public void jobShouldBeScheduledCorrectly() {
        int result = jobScheduler.schedule(new JobInfo.Builder(jobId,
                new ComponentName(RuntimeEnvironment.application, NetworkJobScheduler.class))
        .setPeriodic(1000)
        .build());
        assertThat(result).isEqualTo(JobScheduler.RESULT_SUCCESS);
    }

}
