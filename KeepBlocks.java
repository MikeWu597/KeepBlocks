package com.mws.KeepBlocks;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class KeepBlocks
  extends JavaPlugin implements Listener
{  
  
  public FileConfiguration config = getConfig();
  public String KeptBlocks = config.getString("data");
  public void onEnable()
  {
    getLogger().info("已加载KeepBlocks插件_Build1");
    getServer().getPluginManager().registerEvents(new ListenerAPI(), this);
    
  }
  @Override
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	    if (cmd.getName().equalsIgnoreCase("keepit")) { // 如果玩家输入了/basic则执行如下内容...
	    // 所需要执行的事（此处略）
	    	KeptBlocks=config.getString("data");
	    	Player player= (Player) sender;
	    	String addition="\n"+player.getTargetBlockExact(3).getX()+','+player.getTargetBlockExact(3).getY()+','+player.getTargetBlockExact(3).getZ()+"\n";
	    	KeptBlocks=KeptBlocks+addition;
	    	config.set("data",KeptBlocks);
	    	saveConfig();
	    	//getLogger().info(Bukkit.getPluginManager().getPlugin(args[0]).getName());
	        return true;
	    } //如果以上内容成功执行，则返回true 
	    // 如果执行失败，则返回false.
	    if (cmd.getName().equalsIgnoreCase("unkeepit")) { // 如果玩家输入了/basic则执行如下内容...
		    // 所需要执行的事（此处略）
	    	KeptBlocks=config.getString("data");
		    Player player= (Player) sender;
		    String addition="\n"+player.getTargetBlockExact(3).getX()+','+player.getTargetBlockExact(3).getY()+','+player.getTargetBlockExact(3).getZ()+"\n";
		    KeptBlocks=KeptBlocks.replaceAll(addition, "");
		    config.set("data",KeptBlocks);
		    saveConfig();
		    return true;
		} //如果以上内容成功执行，则返回true 
		    // 如果执行失败，则返回false.
	    return false;
	}
  public void onDisable() {}
}