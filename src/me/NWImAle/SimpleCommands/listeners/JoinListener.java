package me.NWImAle.SimpleCommands.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.NWImAle.SimpleCommands.Main;
import me.NWImAle.SimpleCommands.utils.Utils;

public class JoinListener implements Listener {
	
	private Main plugin;
	
	public JoinListener(Main plugin) {
		this.plugin = plugin;
		
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		
		if (! (p.hasPlayedBefore()) && (plugin.getConfig().getBoolean("firstJoin_broadcast") == true) ) {
			Bukkit.broadcastMessage(Utils.chat(plugin.getConfig().getString("firstJoin_message").replace("<player>", p.getName())));
		} else if ( (p.hasPlayedBefore()) && (plugin.getConfig().getBoolean("join_broadcast") == true ) ) {
			Bukkit.broadcastMessage(Utils.chat(plugin.getConfig().getString("join_message").replace("<player>", p.getName())));
		}
	}

}
