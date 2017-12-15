package me.toxicmushroom.pixelhub.events;

import me.toxicmushroom.pixelhub.Helper;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class ItemClickEvent implements Listener {

    @EventHandler
    public void onItemClick(PlayerInteractEvent e) {
        if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase(Helper.Colors("&3&lCosmetics"))) {
            e.getPlayer().sendMessage("ploperdeplop");
        }
    }
}
