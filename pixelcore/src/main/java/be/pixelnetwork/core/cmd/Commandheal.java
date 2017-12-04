package be.pixelnetwork.core.cmd;

import be.pixelnetwork.core.Helpers;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commandheal {
    public void execute(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (label.equalsIgnoreCase("heal")) {
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
                        target.setHealth(p.getMaxHealth());
                        target.sendMessage(Helpers.prefix + Helpers.Colors(" &3You have been healed."));
                        p.sendMessage(Helpers.prefix + Helpers.Colors(" &3You have healed &6&l" + target.getName() + "."));
                    }
                } else if (args.length == 0) {
                    p.setHealth(p.getMaxHealth());
                    p.setFoodLevel(20);
                    p.sendMessage(Helpers.prefix + Helpers.Colors(" &3You have been healed."));
                } else {
                    p.sendMessage(Helpers.prefix + Helpers.Colors(" &cUsage: /heal [player]"));
                }
            }
        }
    }
}
