package me.kelopy.silkspawners.listeners;

import me.kelopy.silkspawners.SilkSpawners;
import me.kelopy.silkspawners.events.spawnerBreakEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class blockBreak implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e){
        Block blockBroken = e.getBlock();

        if (blockBroken.getType().equals(Material.MOB_SPAWNER) && e.getPlayer().getInventory().getItemInMainHand().containsEnchantment(Enchantment.SILK_TOUCH) && e.getPlayer().hasPermission("silkspawners.touch")) {
            Bukkit.getServer().getPluginManager().callEvent(new spawnerBreakEvent(e.getPlayer(), blockBroken));
        }else if(blockBroken.getType().equals(Material.MOB_SPAWNER) && e.getPlayer().getInventory().getItemInMainHand().containsEnchantment(Enchantment.SILK_TOUCH) && !(e.getPlayer().hasPermission("silkspawners.touch"))){
            e.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', SilkSpawners.getInstance().getConfig().getString("no-perm")));
        }

    }

}
