package be.pixelnetwork.core.cmd;

import be.pixelnetwork.core.Helpers;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commandinvsee {
    public void execute(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (label.equalsIgnoreCase("invsee")) {
                if (p.hasPermission("pixelnetwork.invsee")) {
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
                            p.openInventory(target.getInventory());
                        }
                    } else {
                        p.sendMessage(Helpers.prefix + Helpers.Colors(" &cUsage: /invsee <player>"));
                    }
                } else {
                    p.sendMessage(Helpers.noperms);
                }
            }
        }
    }
}
