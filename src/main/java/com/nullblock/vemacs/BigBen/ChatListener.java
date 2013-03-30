package com.nullblock.vemacs.BigBen;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.google.code.chatterbotapi.ChatterBot;
import com.google.code.chatterbotapi.ChatterBotFactory;
import com.google.code.chatterbotapi.ChatterBotSession;
import com.google.code.chatterbotapi.ChatterBotType;

public class ChatListener implements Listener{
	private BigBen plugin;
	private ChatterBotSession bot1session;
	 
    public ChatListener(BigBen BigBen) {
        plugin = BigBen;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        ChatterBotFactory factory = new ChatterBotFactory();
        ChatterBot bot1;
		try {
			bot1 = factory.create(ChatterBotType.PANDORABOTS, "d179a7ed2e35eaed");
			bot1session = bot1.createSession();
		} catch (Exception e1) {
		}
    }
    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerChat(AsyncPlayerChatEvent event) {
    	String prefix = plugin.getConfig().getString("prefix");
    	String eventMessage = event.getMessage().toLowerCase();
    	String player = ChatColor.stripColor(event.getPlayer().getDisplayName().replace("~", ""));
    	if(eventMessage.startsWith("bigben: ")){
            String message = eventMessage.substring(8, eventMessage.length());
    			message = message.replace("(?i)bigben", "Nickie");
    		new Thread(new ChatThread(BongLib.textToColor(prefix), message, player, this.bot1session)).start();
    	}
	}
}
