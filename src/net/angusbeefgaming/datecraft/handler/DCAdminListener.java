package net.angusbeefgaming.datecraft.handler;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import net.angusbeefgaming.datecraft.data.DataManager;
import net.angusbeefgaming.datecraft.managers.DatingManager;
import net.angusbeefgaming.datecraft.util.ServerUtil;
import net.angusbeefgaming.datecraft.util.VanishUtil;
import net.md_5.bungee.api.ChatColor;

public class DCAdminListener implements Listener {
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		Inventory inv = e.getInventory();
		ItemStack item = e.getCurrentItem();
		Player player = (Player) e.getWhoClicked();
		
		if(!inv.getTitle().equals("DateCraft Admin")) return;
		if(item == null) return;
		if(item.getItemMeta() == null) return;
		
		if(item.getItemMeta().getDisplayName().equals("Save All Player Data")) {
	    	ServerUtil.log("Saving Player Data of All Online Players...");
	    	DataManager.saveAllData();
	    	player.sendMessage(ChatColor.GREEN + "Saving All Player Data...");
		}
		if(item.getItemMeta().getDisplayName().equals("Allow Player Dating")) {
	    	ServerUtil.log("Player Dating has been allowed by " + player.getName());
	    	DatingManager.setDatingAllowed(true);
	    	if(VanishUtil.isVanished(player)) {
	    		ServerUtil.announce("" + ChatColor.GREEN + ChatColor.BOLD + "Dating has been enabled by Anonymous.");
	    	}
	    	else {
	    		ServerUtil.announce("" + ChatColor.GREEN + ChatColor.BOLD + "Dating has been enabled by " + player.getName());
	    	}
		}
		if(item.getItemMeta().getDisplayName().equals("Block Player Dating")) {
	    	ServerUtil.log("Player Dating has been blocked by " + player.getName());
	    	DatingManager.setDatingAllowed(false);
	    	if(VanishUtil.isVanished(player)) {
	    		ServerUtil.announce("" + ChatColor.GREEN + ChatColor.BOLD + "Dating has been disabled by Anonymous.");
	    	}
	    	else {
	    		ServerUtil.announce("" + ChatColor.GREEN + ChatColor.BOLD + "Dating has been disabled by " + player.getName());
	    	}
		}
		
		
		e.setCancelled(true);
		player.closeInventory();
		
		return;
	}
}
