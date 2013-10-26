package com.nullblock.vemacs.BigBen;

import com.google.code.chatterbotapi.ChatterBotSession;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public class ChatThread extends BukkitRunnable {

    private String prefix;
    private String input;
    private String player;
    private ChatterBotSession bot1session;

    public ChatThread(String prefix, String input, String player,
                      ChatterBotSession bot1session) {
        this.prefix = prefix;
        this.input = input;
        this.player = player;
        this.bot1session = bot1session;
    }

    public void run() {
        String response = null;
        try {
            response = bot1session.think(input).trim();
        } catch (Exception ignored) {
        }
        assert response != null;
        response = response.replaceAll("(?i)zoe", "BigBen");
        response = BongLib.replaceAcutesHTML(response);
        response = BongLib.cleanUp(response);
        String message = player + ": " + response;
        Plugin bigBen = BongLib.getBigBen();
        bigBen.getServer().getScheduler().runTaskLater(bigBen, new ChatRunnable(prefix, message), 10);
    }

}
