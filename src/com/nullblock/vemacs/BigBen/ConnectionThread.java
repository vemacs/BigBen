//sleep the chat thread in order to get the response to appear after the message is sent

package com.nullblock.vemacs.BigBen;

import org.bukkit.Bukkit;

import com.google.code.chatterbotapi.ChatterBot;
import com.google.code.chatterbotapi.ChatterBotFactory;
import com.google.code.chatterbotapi.ChatterBotSession;
import com.google.code.chatterbotapi.ChatterBotType;

public class ConnectionThread implements Runnable {

	public static ChatterBotSession bot1session;
	
	public ConnectionThread(){
	}
	
	@Override
	public void run() {
		try {        
			ChatterBotFactory factory = new ChatterBotFactory();
			ChatterBot bot1;
			bot1 = factory.create(ChatterBotType.CLEVERBOT);
	        ChatterBotSession bot1session = bot1.createSession();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
		}
	}
}
