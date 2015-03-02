package com.crispeh.apicore.util;

import org.bukkit.ChatColor;

/**
 * Created by Joey on 3/1/2015.
 */
public final class StringUtil {

    public static String colorize(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    public static String formatTime(Integer seconds) {
        Integer hours = seconds / 3600;
        Integer remainder = seconds % 3600;
        Integer mins = remainder / 60;
        Integer secs = remainder % 60;
        if (hours > 0) {
            return hours + ":" + mins + ":" + secs + " hours";
        }
        else if (mins > 0) {
            if (secs < 10) {
                return mins + ":0" + secs + " minutes";
            }
            if(secs == 00) {
                return mins.toString() + " minutes";
            }
            else return mins + ":" + secs + " minutes";

        } else {
            return secs.toString() + " seconds";
        }
    }

}
