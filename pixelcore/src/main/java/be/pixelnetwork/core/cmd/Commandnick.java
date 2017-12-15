package be.pixelnetwork.core.cmd;

import be.pixelnetwork.core.Helpers;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commandnick {

    public void execute(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            int offset = args[0].equalsIgnoreCase("") ? 1 : 0;
            if (args.length == 1 + offset) {
                if (args[offset].length() < 50) {
                    p.setDisplayName(Helpers.Colors(args[offset]));
                    p.sendMessage(Helpers.Colors(Helpers.prefix + " &3Your nickname has beeen set to &6" + args[offset]));
                }
            }
        }
    }
}
