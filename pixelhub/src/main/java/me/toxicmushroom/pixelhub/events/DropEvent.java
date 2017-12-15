package me.toxicmushroom.pixelhub.events;

import me.toxicmushroom.pixelhub.Helper;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class DropEvent implements Listener {

    @EventHandler
    public void onDrop(PlayerDropItemEvent e) {
        if (!e.getPlayer().hasPermission(Helper.perm + "dropitem")) e.setCancelled(true);
    }
}
