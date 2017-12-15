package me.toxicmushroom.pixelhub;

import me.toxicmushroom.pixelhub.events.DropEvent;
import me.toxicmushroom.pixelhub.events.ItemClickEvent;
import me.toxicmushroom.pixelhub.events.JoinEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import sun.awt.Win32GraphicsConfig;

public class PixelHub extends JavaPlugin {

    private static PixelHub instace;
    public static PixelHub getInstace() {
        return instace;
    }

    @Override
    public void onEnable() {
        instace = this;
        Bukkit.getPluginManager().registerEvents(new JoinEvent(), this);
        Bukkit.getPluginManager().registerEvents(new DropEvent(), this);
        Bukkit.getPluginManager().registerEvents(new ItemClickEvent(), this);
        getLogger().info(ChatColor.GREEN + "-=Enabled=-");
    }
}
