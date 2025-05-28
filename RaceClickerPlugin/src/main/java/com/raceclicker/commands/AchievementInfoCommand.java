package com.raceclicker.commands;

import com.raceclicker.RaceClickerPlugin;
import com.raceclicker.achievements.Achievement;
import com.raceclicker.player.PlayerData;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AchievementInfoCommand implements CommandExecutor {

    private final RaceClickerPlugin plugin;

    public AchievementInfoCommand(RaceClickerPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(RaceClickerPlugin.PREFIX + ChatColor.RED + "This command can only be run by a player.");
            return true;
        }

        if (args.length == 0) {
            sender.sendMessage(RaceClickerPlugin.PREFIX + ChatColor.RED + "Usage: /" + label + " <achievement_id>");
            return true;
        }

        Player player = (Player) sender;
        String achievementId = args[0].toLowerCase();
        Achievement achievement = plugin.getAchievementManager().getAchievement(achievementId);

        if (achievement == null) {
            player.sendMessage(RaceClickerPlugin.PREFIX + ChatColor.RED + "Achievement with ID '" + args[0] + "' not found.");
            return true;
        }

        PlayerData playerData = plugin.getPlayerDataManager().getPlayerData(player);
        boolean unlocked = playerData.hasAchievement(achievement.getId());
        int progress = playerData.getAchievementProgress(achievement.getId());
        int required = achievement.getProgressRequired();

        player.sendMessage(RaceClickerPlugin.PREFIX + ChatColor.GOLD + "--- Achievement Info: " + achievement.getName() + " ---");
        player.sendMessage(ChatColor.AQUA + "ID: " + achievement.getId());
        player.sendMessage(ChatColor.AQUA + "Description: " + achievement.getDescription());
        player.sendMessage(ChatColor.YELLOW + "Category: " + achievement.getCategory());
        player.sendMessage(ChatColor.YELLOW + "Level: " + achievement.getLevel());
        player.sendMessage(ChatColor.LIGHT_PURPLE + "Points: " + achievement.getPoints());
        player.sendMessage(ChatColor.GREEN + "Reward: " + achievement.getRewardValue() + " " + achievement.getRewardType());
        player.sendMessage(ChatColor.BLUE + "Progress: " + progress + "/" + required + (unlocked ? ChatColor.GREEN + " (Unlocked)" : ChatColor.GRAY + " (Locked)"));

        return true;
    }
}