package net.angusbeefgaming.datecraft.util;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class ServerUtil {
	/*
	 * Created by Atticus Zambrana on 8/15/18
	 */
	
	public static void log(String message) {
		Bukkit.getLogger().info("DateCraft > " + message);
	}
	
	public static void announce(String message) {
		for(Player pla : Bukkit.getOnlinePlayers()) {
			pla.sendMessage(message);
			pla.playSound(pla.getLocation(), Sound.BLOCK_NOTE_PLING, 1f, 1f);
		}
	}
	
	// Alerts to announce to the server
	public static void dateAlert(String p1, String p2) {
		for(Player pl : Bukkit.getOnlinePlayers()) {
			pl.sendMessage("" + ChatColor.GREEN + ChatColor.BOLD + p1 + " is now dating " + p2 + "!");
		}
	}
	
	public static void breakupAlert(String p1, String p2) {
		for(Player pl : Bukkit.getOnlinePlayers()) {
			pl.sendMessage("" + ChatColor.GREEN + ChatColor.BOLD + p1 + " has broken up with " + p2 + "!");
		}
	}
	
	public static void marryAlert(String p1, String p2) {
		for(Player pl : Bukkit.getOnlinePlayers()) {
			pl.sendMessage("" + ChatColor.GREEN + ChatColor.BOLD + p1 + " is now married to " + p2 + "!");
		}
	}
	
	public static void divorceAlert(String p1, Player p2) {
		for(Player pl : Bukkit.getOnlinePlayers()) {
			pl.sendMessage("" + ChatColor.GREEN + ChatColor.BOLD + p1 + " has divorced " + p2 + "!");
		}
	}
}
