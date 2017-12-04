package be.pixelnetwork.core.cmd;

import be.pixelnetwork.core.Helpers;
import be.pixelnetwork.core.Main;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class Commandspawn {

    FileConfiguration config = Main.getInstance().getConfig();
    Main plugin = Main.getInstance();
    public void execute(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (label.equalsIgnoreCase("spawn")) {
                if (p.hasPermission(Helpers.perm + "spawn")) {
                    if (args.length == 0) {
                        if (config.isConfigurationSection("PixelCore." + plugin.getPrimaryGroup(String.valueOf(p.getWorld()), p))) {
                            String group = plugin.getPrimaryGroup(String.valueOf(p.getWorld()), p);
                            World w = Bukkit.getServer().getWorld(config.getString("PixelCore." + group + ".world"));
                            double x = config.getDouble("PixelCore." + group + ".x");
                            double y = config.getDouble("PixelCore." + group + ".y");
                            double z = config.getDouble("PixelCore." + group + ".z");
                            Vector dir = (Vector) config.get("PixelCore." + group + ".dir");
                            p.teleport(new org.bukkit.Location(w, x, y, z));
                            p.getLocation().setDirection(dir);
                            p.sendMessage(Helpers.prefix + Helpers.Colors(" &3You have teleported to spawn."));
                        } else {
                            p.sendMessage(Helpers.prefix + Helpers.Colors(" &cThere is no spawnpoint set."));
                        }
                    } else if (args.length == 1) {
                        Player target = null;
                        for (Player possibletarget : Bukkit.getOnlinePlayers()) {
                            if (possibletarget.getName().equalsIgnoreCase(args[0])) target = possibletarget;
                        }
                        if (target != null) {
                            if (config.isConfigurationSection("PixelCore." + plugin.getPrimaryGroup(String.valueOf(target.getWorld()), target))) {
                                String group = plugin.getPrimaryGroup(String.valueOf(target.getWorld()), target);
                                World w = Bukkit.getServer().getWorld(config.getString("PixelCore." + group + ".world"));
                                double x = config.getDouble("PixelCore." + group + ".x");
                                double y = config.getDouble("PixelCore." + group + ".y");
                                double z = config.getDouble("PixelCore." + group + ".z");
                                Vector dir = (Vector) config.get("PixelCore." + group + ".dir");
                                target.teleport(new org.bukkit.Location(w, x, y, z));
                                target.getLocation().setDirection(dir);
                                target.sendMessage(Helpers.prefix + Helpers.Colors(" &3You have been teleported to spawn."));
                            } else {
                                p.sendMessage(Helpers.prefix + Helpers.Colors(" &cThere is no spawnpoint set."));
                            }
                        } else if (config.isConfigurationSection("PixelCore." + args[0])) {
                            World w = Bukkit.getServer().getWorld(config.getString("PixelCore." + args[0] + ".world"));
                            double x = config.getDouble("PixelCore." + args[0] + ".x");
                            double y = config.getDouble("PixelCore." + args[0] + ".y");
                            double z = config.getDouble("PixelCore." + args[0] + ".z");
                            Vector dir = (Vector) config.get("PixelCore." + args[0] + ".dir");
                            p.teleport(new org.bukkit.Location(w, x, y, z));
                            p.getLocation().setDirection(dir);
                            p.sendMessage(Helpers.prefix + Helpers.Colors(" &3You have teleported to spawn."));
                        } else {
                            p.sendMessage(Helpers.prefix + Helpers.Colors(" &cThere is no spawnpoint set."));
                        }
                    } else {
                        p.sendMessage(Helpers.prefix + Helpers.Colors(" &cUsage: /spawn [player]"));
                    }
                } else {
                    p.sendMessage(Helpers.noperms);
                }
            }
        }
    }
}
