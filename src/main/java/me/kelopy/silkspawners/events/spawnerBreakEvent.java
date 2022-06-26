package me.kelopy.silkspawners.events;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class spawnerBreakEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    Player breaker;
    Block spawner;

    public spawnerBreakEvent(Player breaker, Block spawner){
        this.breaker = breaker;
        this.spawner = spawner;
    }

    public Player getBreaker() {
        return breaker;
    }

    public Block getSpawner() {
        return spawner;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

}