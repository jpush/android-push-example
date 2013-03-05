package com.example.jpush.high_example;

import java.util.HashSet;
import java.util.Set;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import cn.jpush.android.api.BasicPushNotificationBuilder;
import cn.jpush.android.api.CustomPushNotificationBuilder;
import cn.jpush.android.api.InstrumentedActivity;
import cn.jpush.android.api.JPushInterface;

public class MainActivity extends InstrumentedActivity {
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        

        ((Button) findViewById(R.id.register)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JPushInterface.init(getApplicationContext());
            }
        });
                
        ((Button) findViewById(R.id.alias_tags)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	Set<String> tags = new HashSet<String>();
            	tags.add("tag1");
            	tags.add("tag2");
                JPushInterface.setAliasAndTags(getApplicationContext(), "alias1", tags);
            }
        });
        
        
        findViewById(R.id.basic1).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	BasicPushNotificationBuilder builder = new BasicPushNotificationBuilder(MainActivity.this);
                builder.developerArg0 = "Basic builder 1";
                JPushInterface.setPushNotificationBuilder(1, builder);
                Toast.makeText(MainActivity.this, "Basic Builder 1 (Default)", Toast.LENGTH_SHORT).show();
            }
        });
        
        findViewById(R.id.basic2).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	BasicPushNotificationBuilder builder = new BasicPushNotificationBuilder(MainActivity.this);
                builder.developerArg0 = "Basic builder 2";
                builder.statusBarDrawable = R.drawable.jpush_notification_icon;
                JPushInterface.setPushNotificationBuilder(2, builder);
                Toast.makeText(MainActivity.this, "Basic Builder 2 (Define icon)", Toast.LENGTH_SHORT).show();
            }
        });
        
        findViewById(R.id.custom1).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomPushNotificationBuilder builder = new CustomPushNotificationBuilder(MainActivity.this,
                        R.layout.test_notitfication_layout, R.id.icon, R.id.title, R.id.text);
                builder.developerArg0 = "Custom Builder 1";
                builder.layoutIconDrawable = R.drawable.jpush_notification_icon;
                JPushInterface.setPushNotificationBuilder(3, builder);
                Toast.makeText(MainActivity.this, "Custom Builder 1 (Default)", Toast.LENGTH_SHORT).show();
            }
        });
        
        findViewById(R.id.custom2).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomPushNotificationBuilder builder = new CustomPushNotificationBuilder(MainActivity.this,
                        R.layout.test_notitfication_layout, R.id.icon, R.id.title, R.id.text);
                builder.developerArg0 = "Custom Builder 2";
                builder.statusBarDrawable = R.drawable.jpush_notification_icon;
                builder.layoutIconDrawable = R.drawable.jpush_notification_icon;
                JPushInterface.setPushNotificationBuilder(4, builder);
                Toast.makeText(MainActivity.this, "Custom Builder 2 (Define icon)", Toast.LENGTH_SHORT).show();
            }
        });
        
    }
}
