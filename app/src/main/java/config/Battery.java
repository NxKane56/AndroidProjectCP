package config;

import android.os.BatteryManager;

public class Battery {
    public static String batteryPlugged (Integer plug) {
        switch (plug) {
            case BatteryManager.BATTERY_PLUGGED_AC:
                return "AC";
            case BatteryManager.BATTERY_PLUGGED_USB:
                return "USB";
            default:
                return "UNDEFINED";
        }
    }

    public static String batteryHealth (Integer health) {
        switch (health) {
            case BatteryManager.BATTERY_HEALTH_DEAD:
                return "DEAD";
            case BatteryManager.BATTERY_HEALTH_GOOD:
                return "GOOD";
            case BatteryManager.BATTERY_HEALTH_OVERHEAT:
                return "OVERHEAT";
            case BatteryManager.BATTERY_HEALTH_OVER_VOLTAGE:
                return "OVER VOLTAGE";
            case BatteryManager.BATTERY_HEALTH_UNKNOWN:
                return "UNKNOWN";
            case BatteryManager.BATTERY_HEALTH_UNSPECIFIED_FAILURE:
                return "UNSPECIFIED FAILURE";
            default:
                return "UNDEFINED";
        }
    }

    public static String batteryStatus (Integer status) {
        switch (status) {
            case BatteryManager.BATTERY_STATUS_CHARGING:
                return "CHARGING";
            case BatteryManager.BATTERY_STATUS_DISCHARGING:
                return "DISCHARGING";
            case BatteryManager.BATTERY_STATUS_FULL:
                return "FULL";
            case BatteryManager.BATTERY_STATUS_NOT_CHARGING:
                return "NOT CHARGING";
            case BatteryManager.BATTERY_STATUS_UNKNOWN:
                return "UNKNOWN";
            default:
                return "UNDEFINED";
        }
    }
}
