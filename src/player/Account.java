package player;

import org.bukkit.entity.Player;

public class Account {
	/*
	 * Created by Atticus Zambrana on 8/15/18
	 */
	Player myPlayer;
	boolean isDisguised;
	String disguisedName;
	public Account(Player player) {
		this.myPlayer = player;
	}
	
	public Player getPlayer() {
		return myPlayer;
	}
	public String getName() {
		if(isDisguised) {
			return disguisedName;
		}
		else {
			return myPlayer.getName();
		}
	}
	public String getRealName() {
		return myPlayer.getName();
	}
}
