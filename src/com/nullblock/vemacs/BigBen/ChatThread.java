/*
 * An inelegant hack to get asyncplayerchatevent to broadcast the message after the player submits it
 */
package com.nullblock.vemacs.BigBen;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class ChatThread implements Runnable {

	@Override
	public void run() {
        String prefix = "<" + ChatColor.GOLD + "BigBen" + ChatColor.RESET + "> ";
        try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
		}
		Bukkit.broadcastMessage(prefix + "No.");
	}

}
