package net.angusbeefgaming.datecraft.handler;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class DCAdminListener implements Listener {
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		Inventory inv = e.getInventory();
		ItemStack item = e.getCurrentItem();
		
		if(!inv.getTitle().equals("DateCraft Admin")) return;
		if(item == null) return;
		
		
	}
}
