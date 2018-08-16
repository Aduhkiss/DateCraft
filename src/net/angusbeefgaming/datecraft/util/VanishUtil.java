package net.angusbeefgaming.datecraft.util;

import org.bukkit.entity.Player;
import org.bukkit.metadata.MetadataValue;

public class VanishUtil {
	/*
	 * Created by Atticus Zambrana on 8/16/18
	 */
	
	// Check if the player is vanished.
	public static boolean isVanished(Player player) {
        for (MetadataValue meta : player.getMetadata("vanished")) {
            if (meta.asBoolean()) return true;
        }
        return false;
	}
}
