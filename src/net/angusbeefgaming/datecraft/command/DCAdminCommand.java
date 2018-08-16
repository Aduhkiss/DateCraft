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

import net.md_5.bungee.api.ChatColor;

public class DCAdminCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		Player player = (Player) sender;
		if(!player.hasPermission("datecraft.admin")) {
			player.sendMessage(ChatColor.RED + "You dont have permission to do that!");
			return false;
		}
		
		Inventory inv = Bukkit.createInventory(null, 18, "DateCraft Admin");
		
		
		ItemStack saveAll = nameItem(Material.FEATHER, "Save All Player Data");
		
		
		inv.setItem(0, saveAll);
		
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
