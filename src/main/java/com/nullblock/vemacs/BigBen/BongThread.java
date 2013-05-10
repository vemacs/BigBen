package com.nullblock.vemacs.BigBen;

import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class BongThread extends BukkitRunnable {

	private String prefix;

	public BongThread(String prefix) {
		this.prefix = prefix;
	}

	public void run() {
		int hour = Integer.parseInt(BongLib.getTimeString().substring(0, 2));
		if (BongLib.secondsUntilNextHour() == 0 && hour != BigBen.lasthour) {
			prefix = BongLib.textToColor(prefix);
			BukkitTask bongtask = new ChatRunnable(prefix,
					BongLib.bongText(hour)).runTask(BongLib.getBigBen());
			BigBen.lasthour = hour;
		}
	}
}
