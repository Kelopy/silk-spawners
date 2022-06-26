package me.kelopy.silkspawners.listeners;

import me.kelopy.silkspawners.events.spawnerBreakEvent;
import org.bukkit.Material;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BlockStateMeta;

public class silkListener implements Listener {

    @EventHandler
    public void onSpawnerBreak(spawnerBreakEvent e){

        CreatureSpawner cs = (CreatureSpawner) e.getSpawner().getState();
        ItemStack spawner_give = new ItemStack(Material.MOB_SPAWNER);
        BlockStateMeta meta = (BlockStateMeta) spawner_give.getItemMeta();
        CreatureSpawner css = (CreatureSpawner) meta.getBlockState();

        css.setSpawnedType(cs.getSpawnedType());
        meta.setBlockState(css);
        spawner_give.setItemMeta(meta);

        e.getBreaker().getInventory().addItem(spawner_give);

    }

}
