package com.raceclicker.achievements;

import com.raceclicker.RaceClickerPlugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class AchievementManager {

    private final RaceClickerPlugin plugin;
    private final Map<String, Achievement> achievements = new HashMap<>();

    public AchievementManager(RaceClickerPlugin plugin) {
        this.plugin = plugin;
        initializeAchievements();
    }

    private void initializeAchievements() {
        // Racing Achievements
        registerAchievement("first_race", "First Race", "Complete your first race", "Racing", "Bronze", 10, "ClickCoins", 1, 1);
        registerAchievement("race_winner", "Race Winner", "Win your first race", "Racing", "Silver", 25, "ClickCoins", 1, 1);
        registerAchievement("track_master", "Track Master", "Complete all tracks", "Racing", "Gold", 50, "ClickCoins", 10, 10); // Assuming 10 tracks
        registerAchievement("speed_demon", "Speed Demon", "Reach 1000 speed multiplier", "Racing", "Platinum", 100, "Speed Boost", 1000, 1000);

        // Clicking Achievements
        registerAchievement("click_master", "Click Master", "Reach 1,000,000 clicks", "Clicking", "Silver", 50, "ClickCoins", 1000, 1000000);
        registerAchievement("combo_king", "Combo King", "Achieve 1000x combo multiplier", "Clicking", "Gold", 75, "ClickCoins", 2500, 1000);
        registerAchievement("accuracy_perfect", "Perfect Accuracy", "Achieve 100% accuracy", "Clicking", "Diamond", 150, "Power Boost", 1500, 100); // Assuming 100 means 100%

        // Social Achievements
        registerAchievement("friendship", "Friendship", "Add 10 friends", "Social", "Bronze", 20, "ClickCoins", 500, 10);
        registerAchievement("guild_master", "Guild Master", "Create a guild", "Social", "Silver", 30, "ClickCoins", 1000, 1);
        registerAchievement("guild_hero", "Guild Hero", "Reach guild rank 10", "Social", "Gold", 100, "Prestige Points", 50, 10);

        // Economy Achievements
        registerAchievement("rich_man", "Rich Man", "Reach 1,000,000 ClickCoins", "Economy", "Gold", 100, "ClickCoins", 5000, 1000000);
        registerAchievement("market_master", "Market Master", "Complete 100 market transactions", "Economy", "Platinum", 150, "ClickCoins", 10000, 100);
        registerAchievement("investor", "Investor", "Reach 1000% market profit", "Economy", "Diamond", 200, "Prestige Points", 100, 1000); // Assuming 1000 means 1000%
    }

    public void registerAchievement(String id, String name, String description, String category, String level, int points, String rewardType, Object rewardValue, int progressRequired) {
        Achievement achievement = new Achievement(id, name, description, category, level, points, rewardType, rewardValue, progressRequired);
        achievements.put(id.toLowerCase(), achievement);
    }

    public Achievement getAchievement(String id) {
        return achievements.get(id.toLowerCase());
    }

    public Map<String, Achievement> getAllAchievements() {
        return achievements;
    }

    public void checkAndUnlockAchievement(Player player, String achievementId, int currentProgress) {
        Achievement achievement = getAchievement(achievementId);
        if (achievement == null) return;

        UUID playerUUID = player.getUniqueId();
        if (plugin.getPlayerDataManager().hasAchievement(playerUUID, achievementId)) return; // Already unlocked

        if (currentProgress >= achievement.getProgressRequired()) {
            plugin.getPlayerDataManager().unlockAchievement(playerUUID, achievementId);
            plugin.getPlayerDataManager().addAchievementPoints(playerUUID, achievement.getPoints());

            // Give reward
            giveReward(player, achievement);

            // Notify player
            player.sendMessage(RaceClickerPlugin.PREFIX + ChatColor.GOLD + "Achievement Unlocked: " + achievement.getName());
            player.sendMessage(RaceClickerPlugin.PREFIX + ChatColor.YELLOW + "Description: " + achievement.getDescription());
            player.sendMessage(RaceClickerPlugin.PREFIX + ChatColor.GREEN + "Reward: " + achievement.getRewardValue() + " " + achievement.getRewardType());

            // Broadcast achievement
            Bukkit.broadcastMessage(RaceClickerPlugin.PREFIX + ChatColor.GOLD + player.getName() + " unlocked achievement: " + achievement.getName());
            // Consider adding a permission check for broadcasting if desired, like in the Skript
        }
    }

    private void giveReward(Player player, Achievement achievement) {
        UUID playerUUID = player.getUniqueId();
        switch (achievement.getRewardType()) {
            case "ClickCoins":
                plugin.getPlayerDataManager().addClickCoins(playerUUID, (Integer) achievement.getRewardValue());
                break;
            case "Speed Boost":
                // This would typically modify a player's temporary or permanent speed attribute
                // For now, let's assume it's a conceptual flag or a timed effect managed elsewhere
                plugin.getPlayerDataManager().setPlayerAttribute(playerUUID, "speed_boost_active", true);
                player.sendMessage(RaceClickerPlugin.PREFIX + ChatColor.AQUA + "You feel faster!");
                break;
            case "Power Boost":
                plugin.getPlayerDataManager().setPlayerAttribute(playerUUID, "power_boost_active", true);
                player.sendMessage(RaceClickerPlugin.PREFIX + ChatColor.RED + "You feel more powerful!");
                break;
            case "Prestige Points":
                plugin.getPlayerDataManager().addPrestigePoints(playerUUID, (Integer) achievement.getRewardValue());
                break;
            case "Title":
                // This would integrate with a chat formatting plugin or a custom title system
                // For now, we'll just store it as a player attribute
                plugin.getPlayerDataManager().setPlayerAttribute(playerUUID, "title", achievement.getRewardValue().toString());
                player.sendMessage(RaceClickerPlugin.PREFIX + ChatColor.LIGHT_PURPLE + "You have earned the title: " + achievement.getRewardValue().toString());
                break;
            // Custom Item case would require more complex logic to create and give an ItemStack
        }
    }

    public void updateAchievementProgress(Player player, String achievementId, int progressAmount) {
        Achievement achievement = getAchievement(achievementId);
        if (achievement == null) {
            plugin.getLogger().warning("Attempted to update progress for non-existent achievement: " + achievementId);
            return;
        }

        UUID playerUUID = player.getUniqueId();
        if (plugin.getPlayerDataManager().hasAchievement(playerUUID, achievementId)) return; // Already unlocked

        int newProgress = plugin.getPlayerDataManager().getAchievementProgress(playerUUID, achievementId) + progressAmount;
        plugin.getPlayerDataManager().setAchievementProgress(playerUUID, achievementId, newProgress);
        checkAndUnlockAchievement(player, achievementId, newProgress);
    }
}