package me.jordan.AutoSave.Functions;

import org.bukkit.Bukkit;

public class SaveFunction {
	
	static String AutoSave = "save-all";

	public static void saveCommand() {
			Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), AutoSave);
		}
	}

