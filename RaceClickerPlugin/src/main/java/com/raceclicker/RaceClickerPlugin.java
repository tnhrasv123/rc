package com.raceclicker;

import com.raceclicker.achievements.AchievementManager;
import com.raceclicker.commands.AchievementInfoCommand;
import com.raceclicker.commands.AchievementsCommand;
import com.raceclicker.commands.RCAdminCommand;
import com.raceclicker.commands.ShopCommand;
import com.raceclicker.listeners.PlayerClickListener;
import com.raceclicker.listeners.PlayerJoinListener;
import com.raceclicker.listeners.ShopListener;
import com.raceclicker.player.PlayerDataManager;
import com.raceclicker.listeners.PlayerQuitListener; // Added import
import com.raceclicker.shop.ShopManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class RaceClickerPlugin extends JavaPlugin {

    private static RaceClickerPlugin instance;
    private AchievementManager achievementManager;
    private PlayerDataManager playerDataManager;
    private ShopManager shopManager;

    public static final String PREFIX = ChatColor.translateAlternateColorCodes('&', "&6&lRaceClicker &8» ");

    @Override
    public void onEnable() {
        instance = this;
        this.playerDataManager = new PlayerDataManager(this);
        this.achievementManager = new AchievementManager(this);
        this.shopManager = new ShopManager(this);

        // Load configurations (if any)
        // For now, achievements are hardcoded in AchievementManager

        registerCommands();
        registerListeners();

        getLogger().info("RaceClicker plugin has been enabled!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        if (playerDataManager != null) {
            playerDataManager.saveAllPlayerData();
        }
        getLogger().info(ChatColor.RED + "RaceClicker has been disabled!");
        instance = null; // It was removed in a previous step, adding it back as it's good practice
    }

    private void registerCommands() {
        getCommand("achievements").setExecutor(new AchievementsCommand(this));
        getCommand("achievementinfo").setExecutor(new AchievementInfoCommand(this));
        getCommand("rcadmin").setExecutor(new RCAdminCommand(this));
        getCommand("shop").setExecutor(new ShopCommand(this));
        // Add other command registrations here
    }

    private void registerListeners() {
        Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(this), this);
        getServer().getPluginManager().registerEvents(new PlayerClickListener(this), this);
        getServer().getPluginManager().registerEvents(new PlayerQuitListener(this), this); // Added listener registration
        getServer().getPluginManager().registerEvents(new ShopListener(this), this);
        // Add other listener registrations here
    }

    public static RaceClickerPlugin getInstance() {
        return instance;
    }

    public AchievementManager getAchievementManager() {
        return achievementManager;
    }

    public PlayerDataManager getPlayerDataManager() {
        return playerDataManager;
    }

    public ShopManager getShopManager() {
        return shopManager;
    }
}