package net.angusbeefgaming.datecraft.fun;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.angusbeefgaming.datecraft.util.MathUtil;
import net.md_5.bungee.api.ChatColor;

public class KissCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		Player player = (Player) sender;
		
		if(args.length < 1) {
			player.sendMessage(ChatColor.RED + "Who would you like to kiss?");
			return false;
		}
		
		Player target = Bukkit.getPlayer(args[0]);
		if(target == null) {
			player.sendMessage(ChatColor.RED + "Player not found!");
			return false;
		}
		if(target.getName().equals(player.getName())) {
			player.sendMessage(ChatColor.RED + "How do you kiss yourself??");
			return false;
		}
		
		if(MathUtil.distance(player, target) > 2) {
			player.sendMessage(ChatColor.RED + "You are too far away to kiss " + target.getName() + "!");
			return false;
		}
		
		player.sendMessage("" + ChatColor.GREEN + ChatColor.BOLD + "You have kissed " + target + "!");
		target.sendMessage("" + ChatColor.GREEN + ChatColor.BOLD + player + " has kissed you!");
		
		return true;
	}

}
