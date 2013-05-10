package com.nullblock.vemacs.BigBen;

import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class BongThread extends BukkitRunnable {

	private String prefix;

	public BongThread(String prefix) {
		this.prefix = prefix;
	}

	public void run() {
		if (BongLib.secondsUntilNextHour() == 0) {
			int hour = Integer.parseInt(BongLib.getTimeString().substring(0, 2));
			BukkitTask bongtask = new ChatRunnable(prefix,
					BongLib.bongText(hour)).runTask(BongLib.getBigBen());
		}
	}
}
