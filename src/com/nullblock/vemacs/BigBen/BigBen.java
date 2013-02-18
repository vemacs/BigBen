package com.nullblock.vemacs.BigBen;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import com.google.code.chatterbotapi.ChatterBot;
import com.google.code.chatterbotapi.ChatterBotFactory;
import com.google.code.chatterbotapi.ChatterBotSession;
import com.google.code.chatterbotapi.ChatterBotType;

public final class BigBen extends JavaPlugin {
	
    public static ChatterBotSession bot1session;
    
	@Override
    public void onEnable() {
    	  FileConfiguration config = this.getConfig();
    	  config.addDefault("prefix", "<&6BigBen&r>");
    	  config.options().copyDefaults(true);
    	  saveConfig();
          new Thread(new BongThread(BongLib.textToColor(BigBen.this.getConfig().getString("prefix")))).start();
          new ChatListener(this);
          ChatterBotFactory factory = new ChatterBotFactory();
          ChatterBot bot1;
          try {
			bot1 = factory.create(ChatterBotType.CLEVERBOT);
		    ChatterBotSession bot1session = bot1.createSession();
		} catch (Exception e) {
		}
    }
    @Override
    public void onDisable() {        
        
    }

}
