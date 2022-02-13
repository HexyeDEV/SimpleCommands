package me.NWImAle.SimpleCommands.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import me.NWImAle.SimpleCommands.utils.Utils;

public class HealCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] arg3) {
		
		Plugin plugin = Bukkit.getPluginManager().getPlugin("SimpleCommands");
		
		if (sender instanceof Player) {
			if (sender.hasPermission("simplecommands.heal")) {
				
				((Player) sender).setHealth(20);
				sender.sendMessage(Utils.chat(plugin.getConfig().getString("prefix")) + " " + "Your health have been refilled");
				return true;
				
			}
		}
		
		return false;
	}

}
