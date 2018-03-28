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

//        NetworkUtility networkUtility = new NetworkUtility(getApplicationContext());
//
//        if (!networkUtility.isConnected()) {
//            Toast.makeText(getApplicationContext(), "Disconnected Do other stuff here...",
//              Toast.LENGTH_LONG).show();
//            jobFinished(params, true);
//        }
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return true;
    }
}
