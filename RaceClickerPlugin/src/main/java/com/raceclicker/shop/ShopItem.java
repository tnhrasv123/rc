package com.raceclicker.shop;

import org.bukkit.Material;

import java.util.List;

public class ShopItem {
    private final String id;
    private final String displayName;
    private final Material material;
    private final List<String> lore;
    private final int cost;
    private final String effectType; // e.g., "CLICK_POWER_INCREASE", "SPEED_BOOST_DURATION"
    private final double effectValue;
    private final int maxLevel; // For upgradable items

    public ShopItem(String id, String displayName, Material material, List<String> lore, int cost, String effectType, double effectValue, int maxLevel) {
        this.id = id;
        this.displayName = displayName;
        this.material = material;
        this.lore = lore;
        this.cost = cost; // This could be the base cost for level 1
        this.effectType = effectType;
        this.effectValue = effectValue; // e.g., +1 click power, +5 seconds duration
        this.maxLevel = maxLevel;
    }

    public String getId() {
        return id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public Material getMaterial() {
        return material;
    }

    public List<String> getLore() {
        return lore;
    }

    public int getCost() {
        return cost;
    }

    public String getEffectType() {
        return effectType;
    }

    public double getEffectValue() {
        return effectValue;
    }

    public int getMaxLevel() {
        return maxLevel;
    }

    // Placeholder for cost calculation for upgradable items
    public int getCostForLevel(int currentLevel) {
        if (currentLevel >= maxLevel) {
            return Integer.MAX_VALUE; // Cannot upgrade further
        }
        // Example: cost increases by 50% per level (compounded)
        return (int) (cost * Math.pow(1.5, currentLevel));
    }
}