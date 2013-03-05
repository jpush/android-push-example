package com.example.jpush.high_example;

import android.app.Application;
import android.util.Log;
import cn.jpush.android.api.JPushInterface;

/**
 * For developer startup JPush SDK
 * 
 */
public class HighExampleApplication extends Application {
    private static final String TAG = "HighExampleApplication";

    @Override
    public void onCreate() {
        Log.d(TAG, "onCreate");
        super.onCreate();
        
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);
    }
}

