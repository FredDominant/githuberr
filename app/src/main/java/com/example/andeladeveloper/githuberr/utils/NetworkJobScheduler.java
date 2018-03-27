package com.example.andeladeveloper.githuberr.utils;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Log;
import android.widget.Toast;

public class NetworkJobScheduler extends JobService {

    @Override
    public boolean onStartJob(JobParameters params) {
        Log.i("", "onStartJob in JobService Was called");
        Toast.makeText(getApplicationContext(), "Job started", Toast.LENGTH_LONG).show();
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return true;
    }
}
