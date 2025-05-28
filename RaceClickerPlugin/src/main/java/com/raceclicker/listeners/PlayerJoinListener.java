package com.raceclicker.listeners;

import com.raceclicker.RaceClickerPlugin;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    private final RaceClickerPlugin plugin;

    public PlayerJoinListener(RaceClickerPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        plugin.getPlayerDataManager().loadPlayerData(player);

        // Send welcome messages
        player.sendMessage(RaceClickerPlugin.PREFIX + ChatColor.GREEN + "Welcome to RaceClicker, " + player.getName() + "!");
        player.sendMessage(RaceClickerPlugin.PREFIX + ChatColor.YELLOW + "Type /rc help for a list of commands.");

        // Update achievements (e.g., for joining the first time, if such an achievement exists)
        // plugin.getAchievementManager().updateAchievementProgress(player, "first_join", 1);
    }
}