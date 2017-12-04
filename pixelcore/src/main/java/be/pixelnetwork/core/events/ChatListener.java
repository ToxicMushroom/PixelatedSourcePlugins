package be.pixelnetwork.core.events;

import be.pixelnetwork.core.Main;
import be.pixelnetwork.core.Helpers;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    public ChatListener(Main main) {
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        String f = e.getFormat();
        String format;
        String group = Main.getPermission().getPrimaryGroup(p);
        e.setMessage(Helpers.Colors(e.getMessage()));
        String prefix = Helpers.Colors(Main.getChat().getGroupPrefix(p.getWorld(), group));
        String suffix = Helpers.Colors(Main.getChat().getGroupSuffix(p.getWorld(), group));
        if (p.hasPermission(Helpers.perm + "rankchat")) {
            format = prefix + ChatColor.RESET + " " + p.getName() + "" + suffix + ChatColor.RESET + ": " + e.getMessage();
        } else {
            format = prefix + ChatColor.RESET + " " + p.getName() + "" + suffix + ChatColor.GRAY + ": " + e.getMessage();
        }
        e.setFormat(format);
    }
}
