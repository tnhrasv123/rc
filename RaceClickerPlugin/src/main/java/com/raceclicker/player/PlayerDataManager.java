package com.raceclicker.player;

import com.raceclicker.RaceClickerPlugin;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class PlayerDataManager {
    private final RaceClickerPlugin plugin;
    private final Map<UUID, PlayerData> playerDataMap = new HashMap<>();

    public PlayerDataManager(RaceClickerPlugin plugin) {
        this.plugin = plugin;
        // Ensure the playerdata directory exists
        File playerDataFolder = new File(plugin.getDataFolder(), "playerdata");
        if (!playerDataFolder.exists()) {
            playerDataFolder.mkdirs();
        }
    }

    public PlayerData getPlayerData(UUID playerUUID) {
        return playerDataMap.computeIfAbsent(playerUUID, PlayerData::new);
    }

    public PlayerData getPlayerData(Player player) {
        return getPlayerData(player.getUniqueId());
    }

    public void loadPlayerData(Player player) {
        UUID playerUUID = player.getUniqueId();
        File playerFile = new File(plugin.getDataFolder(), "playerdata" + File.separator + playerUUID.toString() + ".yml");
        PlayerData data = new PlayerData(playerUUID); // Create new data object first

        if (playerFile.exists()) {
            FileConfiguration playerConfig = YamlConfiguration.loadConfiguration(playerFile);
            data.setClicks(playerConfig.getLong("clicks", 0));
            data.setWins(playerConfig.getInt("wins", 0));
            data.setPrestigePoints(playerConfig.getInt("prestigePoints", 0));
            data.setClickCoins(playerConfig.getInt("clickCoins", 0));
            data.setAchievementPoints(playerConfig.getInt("achievementPoints", 0));

            List<String> unlocked = playerConfig.getStringList("unlockedAchievements");
            for (String achievementId : unlocked) {
                data.getUnlockedAchievements().add(achievementId.toLowerCase());
            }

            if (playerConfig.isConfigurationSection("achievementProgress")) {
                for (String achievementId : playerConfig.getConfigurationSection("achievementProgress").getKeys(false)) {
                    data.getAchievementProgress().put(achievementId.toLowerCase(), playerConfig.getInt("achievementProgress." + achievementId));
                }
            }

            if (playerConfig.isConfigurationSection("attributes")) {
                for (String key : playerConfig.getConfigurationSection("attributes").getKeys(false)) {
                    data.getAttributes().put(key, playerConfig.get("attributes." + key));
                }
            }

            if (playerConfig.isConfigurationSection("shopItemLevels")) {
                for (String itemId : playerConfig.getConfigurationSection("shopItemLevels").getKeys(false)) {
                    data.getShopItemLevels().put(itemId.toLowerCase(), playerConfig.getInt("shopItemLevels." + itemId));
                }
            }

            plugin.getLogger().info("Loaded data for player: " + player.getName() + " from file.");
        } else {
            plugin.getLogger().info("No data file found for " + player.getName() + ". Creating new data set.");
            // Save immediately to create the file for new players if desired, or wait for first save event
            // savePlayerDataToFile(data); // Optional: save new data immediately
        }
        playerDataMap.put(playerUUID, data);
    }

    public void savePlayerData(Player player) {
        PlayerData data = playerDataMap.get(player.getUniqueId());
        if (data != null) {
            savePlayerDataToFile(data, player.getName());
        }
    }

    private void savePlayerDataToFile(PlayerData data, String playerNameForLog) {
        File playerFile = new File(plugin.getDataFolder(), "playerdata" + File.separator + data.getPlayerUUID().toString() + ".yml");
        FileConfiguration playerConfig = YamlConfiguration.loadConfiguration(playerFile); // Load existing or create new

        playerConfig.set("name", playerNameForLog); // Store player name for easier identification in file
        playerConfig.set("clicks", data.getClicks());
        playerConfig.set("wins", data.getWins());
        playerConfig.set("prestigePoints", data.getPrestigePoints());
        playerConfig.set("clickCoins", data.getClickCoins());
        playerConfig.set("achievementPoints", data.getAchievementPoints());
        playerConfig.set("unlockedAchievements", new ArrayList<>(data.getUnlockedAchievements()));

        // Clear old progress before saving new, to handle removed entries if any
        playerConfig.set("achievementProgress", null);
        for (Map.Entry<String, Integer> entry : data.getAchievementProgress().entrySet()) {
            playerConfig.set("achievementProgress." + entry.getKey(), entry.getValue());
        }

        playerConfig.set("attributes", null);
        for (Map.Entry<String, Object> entry : data.getAttributes().entrySet()) {
            playerConfig.set("attributes." + entry.getKey(), entry.getValue());
        }

        playerConfig.set("shopItemLevels", null); // Clear old levels
        for (Map.Entry<String, Integer> entry : data.getShopItemLevels().entrySet()) {
            playerConfig.set("shopItemLevels." + entry.getKey(), entry.getValue());
        }

        try {
            playerConfig.save(playerFile);
            plugin.getLogger().info("Saved data for player: " + (playerNameForLog != null ? playerNameForLog : data.getPlayerUUID().toString()) + " to file.");
        } catch (IOException e) {
            plugin.getLogger().severe("Could not save data for player " + (playerNameForLog != null ? playerNameForLog : data.getPlayerUUID().toString()) + ": " + e.getMessage());
        }
    }

    public void saveAllPlayerData() {
        plugin.getLogger().info("Saving data for all online players...");
        for (UUID playerUUID : playerDataMap.keySet()) {
            PlayerData data = playerDataMap.get(playerUUID);
            if (data != null) {
                // Attempt to get player name if online, otherwise use UUID for logging
                Player onlinePlayer = plugin.getServer().getPlayer(playerUUID);
                String playerNameForLog = onlinePlayer != null ? onlinePlayer.getName() : playerUUID.toString();
                savePlayerDataToFile(data, playerNameForLog);
            }
        }
        plugin.getLogger().info("All online player data saving attempt complete.");
    }

    public boolean hasAchievement(UUID playerUUID, String achievementId) {
        return getPlayerData(playerUUID).hasAchievement(achievementId);
    }

    public void unlockAchievement(UUID playerUUID, String achievementId) {
        getPlayerData(playerUUID).unlockAchievement(achievementId);
    }

    public void addAchievementPoints(UUID playerUUID, int points) {
        getPlayerData(playerUUID).addAchievementPoints(points);
    }

    public int getAchievementPoints(UUID playerUUID) {
        return getPlayerData(playerUUID).getAchievementPoints();
    }

    public void addClickCoins(UUID playerUUID, int amount) {
        getPlayerData(playerUUID).addClickCoins(amount);
    }

    public int getClickCoins(UUID playerUUID) {
        return getPlayerData(playerUUID).getClickCoins();
    }

    public void removeClickCoins(UUID playerUUID, int amount) {
        getPlayerData(playerUUID).removeClickCoins(amount);
    }

    public void setPlayerAttribute(UUID playerUUID, String key, Object value) {
        getPlayerData(playerUUID).setAttribute(key, value);
    }

    public Object getPlayerAttribute(UUID playerUUID, String key) {
        return getPlayerData(playerUUID).getAttribute(key);
    }

    public int getAchievementProgress(UUID playerUUID, String achievementId) {
        return getPlayerData(playerUUID).getAchievementProgress(achievementId);
    }

    public void setAchievementProgress(UUID playerUUID, String achievementId, int progress) {
        getPlayerData(playerUUID).setAchievementProgress(achievementId, progress);
    }

    public void addClicks(UUID playerUUID, long amount) {
        getPlayerData(playerUUID).addClicks(amount);
    }

    public long getClicks(UUID playerUUID) {
        return getPlayerData(playerUUID).getClicks();
    }

    public void addWins(UUID playerUUID, int amount) {
        getPlayerData(playerUUID).addWins(amount);
    }

    public int getWins(UUID playerUUID) {
        return getPlayerData(playerUUID).getWins();
    }

     public void addPrestigePoints(UUID playerUUID, int amount) {
        getPlayerData(playerUUID).addPrestigePoints(amount);
    }

    public int getPrestigePoints(UUID playerUUID) {
        return getPlayerData(playerUUID).getPrestigePoints();
    }
}