package com.sys_info;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import config.SoC;


public class SoCActivity extends Activity {

    SoC soc = new SoC();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.soc);

        TextView TestView = (TextView) findViewById(R.id.text_Cores);
        String result = String.valueOf(soc.getNumOfCores());
        TestView.setText(result);


        TextView text_Architecture = (TextView) findViewById(R.id.text_Architecture);
        text_Architecture.setText(soc.getArchCPU());

        TextView text_big_LITTLE = (TextView) findViewById(R.id.text_big_LITTLE);
        text_big_LITTLE.setText(soc.getCPUInfo());

        TextView text_Tech_process = (TextView) findViewById(R.id.text_Tech_process);
        text_Tech_process.setText(soc.getTech());

        TextView text_CPU_Freq = (TextView) findViewById(R.id.text_CPU_Freq);
        text_CPU_Freq.setText(soc.getFreqCPU());

        TextView text_GPU_Vendor = (TextView) findViewById(R.id.text_GPU_Vendor);
        text_GPU_Vendor.setText(soc.getGPU());

        TextView text_GPU_Renderer = (TextView) findViewById(R.id.text_GPU_Renderer);
        text_GPU_Renderer.setText(soc.getGPUrender());
    }
}