//sleep the chat thread in order to get the response to appear after the message is sent

package com.nullblock.vemacs.BigBen;

import org.bukkit.Bukkit;

import com.google.code.chatterbotapi.ChatterBotSession;

public class ChatThread implements Runnable {

	private String prefix;
	private String input;
	private String player;
	private ChatterBotSession bot1session;
	
	public ChatThread(String prefix, String input, String player, ChatterBotSession bot1session){
		this.prefix = prefix;
		this.input = input;
		this.player = player;
		this.bot1session = bot1session;
	}
	
	public void run() {
		prefix = prefix + " ";
		String response = null; 
		try {        
	        response = bot1session.think(input).trim();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
		}
		response = response.replaceAll("(?i)zoe", "BigBen");
		response = BongLib.replaceAcutesHTML(response);
		response = BongLib.cleanUp(response);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
		}
		Bukkit.broadcastMessage(prefix + player + ": " + response);
		return;
	}
}
