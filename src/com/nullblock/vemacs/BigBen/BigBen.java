package com.nullblock.vemacs.BigBen;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class BigBen extends JavaPlugin {
    @Override
    public void onEnable() {
    	  FileConfiguration config = this.getConfig();
    	  config.addDefault("prefix", "<&6BigBen&r>");
    	  config.options().copyDefaults(true);
    	  saveConfig();
          new Thread(new BongThread(BongLib.textToColor(BigBen.this.getConfig().getString("prefix")))).start();
          new Thread(new ConnectionThread()).start();
          new ChatListener(this);
    }
    @Override
    public void onDisable() {        
        
    }

}
