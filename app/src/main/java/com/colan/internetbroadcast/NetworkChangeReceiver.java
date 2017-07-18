package com.colan.internetbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

/**
 * Created by CIPL0468 on 7/18/2017.
 */


public class NetworkChangeReceiver extends BroadcastReceiver {

    NetworkInterface networkInterface;
    boolean isCon = false;

    @Override
    public void onReceive(Context context, Intent intent) {

        try {

            if (isOnline(context)) {
                networkInterface = (NetworkInterface)MyApp.getInstance().getContext();
                networkInterface.isNetConnected(true);
                isCon = true;
//                dialog(true);
                Log.e("keshav", "Online Connect Intenet ");
            } else {
                networkInterface = (NetworkInterface)MyApp.getInstance().getContext();
                networkInterface.isNetConnected(false);
                isCon = false;
//                dialog(false);
                Log.e("keshav", "Connectivity Failure !!! ");
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    private boolean isOnline(Context context) {
        try {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo netInfo = cm.getActiveNetworkInfo();
            //should check null because in airplane mode it will be null
            return (netInfo != null && netInfo.isConnected());
        } catch (NullPointerException e) {
            e.printStackTrace();
            return false;
        }
    }


}