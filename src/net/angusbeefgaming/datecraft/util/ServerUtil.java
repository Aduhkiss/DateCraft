package net.angusbeefgaming.datecraft.util;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class ServerUtil {
	/*
	 * Created by Atticus Zambrana on 8/15/18
	 */
	
	public static void log(String message) {
		Bukkit.getLogger().info("DateCraft > " + message);
	}
	
	// Alerts to announce to the server
	public static void dateAlert(Player p1, Player p2) {
		for(Player pl : Bukkit.getOnlinePlayers()) {
			pl.sendMessage("" + ChatColor.GREEN + ChatColor.BOLD + p1.getName() + " is now dating " + p2.getName() + "!");
		}
	}
	
	public static void breakupAlert(Player p1, Player p2) {
		for(Player pl : Bukkit.getOnlinePlayers()) {
			pl.sendMessage("" + ChatColor.GREEN + ChatColor.BOLD + p1.getName() + " has broken up with " + p2.getName() + "!");
		}
	}
	
	public static void marryAlert(Player p1, Player p2) {
		for(Player pl : Bukkit.getOnlinePlayers()) {
			pl.sendMessage("" + ChatColor.GREEN + ChatColor.BOLD + p1.getName() + " is now married to " + p2.getName() + "!");
		}
	}
	
	public static void divorceAlert(Player p1, Player p2) {
		for(Player pl : Bukkit.getOnlinePlayers()) {
			pl.sendMessage("" + ChatColor.GREEN + ChatColor.BOLD + p1.getName() + " has divorced " + p2.getName() + "!");
		}
	}
}
