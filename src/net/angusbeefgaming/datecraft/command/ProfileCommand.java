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
import net.md_5.bungee.api.ChatColor;

public class ProfileCommand implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		Player player = (Player) sender;
		
		Inventory inv = Bukkit.createInventory(null, 27, "My Profile");
		
		
		ItemStack gender = nameItem(Material.NAME_TAG, "" + ChatColor.AQUA + ChatColor.BOLD + "My Gender: " + PlayerManager.getAccountFromPlayer(player).gender);
		ItemStack relStatus = nameItem(Material.NAME_TAG, "" + ChatColor.AQUA + ChatColor.BOLD + "My Relationship Status: " + PlayerManager.getAccountFromPlayer(player).relationshipStatus);
		
		ItemStack together = nameItem(Material.NAME_TAG, "" + ChatColor.AQUA + ChatColor.BOLD + "I am with: " + PlayerManager.getAccountFromPlayer(player).togetherWith);
		
		
		//Bukkit.getLogger().info("DEBUG: " + PlayerManager.getAccountFromPlayer(player).relationshipStatus);
		
		inv.setItem(11, gender);
		inv.setItem(13, relStatus);
		inv.setItem(15, together);
		
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
