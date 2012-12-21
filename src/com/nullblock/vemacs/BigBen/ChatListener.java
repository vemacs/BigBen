package com.nullblock.vemacs.BigBen;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.ChatColor;

public class ChatListener implements Listener{
	private BigBen plugin;
	 
    public ChatListener(BigBen BigBen) {
        plugin = BigBen;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerChat(AsyncPlayerChatEvent event) {
    	String prefix = plugin.getConfig().getString("prefix");
    	String eventMessage = event.getMessage().toLowerCase();
    	String player = ChatColor.stripColor(event.getPlayer().getDisplayName().replace("~", ""));
    	if(eventMessage.startsWith("bigben: ")){
            String message = eventMessage.substring(8, eventMessage.length());
    		if(message.toLowerCase().contains("bigben")){
    			message = message.toLowerCase();
    			message = message.replace("bigben", "cleverbot");
    		} 
    		event.setMessage(event.getMessage().replace("(?i)cleverbot", "BigBen"));
    		new Thread(new ChatThread(BongLib.textToColor(prefix), message, player)).start();
    	}
	}
}
