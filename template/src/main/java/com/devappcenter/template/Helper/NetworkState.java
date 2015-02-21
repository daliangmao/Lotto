package com.devappcenter.template.Helper;

import android.app.Activity;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Andy on 2/12/15 AD.
 */
public class NetworkState {

    public static boolean isOnline(Activity activity) {
        ConnectivityManager cm = (ConnectivityManager) activity.getSystemService(activity.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }
}
