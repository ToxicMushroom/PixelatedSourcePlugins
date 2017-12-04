package be.pixelnetwork.core.cmd;

import be.pixelnetwork.core.Helpers;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commandextinguish {
    public void execute(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (label.equalsIgnoreCase("ext") || label.equalsIgnoreCase("extinguish")) {
                if (p.hasPermission("pixelnetwork.ext")) {
                    if (p.hasPermission("pixelnetwork.extother")) {
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
                                p.sendMessage(Helpers.prefix + Helpers.Colors(" &cPlayer: " + args[0] + " not found"));
                            } else {
                                target.setFireTicks(0);
                                target.sendMessage(Helpers.prefix + Helpers.Colors(" &3You have been extinguished."));
                                p.sendMessage(Helpers.prefix + Helpers.Colors(" &3You have extinguished &6&l" + target.getName() + "."));
                            }
                        } else if (args.length == 0) {
                            p.setFireTicks(0);
                            p.sendMessage(Helpers.prefix + Helpers.Colors(" &3You have been extinguished."));
                        } else {
                            p.sendMessage(Helpers.prefix + Helpers.Colors(" &cUsage: /ext [player]"));
                        }
                    } else {
                        if (args.length == 0) {
                            p.setFireTicks(0);
                            p.sendMessage(Helpers.prefix + Helpers.Colors(" &3You have been extinguished."));
                        } else {
                            p.sendMessage(Helpers.prefix + Helpers.Colors(" &cUsage: /ext "));
                        }
                    }
                } else {
                    p.sendMessage(Helpers.noperms);
                }
            } else if (label.equalsIgnoreCase("suicide")) {
                p.sendMessage(Helpers.prefix + " &cSuicide is never a solution.");
            }
        }
    }
}
