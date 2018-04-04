package com.example.andeladeveloper.githuberr.utils;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Log;
import android.widget.Toast;

public class NetworkJobScheduler extends JobService {
    NetworkUtility networkUtility;
    @Override
    public boolean onStartJob(JobParameters params) {
        networkUtility = new NetworkUtility(getApplicationContext());
        if (networkUtility.isConnected()) {
            // do some stuff here
            Log.i("", "onStartJob: Network dey");
        } else {
            Toast.makeText(getApplicationContext(),
                    "Network disconnected", Toast.LENGTH_LONG).show();
        }
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return true;
    }
}
