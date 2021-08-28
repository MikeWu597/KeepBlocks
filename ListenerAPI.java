package com.mws.KeepBlocks;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class ListenerAPI implements Listener{
	String data=null;
	@EventHandler
	  public void onBreak(BlockBreakEvent bpe)
	  {
		String data=null;
		data=Bukkit.getPluginManager().getPlugin("KeepBlocks").getConfig().saveToString();
		String addition=bpe.getBlock().getX()+","+bpe.getBlock().getY()+","+bpe.getBlock().getZ();
		Bukkit.getLogger().info(addition);
		if (data.contains(addition))
		{
			bpe.setCancelled(true);
		}
		data=null;
	  }
}
