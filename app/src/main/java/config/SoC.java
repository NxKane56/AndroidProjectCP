package config;

import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class SoC {
    public int getNumOfCores() {
        try {
            int i = new File("/sys/devices/system/cpu/").listFiles(new FileFilter() {
                public boolean accept(File params) {
                    return Pattern.matches("cpu[0-9]", params.getName());
                }
            }).length;
            return i;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }

    public String getFreqCPU() {
        String LocationMinFreqCPU = "/sys/devices/system/cpu/cpu1/cpufreq/cpuinfo_min_freq";
        String LocationMaxFreqCPU = "/sys/devices/system/cpu/cpu5/cpufreq/cpuinfo_max_freq";
        File FileMinFreqCPU = new File(LocationMinFreqCPU);
        File FileMaxFreqCPU = new File(LocationMaxFreqCPU);
        Scanner scanMax = null;
        Scanner scanMin = null;
        try {
            scanMax = new Scanner(FileMaxFreqCPU);
            scanMin = new Scanner(FileMinFreqCPU);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        double maxFreqCPU = scanMax.nextInt();
        double minFreqCPU = scanMin.nextInt();
        String FreqCPU = String.format("%.0f", minFreqCPU/1000) + " MHz - " + String.format("%.2f",maxFreqCPU/1000000)+" GHz";
        return FreqCPU;
    }

    public String getArchCPU(){
        String LocationArchCPU = "proc/cpuinfo";
        File FileArchCPU = new File(LocationArchCPU);
        Scanner scanArch = null;
        try {
            scanArch = new Scanner(FileArchCPU);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String ArchCPU = scanArch.nextLine();
        return ArchCPU;
    }

    public String getCPUInfo (){
        String LocationArchCPU = "proc/cpuinfo/big.LITTLE";
        File FileArchCPU = new File(LocationArchCPU);
        Scanner scanArch = null;
        try {
            scanArch = new Scanner(FileArchCPU);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String ArchCPU = scanArch.nextLine();
        return ArchCPU;
    }

    public String getTech (){
        String LocationProcess = "proc/cpuinfo/process";
        File FileProcess = new File(LocationProcess);
        Scanner scanProcess = null;
        try {
            scanProcess = new Scanner(FileProcess);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String Process = scanProcess.nextLine();
        return Process;
    }

    public String getGPU (){
        String LocationGPU = "proc/gpuinfo/vendor_id";
        File FileGPU = new File(LocationGPU);
        Scanner scanGPU = null;
        try {
            scanGPU = new Scanner(FileGPU);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String GPU = scanGPU.nextLine();
        return GPU;
    }

    public String getGPUrender (){
        String LocationGPUrender = "proc/gpuinfo/vendor_id";
        File FileGPUrender = new File(LocationGPUrender);
        Scanner scanGPU = null;
        try {
            scanGPU = new Scanner(FileGPUrender);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String GPUrender = scanGPU.nextLine();
        return GPUrender;
    }
}