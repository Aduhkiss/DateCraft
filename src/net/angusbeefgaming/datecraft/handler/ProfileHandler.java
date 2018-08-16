package net.angusbeefgaming.datecraft.handler;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ProfileHandler implements Listener { 
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		Inventory inv = e.getInventory();
		ItemStack item = e.getCurrentItem();
		Player player = (Player) e.getWhoClicked();
		
		if(!inv.getTitle().equals("My Profile")) return;
		if(item == null) return;
		if(item.getItemMeta() == null) return;
		
		e.setCancelled(true);
		
		return;
	}

}
