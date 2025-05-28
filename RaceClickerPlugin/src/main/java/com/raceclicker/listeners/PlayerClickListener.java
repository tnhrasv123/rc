package com.raceclicker.listeners;

import com.raceclicker.RaceClickerPlugin;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerClickListener implements Listener {

    private final RaceClickerPlugin plugin;

    public PlayerClickListener(RaceClickerPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        // Check for right-click action, similar to Skript's `on rightclick:`
        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            // Calculate clicks to add, incorporating click power bonus
            double clickPowerBonus = (double) plugin.getPlayerDataManager().getPlayerData(player).getAttributeOrDefault("click_power_bonus", 0.0);
            long clicksToAdd = 1 + (long)clickPowerBonus;

            // Increment player's click count
            plugin.getPlayerDataManager().addClicks(player.getUniqueId(), clicksToAdd);

            // Update click-related achievements
            // The Skript had {clicks.%player%} for tracking clicks.
            // We'll use the PlayerData's click count.
            long totalClicks = plugin.getPlayerDataManager().getPlayerData(player).getClicks();
            plugin.getAchievementManager().updateAchievementProgress(player, "click_master", 1); // Progress is 1 click

            // Potentially update other achievements like combo or accuracy if they were based on simple clicks
            // For example, if 'accuracy_perfect' was just about making X clicks without missing (not well defined in Skript)
            // plugin.getAchievementManager().updateAchievementProgress(player, "accuracy_perfect", 1);

            // The Skript also had a general click sound and particle effect.
            // player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
            // player.spawnParticle(Particle.CRIT, player.getLocation().add(0, 1, 0), 5);
        }
    }
}