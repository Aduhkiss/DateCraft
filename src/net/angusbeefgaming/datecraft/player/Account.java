package net.angusbeefgaming.datecraft.player;

import java.io.IOException;

import org.bukkit.entity.Player;

import net.angusbeefgaming.datecraft.DateCraftCore;
import net.angusbeefgaming.datecraft.data.DataManager;
import net.angusbeefgaming.datecraft.util.ServerUtil;

public class Account {
	/*
	 * Created by Atticus Zambrana on 8/15/18
	 */
	Player myPlayer;
	boolean isDisguised;
	String disguisedName;
	
	// Player Data
	public String relationshipStatus;
	public String togetherWith;
	public String gender;
	
	public Account(Player player) {
		this.myPlayer = player;
	}
	
	public Player getPlayer() {
		return myPlayer;
	}
	public String getName() {
		if(isDisguised) {
			return disguisedName;
		}
		else {
			return myPlayer.getName();
		}
	}
	public String getRealName() {
		return myPlayer.getName();
	}
	
	public void fetchData() {
		ServerUtil.log("Grabbing player data for " + getRealName());
		this.relationshipStatus = DataManager.getRelationshipStatus(myPlayer);
		this.togetherWith = DataManager.getTogetherWith(myPlayer);
		this.gender = DataManager.getGender(myPlayer);
	}
	
	public void saveData() {
		ServerUtil.log("Saving player data for " + getRealName());
		DateCraftCore.getInstance().getData().set(myPlayer.getUniqueId() + ".relationshipStatus", relationshipStatus);
		DateCraftCore.getInstance().getData().set(myPlayer.getUniqueId() + ".togetherWith", togetherWith);
		DateCraftCore.getInstance().getData().set(myPlayer.getUniqueId() + ".gender", gender);
		try {
			DateCraftCore.getInstance().getData().save(DateCraftCore.getInstance().getDataFile());
		} catch (IOException e) {
			ServerUtil.log("There was an error while saving data.");
			e.printStackTrace();
		}
	}
}
