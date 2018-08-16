package net.angusbeefgaming.datecraft.player;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.OfflinePlayer;

public class PlayerManager {
	/*
	 * Created by Atticus Zambrana on 8/15/18
	 */
	public static List<Account> onlinePlayers = new ArrayList<Account>();
	
	public static Account getAccountFromPlayer(Object player) {
		for(Account acc : onlinePlayers) {
			if(acc.getName().equals(((OfflinePlayer) player).getName())) {
				return acc;
			}
		}
		return null;
	}
}
