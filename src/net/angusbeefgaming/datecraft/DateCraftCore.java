package net.angusbeefgaming.datecraft;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import net.angusbeefgaming.datecraft.util.ServerUtil;

public class DateCraftCore extends JavaPlugin {
	/*
	 * DateCraft
	 * 
	 * Created by Atticus Zambrana on 8/15/18
	 * 
	 * (C) 2018 Infinity Games Ltd.
	 */
    private File configFile;
    private FileConfiguration config;
    
    private File dataFile;
    private FileConfiguration data;
	@Override
	public void onEnable() {
		Bukkit.getLogger().info("DateCraft > Starting Datecraft Core...");
	}
	
    public FileConfiguration getConfig() {
        return this.config;
    }
    
    public FileConfiguration getData() {
        return this.data;
    }
    
    private void setupFiles() {
        configFile = new File(getDataFolder(), "config.yml");
        if (!configFile.exists()) {
        	ServerUtil.log("Config File not found! Creating now...");
            configFile.getParentFile().mkdirs();
            saveResource("config.yml", false);
         }

        config = new YamlConfiguration();
        try {
            config.load(configFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
        
        dataFile = new File(getDataFolder(), "data.yml");
        if (!dataFile.exists()) {
        	ServerUtil.log("Data File not found! Creating now...");
            dataFile.getParentFile().mkdirs();
            saveResource("data.yml", false);
         }

        data = new YamlConfiguration();
        try {
            data.load(dataFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }
}
