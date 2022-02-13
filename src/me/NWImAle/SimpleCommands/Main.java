package me.NWImAle.SimpleCommands;

import org.bukkit.plugin.java.JavaPlugin;

import me.NWImAle.SimpleCommands.commands.BroadcastCommand;
import me.NWImAle.SimpleCommands.commands.HealCommand;
import me.NWImAle.SimpleCommands.commands.InventoryCommand;
import me.NWImAle.SimpleCommands.commands.ReloadCommand;
import me.NWImAle.SimpleCommands.listeners.JoinListener;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		System.out.println("SimpleCommands Succesfully Enables");
		
		saveDefaultConfig();
		
		new JoinListener(this);
		this.getCommand("screload").setExecutor(new ReloadCommand());
		this.getCommand("scping");
		this.getCommand("scbc").setExecutor(new BroadcastCommand());
		this.getCommand("scheal").setExecutor(new HealCommand());
		this.getCommand("scinventory").setExecutor(new InventoryCommand());
	}
	
	@Override
	public void onDisable() {
		System.out.println("SimpleCommands Succesfully Disabled.");
	}
	
}
