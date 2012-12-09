package com.nullblock.vemacs.BigBen;

import org.bukkit.Bukkit;

public class BongThread implements Runnable {
	
	@Override
    public void run() {
		BigBen BigBen = new BigBen();
        String prefix = BigBen.getConfig().getString("prefix") + " " ;
        int nextHour = BongLib.nextHour();
        int waitTime = BongLib.secondsUntilNextHour();
        try {
            Thread.sleep(waitTime * 1000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        Bukkit.broadcastMessage(prefix + BongLib.bongText(nextHour));
        int hour = nextHour;
        for(;;){
            try {
                Thread.sleep(3600000);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            hour++;
            hour = hour % 12;
            Bukkit.broadcastMessage(prefix + BongLib.bongText(hour));
        }
    }
}
