package com.nullblock.vemacs.BigBen;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import com.google.code.chatterbotapi.ChatterBot;
import com.google.code.chatterbotapi.ChatterBotFactory;
import com.google.code.chatterbotapi.ChatterBotSession;
import com.google.code.chatterbotapi.ChatterBotType;

public final class BigBen extends JavaPlugin {
	   
	@Override
    public void onEnable() {
    	  FileConfiguration config = this.getConfig();
    	  config.addDefault("prefix", "<&6BigBen&r>");
    	  config.options().copyDefaults(true);
    	  saveConfig();
          new Thread(new BongThread(BongLib.textToColor(BigBen.this.getConfig().getString("prefix")))).start();
          new ChatListener(this);
    }
    @Override
    public void onDisable() {        
        
    }

}
