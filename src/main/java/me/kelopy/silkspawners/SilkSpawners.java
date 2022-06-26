package me.kelopy.silkspawners;

import me.kelopy.silkspawners.listeners.blockBreak;
import me.kelopy.silkspawners.listeners.silkListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class SilkSpawners extends JavaPlugin {

    private static SilkSpawners instance;

    @Override
    public void onEnable() {
        System.out.println("Silks Spawners are now available!");

        getConfig().options().copyDefaults();
        saveDefaultConfig();
        instance = this;

        getServer().getPluginManager().registerEvents(new blockBreak(), this);
        getServer().getPluginManager().registerEvents(new silkListener(), this);
    }

    public static SilkSpawners getInstance(){
        return instance;
    }

}
