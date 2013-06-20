package com.paulhroth;

import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDamageEvent;

public class LavaHandsListener implements Listener {
	
    public static LavaHandsPlugin plugin;
    
    public LavaHandsListener(LavaHandsPlugin instance) {
        plugin = instance;
    }
    
    @EventHandler
	public void onBlockDamage(BlockDamageEvent event) {
		Block block = event.getBlock();
		if (plugin.enabled(event.getPlayer())) {
            block.setTypeId(10);
		}
	}
}
