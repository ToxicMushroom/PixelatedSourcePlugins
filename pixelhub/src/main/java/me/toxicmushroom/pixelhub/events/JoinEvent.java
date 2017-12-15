package me.toxicmushroom.pixelhub.events;

import me.toxicmushroom.pixelhub.Helper;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class JoinEvent implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        ItemStack selector = new ItemStack(Material.NETHER_STAR, 1);
        ItemMeta mselecotr = selector.getItemMeta();
        mselecotr.setDisplayName(Helper.Colors("&3&lCosmetics"));
        mselecotr.spigot().setUnbreakable(true);
        selector.setItemMeta(mselecotr);
        if (!e.getPlayer().getInventory().contains(selector))
            e.getPlayer().getInventory().setItem(9, selector);
    }
}
