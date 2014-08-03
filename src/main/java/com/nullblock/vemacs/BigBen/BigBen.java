package com.nullblock.vemacs.bigben;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public final class BigBen extends JavaPlugin {
    private static String prefix;
    private static List<String> welcomes;
    private static BigBen instance;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        load();
        new BongThread().runTaskTimer(this, 0, 10);
        getServer().getPluginManager().registerEvents(new ChatListener(), this);
    }

    private void load() {
        prefix = getConfig().getString("prefix", "BigBen: ");
        prefix = ChatColor.translateAlternateColorCodes('&', prefix);
        welcomes = getConfig().getStringList("welcomes");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        load();
        reloadConfig();
        sender.sendMessage(ChatColor.GREEN + "BigBen has been reloaded.");
        return true;
    }

    public static List<String> getWelcomes() {
        return welcomes;
    }

    public static String getPrefix() {
        return prefix;
    }

    public static BigBen getInstance() {
        return instance;
    }
}
