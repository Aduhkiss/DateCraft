package net.angusbeefgaming.datecraft.handler;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import net.angusbeefgaming.datecraft.data.DataManager;
import net.angusbeefgaming.datecraft.util.ServerUtil;
import net.md_5.bungee.api.ChatColor;

public class DCAdminListener implements Listener {
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		Inventory inv = e.getInventory();
		ItemStack item = e.getCurrentItem();
		Player player = (Player) e.getWhoClicked();
		
		if(!inv.getTitle().equals("DateCraft Admin")) return;
		if(item == null) return;
		
		if(item.getItemMeta().getDisplayName().equals("Save All Player Data")) {
	    	ServerUtil.log("Saving Player Data of All Online Players...");
	    	DataManager.saveAllData();
	    	player.sendMessage(ChatColor.GREEN + "Saving All Player Data...");
		}
		
		e.setCancelled(true);
		player.closeInventory();
		
		return;
	}
}
