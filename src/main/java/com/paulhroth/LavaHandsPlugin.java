package com.paulhroth;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class LavaHandsPlugin extends JavaPlugin { 
  private final LavaHandsListener blockListener= new LavaHandsListener(); 
  @Override
  public void onDisable() {
    getLogger().info("[LavaHands] has been disabled.");
  }

  @Override
  public void onEnable() {
    PluginManager pm = getServer().getPluginManager();
    pm.registerEvents(blockListener, this);

    PluginDescriptionFile pdfFile = this.getDescription();
    getLogger().info( pdfFile.getName() + " version " + pdfFile.getVersion() + " is enabled." );
  }

}
