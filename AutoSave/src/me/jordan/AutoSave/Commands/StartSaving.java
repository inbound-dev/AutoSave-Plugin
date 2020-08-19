package me.jordan.AutoSave.Commands;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.jordan.AutoSave.Main;
import me.jordan.AutoSave.Functions.SaveFunction;

public class StartSaving implements CommandExecutor {
	@SuppressWarnings("unused")
	private Main plugin;
	
	String AutoSave = "save-all";
	
	static boolean running = true;

	public StartSaving(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("autosave").setExecutor(this);
		
	}
	public static void stop(boolean a) {
		running = a;
	}
	
	@Override
	public boolean onCommand( CommandSender sender, Command cmd,  String label, String[] args) {
		// TODO
		while(running == true) {
		if(!(sender instanceof Player)) {
			sender.sendMessage("Only Players may execute this command!");
			return true;
		}
		Player p = (Player) sender;
		ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
		
		if(p.hasPermission("autosave.start")) {
				try {
						
					int delayInMinutes = 10;
					p.sendMessage("saving!");
					executorService.scheduleAtFixedRate(SaveFunction::saveCommand, 0, 10 , TimeUnit.SECONDS);
					
				}
			catch(Exception e) {
				p.sendMessage("Timer Failed");
			}
		
			return true;
		}
		
		else {
			p.sendMessage("you do not have permission to execute this command!");
		}
		
		//return false;
		}
		return true;
	}

	
	
	
}
