//sleep the chat thread in order to get the response to appear after the message is sent

package com.nullblock.vemacs.BigBen;

import org.bukkit.Bukkit;

public class ChatThread implements Runnable {

	private String prefix;
	private String msg;
	private Responder responser;
	
	public ChatThread(String prefix, Responder responder, String eventMessage) {
		this.prefix = prefix;
		this.responser = responder;
		this.msg = eventMessage;
	}
	
	@Override
	public void run() {
		prefix = prefix + " ";
        try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
		}
        
		Bukkit.broadcastMessage(prefix + responser.getResponse(msg));
		return;
	}
}
