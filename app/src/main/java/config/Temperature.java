package config;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Temperature {
    //Датчик температуры CPU
    public String getTempCPU() {
        String temperatureFileLocation = "sys/devices/virtual/thermal/thermal_zone1/temp";
        File temperatureFile = new File(temperatureFileLocation);
        Scanner scan = null;
        try {
            scan = new Scanner(temperatureFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        double temperatureC = scan.nextFloat() / 1000;
        String resultTempC = String.format("%.1f", temperatureC);
        return resultTempC;
    }

}