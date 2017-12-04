package be.pixelnetwork.core.cmd;

import be.pixelnetwork.core.Helpers;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commandnick {

    public void execute(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (args.length == 1) {
                if (args[0].length() < 50) {
                    p.setCustomName(Helpers.Colors(args[0]));
                    p.setDisplayName(Helpers.Colors(args[0]));
                    p.sendMessage(Helpers.Colors(Helpers.prefix + " &3Your nickname has beeen set to &6" + args[0]));
                }
            }
        }
    }
}
