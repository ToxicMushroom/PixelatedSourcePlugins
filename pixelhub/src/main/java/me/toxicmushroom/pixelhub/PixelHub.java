package me.toxicmushroom.pixelhub;

import me.toxicmushroom.pixelhub.dbs.MySQL;
import me.toxicmushroom.pixelhub.events.DropEvent;
import me.toxicmushroom.pixelhub.events.ItemClickEvent;
import me.toxicmushroom.pixelhub.events.JoinEvent;
import me.toxicmushroom.pixelhub.events.MoveEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import sun.awt.Win32GraphicsConfig;

public class PixelHub extends JavaPlugin {

    private static PixelHub instance;
    public static PixelHub getInstance() {
        return instance;
    }
    FileConfiguration config = getConfig();

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        MySQL mySQL = new MySQL();
        mySQL.connect();
        Bukkit.getPluginManager().registerEvents(new MoveEvent(), this);
        Bukkit.getPluginManager().registerEvents(new JoinEvent(), this);
        Bukkit.getPluginManager().registerEvents(new DropEvent(), this);
        Bukkit.getPluginManager().registerEvents(new ItemClickEvent(), this);
        getLogger().info(ChatColor.GREEN + "--------------");
        getLogger().info(ChatColor.GREEN + "-#------------");
        getLogger().info(ChatColor.GREEN + "-#------------");
        getLogger().info(ChatColor.GREEN + "-#------------");
        getLogger().info(ChatColor.GREEN + "-#######------");
        getLogger().info(ChatColor.GREEN + "-#-----#------");
        getLogger().info(ChatColor.GREEN + "-#######------");
        getLogger().info(ChatColor.GREEN + "-=Enabled=-");
    }
}
