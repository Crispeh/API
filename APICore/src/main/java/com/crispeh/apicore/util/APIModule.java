package com.crispeh.apicore.util;

import com.crispeh.apicore.command.APICommandHandler;
import lombok.Getter;
import lombok.SneakyThrows;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.InvocationTargetException;

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
    protected final <T extends APICommandHandler> T registerCommand(Class<T> apiCommand) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        return apiCommand.getDeclaredConstructor().newInstance();
    }
    public final <T extends Listener> T registerListener(T listener) {
        getServer().getPluginManager().registerEvents(listener, this);
        return listener;
    }


}
