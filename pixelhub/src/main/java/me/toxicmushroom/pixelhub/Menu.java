package me.toxicmushroom.pixelhub;

import org.bukkit.entity.Player;

public class Menu {

    private Inventories invs = new Inventories();

    public void openMenu(Player p, String menu) {
        if (menu.equalsIgnoreCase("home")) {
            p.openInventory(invs.home());
        } else if (menu.equalsIgnoreCase("particles")) {
            p.openInventory(invs.particles(p));
        }
    }
}
