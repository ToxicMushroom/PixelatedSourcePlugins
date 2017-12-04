package be.pixelnetwork.core.cmd;

import be.pixelnetwork.core.Helpers;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commandeat {
    public void execute(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (label.equalsIgnoreCase("eat")) {
                if (p.hasPermission("pixelnetwork.eat")) {
                    if (p.hasPermission("pixelnetwork.eatother")) {
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
                                target.setFoodLevel(20);
                                target.sendMessage(Helpers.prefix + Helpers.Colors(" &3You have been fed."));
                                p.sendMessage(Helpers.prefix + Helpers.Colors(" &3You have fed &6&l" + target.getName() + "."));
                            }


                        } else if (args.length == 0) {
                            p.setFoodLevel(20);
                            p.sendMessage(Helpers.prefix + Helpers.Colors(" &3You have been fed."));
                        } else {
                            p.sendMessage(Helpers.prefix + Helpers.Colors(" &cUsage: /eat [player]    --> \n" +
                                    "&4No cannibalistic ideas intended. "));
                        }
                    } else {
                        if (args.length == 0) {
                            p.setFoodLevel(20);
                            p.sendMessage(Helpers.prefix + Helpers.Colors(" &3You have been fed."));
                        } else {
                            p.sendMessage(Helpers.prefix + Helpers.Colors(" &cUsage: /eat "));
                        }
                    }
                } else {
                    p.sendMessage(Helpers.noperms);
                }
            }
        }
    }
}
