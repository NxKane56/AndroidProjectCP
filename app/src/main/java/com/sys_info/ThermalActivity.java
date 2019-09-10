package com.sys_info;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.widget.TextView;

import config.Temperature;

public class ThermalActivity extends Activity {

    Temperature temp = new Temperature();

    TextView text_PSU_temp;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thermal);

        TextView text_CPU_temp = (TextView) findViewById(R.id.text_CPU_temp);
        String result_CPU = String.valueOf(temp.getTempCPU());
        text_CPU_temp.setText(result_CPU + "\u2103");


        text_PSU_temp = (TextView) findViewById(R.id.text_PSU_temp);

        BroadcastReceiver receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                text_PSU_temp.setText((double) intent.getIntExtra(BatteryManager.EXTRA_TEMPERATURE, -1) / 10 + "\u2103");

            }
        };
        registerReceiver(receiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    }
}
