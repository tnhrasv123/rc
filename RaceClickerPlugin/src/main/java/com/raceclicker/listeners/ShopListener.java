package com.raceclicker.listeners;

import com.raceclicker.RaceClickerPlugin;
import com.raceclicker.shop.ShopItem;
import com.raceclicker.shop.ShopManager;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class ShopListener implements Listener {

    private final RaceClickerPlugin plugin;

    public ShopListener(RaceClickerPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (!(event.getWhoClicked() instanceof Player)) {
            return;
        }

        Player player = (Player) event.getWhoClicked();
        String inventoryTitle = event.getView().getTitle();

        if (inventoryTitle.equals(ShopManager.SHOP_TITLE)) {
            event.setCancelled(true); // Prevent taking items from the shop GUI

            ItemStack clickedItem = event.getCurrentItem();
            if (clickedItem == null || !clickedItem.hasItemMeta() || !clickedItem.getItemMeta().hasDisplayName()) {
                return;
            }

            // Try to identify the ShopItem based on material and display name
            // This is a basic way; a more robust method might involve NBT tags or a custom item identifier
            ShopItem shopItem = plugin.getShopManager().getShopItemByMaterial(clickedItem.getType(), clickedItem.getItemMeta().getDisplayName());

            if (shopItem != null) {
                plugin.getShopManager().handlePurchase(player, shopItem.getId());
            } else {
                // This might happen if the item is purely decorative or if the matching logic fails
                // player.sendMessage(RaceClickerPlugin.PREFIX + ChatColor.YELLOW + "Debug: Clicked on an item not recognized as a purchasable shop item.");
            }
        }
    }
}