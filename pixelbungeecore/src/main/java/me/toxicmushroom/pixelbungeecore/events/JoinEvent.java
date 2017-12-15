package me.toxicmushroom.pixelbungeecore.events;

import me.toxicmushroom.pixelbungeecore.Helper;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ServerConnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class JoinEvent implements Listener {

    @EventHandler
    public void onJoin(ServerConnectEvent e) {
        ProxiedPlayer player = e.getPlayer();
        if (player.hasPermission(Helper.permission + "staff")) {
            if (!Helper.staff.contains(player)) Helper.staff.add(player);
        }
    }
}
