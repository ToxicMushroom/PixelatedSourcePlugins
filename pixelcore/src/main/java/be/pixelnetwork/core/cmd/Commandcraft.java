package be.pixelnetwork.core.cmd;

import be.pixelnetwork.core.Helpers;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commandcraft {

    public void execute(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (label.equalsIgnoreCase("craft")) {
                if (p.hasPermission("pixelnetwork.craft")) {
                    p.openWorkbench(p.getLocation(), true);
                    p.sendMessage(Helpers.prefix + Helpers.Colors(" &3A workbench has been opened."));
                } else {
                    p.sendMessage(Helpers.noperms);
                }
            }
        }
    }
}
