package com.nullblock.vemacs.bigben;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class ChatRunnable extends BukkitRunnable {
    String message;

    public ChatRunnable(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        Bukkit.broadcastMessage(BigBen.getPrefix() + " " + message);
    }
}
