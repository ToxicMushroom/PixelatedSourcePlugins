package be.pixelnetwork.core.events;

import be.pixelnetwork.core.Main;
import be.pixelnetwork.core.databases.MySQL;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class DisconnectListener implements Listener {

    public DisconnectListener(Main main) {
    }

    @EventHandler
    public void onDisconnect(PlayerQuitEvent e) {
        if (MySQL.isVanishedPlayer(e.getPlayer())) {
            MySQL.removeVanishedPlayer(e.getPlayer());
        }
    }
}
