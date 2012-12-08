package com.nullblock.vemacs.BigBen;

import org.bukkit.event.Listener;

public class BongListener implements Listener{
	private BigBen plugin;
	 
    public BongListener(BigBen BigBen) {
        plugin = BigBen;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        new Thread(new BongThread()).start();
     }
}