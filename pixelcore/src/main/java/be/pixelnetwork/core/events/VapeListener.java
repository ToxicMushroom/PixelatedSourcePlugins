package be.pixelnetwork.core.events;

import be.pixelnetwork.core.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.messaging.PluginMessageListener;

public class VapeListener implements Listener, PluginMessageListener {
    public VapeListener(Main main) {
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        event.getPlayer().sendMessage("§8 §8 §1 §3 §3 §7 §8 ");
    }

    public void onPluginMessageReceived(String channel, Player p, byte[] data) {
        String bandata;
        try {
            bandata = new String(data);
        } catch (Exception ex) {
            bandata = "";
        }
        if (bandata.equalsIgnoreCase("")) return;
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "bc " + p.getName() + " :D another one. niger down we'll get them next time");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "ban " + p.getPlayer().getName() + " I don't know.");
    }

}
