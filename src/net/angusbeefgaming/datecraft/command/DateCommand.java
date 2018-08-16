package net.angusbeefgaming.datecraft.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.angusbeefgaming.datecraft.player.PlayerManager;
import net.angusbeefgaming.datecraft.util.ServerUtil;
import net.md_5.bungee.api.ChatColor;

public class DateCommand implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		Player player = (Player) sender;
		if(args.length < 1) {
			player.sendMessage(ChatColor.RED + "Who would you like to date?");
			return false;
		}
		
		Player target = Bukkit.getPlayer(args[0]);
		if(target == null) {
			player.sendMessage(ChatColor.RED + "Player not found!");
			return false;
		}
		if(target.getName().equals(player.getName())) {
			player.sendMessage(ChatColor.RED + "You cannot date yourself...");
			return false;
		}
		
		if(PlayerManager.getAccountFromPlayer(player).relationshipStatus.equals("DATING")) {
			player.sendMessage(ChatColor.RED + player.getName() + " is already dating someone!");
			return false;
		}
		if(PlayerManager.getAccountFromPlayer(player).relationshipStatus.equals("MARRIED")) {
			player.sendMessage(ChatColor.RED + player.getName() + " is already married to someone!");
			return false;
		}
		
		if(PlayerManager.getAccountFromPlayer(target).dateRequest.equalsIgnoreCase(player.getName())) {
			ServerUtil.dateAlert(target.getName(), player.getName());
			
			PlayerManager.getAccountFromPlayer(target).dateRequest = null;
			PlayerManager.getAccountFromPlayer(player).dateRequest = null;
			
			// Set all the player data
			PlayerManager.getAccountFromPlayer(target).relationshipStatus = "DATING";
			PlayerManager.getAccountFromPlayer(player).relationshipStatus = "DATING";
			
			PlayerManager.getAccountFromPlayer(target).togetherWith = player.getName();
			PlayerManager.getAccountFromPlayer(player).relationshipStatus = target.getName();
			
			PlayerManager.getAccountFromPlayer(target).partnerID = player.getUniqueId().toString();
			PlayerManager.getAccountFromPlayer(player).partnerID = target.getUniqueId().toString();
			
			// Then we should be all good to go!
			return true;
		}
		else {
			PlayerManager.getAccountFromPlayer(player).dateRequest = target.getName();
			player.sendMessage(ChatColor.GREEN + "You have requested to date " + target.getName() + "!");
			
			target.sendMessage(ChatColor.GREEN + player.getName() + " has requested to date you! To accept, run /date " + player.getName());
			return true;
		}
		
	}
}
