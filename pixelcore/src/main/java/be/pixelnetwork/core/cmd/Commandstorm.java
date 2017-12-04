package be.pixelnetwork.core.cmd;

import be.pixelnetwork.core.Helpers;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commandstorm {
    public void execute(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (label.equalsIgnoreCase("storm")) {
                if (p.hasPermission(Helpers.perm + "storm")) {
                    p.getWorld().setStorm(true);
                    p.getWorld().setThundering(true);
                } else {
                    p.sendMessage(Helpers.noperms);
                }
            }
        }
    }
}
