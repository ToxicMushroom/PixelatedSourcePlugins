package be.pixelnetwork.core.cmd;

import be.pixelnetwork.core.Helpers;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commandkill {
    public void execute(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (label.equalsIgnoreCase("kill")) {
                if (p.hasPermission("pixelnetwork.kill")) {
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
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&', Helpers.prefix + " &cPlayer: " + args[0] + " not found"));
                        } else {
                            target.setHealth(0);
                            p.sendMessage(Helpers.prefix + Helpers.Colors(" &4You have killed &6&l" + target.getName() + "."));
                        }
                    } else {
                        p.sendMessage(Helpers.prefix + Helpers.Colors(" &cUsage: /kill <player>"));
                    }
                } else {
                    p.sendMessage(Helpers.noperms);
                }
            }
        }
    }
}
