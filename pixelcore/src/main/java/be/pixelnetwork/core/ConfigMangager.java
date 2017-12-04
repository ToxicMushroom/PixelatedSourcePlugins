package be.pixelnetwork.core;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ConfigMangager {
    private Main plugin = Main.getInstance();
    static ConfigMangager pl;
    public static ConfigMangager getInstance() {
        return pl;
    }
    //Files and file configs
    public FileConfiguration settings;
    public File settingfile;
    public void setup() {
        if (!plugin.getDataFolder().exists()) {
            plugin.getDataFolder().mkdir();
        }
        pl = this;
        settingfile = new File(plugin.getDataFolder(), "settings.yml");
        if (!settingfile.exists()) {
            try{
                settingfile.createNewFile();

            }catch (IOException e){
                Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "Could not create settings.yml file!");
            }
        }

        settings = YamlConfiguration.loadConfiguration(settingfile);
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + " settings.yml is created.");
        settings.set("PixelCore.yt", "https://www.youtube.com/toxicmushroom");
        settings.set("PixelCore.site", "in maintenance");
        settings.set("PixelCore.twitter", "https://twitter.com/MiFoGaming");
        settings.set("PixelCore.discord", "https://discord.gg/SKWWzEU");
        saveSettings();
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + " settings.yml defaults have been set.");
    }

    public FileConfiguration getSettings() {
        return settings;
    }
    public void saveSettings() {
        try{
            settings.save(settingfile);
        } catch (IOException e) {
            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "Could not save the settings.yml file");
        }
    }
    public void reloadSettings() {
        settings = YamlConfiguration.loadConfiguration(settingfile);
    }

}
