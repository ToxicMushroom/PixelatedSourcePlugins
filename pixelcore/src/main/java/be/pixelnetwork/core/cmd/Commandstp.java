package be.pixelnetwork.core.cmd;

import be.pixelnetwork.core.Helpers;
import be.pixelnetwork.core.Main;
import be.pixelnetwork.core.fanciful.FancyMessage;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;


public class Commandstp implements Listener {

    private FileConfiguration config = Main.getInstance().getConfig();
    public void execute(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if (label.equalsIgnoreCase("tp")) {
            if (p.hasPermission(Helpers.perm + "tp")) {
                if (args.length == 0) {
                    p.sendMessage(Helpers.prefix + Helpers.Colors(" &cUsage: /Commandstp <x|~> <y|~> <z|~>    ||    /Commandstp <player> [player]"));
                } else if (args.length == 1) {

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
                        return;
                    } else {
                        p.teleport(target);
                        p.sendMessage(Helpers.prefix + Helpers.Colors(" &3you have teleported to " + target.getName()));
                    }

                } else if (args.length == 2) {

                    Player target1 = null;
                    Player target2 = null;
                    boolean targetFound1 = false;
                    boolean targetFound2 = false;
                    for (Player pp : Bukkit.getOnlinePlayers()) {
                        if (pp.getName().equalsIgnoreCase(args[0])) {
                            target1 = pp;
                            targetFound1 = true;
                        }
                        if (pp.getName().equalsIgnoreCase(args[1])) {
                            target2 = pp;
                            targetFound2 = true;
                        }
                    }
                    if (!targetFound1) {
                        p.sendMessage(Helpers.prefix + Helpers.Colors(" &c" + args[0] + " not found"));
                        return;
                    } else if (!targetFound2) {
                        p.sendMessage(Helpers.prefix + Helpers.Colors(" &c" + args[1] + " not found"));
                        return;
                    } else {
                        target1.teleport(target2);
                        target1.sendMessage(Helpers.prefix + Helpers.Colors(" &3You have been teleported to " + target2.getName()));

                    }

                } else if (args.length == 3) {
                    boolean fat = false;
                    if (args[0].equalsIgnoreCase("-") || args[1].equalsIgnoreCase("-") || args[2].equalsIgnoreCase("-")) {
                        p.sendMessage(Helpers.prefix + Helpers.Colors(" &cUsage: /Commandstp <x|~> <y|~> <z|~>    ||    /Commandstp <player> [player]"));
                        return;
                    }
                    if (!args[0].equalsIgnoreCase("~")) {
                        int arg0 = 2;
                        if (args[0].startsWith("-")) {
                            arg0 = 1;
                        }
                        for (String s : args[0].split("[0-9]")) {
                            if (arg0 != 1) {
                                if (!s.matches("[0-9]")) {
                                    fat = true;
                                }
                            } else {
                                arg0++;
                            }
                        }
                    } else {
                        args[0] = String.valueOf(p.getLocation().getBlockX());
                    }
                    if (!args[1].equalsIgnoreCase("~")) {
                        int arg1 = 2;
                        if (args[1].startsWith("-")) {
                            arg1 = 1;
                        }
                        for (String s : args[1].split("[0-9]")) {
                            if (arg1 != 1) {
                                if (!s.matches("[0-9]")) {
                                    fat = true;
                                }
                            } else {
                                arg1++;
                            }
                        }
                    } else {
                        args[1] = String.valueOf(p.getLocation().getBlockY());
                    }
                    if (!args[2].equalsIgnoreCase("~")) {
                        int arg2 = 2;
                        if (args[2].startsWith("-")) {
                            arg2 = 1;
                        }
                        for (String s : args[2].split("[0-9]")) {
                            if (arg2 != 1) {
                                if (!s.matches("[0-9]")) {
                                    fat = true;
                                }
                            } else {
                                arg2++;
                            }
                        }
                    } else {
                        args[2] = String.valueOf(p.getLocation().getBlockZ());
                    }
                    if (!fat) {
                        double x = Double.parseDouble(args[0]) + 0.5;
                        double y = Double.parseDouble(args[1]);
                        double z = Double.parseDouble(args[2]) + 0.5;
                        p.teleport(new Location(p.getWorld(), x, y, z));
                    } else {
                        p.sendMessage(Helpers.prefix + Helpers.Colors(" &cOnly numbers or ~ !"));
                        return;
                    }
                } else {
                    p.sendMessage(Helpers.prefix + Helpers.Colors(" &cUsage: /Commandstp <x|~> <y|~> <z|~>    ||    /Commandstp <player> [player]"));
                    return;
                }
            } else {
                p.sendMessage(Helpers.noperms);
            }
        }
        if (label.equalsIgnoreCase("tphere")) {
            if (p.hasPermission(Helpers.perm + "tphere")) {
                if (args.length == 1) {
                    Player target = null;
                    boolean targetFound = false;
                    for (Player pp : Bukkit.getOnlinePlayers()) {
                        if (pp.getName().equalsIgnoreCase(args[0])) {
                            target = Bukkit.getPlayer(pp.getUniqueId());
                            targetFound = true;
                        }
                    }
                    if (!targetFound) {
                        p.sendMessage(Helpers.prefix + Helpers.Colors(" &c" + args[0] + " not found"));
                        return;
                    } else {
                        target.teleport(p);
                        p.sendMessage(Helpers.prefix + Helpers.Colors(" &3You have teleported &6&l" + target.getName() + " &3to you."));
                        target.sendMessage(Helpers.prefix + Helpers.Colors(" &3You have been teleported."));
                        return;
                    }
                } else {
                    p.sendMessage(Helpers.prefix + Helpers.Colors(" &cUsage: /tphere <player>"));
                }
            } else {
                p.sendMessage(Helpers.noperms);
            }
        }
        if (label.equalsIgnoreCase("tpa")) {
            if (p.hasPermission(Helpers.perm + "tpa")) {
                if (args.length == 0) {
                    p.sendMessage(Helpers.Colors("&cUsage: /tpa <Player>"));
                } else if (args.length == 1) {

                    Player target = null;
                    boolean targetFound = false;
                    for (Player pp : Bukkit.getOnlinePlayers()) {
                        if (pp.getName().equalsIgnoreCase(args[0])) {
                            target = Bukkit.getPlayer(pp.getUniqueId());
                            targetFound = true;
                        }
                    }
                    if (!targetFound) {
                        p.sendMessage(Helpers.prefix + Helpers.Colors(" &c" + args[0] + " not found"));
                        return;
                    } else {
                        if (!config.getBoolean("unable." + p.getName() + "." + target.getName())
                                && !config.getBoolean("delay." + p.getName() + "." + target.getName())) {

                            new FancyMessage(p.getName() + " has requested to teleport to your location.")
                                    .color(ChatColor.GREEN)
                                    .then(" [accept] ")
                                    .color(ChatColor.AQUA)
                                    .tooltip("click to accept the Commandstp request")
                                    .command("/tpyes")
                                    .then(" [deny] ")
                                    .color(ChatColor.RED)
                                    .tooltip("click to deny the Commandstp request")
                                    .command("/tpdeny")
                                    .send(target);

                            unableIgnore(target, p);
                            config.set("tprequests." + target.getName(), p.getName());
                            Main.getInstance().saveConfig();
                        } else {
                            p.sendMessage(Helpers.prefix + Helpers.Colors(" &3The target has denied or ignored your last request please wait."));
                        }
                    }
                } else {
                    p.sendMessage(Helpers.Colors("&cUsage: /tpa <Player>"));
                }
            } else {
                p.sendMessage(Helpers.noperms);
            }
        }
        if (label.equalsIgnoreCase("tpyes")) {
            if (p.hasPermission(Helpers.perm + "tpyes")) {
                if (config.get("tprequests." + p.getName()) != null) {
                    Player rq = p;
                    boolean targetFound = false;
                    for (Player pp : Bukkit.getOnlinePlayers()) {
                        if (pp.getName().equalsIgnoreCase(config.getString("tprequests." + p.getName()))) {
                            rq = Bukkit.getPlayer(pp.getUniqueId());
                            targetFound = true;
                        }
                    }
                    final Player rqf = rq;
                    if (!targetFound) {
                        p.sendMessage(Helpers.prefix + Helpers.Colors(" there are currently no Commandstp requests or they have expired."));
                        return;
                    } else {
                        tpWait(rq);
                        config.set("tptime." + p.getName(), 5);
                        config.set("waiting." + rq.getName(), true);
                        config.set("unable." + rq.getName() + "." + p.getName(), false);
                        config.set("delay." + rq.getName() + "." + p.getName(), false);
                        config.set("tprequests." + p.getName(), null);
                        Main.getInstance().saveConfig();

                        new BukkitRunnable() {
                            @Override
                            public void run() {

                                if (config.get("waiting." + rqf.getName()) != null) {


                                    if (config.getInt("tptime." + p.getName()) == 0) {
                                        rqf.teleport(p);
                                        config.set("tptime." + p.getName(), null);
                                        config.set("tprequests." + p.getName(), null);
                                        Main.getInstance().saveConfig();
                                        cancel();
                                    } else {
                                        rqf.sendMessage(Helpers.prefix + " wait " + config.getInt("tptime." + p.getName()) + " seconds.");
                                        config.set("tptime." + p.getName(), config.getInt("tptime." + p.getName()) - 1);
                                    }
                                    Main.getInstance().saveConfig();

                                } else {
                                    config.set("tptime." + p.getName(), null);
                                    config.set("tprequests." + p.getName(), null);
                                    Main.getInstance().saveConfig();
                                    rqf.sendMessage(Helpers.prefix + Helpers.Colors(" &cYou have moved, your TP request has been cancelled!"));
                                    cancel();
                                }
                            }
                        }.runTaskTimerAsynchronously(Main.getInstance(), 1, 20);
                    }
                } else {
                    p.sendMessage(Helpers.prefix + ChatColor.translateAlternateColorCodes('&', " there are currently no Commandstp requests or they have expired."));
                }
            }
        }
        if (label.equalsIgnoreCase("tpdeny")) {
            if (p.hasPermission(Helpers.perm + "tpdeny")) {
                if (config.get("tprequests." + p.getName()) != null) {
                    Player rq = p;
                    boolean targetFound = false;
                    for (Player pp : Bukkit.getOnlinePlayers()) {
                        if (pp.getName().equalsIgnoreCase(config.getString("tprequests." + p.getName()))) {
                            rq = Bukkit.getPlayer(pp.getUniqueId());
                            targetFound = true;
                        }
                    }
                    if (!targetFound) {
                        p.sendMessage(Helpers.prefix + ChatColor.translateAlternateColorCodes('&', " there are currently no Commandstp requests or they have expired."));
                    } else {
                        unableDeny(p, rq);
                        config.set("tprequests." + p.getName(), null);
                        config.set("unable." + rq.getName() + "." + p.getName(), true);
                        Main.getInstance().saveConfig();
                        p.sendMessage(Helpers.prefix + Helpers.Colors(" &3You have denied " + rq.getName() + "'s Commandstp request."));
                        rq.sendMessage(Helpers.prefix + Helpers.Colors(" &c" + p.getName() + " has denied your Commandstp request!"));
                    }
                } else {
                    p.sendMessage(Helpers.prefix + ChatColor.translateAlternateColorCodes('&', " there are currently no Commandstp requests or they have expired."));
                }
            }
        }
    }

    private void unableDeny(Player p, Player rq) {
        config.set("unable." + rq.getName() + "." + p.getName(), true);
        Main.getInstance().saveConfig();
        new BukkitRunnable() {
            @Override
            public void run() {
                config.set("unable." + rq.getName() + "." + p.getName(), false);
                Main.getInstance().saveConfig();
            }
        }.runTaskLaterAsynchronously(Main.getInstance(), 3600);
    }

    private void unableIgnore(Player p, Player rq) {
        config.set("delay." + rq.getName() + "." + p.getName(), true);
        Main.getInstance().saveConfig();
        new BukkitRunnable() {
            @Override
            public void run() {
                config.set("delay." + rq.getName() + "." + p.getName(), false);
                Main.getInstance().saveConfig();
            }
        }.runTaskLaterAsynchronously(Main.getInstance(), 1200);
    }

    private void tpWait(Player p) {
        config.set("plocX." + p.getName(), p.getLocation().getBlockX());
        config.set("plocY." + p.getName(), p.getLocation().getY());
        config.set("plocZ." + p.getName(), p.getLocation().getBlockZ());
        Main.getInstance().saveConfig();

        new BukkitRunnable() {
            @Override
            public void run() {
                if (config.getInt("plocX." + p.getName()) != p.getLocation().getBlockX() ||
                        config.getInt("plocZ." + p.getName()) != p.getLocation().getBlockZ() ||
                        config.getInt("plocY." + p.getName()) != p.getLocation().getY()) {

                    config.set("waiting." + p.getName(), null);
                    config.set("plocX." + p.getName(), null);
                    config.set("plocY." + p.getName(), null);
                    config.set("plocZ." + p.getName(), null);
                    Main.getInstance().saveConfig();
                    cancel();
                }
                config.set("plocX." + p.getName(), p.getLocation().getBlockX());
                config.set("plocY." + p.getName(), p.getLocation().getY());
                config.set("plocZ." + p.getName(), p.getLocation().getBlockZ());
                Main.getInstance().saveConfig();
            }
        }.runTaskTimerAsynchronously(Main.getInstance(), 2, 5);
    }
}
