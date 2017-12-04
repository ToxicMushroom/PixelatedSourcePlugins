package be.pixelnetwork.core.cmd;

import be.pixelnetwork.core.Helpers;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commandspeed {

    public void execute(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (label.equalsIgnoreCase("speed")) {
                if (p.hasPermission(Helpers.perm + "speed")) {
                    if (args.length == 0) {
                        p.sendMessage(Helpers.prefix + Helpers.Colors(" &cUsage: /speed <0-10> [Commandfly|walk] [player]"));
                    } else {
                        boolean fatt = false;
                        for (String b : args[0].split("[0-9]")) {
                            if (b.matches("[0-9]")) {
                                if (!fatt) {
                                    fatt = false;
                                }
                            } else {
                                fatt = true;
                            }
                        }
                        if (!fatt) {
                            int arg0 = Integer.parseInt(args[0]);
                            float speed;
                            switch (arg0) {
                                case 0:
                                    speed = 0;
                                    break;
                                case 1:
                                    speed = 0.15f;
                                    break;
                                case 2:
                                    speed = 0.2f;
                                    break;
                                case 3:
                                    speed = 0.3f;
                                    break;
                                case 4:
                                    speed = 0.4f;
                                    break;
                                case 5:
                                    speed = 0.5f;
                                    break;
                                case 6:
                                    speed = 0.6F;
                                    break;
                                case 7:
                                    speed = 0.7F;
                                    break;
                                case 8:
                                    speed = 0.8F;
                                    break;
                                case 9:
                                    speed = 0.9F;
                                    break;
                                case 10:
                                    speed = 1;
                                    break;
                                default:
                                    speed = 0.11F;
                                    break;
                            }
                            if (speed == 0.11F) {
                                p.sendMessage(Helpers.prefix + Helpers.Colors(" &cChoose a number from 0 to 10"));
                            } else {
                                if (args.length == 1) {
                                    if (p.isFlying()) {
                                        if (speed == 0.15f) p.setFlySpeed(0.1f); else p.setFlySpeed(speed);
                                        p.sendMessage(Helpers.prefix + Helpers.Colors(" &3Fly speed has been changed to &6" + arg0));
                                    } else {
                                        p.setWalkSpeed(speed);
                                        p.sendMessage(Helpers.prefix + Helpers.Colors(" &3Walk speed has been changed to &6" + arg0));
                                    }
                                }
                                if (args.length == 2) {
                                    if (args[1].equalsIgnoreCase("fly")) {
                                        if (speed == 0.15f) p.setFlySpeed(0.1f); else p.setFlySpeed(speed);
                                        p.sendMessage(Helpers.prefix + Helpers.Colors(" &3Fly speed has been changed to &6" + arg0));
                                    }
                                    if (args[1].toLowerCase().equalsIgnoreCase("walk")) {
                                        p.setWalkSpeed(speed);
                                        p.sendMessage(Helpers.prefix + Helpers.Colors(" &3Walk speed has been changed to &6" + arg0));
                                    }
                                }
                                if (args.length == 3) {
                                    Player target = null;
                                    for (Player pp : Bukkit.getOnlinePlayers()) {
                                        if (pp.getName().equalsIgnoreCase(args[2])) {
                                            target = Bukkit.getPlayer(pp.getUniqueId());
                                        }
                                    }
                                    if (target == null) {
                                        p.sendMessage(Helpers.prefix + ChatColor.translateAlternateColorCodes('&', " &cplayer not found"));
                                    } else {
                                        if (args[1].toLowerCase().equalsIgnoreCase("fly" +
                                                "" +
                                                "" +
                                                "")) {
                                            if (speed == 0.15f) p.setFlySpeed(0.1f); else p.setFlySpeed(speed);
                                            target.sendMessage(Helpers.prefix + Helpers.Colors(" &3Fly speed has been changed to &6" + arg0));
                                            p.sendMessage(Helpers.prefix + Helpers.Colors(" &6" + target.getName() + "&3's Commandfly speed has been changed to &6" + arg0));
                                        }
                                        if (args[1].toLowerCase().equalsIgnoreCase("walk")) {
                                            target.setWalkSpeed(speed);
                                            target.sendMessage(Helpers.prefix + Helpers.Colors(" &3Walk speed has been changed to &6" + arg0));
                                            p.sendMessage(Helpers.prefix + Helpers.Colors(" &6" + target.getName() + "&3's walk speed has been changed to &6" + arg0));
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
