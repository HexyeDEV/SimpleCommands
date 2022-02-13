package me.NWImAle.SimpleCommands.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;


public class PingCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] arg3) {
		
		
		if (sender instanceof Player) {
			
			Plugin plugin = Bukkit.getPluginManager().getPlugin("SimpleCommands");
				
			CraftPlayer p = (CraftPlayer) sender;
			int ping = p.getHandle().ping;
			sender.sendMessage(plugin.getConfig().getString("prefix") + " " + "Your ping is " + String.valueOf(ping));
			
		}
		
		return false;
	}

}
