package com.nullblock.vemacs.BigBen;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

public final class BigBen extends JavaPlugin {
	
	public static int lasthour = -1;

	@Override
	public void onEnable() {
		FileConfiguration config = this.getConfig();
		config.addDefault("prefix", "<&6BigBen&r>");
		config.options().copyDefaults(true);
		saveConfig();
		BukkitTask bong = new BongThread(config.getString("prefix")).runTaskTimer(BongLib
				.getBigBen(), 0, 10);
		new ChatListener(this);
	}

	@Override
	public void onDisable() {

	}

}
