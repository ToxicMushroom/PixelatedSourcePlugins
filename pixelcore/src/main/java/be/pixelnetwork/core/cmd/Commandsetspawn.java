package be.pixelnetwork.core.cmd;

import be.pixelnetwork.core.Helpers;
import be.pixelnetwork.core.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class Commandsetspawn {

    FileConfiguration config = Main.getInstance().getConfig();
    public void execute(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (label.equalsIgnoreCase("setspawn")) {
                if (p.hasPermission(Helpers.perm + "setspawn")) {
                    if (args.length != 1) {
                        p.sendMessage(Helpers.prefix + Helpers.Colors(" &cUsage: /setspawn <group>"));
                    } else {
                        config.set("PixelCore." + args[0] + ".world", p.getLocation().getWorld().getName());
                        config.set("PixelCore." + args[0] + ".x", p.getLocation().getX());
                        config.set("PixelCore." + args[0] + ".y", p.getLocation().getY());
                        config.set("PixelCore." + args[0] + ".z", p.getLocation().getZ());
                        config.set("PixelCore." + args[0] + ".dir", p.getLocation().getDirection());
                        Main.getInstance().saveConfig();
                        p.sendMessage(Helpers.prefix + Helpers.Colors(" &3The spawnpoint for group &6" + args[0] + " &3has been set."));
                    }
                } else {
                    p.sendMessage(Helpers.noperms);
                }
            }
        }
    }
}
