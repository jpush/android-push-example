package com.example.jpush.high_example;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import cn.jpush.android.api.JPushInterface;

public class MyReceiver extends BroadcastReceiver {
	private static final String TAG = "MyReceiver";

	@Override
	public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
		Log.d(TAG, "onReceive - " + intent.getAction() + ", extras: " + printBundle(bundle));
		
        if (JPushInterface.ACTION_REGISTRATION_ID.equals(intent.getAction())) {
            
        } else if (JPushInterface.ACTION_MESSAGE_RECEIVED.equals(intent.getAction())) {
        	
        } else if (JPushInterface.ACTION_NOTIFICATION_RECEIVED.equals(intent.getAction())) {
        	
        } else if (JPushInterface.ACTION_NOTIFICATION_OPENED.equals(intent.getAction())) {
        	Intent i = new Intent(context, TestActivity.class);
        	i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        	context.startActivity(i);
        	
        } else {
        	Log.d(TAG, "Unhandled intent - " + intent.getAction());
        }
	}

	
	private static String printBundle(Bundle bundle) {
		StringBuilder sb = new StringBuilder();
		for (String key : bundle.keySet()) {
			sb.append("\nkey:" + key + ", value:" + bundle.getString(key));
		}
		return sb.toString();
	}
}
