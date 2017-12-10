package me.toxicmushroom.pixelbungeecore;

import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

public class Config {
    public static Configuration configuration;

    public static void setup() {
        if (!PixelCore.getInstance().getDataFolder().exists()) PixelCore.getInstance().getDataFolder().mkdir();
        File file = new File(PixelCore.getInstance().getDataFolder(), "config.yml");
        if (!file.exists()) {
            try (InputStream in = PixelCore.getInstance().getResourceAsStream("config.yml")) {
                Files.copy(in, file.toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            configuration = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
            saveConfig();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveConfig() {
        try {
            ConfigurationProvider.getProvider(YamlConfiguration.class).save(configuration, new File(PixelCore.getInstance().getDataFolder(), "config.yml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
