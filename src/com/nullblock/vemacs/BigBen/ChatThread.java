/*
 * An inelegant hack to get asyncplayerchatevent to broadcast the message after the player submits it
 */
package com.nullblock.vemacs.BigBen;

import org.bukkit.Bukkit;

public class ChatThread implements Runnable {

	private String prefix;
	
	public ChatThread(String prefix){
		this.prefix = prefix;
	}
	
	@Override
	public void run() {
		prefix = prefix + " ";
		Bukkit.broadcastMessage(prefix);
        try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
		}
        double random = Math.random();
        if(random < 0.5){
        Bukkit.broadcastMessage(prefix + "No.");
        }
        if(random >= 0.5){
        Bukkit.broadcastMessage(prefix + "Yes.");
        }
        return;
	}
}
