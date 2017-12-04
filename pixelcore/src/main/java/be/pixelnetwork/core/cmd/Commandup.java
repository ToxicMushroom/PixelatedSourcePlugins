package be.pixelnetwork.core.cmd;

import be.pixelnetwork.core.Helpers;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commandup {
    public void execute(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (label.equalsIgnoreCase("up")) {
                if (p.hasPermission(Helpers.perm + "up")) {
                    if (args.length == 1) {
                        boolean fat = false;
                        for (String s : args[0].split("[0-9]")) {
                            if (s.matches("[0-9]")) {
                                if (fat) {

                                } else {
                                    fat = false;
                                }
                            } else {
                                fat = true;
                            }
                        }
                        if (!fat) {
                            if (p.getWorld().getBlockAt(p.getLocation().add(0, Double.parseDouble(args[0]) - 1, 0)).getType() == Material.AIR &&
                                    p.getWorld().getBlockAt(p.getLocation().add(0, Double.parseDouble(args[0]) + 1, 0)).getType() == Material.AIR &&
                                    p.getWorld().getBlockAt(p.getLocation().add(0, Double.parseDouble(args[0]), 0)).getType() == Material.AIR) {
                                p.teleport(p.getLocation().add(0, Double.parseDouble(args[0]), 0));
                                p.getWorld().getBlockAt(p.getLocation().subtract(0, 1, 0)).setType(Material.STAINED_GLASS);
                            } else {
                                p.sendMessage(Helpers.prefix + Helpers.Colors(" &cYou will hit a block!"));
                            }
                        } else {
                            p.sendMessage(Helpers.prefix + Helpers.Colors(" &cOnly numbers please"));
                        }
                    } else {
                        p.sendMessage(Helpers.prefix + Helpers.Colors(" &cUsage: /up <number>"));
                    }
                } else {
                    p.sendMessage(Helpers.noperms);
                }
            }
        }
    }
}
