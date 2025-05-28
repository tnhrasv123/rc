package com.raceclicker.commands;

import com.raceclicker.RaceClickerPlugin;
import com.raceclicker.achievements.Achievement;
import com.raceclicker.player.PlayerData;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Map;

public class AchievementsCommand implements CommandExecutor {

    private final RaceClickerPlugin plugin;

    public AchievementsCommand(RaceClickerPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(RaceClickerPlugin.PREFIX + ChatColor.RED + "This command can only be run by a player.");
            return true;
        }

        Player player = (Player) sender;
        PlayerData playerData = plugin.getPlayerDataManager().getPlayerData(player);

        player.sendMessage(RaceClickerPlugin.PREFIX + ChatColor.GOLD + "--- Your Achievements ---");

        Map<String, Achievement> allAchievements = plugin.getAchievementManager().getAllAchievements();

        if (allAchievements.isEmpty()) {
            player.sendMessage(RaceClickerPlugin.PREFIX + ChatColor.YELLOW + "No achievements are currently available.");
            return true;
        }

        for (Achievement achievement : allAchievements.values()) {
            boolean unlocked = playerData.hasAchievement(achievement.getId());
            int progress = playerData.getAchievementProgress(achievement.getId());
            int required = achievement.getProgressRequired();

            ChatColor statusColor = unlocked ? ChatColor.GREEN : ChatColor.GRAY;
            String status = unlocked ? " (Unlocked)" : " (" + progress + "/" + required + ")";

            player.sendMessage(statusColor + "- " + achievement.getName() + status);
            player.sendMessage(ChatColor.AQUA + "  Description: " + achievement.getDescription());
            player.sendMessage(ChatColor.YELLOW + "  Category: " + achievement.getCategory() + " | Level: " + achievement.getLevel());
            player.sendMessage(ChatColor.LIGHT_PURPLE + "  Points: " + achievement.getPoints());
            if (unlocked) {
                player.sendMessage(ChatColor.GREEN + "  Reward: " + achievement.getRewardValue() + " " + achievement.getRewardType());
            }
        }
        player.sendMessage(RaceClickerPlugin.PREFIX + ChatColor.GOLD + "Total Achievement Points: " + playerData.getAchievementPoints());
        return true;
    }
}