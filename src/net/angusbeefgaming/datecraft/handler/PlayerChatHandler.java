package net.angusbeefgaming.datecraft.handler;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import net.angusbeefgaming.datecraft.player.Account;
import net.angusbeefgaming.datecraft.player.PlayerManager;
import net.angusbeefgaming.datecraft.util.ChatType;
import net.md_5.bungee.api.ChatColor;

public class PlayerChatHandler implements Listener {
	/*
	 * Created by Atticus Zambrana on 8/16/18
	 */
	@EventHandler
	public void playerChat(AsyncPlayerChatEvent e) {
		Account acc = PlayerManager.getAccountFromPlayer(e.getPlayer());
		
		if(acc.getChatType() == ChatType.PUBLIC) {
			return;
		}
		if(acc.getChatType() == ChatType.RELATIONSHIP) {
			// Stop the message from going to pub chat
			e.setCancelled(true);
			if(Bukkit.getPlayer(acc.togetherWith) != null) {
				Bukkit.getPlayer(acc.togetherWith).sendMessage(ChatColor.GOLD + "<Relationship Chat> " + ChatColor.GREEN + "(" + acc.getName() + ") "
						+ e.getMessage());
			}
			
			e.getPlayer().sendMessage(ChatColor.GOLD + "<Relationship Chat> " + ChatColor.GREEN + "(" + acc.getName() + ") "
						+ e.getMessage());
			return;
		}
	}

}
