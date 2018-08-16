package net.angusbeefgaming.datecraft.player;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;

public class PlayerManager {
	/*
	 * Created by Atticus Zambrana on 8/15/18
	 */
	public static List<Account> onlinePlayers = new ArrayList<Account>();
	
	public static Account getAccountFromPlayer(Player player) {
		for(Account acc : onlinePlayers) {
			if(acc.getName().equals(player.getName())) {
				return acc;
			}
		}
		return null;
	}
}
