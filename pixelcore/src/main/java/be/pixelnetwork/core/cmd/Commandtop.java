package be.pixelnetwork.core.cmd;

import be.pixelnetwork.core.Helpers;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commandtop {
   public void execute(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (label.equalsIgnoreCase("top")) {
                if (p.hasPermission(Helpers.perm + "top")) {
                    Location loc = p.getLocation();
                    Location newloc = loc.getWorld().getHighestBlockAt(loc).getLocation();
                    p.teleport(newloc);
                    p.sendMessage(Helpers.prefix + Helpers.Colors(" &3Welcome to the top :D"));
                } else {
                    p.sendMessage(Helpers.noperms);
                }
            }
        }
    }
}
