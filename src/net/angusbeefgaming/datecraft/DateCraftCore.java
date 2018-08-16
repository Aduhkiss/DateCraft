package net.angusbeefgaming.datecraft;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import net.angusbeefgaming.datecraft.command.DCAdminCommand;
import net.angusbeefgaming.datecraft.command.GenderCommand;
import net.angusbeefgaming.datecraft.command.ProfileCommand;
import net.angusbeefgaming.datecraft.data.DataManager;
import net.angusbeefgaming.datecraft.handler.DCAdminListener;
import net.angusbeefgaming.datecraft.handler.PlayerLoginHandler;
import net.angusbeefgaming.datecraft.handler.ProfileHandler;
import net.angusbeefgaming.datecraft.util.ServerUtil;

public class DateCraftCore extends JavaPlugin {
	/*
	 * DateCraft
	 * 
	 * Created by Atticus Zambrana on 8/15/18
	 * 
	 * (C) 2018 Infinity Games Ltd.
	 */
	static DateCraftCore instance;
	
    private File configFile;
    private FileConfiguration config;
    
    private File dataFile;
    private FileConfiguration data;
	@Override
	public void onEnable() {
		Bukkit.getLogger().info("DateCraft > Starting Datecraft Core...");
		setupFiles();
		instance = this;
		
		// Add Event Handlers
		getServer().getPluginManager().registerEvents(new PlayerLoginHandler(), this);
		getServer().getPluginManager().registerEvents(new DCAdminListener(), this);
		getServer().getPluginManager().registerEvents(new ProfileHandler(), this);
		
		// Add Commands
		getCommand("gender").setExecutor(new GenderCommand());
		getCommand("dcadmin").setExecutor(new DCAdminCommand());
		getCommand("profile").setExecutor(new ProfileCommand());
		
		// Set up Saving All Data every 10 minutes
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, 
				new Runnable() {
			
		    public void run() {
		    	ServerUtil.log("Saving Player Data of All Online Players...");
		    	DataManager.saveAllData();
		    }
		}, 20, 6000);
	}
	
    public FileConfiguration getConfig() {
        return this.config;
    }
    
    public FileConfiguration getData() {
        return this.data;
    }
    
    public File getDataFile() {
    	return dataFile;
    }
    
    public File getConfigFile() {
    	return configFile;
    }
    
    public static DateCraftCore getInstance() {
    	return instance;
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
