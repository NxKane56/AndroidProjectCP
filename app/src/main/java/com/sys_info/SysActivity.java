package com.sys_info;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class SysActivity extends Activity {

    private Handler updateHandler;
    private TextView text_Time;

    private void updateUptimes() {
        long uptimeMillis = SystemClock.elapsedRealtime();
        String wholeUptime = String.format(
                "%02d:%02d:%02d",
                TimeUnit.MILLISECONDS.toHours(uptimeMillis),
                TimeUnit.MILLISECONDS.toMinutes(uptimeMillis)
                        - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS
                        .toHours(uptimeMillis)),
                TimeUnit.MILLISECONDS.toSeconds(uptimeMillis)
                        - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS
                        .toMinutes(uptimeMillis)));
        text_Time.setText(wholeUptime);

        updateHandler.postDelayed(new Runnable() {

            @Override
            public void run() {
                updateUptimes();
            }
        }, 1000);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.system);

        updateHandler = new Handler();

        TextView text_Version = (TextView) findViewById(R.id.text_Version);
        TextView text_API = (TextView) findViewById(R.id.text_API);
        TextView text_Bootloader = (TextView) findViewById(R.id.text_Bootloader);
        TextView text_Build_ID = (TextView) findViewById(R.id.text_Build_ID);
        TextView text_JVM = (TextView) findViewById(R.id.text_JVM);
        TextView text_Ker_Arch = (TextView) findViewById(R.id.text_Kernel_Arch);
        TextView text_Ker_Version = (TextView) findViewById(R.id.text_Kernel_Version);
        text_Time = (TextView) findViewById(R.id.text_Time);

        text_Version.setText("" + Build.VERSION.RELEASE);
        text_API.setText("" + Build.VERSION_CODES.N);
        text_Bootloader.setText("" + Build.BOOTLOADER);
        text_Build_ID.setText("" + Build.ID + "." + Build.BOOTLOADER);
        text_JVM.setText("" + System.getProperty("java.vm.version"));
        text_Ker_Arch.setText("" + System.getProperty("os.arch"));
        text_Ker_Version.setText("" + System.getProperty("os.version"));

        updateUptimes();
    }
}