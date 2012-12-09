//sleep the chat thread in order to get the response to appear after the message is sent

package com.nullblock.vemacs.BigBen;

import org.bukkit.Bukkit;

public class ChatThread implements Runnable {

	private String prefix;
	private String response;
	
	public ChatThread(String prefix, String response){
		this.prefix = prefix;
		this.response = response;
	}
	
	@Override
	public void run() {
		prefix = prefix + " ";
        try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
		}
		Bukkit.broadcastMessage(prefix + response);
		return;
	}
}
