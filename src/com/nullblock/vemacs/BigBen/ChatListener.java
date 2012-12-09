package com.nullblock.vemacs.BigBen;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener{
	private BigBen plugin;
	 
    public ChatListener(BigBen BigBen) {
        plugin = BigBen;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerChat(AsyncPlayerChatEvent event) {
    	String eventMessage = event.getMessage().toLowerCase();
    	if(eventMessage.startsWith("bigben: ") && eventMessage.endsWith("??")){
            new Thread(new ChatThread()).start();
    	}
	}
}
