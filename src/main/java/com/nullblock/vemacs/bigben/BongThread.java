package com.nullblock.vemacs.bigben;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class BongThread extends BukkitRunnable {
    private int hour = -1;

    @Override
    public void run() {
        int currentHour = Integer.parseInt(BongLib.getTimeString().substring(0, 2));
        if (BongLib.secondsUntilNextHour() == 0 && currentHour != hour) {
            hour = currentHour;
            Bukkit.getScheduler().runTask(
                    BigBen.getInstance(),
                    new ChatRunnable(BongLib.bongText(hour)));
        }
    }
}

