package com.paulhroth;

import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDamageEvent;
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
		if (plugin.enabled(event.getPlayer())) {
		    World world = event.getPlayer().getWorld();
		    world.playSound(event.getPlayer().getLocation(), Sound.GHAST_FIREBALL, 10f, 1.0f);
		    block.setTypeId(10);
		}
	}
}
