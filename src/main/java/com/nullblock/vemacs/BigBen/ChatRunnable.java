package com.nullblock.vemacs.BigBen;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class ChatRunnable extends BukkitRunnable {
	
	String message;
	String prefix;
	
	public ChatRunnable(String prefix, String message) {
		this.message = message;
		this.prefix = prefix;
	}

	public void run() {
		prefix = prefix + " ";
		Bukkit.broadcastMessage(prefix + message);
	}
}
