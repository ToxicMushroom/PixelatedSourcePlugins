package me.toxicmushroom.pixelbungeecore.events;

import me.toxicmushroom.pixelbungeecore.Helper;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PlayerDisconnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class LeaveEvent implements Listener {

    @EventHandler
    public void onDisconnect(PlayerDisconnectEvent e) {
        ProxiedPlayer player = e.getPlayer();
        if (Helper.staff.contains(player)) Helper.staff.remove(player);
    }
}
