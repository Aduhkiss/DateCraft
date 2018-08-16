package net.angusbeefgaming.datecraft.command;

import java.io.IOException;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import net.angusbeefgaming.datecraft.DateCraftCore;
import net.angusbeefgaming.datecraft.player.PlayerManager;
import net.angusbeefgaming.datecraft.util.ServerUtil;
import net.md_5.bungee.api.ChatColor;

public class BreakupCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		Player player = (Player) sender;
		
		// Check to make sure they are in a relationship
		if(PlayerManager.getAccountFromPlayer(player).relationshipStatus.equals("NONE")) {
			player.sendMessage(ChatColor.RED + "You are not in a relationship!");
			return false;
		}
		
		// Go to each Accounts player data and remove the relationship
		
		OfflinePlayer target = Bukkit.getOfflinePlayer(UUID.fromString(PlayerManager.getAccountFromPlayer(player).partnerID));
		
		PlayerManager.getAccountFromPlayer(player).relationshipStatus = "NONE";
		PlayerManager.getAccountFromPlayer(player).togetherWith = "NONE";
		PlayerManager.getAccountFromPlayer(player).partnerID = "NONE";
		
		PlayerManager.getAccountFromPlayer(player).saveData();
		
		DateCraftCore.getInstance().getData().set(target.getUniqueId() + ".relationshipStatus", "NONE");
		DateCraftCore.getInstance().getData().set(target.getUniqueId() + ".togetherWith", "NONE");
		DateCraftCore.getInstance().getData().set(target.getUniqueId() + ".partnerID", "NONE");
		try {
			DateCraftCore.getInstance().getData().save(DateCraftCore.getInstance().getDataFile());
		} catch (IOException e) {
			ServerUtil.log("There was an error while saving data.");
			e.printStackTrace();
		}
		
		ServerUtil.breakupAlert(player.getName(), target.getName());
		return true;
	}

}
