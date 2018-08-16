package net.angusbeefgaming.datecraft.command;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

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
		PlayerManager.getAccountFromPlayer(player).relationshipStatus = "NONE";
		
		PlayerManager.getAccountFromPlayer(player).partnerID = "NONE";
		
		OfflinePlayer target = Bukkit.getOfflinePlayer(UUID.fromString(PlayerManager.getAccountFromPlayer(player).partnerID));
		
		PlayerManager.getAccountFromPlayer((Player) target).relationshipStatus = "NONE";
		PlayerManager.getAccountFromPlayer((Player) target).partnerID = "NONE";
		
		ServerUtil.breakupAlert(player, (Player) target);
		return true;
	}

}
