package com.indooratlas.android.sdk.indoornavigation.imageview;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

public class NetworkUsage {

    public static boolean isConnectedThroughWifi(ConnectivityManager connManager)
    {
        NetworkInfo mWifi = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if(mWifi.isConnected())
        {
            Log.d("NetworkUtils", "Wifi Connected");
            return true;
        }
        return false;
    }

    public static boolean isConnectedThroughMobile(ConnectivityManager connManager)
    {
        NetworkInfo mWifi = connManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if(mWifi.isConnected() )
        {
            Log.d("NetworkUtils","3G connected");
            return true;
        }
        return false;
    }

    public static boolean isConnected(ConnectivityManager connManager) {
        NetworkInfo activeNetwork = connManager.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();
        return isConnected;
    }
}


