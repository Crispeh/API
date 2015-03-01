package com.crispeh.apicore;

import com.crispeh.apicore.util.APIModule;
import lombok.Getter;
import lombok.SneakyThrows;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import static com.crispeh.apicore.util.StringUtil.colorize;

/**
 * Created by Joey on 3/1/2015.
 */
public class APICore extends APIModule {

    @Getter private static APICore instance;


    @Override
    @SneakyThrows
    protected void enable() {
        instance = this;
        logInfo("Enabled APICore.");
        for(Player pl : Bukkit.getOnlinePlayers()) {
            pl.kickPlayer(colorize(getConfig().getString("kick-message")));
        }
    }

    @Override
    protected void disable() {
        logInfo("Disabled APICore.");
    }
}
