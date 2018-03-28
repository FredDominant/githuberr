package com.example.andeladeveloper.githuberr.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.util.Log;
import android.widget.Toast;

public class NetworkBroadcast extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(context.toString(), "onReceive gets called");
        ConnectivityManager connectivityManager =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        android.net.NetworkInfo mobileStatus =
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        android.net.NetworkInfo wifiStatus =
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

        boolean connectivityStatus = mobileStatus.isAvailable() || wifiStatus.isAvailable();
        if (!connectivityStatus) {
            Toast.makeText(context, "Check your network connection", Toast.LENGTH_LONG)
                    .show();
        }

    }
}
