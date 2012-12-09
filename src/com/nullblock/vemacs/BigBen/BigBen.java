package com.nullblock.vemacs.BigBen;

import org.bukkit.plugin.java.JavaPlugin;

public final class BigBen extends JavaPlugin {
    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        this.getConfig().set("prefix", "<&6BigBen&r>");
        this.saveConfig();
        new Thread(new BongThread()).start();
        new ChatListener(this);

    }
    @Override
    public void onDisable() {        
        
    }

}
