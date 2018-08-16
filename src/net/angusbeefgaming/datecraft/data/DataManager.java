package net.angusbeefgaming.datecraft.data;

import org.bukkit.entity.Player;

import net.angusbeefgaming.datecraft.DateCraftCore;
import net.angusbeefgaming.datecraft.util.ServerUtil;

public class DataManager {
	/*
	 * Created by Atticus Zambrana on 8/15/18
	 */
	public static void setupPlayer(Player player) {
		ServerUtil.log("Setting up player data for " + player.getName() + "...");
		DateCraftCore.getInstance().getData().set(player.getUniqueId() + ".relationshipStatus", "NONE");
		DateCraftCore.getInstance().getData().set(player.getUniqueId() + ".togetherWith", "NONE");
		DateCraftCore.getInstance().getData().set(player.getUniqueId() + ".gender", "NONE");
	}
	
	public static boolean hasPlayerData(Player player) {
		String checker = (String) DateCraftCore.getInstance().getData().get(player.getUniqueId() + ".relationshipStatus");
		if(checker == null) {
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
	
	public static String getGender(Player player) {
		return (String) DateCraftCore.getInstance().getData().get(player.getUniqueId() + ".gender");
	}
}
