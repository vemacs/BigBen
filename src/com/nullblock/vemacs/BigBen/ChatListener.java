package com.nullblock.vemacs.BigBen;

import org.bukkit.event.Listener;

public class ChatListener implements Listener{
	private BigBen plugin;
	 
    public ChatListener(BigBen BigBen) {
        plugin = BigBen;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

}
