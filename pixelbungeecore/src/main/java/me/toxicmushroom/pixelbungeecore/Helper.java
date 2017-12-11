package me.toxicmushroom.pixelbungeecore;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.connection.ProxiedPlayer;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class Helper {

    public static String permission = "PixelNetwork";
    private static HashMap<UUID, UUID> conversations = new HashMap();
    public static String prefix = "&f[&b&lP&6&lS&f]";
    public static BaseComponent[] Colors(String colorize) {
        return new ComponentBuilder(ChatColor.translateAlternateColorCodes('&', colorize)).create();
    }
    public static void msg(ProxiedPlayer paramProxiedPlayer1, ProxiedPlayer paramProxiedPlayer2, String paramString) {
        paramProxiedPlayer2.sendMessage(Helper.Colors("&7[&a" + paramProxiedPlayer1.getName() + " &7-> &aYou&7] " + paramString));
        paramProxiedPlayer1.sendMessage(Helper.Colors("&7[&aYou &7-> &a" + paramProxiedPlayer2.getName() + "&7] " + paramString));
        conversations.put(paramProxiedPlayer1.getUniqueId(), paramProxiedPlayer2.getUniqueId());
        conversations.put(paramProxiedPlayer2.getUniqueId(), paramProxiedPlayer1.getUniqueId());
    }
    public static ProxiedPlayer getConversation(ProxiedPlayer paramProxiedPlayer) {
        if (!conversations.containsKey(paramProxiedPlayer.getUniqueId())) {
            return null;
        }
        return ProxyServer.getInstance().getPlayer(conversations.get(paramProxiedPlayer.getUniqueId()));
    }
    public static HashMap<String, String> staffGroupNames = new HashMap<>();
    public static void initstaffGroups() {
        List<String> staffgrouplist = Config.configuration.getStringList("staffgroupnames");
        for (String s : staffgrouplist) {
            if (Config.configuration.getString("staffgroupcolors." + s) != null)
                staffGroupNames.put(s, Config.configuration.getString("staffgroupcolors." + s));
            else PixelCore.getInstance().getLogger().info("error: code-69");
        }
    }
}
