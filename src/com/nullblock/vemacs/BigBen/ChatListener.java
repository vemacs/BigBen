package com.nullblock.vemacs.BigBen;

import java.util.List;
import java.util.Random;

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
    	String prefix = plugin.getConfig().getString("prefix");
    	List<String> responselist = plugin.getConfig().getStringList("responses");
    	Random generator = new Random();
    	int i = generator.nextInt(responselist.size() - 1);
    	String eventMessage = event.getMessage().toLowerCase();
    	if(eventMessage.startsWith("bigben: ") && eventMessage.endsWith("??")){
            new Thread(new ChatThread(BongLib.textToColor(prefix), responselist.get(i))).start();
    	}
	}
}
