package me.toxicmushroom.pixelhub;

import me.toxicmushroom.pixelhub.events.DropEvent;
import me.toxicmushroom.pixelhub.events.ItemClickEvent;
import me.toxicmushroom.pixelhub.events.JoinEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class PixelHub extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new JoinEvent(), this);
        Bukkit.getPluginManager().registerEvents(new DropEvent(), this);
        Bukkit.getPluginManager().registerEvents(new ItemClickEvent(), this);
        getLogger().info("-=Enabled=-");
    }
}
