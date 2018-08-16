package net.angusbeefgaming.datecraft.command;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.angusbeefgaming.datecraft.player.PlayerManager;

public class ProfileCommand implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		Player player = (Player) sender;
		
		Inventory inv = Bukkit.createInventory(null, 18, "My Profile");
		
		
		ItemStack gender = nameItem(Material.NAME_TAG, "My Gender: " + PlayerManager.getAccountFromPlayer(player).gender);
		ItemStack relStatus = nameItem(Material.NAME_TAG, "My Relationship Status: " + PlayerManager.getAccountFromPlayer(player).relationshipStatus);
		
		ItemStack relStatusSingle = nameItem(Material.NAME_TAG, "My Relationship Status: Single");
		
		ItemStack together = nameItem(Material.NAME_TAG, "I am with: " + PlayerManager.getAccountFromPlayer(player).togetherWith);
		
		
		if((PlayerManager.getAccountFromPlayer(player).relationshipStatus).equals("NONE")) {
			inv.setItem(12, gender);
			inv.setItem(14, relStatusSingle);
		}
		else {
			inv.setItem(11, gender);
			inv.setItem(13, relStatus);
			inv.setItem(15, together);
		}
		
		player.openInventory(inv);
		
		return true;
	}
	
    private ItemStack nameItem(ItemStack item, String name) {
    	ItemMeta meta = item.getItemMeta();
    	meta.setDisplayName(name);
    	item.setItemMeta(meta);
    	return item;
    }

    private ItemStack nameItem(Material item, String name) {
    	return nameItem(new ItemStack(item), name);
    }
}
