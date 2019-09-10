package com.sys_info;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.widget.TextView;

import config.Battery;

public class BatteryActivity extends Activity {

    public double getBatteryCapacity() {
        Object mPowerProfile_ = null;

        final String POWER_PROFILE_CLASS = "com.android.internal.os.PowerProfile";

        try {
            mPowerProfile_ = Class.forName(POWER_PROFILE_CLASS)
                    .getConstructor(Context.class).newInstance(this);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            double batteryCapacity = (Double) Class
                    .forName(POWER_PROFILE_CLASS)
                    .getMethod("getAveragePower", String.class)
                    .invoke(mPowerProfile_, "battery.capacity");
            return batteryCapacity;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.battery);

        final TextView text_Health = (TextView) findViewById(R.id.text_Health);
        final TextView text_Level = (TextView) findViewById(R.id.text_Level);
        final TextView text_Power = (TextView) findViewById(R.id.text_Power);
        final TextView text_Status = (TextView) findViewById(R.id.text_Status);
        final TextView text_Tech = (TextView) findViewById(R.id.text_Tech);
        final TextView text_V = (TextView) findViewById(R.id.text_V);
        TextView text_Capacity = (TextView) findViewById(R.id.text_Capacity);
        //  final TextView text_Capacity = (TextView) findViewById(R.id.text_Capacity);

        BroadcastReceiver receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                text_Health.setText("" + Battery.batteryHealth(intent.getIntExtra(BatteryManager.EXTRA_HEALTH, -1)));
                text_Level.setText("" + intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1) + "%");
                text_Power.setText("" + Battery.batteryPlugged(intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1)));
                text_Status.setText("" + Battery.batteryStatus(intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1)));
                text_Tech.setText("" + intent.getStringExtra(BatteryManager.EXTRA_TECHNOLOGY));
                text_V.setText("" + intent.getIntExtra(BatteryManager.EXTRA_VOLTAGE, -1) + " mV");
            }

        };

        registerReceiver(receiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));

        text_Capacity.setText(""+(int)getBatteryCapacity()+" mAh");

    }
}
