package com.nullblock.vemacs.BigBen;

import org.bukkit.Bukkit;

public class BongThread implements Runnable {
	
	private String prefix;
	
	public BongThread(String prefix){
		this.prefix = prefix;
	}
	
	public void run() {
		prefix = prefix + " ";
		int hour = 0;
        for(;;){
        	try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
        	if(BongLib.secondsUntilNextHour() == 0 && Integer.parseInt(BongLib.getTimeString().substring(0,2)) != hour){
        	hour = Integer.parseInt(BongLib.getTimeString().substring(0,2));
            Bukkit.broadcastMessage(prefix + BongLib.bongText(hour));
        }
    }
}
}
