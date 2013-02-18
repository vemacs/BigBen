//sleep the chat thread in order to get the response to appear after the message is sent

package com.nullblock.vemacs.BigBen;

import org.bukkit.Bukkit;

import com.google.code.chatterbotapi.ChatterBot;
import com.google.code.chatterbotapi.ChatterBotFactory;
import com.google.code.chatterbotapi.ChatterBotSession;
import com.google.code.chatterbotapi.ChatterBotType;

public class ChatThread implements Runnable {

	private String prefix;
	private String input;
	private String player;
	
	public ChatThread(String prefix, String input, String player){
		this.prefix = prefix;
		this.input = input;
		this.player = player;
	}
	
	@Override
	public void run() {
		prefix = prefix + " ";
		String response = null; 
		try {        
	        response = BigBen.bot1session.think(input);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
		}
		response = response.replaceAll("(?i)cleverbot", "BigBen");
		Bukkit.broadcastMessage(prefix + player + ": " + response);
		return;
	}
}
