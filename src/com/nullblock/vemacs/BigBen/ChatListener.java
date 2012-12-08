package com.nullblock.vemacs.BigBen;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
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
    @EventHandler(priority = EventPriority.LOW)
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        String prefix = "<" + ChatColor.GOLD + "BigBen" + ChatColor.RESET + ">";
    	String eventMessage = event.getMessage().toLowerCase();
    	if(eventMessage.startsWith("bigben: ") && eventMessage.endsWith("??")){
    		Bukkit.broadcastMessage(prefix + "No.");
    	}
	}
}
