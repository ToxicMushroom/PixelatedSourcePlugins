package me.toxicmushroom.pixelhub;

import org.bukkit.ChatColor;

import java.util.HashMap;

public class Helper {

    public static HashMap<String, Double> time = new HashMap<>();
    public static String perm = "PixelNetwork.";
    public static String prefix = "&f[&b&lP&6&lS&f]";
    public static String Colors(String tocolorize) {
        return ChatColor.translateAlternateColorCodes('&', tocolorize);
    }
}
