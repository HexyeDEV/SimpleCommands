package me.NWImAle.SimpleCommands.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;


public class ReloadCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] arg3) {
		
		if (sender.hasPermission("simplecommands.reload")) {
			
			
			Plugin plugin = Bukkit.getPluginManager().getPlugin("SimpleCommands");
			Bukkit.getPluginManager().disablePlugin(plugin);
			Bukkit.getPluginManager().enablePlugin(plugin);
			plugin.reloadConfig();
			sender.sendMessage("Plugin Succesfully Reloaded.");
			return true;
			
		}else {
			sender.sendMessage("You are not allowed to use that command");
		}
		
		return false;
	}

}
