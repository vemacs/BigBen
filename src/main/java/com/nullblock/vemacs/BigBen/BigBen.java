package com.nullblock.vemacs.BigBen;

import org.bukkit.plugin.java.JavaPlugin;

public final class BigBen extends JavaPlugin {

    public static int hour;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        hour = -1;
        this.getServer().getScheduler().runTaskTimerAsynchronously(this,
                new BongThread(BongLib.textToColor(getConfig().getString("prefix"))), 0, 10);
        new ChatListener(this);
    }

    @Override
    public void onDisable() {

    }

}
