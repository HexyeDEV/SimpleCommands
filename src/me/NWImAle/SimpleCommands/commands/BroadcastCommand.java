package me.NWImAle.SimpleCommands.commands;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import me.NWImAle.SimpleCommands.utils.Utils;
	
	
public class BroadcastCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
	Player p = (Player) sender;
	
	Plugin plugin = Bukkit.getPluginManager().getPlugin("SimpleCommands");
	
	if (!(args.length == 0)) {
		if (p.hasPermission("simplecommands.bc")) {
			Bukkit.broadcastMessage(Utils.chat(plugin.getConfig().getString("bc_prefix") + " " + StringUtils.join(args, " ")));
			return true;
		} else {
			p.sendMessage("You are not allowed to execute this command.");
			return true;
		}
	
	} else {
		p.sendMessage("Please, specify a message to broadcast");
		return false;
	}
	
	}
	

}
