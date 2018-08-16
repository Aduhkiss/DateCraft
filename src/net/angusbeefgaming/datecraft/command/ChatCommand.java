package net.angusbeefgaming.datecraft.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.angusbeefgaming.datecraft.player.PlayerManager;
import net.angusbeefgaming.datecraft.util.ChatType;
import net.md_5.bungee.api.ChatColor;

public class ChatCommand implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		Player player = (Player) sender;
		if(args.length < 1) {
			if(PlayerManager.getAccountFromPlayer(player).getChatType() == ChatType.PUBLIC) {
				PlayerManager.getAccountFromPlayer(player).chatType = ChatType.RELATIONSHIP;
				player.sendMessage(ChatColor.GREEN + "You are now in Relationship Chat!");
				return true;
			}
			else {
				PlayerManager.getAccountFromPlayer(player).chatType = ChatType.PUBLIC;
				player.sendMessage(ChatColor.GREEN + "You are now in Public Chat!");
				return true;
			}
		}
		else {
			if(args[0].equalsIgnoreCase("p") || args[0].equalsIgnoreCase("public")) {
				PlayerManager.getAccountFromPlayer(player).chatType = ChatType.PUBLIC;
				player.sendMessage(ChatColor.GREEN + "You are now in Public Chat!");
				return true;
			}
			if(args[0].equalsIgnoreCase("r") || args[0].equalsIgnoreCase("relationship")) {
				PlayerManager.getAccountFromPlayer(player).chatType = ChatType.RELATIONSHIP;
				player.sendMessage(ChatColor.GREEN + "You are now in Relationship Chat!");
				return true;
			}
			else {
				player.sendMessage(ChatColor.RED + "Valid chat types are: Public, Relationship");
				return false;
			}
		}
	}
}
