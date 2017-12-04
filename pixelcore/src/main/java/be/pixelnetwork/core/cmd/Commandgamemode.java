package be.pixelnetwork.core.cmd;

import be.pixelnetwork.core.Helpers;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commandgamemode {
    public boolean execute(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (label.equalsIgnoreCase("gmc")) {
                if (args.length == 0) {
                    if (p.hasPermission("pixelnetwork.gm.1")) {
                        p.setGameMode(GameMode.CREATIVE);
                        p.sendMessage(Helpers.GamemodeC);
                    }
                } else if (args.length == 1) {
                    if (p.hasPermission("pixelnetwork.gmother.1")) {
                        Player targetfound1 = null;
                        for (Player t : Bukkit.getOnlinePlayers()) {
                            if (args[0].equalsIgnoreCase(t.getName())) {
                                targetfound1 = t;
                            }
                        }
                        if (targetfound1 == null) {
                            p.sendMessage(ChatColor.RED + " player not found");
                        } else {
                            targetfound1.setGameMode(GameMode.CREATIVE);
                            targetfound1.sendMessage(Helpers.GamemodeC);
                            p.sendMessage(Helpers.Colors(Helpers.prefix + "&6" + targetfound1.getName() + "'s &3gamemode has been chananged to CREATIVE"));
                        }
                    }
                }
            }
            if (label.equalsIgnoreCase("gma")) {
                if (args.length == 0) {
                    if (p.hasPermission("pixelnetwork.gm.2")) {

                        //survival self
                        p.setGameMode(GameMode.ADVENTURE);
                        p.sendMessage(Helpers.GamemodeA);

                    }
                } else if (args.length == 1) {
                    if (p.hasPermission("pixelnetwork.gmother.2")) {
                        Player targetfound1 = null;
                        for (Player t : Bukkit.getOnlinePlayers()) {
                            if (args[0].equalsIgnoreCase(t.getName())) {
                                targetfound1 = t;
                            }
                        }
                        if (targetfound1 == null) {
                            p.sendMessage(ChatColor.RED + " player not found");
                        } else {
                            //survival self
                            targetfound1.setGameMode(GameMode.ADVENTURE);
                            targetfound1.sendMessage(Helpers.GamemodeA);
                            p.sendMessage(Helpers.Colors("&6" + targetfound1.getName() + "'s &3gamemode has been chananged to ADVENTURE"));
                        }
                    }
                }
            }
            if (label.equalsIgnoreCase("gms")) {
                if (args.length == 0) {
                    if (p.hasPermission("pixelnetwork.gm.0")) {
                        //survival self
                        p.setGameMode(GameMode.SURVIVAL);
                        p.sendMessage(Helpers.GamemodeS);
                    }
                } else if (args.length == 1) {
                    if (p.hasPermission("pixelnetwork.gmother.0")) {
                        Player targetfound1 = null;
                        for (Player t : Bukkit.getOnlinePlayers()) {
                            if (args[0].equalsIgnoreCase(t.getName())) {
                                targetfound1 = t;
                            }
                        }
                        if (targetfound1 == null) {
                            p.sendMessage(ChatColor.RED + " player not found");
                        } else {
                            //survival self
                            targetfound1.setGameMode(GameMode.SURVIVAL);
                            targetfound1.sendMessage(Helpers.GamemodeS);
                            p.sendMessage(Helpers.Colors("&6" + targetfound1.getName() + "'s &3gamemode has been chananged to SURVIVAL"));
                        }
                    }
                }
            }
            if (label.equalsIgnoreCase("gmsp")) {
                if (args.length == 0) {
                    if (p.hasPermission("pixelnetwork.gm.3")) {

                        //survival self
                        p.setGameMode(GameMode.SPECTATOR);
                        p.sendMessage(Helpers.GamemodeSP);

                    }
                } else if (args.length == 1) {
                    if (p.hasPermission("pixelnetwork.gmother.3")) {
                        Player targetfound1 = null;
                        for (Player t : Bukkit.getOnlinePlayers()) {
                            if (args[0].equalsIgnoreCase(t.getName())) {
                                targetfound1 = t;
                            }
                        }
                        if (targetfound1 == null) {
                            p.sendMessage(ChatColor.RED + " player not found");
                        } else {
                            //survival self
                            targetfound1.setGameMode(GameMode.SPECTATOR);
                            targetfound1.sendMessage(Helpers.GamemodeSP);
                            p.sendMessage(Helpers.Colors("&6" + targetfound1.getName() + "'s &3gamemode has been chananged to SPECTATOR"));
                        }
                    }
                }
            }
            if (p.hasPermission("PixelNetwork.gm")) {
                if (label.equalsIgnoreCase("gm")) {
                    if (args.length == 0) {
                        p.sendMessage(ChatColor.RED + "Usage: /gm <0, 1, 2, 3, s, sp, c, a> [Player]");
                    } else if (args.length == 1) {
                        if (args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("s")) {
                            if (p.hasPermission("pixelnetwork.gm.0")) {
                                //survival self
                                p.setGameMode(GameMode.SURVIVAL);
                                p.sendMessage(Helpers.GamemodeS);
                            }
                        } else if (args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("c")) {
                            if (p.hasPermission("pixelnetwork.gm.1")) {
                                //creative self
                                p.setGameMode(GameMode.CREATIVE);
                                p.sendMessage(Helpers.GamemodeC);
                            }
                        } else if (args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase("a")) {
                            if (p.hasPermission("pixelnetwork.gm.2")) {
                                //advanture self
                                p.setGameMode(GameMode.ADVENTURE);
                                p.sendMessage(Helpers.GamemodeA);
                            }
                        } else if (args[0].equalsIgnoreCase("3") || args[0].equalsIgnoreCase("sp")) {
                            if (p.hasPermission("pixelnetwork.gm.3")) {
                                //spectator self
                                p.setGameMode(GameMode.SPECTATOR);
                                p.sendMessage(Helpers.GamemodeSP);
                            }
                        }
                    } else if (args.length == 2) {
                        if (p.hasPermission("pixelnetwork.gmother")) {
                            Player targetfound1 = null;
                            Player targetfound2 = null;
                            Player target = null;
                            for (Player t : Bukkit.getOnlinePlayers()) {
                                if (args[1].equalsIgnoreCase(t.getName())) {
                                    targetfound1 = t;
                                } else if (args[0].equalsIgnoreCase(t.getName())) {
                                    targetfound2 = t;
                                }
                            }
                            if (targetfound1 == null && targetfound2 == null) {
                                p.sendMessage(Helpers.prefix + ChatColor.RED + " player not found");
                            } else if (targetfound1 == null) target = targetfound2; else if (targetfound2 == null) target = targetfound1;
                            if (target != null) {
                                if (args[1].equalsIgnoreCase("0") || args[1].equalsIgnoreCase("s")) {
                                    if (p.hasPermission("pixelnetwork.gmother.0")) {
                                        //survival self
                                        target.setGameMode(GameMode.SURVIVAL);
                                        target.sendMessage(Helpers.GamemodeS);
                                        p.sendMessage(Helpers.Colors(Helpers.prefix + "&6" + target.getName() + "'s &3gamemode has been chananged to SURVIVAL"));
                                    } else {
                                        p.sendMessage(Helpers.noperms);
                                    }
                                } else if (args[1].equalsIgnoreCase("1") || args[1].equalsIgnoreCase("c")) {
                                    if (p.hasPermission("pixelnetwork.gmother.1")) {
                                        //creative self
                                        target.setGameMode(GameMode.CREATIVE);
                                        target.sendMessage(Helpers.GamemodeC);
                                        p.sendMessage(Helpers.Colors(Helpers.prefix + " &6" + target.getName() + "'s &3gamemode has been chananged to CREATIVE"));
                                    } else {
                                        p.sendMessage(Helpers.noperms);
                                    }
                                } else if (args[1].equalsIgnoreCase("2") || args[1].equalsIgnoreCase("a")) {
                                    if (p.hasPermission("pixelnetwork.gmother.2")) {
                                        //advanture self
                                        target.setGameMode(GameMode.ADVENTURE);
                                        target.sendMessage(Helpers.GamemodeA);
                                        p.sendMessage(Helpers.Colors(Helpers.prefix + " &6" + target.getName() + "'s &3gamemode has been chananged to ADVENTURE"));
                                    } else {
                                        p.sendMessage(Helpers.noperms);
                                    }
                                } else if (args[1].equalsIgnoreCase("3") || args[1].equalsIgnoreCase("sp")) {
                                    if (p.hasPermission("pixelnetwork.gmother.3")) {
                                        //spectator self
                                        target.setGameMode(GameMode.SPECTATOR);
                                        target.sendMessage(Helpers.GamemodeSP);
                                        p.sendMessage(Helpers.Colors(Helpers.prefix + " &6" + target.getName() + "'s &3gamemode has been chananged to SPECTATOR"));
                                    } else {
                                        p.sendMessage(Helpers.noperms);
                                    }
                                }
                            }
                        } else {
                            p.sendMessage(Helpers.noperms);
                        }
                    }
                }
            }
        }
        return false;
    }
}
