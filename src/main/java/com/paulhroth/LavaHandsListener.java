package com.paulhroth;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.World;

public class LavaHandsListener implements Listener {

    public static LavaHandsPlugin plugin;

    public LavaHandsListener(LavaHandsPlugin instance) {
        plugin = instance;
    }

    @EventHandler
    public void onBlockDamage(BlockDamageEvent event) {
        Block block = event.getBlock();
        Player player = event.getPlayer();
        World world = event.getPlayer().getWorld();
        if (plugin.enabled(player)) {
            int foodLevel = player.getFoodLevel();
            if (foodLevel >= 2) {
                player.setFoodLevel(foodLevel - 2);
                world.playSound(event.getPlayer().getLocation(),
                        Sound.GHAST_FIREBALL, 5.0f, 1.0f);
                block.setTypeId(10);
                player.sendMessage(ChatColor.RED + "Some of your energy has been consumed in the creation of your lava.");
            } else {
                player.sendMessage(ChatColor.DARK_RED + "You need to replenish your energy before creating lava.");
            }
        } 
    }

}
