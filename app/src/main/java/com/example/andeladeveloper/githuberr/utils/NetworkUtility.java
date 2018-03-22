package com.example.andeladeveloper.githuberr.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by andeladeveloper on 22/03/2018.
 */

public class NetworkUtility {
    private final Context context;


    public NetworkUtility(Context context) {
        this.context = context;
    }

    public boolean isConnected() {
        if (context != null) {
            ConnectivityManager connectivityManager =
                    (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            return networkInfo != null && networkInfo.isConnected();
        }
        return false;
    }
}
