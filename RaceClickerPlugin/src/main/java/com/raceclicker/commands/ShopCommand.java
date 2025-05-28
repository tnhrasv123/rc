package com.raceclicker.commands;

import com.raceclicker.RaceClickerPlugin;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ShopCommand implements CommandExecutor {

    private final RaceClickerPlugin plugin;

    public ShopCommand(RaceClickerPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(RaceClickerPlugin.PREFIX + ChatColor.RED + "This command can only be run by a player.");
            return true;
        }

        Player player = (Player) sender;
        player.openInventory(plugin.getShopManager().getShopGUI(player));
        player.sendMessage(RaceClickerPlugin.PREFIX + ChatColor.GREEN + "Opening the shop...");
        return true;
    }
}