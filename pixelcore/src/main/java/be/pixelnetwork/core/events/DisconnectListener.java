package be.pixelnetwork.core.events;

import be.pixelnetwork.core.Main;
import be.pixelnetwork.core.databases.MySQL;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class DisconnectListener implements Listener {

    public DisconnectListener(Main main) {
    }
    MySQL mySQL = new MySQL();

    @EventHandler
    public void onDisconnect(PlayerQuitEvent e) {
        if (mySQL.isVanishedPlayer(e.getPlayer())) {
            mySQL.removeVanishedPlayer(e.getPlayer());
        }
    }
}
