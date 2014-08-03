package com.nullblock.vemacs.bigben;

import com.google.code.chatterbotapi.ChatterBot;
import com.google.code.chatterbotapi.ChatterBotFactory;
import com.google.code.chatterbotapi.ChatterBotSession;
import com.google.code.chatterbotapi.ChatterBotType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.List;
import java.util.Random;

public class ChatListener implements Listener {
    private ChatterBotSession bot1session;
    private Random random;

    public ChatListener() {
        ChatterBotFactory factory = new ChatterBotFactory();
        random = new Random();
        ChatterBot bot1;
        try {
            bot1 = factory.create(ChatterBotType.PANDORABOTS, "83e198ed1e345ab2");
            bot1session = bot1.createSession();
        } catch (Exception ignored) {
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        String eventMessage = event.getMessage().toLowerCase();
        String player = event.getPlayer().getName();
        if (eventMessage.startsWith("bigben: ")) {
            String message = eventMessage.substring(8, eventMessage.length());
            message = message.replace("(?i)bigben", "Zoe");
            new ChatThread(message, player, this.bot1session)
                .runTaskAsynchronously(BigBen.getInstance());
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (player.hasPlayedBefore()) {
            String playername = event.getPlayer().getName();
            List<String> welcomes = BigBen.getWelcomes();
            String response = welcomes.get(random.nextInt(welcomes.size())) + " " + playername;
            new ChatRunnable(response).runTaskLater(BigBen.getInstance(), 3);
        }
    }

}