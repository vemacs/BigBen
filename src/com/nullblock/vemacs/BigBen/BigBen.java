package com.nullblock.vemacs.BigBen;

import org.bukkit.plugin.java.JavaPlugin;

public final class BigBen extends JavaPlugin {
    @Override
    public void onEnable() {
        new BongListener(this);
        new ChatListener(this);
    }
    @Override
    public void onDisable() {        
        
    }

}
