package com.nullblock.vemacs.BigBen;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitTask;

import com.google.code.chatterbotapi.ChatterBotSession;

public class ChatThread implements Runnable {

	private String prefix;
	private String input;
	private String player;
	private ChatterBotSession bot1session;

	public ChatThread(String prefix, String input, String player,
			ChatterBotSession bot1session) {
		this.prefix = prefix;
		this.input = input;
		this.player = player;
		this.bot1session = bot1session;
	}

	public void run() {
		String response = null;
		try {
			response = bot1session.think(input).trim();
		} catch (Exception e1) {
		}
		response = response.replaceAll("(?i)zoe", "BigBen");
		response = BongLib.replaceAcutesHTML(response);
		response = BongLib.cleanUp(response);
		String message = player + ": " + response;
		BukkitTask responsetask = new ChatRunnable(prefix, message).runTaskLater(BongLib
				.getBigBen(), 10);
	}
}
