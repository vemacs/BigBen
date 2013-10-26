package com.nullblock.vemacs.BigBen;

import com.google.code.chatterbotapi.ChatterBot;
import com.google.code.chatterbotapi.ChatterBotFactory;
import com.google.code.chatterbotapi.ChatterBotSession;
import com.google.code.chatterbotapi.ChatterBotType;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class ChatListener implements Listener {

    private BigBen plugin;
    private ChatterBotSession bot1session;

    public ChatListener(BigBen BigBen) {
        plugin = BigBen;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        ChatterBotFactory factory = new ChatterBotFactory();
        ChatterBot bot1;
        try {
            bot1 = factory.create(ChatterBotType.PANDORABOTS, "83e198ed1e345ab2");
            bot1session = bot1.createSession();
        } catch (Exception ignored) {
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        String prefix = plugin.getConfig().getString("prefix");
        String eventMessage = event.getMessage().toLowerCase();
        String player = ChatColor.stripColor(event.getPlayer().getDisplayName().replace("~", ""));
        if (eventMessage.startsWith("bigben: ")) {
            String message = eventMessage.substring(8, eventMessage.length());
            message = message.replace("(?i)bigben", "Zoe");
            plugin.getServer().getScheduler().runTaskAsynchronously(plugin,
                    new ChatThread(BongLib.textToColor(prefix), message, player, this.bot1session));
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (player.hasPlayedBefore()) {
            String playername = event.getPlayer().getName();
            String prefix = plugin.getConfig().getString("prefix");
            String response = null;
            int number = (int) (Math.random() * ((2) + 1));
            prefix = BongLib.textToColor(prefix);
            switch (number) {
                case 0:
                    response = "wb " + playername;
                    break;
                case 1:
                    response = "welcome back " + playername;
                    break;
                case 2:
                    response = "whalecum back " + playername;
                    break;
            }
            plugin.getServer().getScheduler().runTaskLater(plugin, new ChatRunnable(prefix, response), 3);
        }
    }

}