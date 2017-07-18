package com.colan.internetbroadcast;

import android.app.Application;
import android.content.Context;

/**
 * Created by CIPL0468 on 7/18/2017.
 */

public class MyApp extends Application {

    private static MyApp ourInstance;
    Context mContext;

    public static MyApp getInstance() {
        return ourInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        ourInstance= this;
        mContext=getApplicationContext();
    }

    public Context getContext(){
        return mContext;
    }

    public void setContext(Context aContext){
        this.mContext=aContext;
    }

}
