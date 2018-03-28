package com.example.andeladeveloper.githuberr.utils;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.widget.Toast;

public class NetworkJobScheduler extends JobService {
    NetworkUtility networkUtility;
    @Override
    public boolean onStartJob(JobParameters params) {
        networkUtility = new NetworkUtility(getApplicationContext());
        if (!networkUtility.isConnected()) {
            Toast.makeText(getApplicationContext(),
                    "Network disconnected", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), "Job started", Toast.LENGTH_LONG).show();
        }
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return true;
    }
}
