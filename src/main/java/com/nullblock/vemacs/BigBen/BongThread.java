package com.nullblock.vemacs.BigBen;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class BongThread extends BukkitRunnable {

    private String prefix;

    public BongThread(String prefix) {
        this.prefix = prefix;
    }

    public void run() {
        int currentHour = Integer.parseInt(BongLib.getTimeString().substring(0, 2));
        if (BongLib.secondsUntilNextHour() == 0 && currentHour != BigBen.hour) {
            BigBen.hour = currentHour;
            Bukkit.getScheduler().runTask(BongLib.getBigBen(), new ChatRunnable(prefix, BongLib.bongText(BigBen.hour)));
        }
    }

}

