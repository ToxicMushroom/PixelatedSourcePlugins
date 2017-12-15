package me.toxicmushroom.pixelhub.events;

import me.toxicmushroom.pixelhub.Helper;
import me.toxicmushroom.pixelhub.Inventories;
import me.toxicmushroom.pixelhub.Menu;
import me.toxicmushroom.pixelhub.PixelHub;
import net.minecraft.server.v1_8_R3.EnumParticle;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ItemClickEvent implements Listener {

    private FileConfiguration config = PixelHub.getInstace().getConfig();
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
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        String pn = player.getName();
        ItemStack clicked = event.getCurrentItem();
        Inventory inventory = event.getInventory();
        if (inventory.getName().equalsIgnoreCase(Helper.Colors("&c&lParticles"))) {
            switch (clicked.getType()) {
                case APPLE:
                    config.set("particles." + pn + ".selected", EnumParticle.HEART.toString());
                    event.setCancelled(true);
                    player.sendMessage("Je hebt hartjes geselecteerd!");
                    break;
                case FLINT_AND_STEEL:
                    config.set("particles." + pn + ".selected", EnumParticle.FLAME.toString());
                    event.setCancelled(true);
                    player.sendMessage("Je hebt vuurtjes geselecteerd!");
                    break;
                case LAVA_BUCKET:
                    config.set("particles." + pn + ".selected", EnumParticle.DRIP_LAVA.toString());
                    event.setCancelled(true);
                    player.sendMessage("Je hebt lava druppels geselecteerd!");
                    break;
                case WATER_BUCKET:
                    config.set("particle." + pn + ".selected", EnumParticle.DRIP_WATER.toString());
                    event.setCancelled(true);
                    player.sendMessage("Je hebt water druppels geselecteerd!");
                    break;
                case STICK:
                    config.set("particle." + pn + ".selected", EnumParticle.CRIT_MAGIC.toString());
                    event.setCancelled(true);
                    player.sendMessage("Je hebt een wolkje melk geselecteerd!");
                    break;
                case MILK_BUCKET:
                    config.set("particle." + pn + ".selected", EnumParticle.CLOUD.toString());
                    event.setCancelled(true);
                    player.sendMessage("Je hebt magic the gathering geselecteerd!");
                    break;
                case WOOL:
                    if (clicked.getItemMeta().getDisplayName().equalsIgnoreCase(Helper.Colors("&aParticles AAN"))) {
                        config.set("particle." + pn + ".show", false);
                        event.setCancelled(true);
                        player.sendMessage(Helper.Colors(Helper.prefix + " &3Particles disabled!"));
                        player.closeInventory();
                    } else if (clicked.getItemMeta().getDisplayName().equalsIgnoreCase(Helper.Colors("&4Particles UIT"))) {
                        config.set("particle." + pn + ".show", true);
                        event.setCancelled(true);
                        player.sendMessage(Helper.Colors(Helper.prefix + " &3Particles enabled!"));
                        player.closeInventory();
                    }
                    break;
                default:
                    break;
            }
            saveConfig();
        } else if (inventory.getName().equalsIgnoreCase(Helper.Colors("&3&lHome")))
            if (clicked.getItemMeta().getDisplayName().equalsIgnoreCase(Helper.Colors("&c&lParticles")))
                menus.openMenu(player, "particles");
    }

    private void saveConfig() {
        PixelHub.getInstace().saveConfig();
    }
}
