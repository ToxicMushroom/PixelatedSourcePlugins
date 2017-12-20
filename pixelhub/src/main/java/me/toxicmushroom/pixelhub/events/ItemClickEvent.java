package me.toxicmushroom.pixelhub.events;

import me.toxicmushroom.pixelhub.Helper;
import me.toxicmushroom.pixelhub.Menu;
import me.toxicmushroom.pixelhub.PixelHub;
import net.minecraft.server.v1_8_R3.EnumParticle;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class ItemClickEvent implements Listener {

    private FileConfiguration config = PixelHub.getInstance().getConfig();
    private Menu menus = new Menu();

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        if (e.getItem() == null || e.getItem().getItemMeta() == null || e.getItem().getItemMeta().getDisplayName() == null)
            return;
        if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase(Helper.Colors("&3&lCosmetics"))) {
            menus.openMenu(e.getPlayer(), "home");
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        if (e.getClickedInventory() == null) return;
        Player p = (Player) e.getWhoClicked();
        ItemStack clicked = e.getCurrentItem();
        if (p.getOpenInventory().getTitle().equalsIgnoreCase(Helper.Colors("&c&lParticles"))) {
            if (e.getClickedInventory().equals(p.getInventory())) {
                e.setCancelled(true);
                return;
            }
            String id = p.getUniqueId().toString();
            e.setCancelled(true);
            switch (clicked.getType()) {
                case APPLE:
                    config.set("particles." + id + ".selected", EnumParticle.HEART.toString());
                    p.sendMessage(Helper.Colors(Helper.prefix + " &3You've selected &6&lHearths&3!"));
                    break;
                case FLINT_AND_STEEL:
                    config.set("particles." + id + ".selected", EnumParticle.FLAME.toString());
                    p.sendMessage(Helper.Colors(Helper.prefix + " &3You've selected &6&lFlames&3!"));
                    break;
                case LAVA_BUCKET:
                    config.set("particles." + id + ".selected", EnumParticle.DRIP_LAVA.toString());
                    p.sendMessage(Helper.Colors(Helper.prefix + " &3You've selected &6&lLava Drips&3!"));
                    break;
                case WATER_BUCKET:
                    config.set("particles." + id + ".selected", EnumParticle.DRIP_WATER.toString());
                    p.sendMessage(Helper.Colors(Helper.prefix + " &3You've selected &6&lWater Drips&3!"));
                    break;
                case STICK:
                    config.set("particles." + id + ".selected", EnumParticle.CRIT_MAGIC.toString());
                    p.sendMessage(Helper.Colors(Helper.prefix + " &3You've selected &6&lWitch Crits&3!"));
                    break;
                case MILK_BUCKET:
                    config.set("particles." + id + ".selected", EnumParticle.CLOUD.toString());
                    p.sendMessage(Helper.Colors(Helper.prefix + " &3You've selected &6&lClouds&3!"));
                    break;
                case NOTE_BLOCK:
                    config.set("particles." + id + ".selected", EnumParticle.NOTE.toString());
                    p.sendMessage(Helper.Colors(Helper.prefix + " &3You've selected &6&lMusic Notes&3!"));
                    break;
                case DRAGON_EGG:
                    config.set("particles." + id + ".selected", EnumParticle.SPELL_WITCH.toString());
                    p.sendMessage(Helper.Colors(Helper.prefix + " &3You've selected &6&lWitch Magic&3!"));
                case WOOL:
                    if (config.getBoolean("particles." + id + ".show")) {
                        config.set("particles." + id + ".show", false);
                        p.sendMessage(Helper.Colors(Helper.prefix + " &3Particles disabled!"));
                        p.closeInventory();
                    } else  {
                        config.set("particles." + id + ".show", true);
                        p.sendMessage(Helper.Colors(Helper.prefix + " &3Particles enabled!"));
                        p.closeInventory();
                    }
                    break;
                default: break;
            }
            saveConfig();
        } else if (p.getOpenInventory().getTitle().equalsIgnoreCase(Helper.Colors("&3&lHome"))) {
            if (e.getClickedInventory().equals(p.getInventory())) {
                e.setCancelled(true);
                return;
            }
            if (clicked.getType() != Material.AIR) {
                if (clicked.getItemMeta().getDisplayName().equalsIgnoreCase(Helper.Colors("&c&lParticles"))) {
                    e.setCancelled(true);
                    menus.openMenu(p, "particles");
                }
            }
        }
    }

    private void saveConfig() {
        PixelHub.getInstance().saveConfig();
    }
}
