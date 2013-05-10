package com.nullblock.vemacs.BigBen;

import org.bukkit.scheduler.BukkitTask;

public class BongThread implements Runnable {

	private String prefix;

	public BongThread(String prefix) {
		this.prefix = prefix;
	}

	public void run() {
		int hour = 0;
		for (;;) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
			if (BongLib.secondsUntilNextHour() == 0
					&& Integer
					.parseInt(BongLib.getTimeString().substring(0, 2)) != hour) {
				hour = Integer
						.parseInt(BongLib.getTimeString().substring(0, 2));
				String message = prefix + BongLib.bongText(hour);
				BukkitTask bongtask = new ChatRunnable(prefix, BongLib.bongText(hour))
				.runTask(BongLib.getBigBen());
			}
		}
	}
}
