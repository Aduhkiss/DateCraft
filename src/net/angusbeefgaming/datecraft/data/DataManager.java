package net.angusbeefgaming.datecraft.data;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import net.angusbeefgaming.datecraft.DateCraftCore;
import net.angusbeefgaming.datecraft.player.PlayerManager;
import net.angusbeefgaming.datecraft.util.ServerUtil;

public class DataManager {
	/*
	 * Created by Atticus Zambrana on 8/15/18
	 */
	public static void setupPlayer(Player player) {
		ServerUtil.log("Setting up player data for " + player.getName() + "...");
		DateCraftCore.getInstance().getData().set(player.getUniqueId() + ".relationshipStatus", "NONE");
		DateCraftCore.getInstance().getData().set(player.getUniqueId() + ".togetherWith", "NONE");
		DateCraftCore.getInstance().getData().set(player.getUniqueId() + ".partnerID", "NONE");
		DateCraftCore.getInstance().getData().set(player.getUniqueId() + ".gender", "NONE");
		try {
			DateCraftCore.getInstance().getData().save(DateCraftCore.getInstance().getDataFile());
		} catch (IOException e) {
			ServerUtil.log("There was an error while saving data.");
			e.printStackTrace();
		}
	}
	
	// For saving player data of all players
	public static void saveAllData() {
		for(Player pla : Bukkit.getOnlinePlayers()) {
			PlayerManager.getAccountFromPlayer(pla).saveData();
		}
	}
	
	public static boolean hasPlayerData(Player player) {
		if(DateCraftCore.getInstance().getData().get(player.getUniqueId() + ".relationshipStatus") == null) {
			return false;
		}
		else {
			return true;
		}
	}
	
	// Then a method for each player data value
	
	public static String getRelationshipStatus(Player player) {
		return (String) DateCraftCore.getInstance().getData().get(player.getUniqueId() + ".relationshipStatus");
	}
	
	public static String getTogetherWith(Player player) {
		return (String) DateCraftCore.getInstance().getData().get(player.getUniqueId() + ".togetherWith");
	}
	
	public static String getPartnerID(Player player) {
		return (String) DateCraftCore.getInstance().getData().get(player.getUniqueId() + ".partnerID");
	}
	
	public static String getGender(Player player) {
		return (String) DateCraftCore.getInstance().getData().get(player.getUniqueId() + ".gender");
	}
}
