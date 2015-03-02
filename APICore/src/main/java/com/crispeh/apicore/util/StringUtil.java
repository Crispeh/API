package com.crispeh.apicore.util;

import org.bukkit.ChatColor;

/**
 * Created by Joey on 3/1/2015.
 */
public final class StringUtil {

    public static String colorize(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

}
