package be.pixelnetwork.core.cmd;

import be.pixelnetwork.core.Helpers;
import be.pixelnetwork.core.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class Commandgod {
    private FileConfiguration config = Main.getInstance().getConfig();
    public void execute(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (label.equalsIgnoreCase("god")) {
                if (p.hasPermission("pixelnetwork.god")) {
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
                            p.sendMessage(Helpers.prefix + Helpers.Colors(" &cPlayer: " + args[0] + " not found"));
                        } else {
                            if (config.get("godlist." + target.getUniqueId()) != null) {
                                if (config.getBoolean("godlist." + target.getUniqueId())) {
                                    config.set("godlist." + target.getUniqueId(), false);
                                    Main.getInstance().saveConfig();
                                    target.sendMessage(Helpers.prefix + Helpers.Colors(" &3God mode disabled."));
                                    p.sendMessage(Helpers.prefix + Helpers.Colors(" &3Successfully disabled &6&l" + target.getName() + "'s &3god mode."));
                                } else {
                                    config.set("godlist." + target.getUniqueId(), true);
                                    Main.getInstance().saveConfig();
                                    target.sendMessage(Helpers.prefix + Helpers.Colors(" &3God mode enabled."));
                                    p.sendMessage(Helpers.prefix + Helpers.Colors(" &3Successfully enabled &6&l" + target.getName() + "'s &3god mode."));
                                }
                            } else {
                                config.set("godlist." + target.getUniqueId(), true);
                                Main.getInstance().saveConfig();
                                target.sendMessage(Helpers.prefix + Helpers.Colors(" &3God mode enabled."));
                                p.sendMessage(Helpers.prefix + Helpers.Colors(" &3Successfully enabled &6&l" + target.getName() + "'s &3god mode."));
                            }
                        }
                    } else if (args.length == 0) {
                        if (config.get("godlist." + p.getUniqueId()) != null) {
                            if (config.getBoolean("godlist." + p.getUniqueId())) {
                                config.set("godlist." + p.getUniqueId(), false);
                                Main.getInstance().saveConfig();
                                p.sendMessage(Helpers.prefix + Helpers.Colors(" &3God mode disabled."));
                            } else {
                                config.set("godlist." + p.getUniqueId(), true);
                                Main.getInstance().saveConfig();
                                p.sendMessage(Helpers.prefix + Helpers.Colors(" &3God mode enabled."));
                            }
                        } else {
                            config.set("godlist." + p.getUniqueId(), true);
                            Main.getInstance().saveConfig();
                            p.sendMessage(Helpers.prefix + Helpers.Colors(" &3God mode enabled."));
                        }
                    } else {
                        p.sendMessage(Helpers.prefix + Helpers.Colors(" &cUsage: /god [player]"));
                    }
                }
            }
        }
    }
}
