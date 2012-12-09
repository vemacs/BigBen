package com.nullblock.vemacs.BigBen;

import org.bukkit.Bukkit;

public class BongThread implements Runnable {
	
	private String prefix;
	
	public BongThread(String prefix){
		this.prefix = prefix;
	}
	
	@Override
    public void run() {
		prefix = prefix + " ";
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
                Thread.sleep(3590000);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            try {
				Thread.sleep(BongLib.secondsUntilNextHour() * 1000);
			} catch (InterruptedException e) {
                Thread.currentThread().interrupt();
			}
            hour++;
            hour = hour % 12;
            Bukkit.broadcastMessage(prefix + BongLib.bongText(hour));
        }
    }
}
