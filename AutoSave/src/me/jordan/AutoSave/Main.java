package me.jordan.AutoSave;

import org.bukkit.plugin.java.JavaPlugin;

import me.jordan.AutoSave.Commands.StartSaving;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		new StartSaving(this);
	}
}
