package net.angusbeefgaming.datecraft.handler;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import net.angusbeefgaming.datecraft.data.DataManager;
import net.angusbeefgaming.datecraft.player.Account;
import net.angusbeefgaming.datecraft.player.PlayerManager;

public class PlayerLoginHandler implements Listener {
	/*
	 * Created by Atticus Zambrana on 8/15/18
	 */
	
	@EventHandler
	public void playerJoin(PlayerJoinEvent e) {
		Account pl = new Account(e.getPlayer());
		
		PlayerManager.onlinePlayers.add(pl);
		
		if(!DataManager.hasPlayerData(e.getPlayer())) {
			DataManager.setupPlayer(e.getPlayer());
		}
		else {
			pl.fetchData();
		}
	}
	
	@EventHandler
	public void playerLeave(PlayerQuitEvent e) {
		Account pl = PlayerManager.getAccountFromPlayer(e.getPlayer());
		
		// Save player data to file
		pl.saveData();
	}

}
