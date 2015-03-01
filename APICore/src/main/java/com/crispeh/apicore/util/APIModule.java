package com.crispeh.apicore.util;

import com.sun.media.jfxmedia.logging.Logger;
import lombok.Getter;
import lombok.SneakyThrows;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Joey on 3/1/2015.
 */
public abstract class APIModule extends JavaPlugin {

    @Getter private static APIModule instance;

    @Override
    @SneakyThrows
    public void onEnable() {
        enable();
        saveDefaultConfig();
    }
    @Override
    @SneakyThrows
    public void onDisable() {
        disable();
    }

    protected abstract void enable();
    protected abstract void disable();

    @SafeVarargs
    public final <T> void logInfo(T... info) {
        for(T t : info) {
            getServer().getConsoleSender().sendMessage(t.toString());
        }
    }


}
