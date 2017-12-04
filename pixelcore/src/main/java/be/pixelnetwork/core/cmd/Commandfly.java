package be.pixelnetwork.core.cmd;

import be.pixelnetwork.core.Main;
import be.pixelnetwork.core.Helpers;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class Commandfly  {
    private FileConfiguration config = Main.getInstance().getConfig();
    public void execute(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if (label.equalsIgnoreCase("fly")) {
            if (p.hasPermission("PixelNetwork.fly") || p.isOp() || p.isFlying() || config.get("PixelNetwork.perms." + p.getName() + ".bypass") == Boolean.TRUE) {
                if (args.length == 0) {
                    if (p.isFlying() || p.getAllowFlight()) {
                        p.setAllowFlight(false);
                        p.setFlying(false);
                        p.sendMessage(Helpers.Colors(Helpers.prefix + " &3fly disabled!"));
                    } else {
                        p.setAllowFlight(true);
                        p.setFlying(true);
                        p.sendMessage(Helpers.Colors(Helpers.prefix + " &3fly enabled!"));
                    }
                } else if (args.length == 2) {
                    if (p.hasPermission("PixelNetwork.givefly") || p.isOp() || config.get("PixelNetwork.perms." + p.getName() + ".bypass") == Boolean.TRUE) {
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
                            if (args[1].equalsIgnoreCase("off")) {
                                target.setAllowFlight(false);
                                target.setFlying(false);
                                target.sendMessage(Helpers.Colors(Helpers.prefix + " &3fly disabled!"));
                                p.sendMessage(Helpers.Colors(Helpers.prefix + " &3fly for &6" + args[0] + "&3 disabled!"));
                            } else if (args[1].equalsIgnoreCase("on")) {
                                target.setAllowFlight(true);
                                target.setFlying(true);
                                target.sendMessage(Helpers.Colors(Helpers.prefix + " &3fly enabled!"));
                                p.sendMessage(Helpers.Colors(Helpers.prefix + " &3fly for &6" + args[0] + "&3 enabled!"));
                            }
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&', Helpers.prefix + " &cusage: /Commandfly <player> <on>"));
                        }
                    } else {
                        p.sendMessage(Helpers.noperms);
                    }
                } else if (args.length == 1) {
                    if (p.hasPermission("PixelNetwork.givefly") || p.isOp() || config.get("PixelNetwork.perms." + p.getName() + ".bypass") == Boolean.TRUE) {
                        Player targetfound1 = null;
                        for (Player t : Bukkit.getOnlinePlayers()) {
                            if (args[0].equalsIgnoreCase(t.getName())) {
                                targetfound1 = t;
                            }
                        }
                        if (targetfound1 == null) {
                            p.sendMessage(org.bukkit.ChatColor.RED + " player not found");
                        } else {
                            //player found
                            if (targetfound1.isFlying() || targetfound1.getAllowFlight()) {
                                targetfound1.setFlying(false);
                                targetfound1.setAllowFlight(false);
                                targetfound1.sendMessage(Helpers.prefix + Helpers.Colors(" &3fly disabled!"));
                                p.sendMessage(Helpers.prefix + Helpers.Colors(" &3fly for " + args[0] + " disabled!"));
                            } else {
                                targetfound1.setAllowFlight(true);
                                targetfound1.setFlying(true);
                                targetfound1.sendMessage(Helpers.prefix + Helpers.Colors(" &3fly enabled!"));
                                p.sendMessage(Helpers.prefix + Helpers.Colors(" &3fly for " + args[0] + " enabled!"));
                            }
                        }
                    } else {
                        p.sendMessage(Helpers.noperms);
                    }
                }
            } else {
                p.sendMessage(Helpers.noperms);
            }
        }
    }
}
