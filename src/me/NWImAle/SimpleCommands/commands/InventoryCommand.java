package me.NWImAle.SimpleCommands.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;


public class InventoryCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("Please use this command only within game");
			return true;
		} else {
			if (sender.hasPermission("simplecommands.inventory")) {
				if (args.length != 0) {
					Player p = (Player) sender;
					if (sender.getServer().getPlayer(args[0]) != null) {
						Player target = p.getServer().getPlayer(args[0]);
						Inventory inv = target.getInventory();
						p.openInventory(inv);
						return true;
					} else {
						sender.sendMessage("Player is currently offline");
						return true;
					}
				} else {
					return false;
				}
			} else {
				sender.sendMessage("You do not have permission to use this command.");
				return true;
			}
		}
		


	}
	
}
