package com.paulhroth;

import java.util.ArrayList;
import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class LavaHandsPlugin extends JavaPlugin { 
  private final LavaHandsListener blockListener= new LavaHandsListener(this); 
  public final ArrayList<Player> LavaHandsUsers = new ArrayList<Player>();
  private static final Logger logger = Logger.getLogger("Minecraft");
  
  @Override
  public void onEnable() {
    logger.info("[LavaHands] enabled.");
    PluginManager pm = getServer().getPluginManager();
    pm.registerEvents(blockListener, this);

    PluginDescriptionFile pdfFile = this.getDescription();
    getLogger().info( pdfFile.getName() + " version " + pdfFile.getVersion() + " is enabled." );
  }
  
  @Override
  public void onDisable() {
    logger.info("[LavaHands] disabled.");
  }
  
  @Override
  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
      if (cmd.getName().equalsIgnoreCase("LavaHands"));
          toggleLavaHands(sender);
      
      return true;
  }
  
  private void toggleLavaHands(CommandSender sender) {
      if ( !enabled((Player) sender) ) {
          LavaHandsUsers.add((Player) sender);
          ((Player) sender).sendMessage(ChatColor.RED + "LavaHands fired up!");
      } else {
          LavaHandsUsers.remove((Player) sender);
          ((Player) sender).sendMessage(ChatColor.BLUE + "LavaHands cooled off.");
      }
  }
  
  public boolean enabled (Player player) {
      return LavaHandsUsers.contains(player);
  }
  
  public Logger getLavaHandsLogger() {
      return logger;
  }

}
