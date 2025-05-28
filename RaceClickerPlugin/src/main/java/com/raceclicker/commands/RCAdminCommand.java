package com.raceclicker.commands;

import com.raceclicker.RaceClickerPlugin;
import com.raceclicker.achievements.Achievement;
import com.raceclicker.player.PlayerDataManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class RCAdminCommand implements CommandExecutor {

    private final RaceClickerPlugin plugin;
    private final PlayerDataManager playerDataManager;

    public RCAdminCommand(RaceClickerPlugin plugin) {
        this.plugin = plugin;
        this.playerDataManager = plugin.getPlayerDataManager();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("raceclicker.admin")) {
            sender.sendMessage(RaceClickerPlugin.PREFIX + ChatColor.RED + "You do not have permission to use this command.");
            return true;
        }

        if (args.length < 2) {
            sendHelpMessage(sender, label);
            return true;
        }

        String subCommand = args[0].toLowerCase();
        OfflinePlayer targetPlayer = Bukkit.getOfflinePlayer(args[1]);
        UUID targetUUID = targetPlayer.getUniqueId();

        if (!targetPlayer.hasPlayedBefore() && !targetPlayer.isOnline()) {
            sender.sendMessage(RaceClickerPlugin.PREFIX + ChatColor.RED + "Player " + args[1] + " not found or has never played.");
            return true;
        }

        switch (subCommand) {
            case "giveclicks":
                if (args.length < 3) {
                    sender.sendMessage(RaceClickerPlugin.PREFIX + ChatColor.RED + "Usage: /" + label + " giveclicks <player> <amount>");
                    return true;
                }
                try {
                    long amount = Long.parseLong(args[2]);
                    playerDataManager.addClicks(targetUUID, amount);
                    sender.sendMessage(RaceClickerPlugin.PREFIX + ChatColor.GREEN + "Gave " + amount + " clicks to " + targetPlayer.getName() + ".");
                    if (targetPlayer.isOnline()) {
                        ((Player)targetPlayer).sendMessage(RaceClickerPlugin.PREFIX + ChatColor.GREEN + "You received " + amount + " clicks from an admin.");
                    }
                } catch (NumberFormatException e) {
                    sender.sendMessage(RaceClickerPlugin.PREFIX + ChatColor.RED + "Invalid amount.");
                }
                break;
            case "givewins":
                if (args.length < 3) {
                    sender.sendMessage(RaceClickerPlugin.PREFIX + ChatColor.RED + "Usage: /" + label + " givewins <player> <amount>");
                    return true;
                }
                try {
                    int amount = Integer.parseInt(args[2]);
                    playerDataManager.addWins(targetUUID, amount);
                    sender.sendMessage(RaceClickerPlugin.PREFIX + ChatColor.GREEN + "Gave " + amount + " wins to " + targetPlayer.getName() + ".");
                     if (targetPlayer.isOnline()) {
                        ((Player)targetPlayer).sendMessage(RaceClickerPlugin.PREFIX + ChatColor.GREEN + "You received " + amount + " wins from an admin.");
                    }
                } catch (NumberFormatException e) {
                    sender.sendMessage(RaceClickerPlugin.PREFIX + ChatColor.RED + "Invalid amount.");
                }
                break;
            case "giveprestige":
                if (args.length < 3) {
                    sender.sendMessage(RaceClickerPlugin.PREFIX + ChatColor.RED + "Usage: /" + label + " giveprestige <player> <amount>");
                    return true;
                }
                try {
                    int amount = Integer.parseInt(args[2]);
                    playerDataManager.addPrestigePoints(targetUUID, amount);
                    sender.sendMessage(RaceClickerPlugin.PREFIX + ChatColor.GREEN + "Gave " + amount + " prestige points to " + targetPlayer.getName() + ".");
                    if (targetPlayer.isOnline()) {
                        ((Player)targetPlayer).sendMessage(RaceClickerPlugin.PREFIX + ChatColor.GREEN + "You received " + amount + " prestige points from an admin.");
                    }
                } catch (NumberFormatException e) {
                    sender.sendMessage(RaceClickerPlugin.PREFIX + ChatColor.RED + "Invalid amount.");
                }
                break;
            case "giveclickcoins":
                if (args.length < 3) {
                    sender.sendMessage(RaceClickerPlugin.PREFIX + ChatColor.RED + "Usage: /" + label + " giveclickcoins <player> <amount>");
                    return true;
                }
                try {
                    int amount = Integer.parseInt(args[2]);
                    playerDataManager.addClickCoins(targetUUID, amount);
                    sender.sendMessage(RaceClickerPlugin.PREFIX + ChatColor.GREEN + "Gave " + amount + " ClickCoins to " + targetPlayer.getName() + ".");
                    if (targetPlayer.isOnline()) {
                        ((Player)targetPlayer).sendMessage(RaceClickerPlugin.PREFIX + ChatColor.GREEN + "You received " + amount + " ClickCoins from an admin.");
                    }
                } catch (NumberFormatException e) {
                    sender.sendMessage(RaceClickerPlugin.PREFIX + ChatColor.RED + "Invalid amount.");
                }
                break;
            case "resetachievements":
                // This would require clearing specific data in PlayerData
                // For simplicity, let's assume it means resetting all achievement progress and unlocked status
                playerDataManager.getPlayerData(targetUUID).getUnlockedAchievements().clear();
                playerDataManager.getPlayerData(targetUUID).getAchievementProgress().clear();
                // playerDataManager.getPlayerData(targetUUID).setAchievementPoints(0); // Reset points too if desired
                sender.sendMessage(RaceClickerPlugin.PREFIX + ChatColor.GREEN + "Reset achievements for " + targetPlayer.getName() + ".");
                if (targetPlayer.isOnline()) {
                        ((Player)targetPlayer).sendMessage(RaceClickerPlugin.PREFIX + ChatColor.YELLOW + "Your achievements have been reset by an admin.");
                    }
                break;
            case "unlockachievement":
                if (args.length < 3) {
                    sender.sendMessage(RaceClickerPlugin.PREFIX + ChatColor.RED + "Usage: /" + label + " unlockachievement <player> <achievement_id>");
                    return true;
                }
                String achievementIdToUnlock = args[2].toLowerCase();
                Achievement achievementToUnlock = plugin.getAchievementManager().getAchievement(achievementIdToUnlock);
                if (achievementToUnlock == null) {
                    sender.sendMessage(RaceClickerPlugin.PREFIX + ChatColor.RED + "Achievement '" + args[2] + "' not found.");
                    return true;
                }
                playerDataManager.unlockAchievement(targetUUID, achievementIdToUnlock);
                playerDataManager.addAchievementPoints(targetUUID, achievementToUnlock.getPoints()); // Grant points for manual unlock
                sender.sendMessage(RaceClickerPlugin.PREFIX + ChatColor.GREEN + "Unlocked achievement '" + achievementToUnlock.getName() + "' for " + targetPlayer.getName() + ".");
                 if (targetPlayer.isOnline()) {
                        ((Player)targetPlayer).sendMessage(RaceClickerPlugin.PREFIX + ChatColor.GREEN + "Achievement '"+ achievementToUnlock.getName() +"' has been unlocked for you by an admin.");
                    }
                break;
            default:
                sendHelpMessage(sender, label);
                break;
        }
        return true;
    }

    private void sendHelpMessage(CommandSender sender, String label) {
        sender.sendMessage(RaceClickerPlugin.PREFIX + ChatColor.GOLD + "--- RCAdmin Help ---");
        sender.sendMessage(ChatColor.YELLOW + "/" + label + " giveclicks <player> <amount>");
        sender.sendMessage(ChatColor.YELLOW + "/" + label + " givewins <player> <amount>");
        sender.sendMessage(ChatColor.YELLOW + "/" + label + " giveprestige <player> <amount>");
        sender.sendMessage(ChatColor.YELLOW + "/" + label + " giveclickcoins <player> <amount>");
        sender.sendMessage(ChatColor.YELLOW + "/" + label + " resetachievements <player>");
        sender.sendMessage(ChatColor.YELLOW + "/" + label + " unlockachievement <player> <achievement_id>");
    }
}