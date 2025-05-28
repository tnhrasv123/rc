package com.raceclicker.player;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class PlayerData {
    private final UUID playerUUID;
    private long clicks;
    private int wins;
    private int prestigePoints;
    private int clickCoins;
    private final Set<String> unlockedAchievements;
    private final Map<String, Integer> achievementProgress;
    private final Map<String, Object> attributes; // For things like titles, speed_boost_active
    private final Map<String, Integer> shopItemLevels; // To store levels of purchased shop items
    private int achievementPoints;

    public PlayerData(UUID playerUUID) {
        this.playerUUID = playerUUID;
        this.clicks = 0;
        this.wins = 0;
        this.prestigePoints = 0;
        this.clickCoins = 0;
        this.unlockedAchievements = new HashSet<>();
        this.achievementProgress = new HashMap<>();
        this.attributes = new HashMap<>();
        this.shopItemLevels = new HashMap<>();
        this.achievementPoints = 0;
    }

    // Getters
    public UUID getPlayerUUID() {
        return playerUUID;
    }

    public long getClicks() {
        return clicks;
    }

    public int getWins() {
        return wins;
    }

    public int getPrestigePoints() {
        return prestigePoints;
    }

    public int getClickCoins() {
        return clickCoins;
    }

    public Set<String> getUnlockedAchievements() {
        return unlockedAchievements;
    }

    public Map<String, Integer> getAchievementProgress() {
        return achievementProgress;
    }

    public int getAchievementProgress(String achievementId) {
        return achievementProgress.getOrDefault(achievementId.toLowerCase(), 0);
    }

    public boolean hasAchievement(String achievementId) {
        return unlockedAchievements.contains(achievementId.toLowerCase());
    }

    public Object getAttribute(String key) {
        return attributes.get(key);
    }

    public Object getAttributeOrDefault(String key, Object defaultValue) {
        return attributes.getOrDefault(key, defaultValue);
    }

    public int getAchievementPoints() {
        return achievementPoints;
    }

    // Setters for loading data
    public void setClicks(long clicks) {
        this.clicks = clicks;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public void setPrestigePoints(int prestigePoints) {
        this.prestigePoints = prestigePoints;
    }

    public void setClickCoins(int clickCoins) {
        this.clickCoins = clickCoins;
    }

    public void setAchievementPoints(int achievementPoints) {
        this.achievementPoints = achievementPoints;
    }

    // Setters/Modifiers
    public void addClicks(long amount) {
        this.clicks += amount;
    }

    public void addWins(int amount) {
        this.wins += amount;
    }

    public void addPrestigePoints(int amount) {
        this.prestigePoints += amount;
    }

    public void addClickCoins(int amount) {
        this.clickCoins += amount;
    }

    public void removeClickCoins(int amount) {
        this.clickCoins = Math.max(0, this.clickCoins - amount);
    }

    public void unlockAchievement(String achievementId) {
        this.unlockedAchievements.add(achievementId.toLowerCase());
    }

    public void setAchievementProgress(String achievementId, int progress) {
        this.achievementProgress.put(achievementId.toLowerCase(), progress);
    }

    public void setAttribute(String key, Object value) {
        this.attributes.put(key, value);
    }

    public void addAchievementPoints(int points) {
        this.achievementPoints += points;
    }

    // Shop Item Level Management
    public int getShopItemLevel(String itemId) {
        return shopItemLevels.getOrDefault(itemId.toLowerCase(), 0);
    }

    public void incrementShopItemLevel(String itemId) {
        shopItemLevels.put(itemId.toLowerCase(), getShopItemLevel(itemId) + 1);
    }

    public Map<String, Integer> getShopItemLevels() {
        return shopItemLevels;
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    // You might want to add methods for loading/saving this data to a file/database
}