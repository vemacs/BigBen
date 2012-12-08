package com.nullblock.vemacs.BigBen;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

public class BongListener implements Listener{
	private BigBen plugin;
	 
    public BongListener(BigBen BigBen) {
        plugin = BigBen;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        int nextHour = BongLib.nextHour();
        int waitTime = BongLib.secondsUntilNextHour();
        try {
            Thread.sleep(waitTime * 1000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        Bukkit.broadcastMessage(BongLib.bongText(nextHour));
        int hour = nextHour;
        for(;;){
            try {
                Thread.sleep(3600000);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            hour++;
            hour = hour % 12;
            Bukkit.broadcastMessage(BongLib.bongText(hour));
        }
    }

}