package com.nullblock.vemacs.bigben;

import com.google.code.chatterbotapi.ChatterBotSession;
import org.bukkit.scheduler.BukkitRunnable;

public class ChatThread extends BukkitRunnable {
    private String input;
    private String player;
    private ChatterBotSession bot1session;

    public ChatThread(String input, String player,
                      ChatterBotSession bot1session) {
        this.input = input;
        this.player = player;
        this.bot1session = bot1session;
    }

    @Override
    public void run() {
        String response = null;
        try {
            response = bot1session.think(input).trim();
        } catch (Exception ignored) {
        }
        assert response != null;
        response = response.replaceAll("(?i)cleverbot", "BigBen");
        response = BongLib.replaceAcutesHTML(response);
        response = BongLib.cleanUp(response);
        String message = player + ": " + response;
        new ChatRunnable(message).runTaskLater(BigBen.getInstance(), 10);
    }
}
