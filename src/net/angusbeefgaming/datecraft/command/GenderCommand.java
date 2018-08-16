package net.angusbeefgaming.datecraft.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.angusbeefgaming.datecraft.player.PlayerManager;
import net.md_5.bungee.api.ChatColor;

public class GenderCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		Player player = (Player) sender;
		if(args.length < 1) {
			player.sendMessage(ChatColor.GREEN + "You must enter your gender!");
			return false;
		}
		String value = args[0];
		if(value.equalsIgnoreCase("male")) {
			PlayerManager.getAccountFromPlayer(player).gender = "MALE";
			player.sendMessage(ChatColor.GREEN + "Your gender has been updated to MALE!");
			return true;
		}
		if(value.equalsIgnoreCase("female")) {
			PlayerManager.getAccountFromPlayer(player).gender = "FEMALE";
			player.sendMessage(ChatColor.GREEN + "Your gender has been updated to FEMALE!");
			return true;
		}
		else {
			player.sendMessage(ChatColor.GREEN + "The only genders are male, and female!");
			return false;
		}
	}

}
