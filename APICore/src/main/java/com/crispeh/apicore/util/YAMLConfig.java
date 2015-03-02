package com.crispeh.apicore.util;

import lombok.Data;
import lombok.NonNull;
import lombok.SneakyThrows;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.InputStream;

/**
 * Created by Joey on 3/1/2015.
 */
@Data
public final class YAMLConfig {

    private final String fileName;
    private final JavaPlugin plugin;

    private File configFile;
    private FileConfiguration fileConfig;

    public YAMLConfig(@NonNull JavaPlugin plugin, @NonNull String fileName) {
        this(plugin, new File(plugin.getDataFolder(), fileName));
    }

    public YAMLConfig(@NonNull JavaPlugin plugin, File file) {
        if(!plugin.isEnabled()) throw new IllegalArgumentException("The plugin is not enabled!");
        this.plugin = plugin;
        this.fileName = file.getName();
        File dataFolder = plugin.getDataFolder();
        if(dataFolder == null) throw new IllegalStateException();
        this.configFile = file;
    }

    public void reload() {
        fileConfig = YamlConfiguration.loadConfiguration(configFile);
        InputStream configStream = plugin.getResource(fileName);
        if(configStream != null) {
            YamlConfiguration config = YamlConfiguration.loadConfiguration(configStream);
            fileConfig.setDefaults(config);
        }
    }

    public FileConfiguration getConfig() {
        if(fileConfig == null) this.reload();
        return fileConfig;
    }

    @SneakyThrows
    public void saveConfig() {
        if(fileConfig==null||configFile==null) return;
        getConfig().save(configFile);
    }

    public void saveDefaultConfig() {
        if(!configFile.exists()) this.plugin.saveResource(fileName, false);
    }

}
