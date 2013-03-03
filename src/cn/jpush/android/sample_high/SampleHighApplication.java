package cn.jpush.android.sample_high;

import android.app.Application;
import android.util.Log;
import cn.jpush.android.api.JPushInterface;

/**
 * For developer startup JPush SDK
 * 
 */
public class SampleHighApplication extends Application {
    private static final String TAG = "SampleHighApplication";

    @Override
    public void onCreate() {
        Log.d(TAG, "onCreate");
        super.onCreate();
        
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);
    }
}

