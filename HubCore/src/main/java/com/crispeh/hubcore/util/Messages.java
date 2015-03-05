package com.crispeh.hubcore.util;

import com.crispeh.hubcore.HubCore;
import org.bukkit.ChatColor;
import org.bukkit.configuration.ConfigurationSection;

/**
 * Created by Joey on 3/5/2015.
 */
public final class Messages {

    public static String getFormat(String s) {
        return getFormat(HubCore.getInstance().getConfig(), s, false);
    }

    public static String getFormat(String s, Boolean b, String[]... changes) {
        return getFormat(HubCore.getInstance().getConfig(), s, b, changes);
    }

    public static String getFormat(ConfigurationSection configurationSection, String s, boolean b, String[]... changes) {
        String format = (b ? getFormat(configurationSection, "prefix", false)+" " : "")+ ChatColor.translateAlternateColorCodes('&', configurationSection.getString(s, s));
        for(String[] ch: changes) {
            if(ch.length == 2) format = format.replace(ch[0], ch[1]);
        }
        return format;
    }

}
