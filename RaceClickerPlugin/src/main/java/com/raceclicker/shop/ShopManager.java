package com.raceclicker.shop;

import com.raceclicker.RaceClickerPlugin;
import com.raceclicker.player.PlayerData;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ShopManager {
    private final RaceClickerPlugin plugin;
    private final Map<String, ShopItem> shopItems = new LinkedHashMap<>(); // LinkedHashMap to maintain order
    public static final String SHOP_TITLE = ChatColor.DARK_GREEN + "RaceClicker Shop";

    public ShopManager(RaceClickerPlugin plugin) {
        this.plugin = plugin;
        initializeShopItems();
    }

    private void initializeShopItems() {
        // Example items - these would ideally be loaded from a config file
        shopItems.put("click_power_1", new ShopItem(
                "click_power_1",
                ChatColor.GOLD + "Click Power I",
                Material.IRON_SWORD,
                Arrays.asList(ChatColor.GRAY + "Increases clicks per action by 1.", ChatColor.YELLOW + "Cost: 100 ClickCoins"),
                100,
                "CLICK_POWER_INCREASE",
                1.0,
                5 // Max level for this specific upgrade path
        ));

        shopItems.put("auto_clicker_1", new ShopItem(
                "auto_clicker_1",
                ChatColor.AQUA + "Auto Clicker I",
                Material.CLOCK,
                Arrays.asList(ChatColor.GRAY + "Generates 1 click per second.", ChatColor.YELLOW + "Cost: 500 ClickCoins"),
                500,
                "AUTO_CLICK_RATE",
                1.0, // 1 click per second
                3
        ));

        shopItems.put("speed_boost_duration_1", new ShopItem(
                "speed_boost_duration_1",
                ChatColor.LIGHT_PURPLE + "Speed Boost Extender I",
                Material.FEATHER,
                Arrays.asList(ChatColor.GRAY + "Increases Speed Boost duration by 5s.", ChatColor.YELLOW + "Cost: 250 ClickCoins"),
                250,
                "SPEED_BOOST_DURATION_INCREASE",
                5.0, // +5 seconds
                5
        ));
        // Add more items here
    }

    public Inventory getShopGUI(Player player) {
        Inventory shopInventory = plugin.getServer().createInventory(null, 27, SHOP_TITLE); // 3 rows for now
        PlayerData playerData = plugin.getPlayerDataManager().getPlayerData(player);

        int slot = 0;
        for (ShopItem item : shopItems.values()) {
            if (slot >= shopInventory.getSize()) break; // Prevent overflow

            int currentLevel = playerData.getShopItemLevel(item.getId());
            int cost = item.getCostForLevel(currentLevel);
            boolean maxLevelReached = currentLevel >= item.getMaxLevel();

            ItemStack itemStack = new ItemStack(item.getMaterial());
            ItemMeta itemMeta = itemStack.getItemMeta();
            itemMeta.setDisplayName(item.getDisplayName() + (item.getMaxLevel() > 1 ? " (Level " + (currentLevel + 1) + "/" + item.getMaxLevel() + ")" : ""));

            List<String> lore = new ArrayList<>(item.getLore());
            lore.add("");
            if (maxLevelReached) {
                lore.add(ChatColor.RED + "Max Level Reached!");
            } else {
                lore.add(ChatColor.GREEN + "Cost: " + cost + " ClickCoins");
                lore.add(ChatColor.YELLOW + "Click to purchase/upgrade!");
            }
            lore.add(ChatColor.GRAY + "Current Level: " + currentLevel);

            itemMeta.setLore(lore);
            itemStack.setItemMeta(itemMeta);
            shopInventory.setItem(slot++, itemStack);
        }
        return shopInventory;
    }

    public void handlePurchase(Player player, String itemId) {
        ShopItem item = shopItems.get(itemId);
        if (item == null) {
            player.sendMessage(RaceClickerPlugin.PREFIX + ChatColor.RED + "Invalid shop item selected.");
            return;
        }

        PlayerData playerData = plugin.getPlayerDataManager().getPlayerData(player);
        int currentLevel = playerData.getShopItemLevel(itemId);

        if (currentLevel >= item.getMaxLevel()) {
            player.sendMessage(RaceClickerPlugin.PREFIX + ChatColor.RED + "This item is already at its maximum level!");
            return;
        }

        int cost = item.getCostForLevel(currentLevel);
        if (playerData.getClickCoins() < cost) {
            player.sendMessage(RaceClickerPlugin.PREFIX + ChatColor.RED + "You don't have enough ClickCoins! You need " + cost + ".");
            return;
        }

        plugin.getPlayerDataManager().removeClickCoins(player.getUniqueId(), cost);
        playerData.incrementShopItemLevel(itemId);
        applyItemEffect(player, item, currentLevel + 1);

        player.sendMessage(RaceClickerPlugin.PREFIX + ChatColor.GREEN + "You purchased/upgraded " + item.getDisplayName() + " to Level " + (currentLevel + 1) + "!");
        player.closeInventory(); // Close and reopen to refresh item costs/levels
        player.openInventory(getShopGUI(player));
    }

    private void applyItemEffect(Player player, ShopItem item, int newLevel) {
        PlayerData playerData = plugin.getPlayerDataManager().getPlayerData(player);
        // This is where you'd update player stats based on the item's effectType and effectValue
        // For example, if effectType is "CLICK_POWER_INCREASE", update a clickPower attribute in PlayerData
        // This might involve adding new fields to PlayerData or using the existing 'attributes' map.

        switch (item.getEffectType()) {
            case "CLICK_POWER_INCREASE":
                // Assuming PlayerData has a method like addClickPowerMultiplier or similar
                // For now, let's store it as an attribute. Each level adds to the base.
                double currentClickPower = (double) playerData.getAttributeOrDefault("click_power_bonus", 0.0);
                playerData.setAttribute("click_power_bonus", currentClickPower + item.getEffectValue());
                player.sendMessage(RaceClickerPlugin.PREFIX + ChatColor.AQUA + "Your click power has increased!");
                break;
            case "AUTO_CLICK_RATE":
                double currentAutoClickRate = (double) playerData.getAttributeOrDefault("auto_click_rate", 0.0);
                playerData.setAttribute("auto_click_rate", currentAutoClickRate + item.getEffectValue());
                player.sendMessage(RaceClickerPlugin.PREFIX + ChatColor.AQUA + "Your auto-clicker is now faster!");
                // You'd need a separate task to handle auto-clicking based on this rate.
                break;
            case "SPEED_BOOST_DURATION_INCREASE":
                double currentSpeedBoostDuration = (double) playerData.getAttributeOrDefault("speed_boost_duration_bonus", 0.0);
                playerData.setAttribute("speed_boost_duration_bonus", currentSpeedBoostDuration + item.getEffectValue());
                player.sendMessage(RaceClickerPlugin.PREFIX + ChatColor.AQUA + "Your speed boosts will last longer!");
                break;
            // Add more cases for other effect types
        }
    }

    public ShopItem getShopItemByMaterial(Material material, String displayName) {
        for (ShopItem item : shopItems.values()) {
            // A more robust check might involve custom NBT tags on items if display names can change due to levels
            if (item.getMaterial() == material && item.getDisplayName().startsWith(ChatColor.stripColor(displayName).split(" (Level")[0])) {
                return item;
            }
        }
        return null;
    }
}