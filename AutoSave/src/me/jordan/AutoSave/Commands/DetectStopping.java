package me.jordan.AutoSave.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import me.jordan.AutoSave.Main;

public abstract class DetectStopping implements CommandExecutor {
	private Main plugin;
	static String stop = "stop";
	static boolean Running = true;
	
	public void logic(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("astop").setExecutor(this);
		
	}

	public boolean onEnable( CommandSender sender, Command cmd,  String label, String[] args) {
		if((sender.hasPermission("autosave.start"))) {
			sender.sendMessage("Stopping the auto-save process");
			Running = false;
			//Bukkit.dispatchCommand(Bukkit.getConsoleSender(), stop);
		}
		else {
			Running = true;
		}
		return false;
	}
	
	public static void result() {
		if (Running == true) {
			StartSaving.stop(true);
		}
		else if (Running == false) {
			StartSaving.stop(false);
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), stop);
			System.exit(1);
			StartSaving.stop(false);
		}
	}
}
