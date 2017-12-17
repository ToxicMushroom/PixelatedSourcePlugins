package me.toxicmushroom.pixelhub.events;

import me.toxicmushroom.pixelhub.Helper;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class MoveEvent implements Listener {

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        if (e.getFrom().getBlock() != e.getTo().getBlock()) {
            Helper.time.put(e.getPlayer().getUniqueId().toString(), 1.0);
        }
    }
}
