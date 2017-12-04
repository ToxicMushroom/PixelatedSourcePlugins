package be.pixelnetwork.core.cmd;

import be.pixelnetwork.core.Helpers;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commanddry {
    public void execute(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (label.equalsIgnoreCase("dry")) {
                if (p.hasPermission(Helpers.perm + "dry")) {
                    p.getWorld().setStorm(false);
                    p.getWorld().setThundering(false);
                } else {
                    p.sendMessage(Helpers.noperms);
                }
            }
        }
    }
}
