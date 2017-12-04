package be.pixelnetwork.core.cmd;

import be.pixelnetwork.core.Helpers;
import be.pixelnetwork.core.Main;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class Commandarmorsee {

    public String title = "&3Armor";
    private HashMap<Player, Player> spectators = new HashMap<>();
    public HashMap<Player, Player> getSpectators() {
        return spectators;
    }
    public void execute(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (label.equalsIgnoreCase("armorsee")) {
                if (p.hasPermission(Helpers.perm + "armorsee")) {
                    if (args.length == 1) {
                        Player target = null;
                        boolean targetFound = false;
                        for (Player pp : Bukkit.getOnlinePlayers()) {
                            if (pp.getName().equalsIgnoreCase(args[0])) {
                                target = Bukkit.getPlayer(pp.getUniqueId());
                                targetFound = true;
                            }
                        }
                        if (!targetFound) {
                            p.sendMessage(Helpers.prefix + Helpers.Colors(" &cplayer not found"));
                        } else {
                            Inventory inventory = Bukkit.createInventory(null, 9, Helpers.Colors(title));
                            if (target.getInventory().getHelmet() != null) {
                                inventory.setItem(0, target.getInventory().getHelmet());
                            }
                            if (target.getInventory().getChestplate() != null) {
                                inventory.setItem(1, target.getInventory().getChestplate());
                            }
                            if (target.getInventory().getLeggings() != null) {
                                inventory.setItem(2, target.getInventory().getLeggings());
                            }
                            if (target.getInventory().getBoots() != null) {
                                inventory.setItem(3, target.getInventory().getBoots());
                            }
                            inventory.setItem(4, new ItemStack(Material.BARRIER, 1));
                            inventory.setItem(5, new ItemStack(Material.BARRIER, 1));
                            inventory.setItem(6, new ItemStack(Material.BARRIER, 1));
                            inventory.setItem(7, new ItemStack(Material.BARRIER, 1));
                            inventory.setItem(8, new ItemStack(Material.BARRIER, 1));
                            p.openInventory(inventory);
                            Main.getInstance().saveConfig();
                            spectators.put(p, target);
                        }
                    } else {
                        p.sendMessage(Helpers.prefix + Helpers.Colors(" &cUsage: /armorsee <player>"));
                    }
                } else {
                    p.sendMessage(Helpers.noperms);
                }
            }
        }
    }
}
