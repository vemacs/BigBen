package com.nullblock.vemacs.BigBen;

import java.util.Arrays;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class BigBen extends JavaPlugin {
    @Override
    public void onEnable() {
    	  FileConfiguration config = this.getConfig();
    	  config.addDefault("prefix", "<&6BigBen&r>");
    	  String[] responselist = {"Definitely.", "Absolutely not.", "Ask again later.", "Install Gentoo.", "Do you even lift?", "Don't count on it.", "Indeed."};
    	  this.getConfig().set("responses", Arrays.asList(responselist));
    	  config.options().copyDefaults(true);
    	  saveConfig();
          new Thread(new BongThread(BongLib.textToColor(BigBen.this.getConfig().getString("prefix")))).start();
          new ChatListener(this);

    }
    @Override
    public void onDisable() {        
        
    }

}
