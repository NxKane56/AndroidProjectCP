package com.sys_info;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;

public class DeviceActivity extends Activity {

    String getScreenSize(double a, double b, double c) {
        double result = Math.sqrt((Math.pow(a, 2) + Math.pow(b, 2)) / Math.pow(c, 2));
        return String.format("%.1f", result);
    }


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.device);

        TextView text_Model = (TextView) findViewById(R.id.text_Model);
        TextView text_Brand = (TextView) findViewById(R.id.text_Brand);
        TextView text_Platform = (TextView) findViewById(R.id.text_Platform);
        TextView text_Hardware = (TextView) findViewById(R.id.text_Hardware);
        TextView text_Size = (TextView) findViewById(R.id.text_Size);
        TextView text_Resolution = (TextView) findViewById(R.id.text_Res);
        TextView text_Dpi = (TextView) findViewById(R.id.text_Dpi);

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        text_Model.setText("" + Build.MODEL);
        text_Brand.setText("" + Build.MANUFACTURER);
        text_Platform.setText("" + Build.BOARD);
        text_Hardware.setText("" + Build.HARDWARE);
        text_Size.setText("" + getScreenSize(metrics.widthPixels, metrics.heightPixels, metrics.xdpi)+"\"");
        text_Resolution.setText("" + metrics.widthPixels + "x" + metrics.heightPixels);
        text_Dpi.setText("" + (int) (metrics.xdpi)+" dpi");
    }
}