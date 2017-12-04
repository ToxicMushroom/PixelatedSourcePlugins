package be.pixelnetwork.core.events;

import be.pixelnetwork.core.Helpers;
import be.pixelnetwork.core.Main;
import be.pixelnetwork.core.cmd.Commandarmorsee;
import be.pixelnetwork.core.cmd.Commandtime;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.inventory.Inventory;

public class InventoryListener implements Listener {

    private FileConfiguration config = Main.getInstance().getConfig();

    public InventoryListener(Main main) {

    }

    private Commandarmorsee armorsee = new Commandarmorsee();

    @EventHandler
    public void inventoryClose(InventoryCloseEvent e) {
        if (e.getInventory().getName().equalsIgnoreCase(Helpers.Colors("&3Armor"))) {
            Player p = (Player) e.getPlayer();
            Player target = armorsee.getSpectators().get(p);
            armorsee.getSpectators().remove(p);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onInventoryClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        p.sendMessage("------------called--------------");
        if (e.getClickedInventory() != null) {
            p.sendMessage("notnull");
            Inventory clicked = e.getClickedInventory();
            if (p.getOpenInventory() != null)
                if (p.getOpenInventory().getTitle().equalsIgnoreCase(Commandtime.timeinv.getTitle()) && clicked == p.getInventory()) {
                    p.sendMessage("cancelled by 1");
                    e.setCancelled(true);
                }
            if (clicked.equals(p.getInventory()) && armorsee.getSpectators().containsValue(p)) {
                p.sendMessage("Your inventory is being edited. Leaving in this situation will result in a ban.");
                e.setCancelled(true);
            }
            if (clicked.equals(Commandtime.timeinv)) {
                if (p.hasPermission(Helpers.perm + "time")) {
                    p.sendMessage("cancelled by 2");
                    e.setCancelled(true);
                    World cw = p.getWorld();
                    switch (e.getSlot()) {
                        case 1:
                            cw.setTime(19000);
                            break;
                        case 2:
                            cw.setTime(20000);
                            break;
                        case 3:
                            cw.setTime(21000);
                            break;
                        case 4:
                            cw.setTime(22000);
                            break;
                        case 5:
                            cw.setTime(23000);
                            break;
                        case 6:
                            cw.setTime(0);
                            break;
                        case 7:
                            cw.setTime(1000);
                            break;
                        case 8:
                            cw.setTime(2000);
                            break;
                        case 9:
                            cw.setTime(3000);
                            break;
                        case 10:
                            cw.setTime(4000);
                            break;
                        case 11:
                            cw.setTime(5000);
                            break;
                        case 12:
                            cw.setTime(6000);
                            break;
                        case 13:
                            cw.setTime(7000);
                            break;
                        case 14:
                            cw.setTime(8000);
                            break;
                        case 15:
                            cw.setTime(9000);
                            break;
                        case 16:
                            cw.setTime(10000);
                            break;
                        case 17:
                            cw.setTime(11000);
                            break;
                        case 18:
                            cw.setTime(12000);
                            break;
                        case 19:
                            cw.setTime(13000);
                            break;
                        case 20:
                            cw.setTime(14000);
                            break;
                        case 21:
                            cw.setTime(15000);
                            break;
                        case 22:
                            cw.setTime(16000);
                            break;
                        case 23:
                            cw.setTime(17000);
                            break;
                        case 24:
                            cw.setTime(18000);
                            break;
                    }
                }
            }
            if (clicked.getTitle().equalsIgnoreCase(Helpers.Colors(armorsee.title))) {
                Player t = armorsee.getSpectators().get(p);
                if (t == null) {
                    p.sendMessage("wrong china");
                    e.setCancelled(true);
                    return;
                }
                if (e.getSlot() < 4) {
                    switch (e.getSlot()) {
                        case 0:
                            t.getInventory().setHelmet(e.getCursor());
                            break;
                        case 1:
                            t.getInventory().setChestplate(e.getCursor());
                            break;
                        case 2:
                            t.getInventory().setLeggings(e.getCursor());
                            break;
                        case 3:
                            t.getInventory().setBoots(e.getCursor());
                            break;
                        default:
                            e.setCancelled(true);
                            break;
                    }
                } else {
                    e.setCancelled(true);
                }
            }
        }
    }
}
