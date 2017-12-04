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
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class Commandfreeze {

    private FileConfiguration config = Main.getInstance().getConfig();
    private void saveConfig() {
        Main.getInstance().saveConfig();
    }
    public void execute(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (label.equalsIgnoreCase("freeze")) {
                if (p.hasPermission(Helpers.perm + "freeze") || p.isOp() || config.get("PixelNetwork.perms." + p.getName() + ".bypass") == Boolean.TRUE) {
                    if (args.length != 1) {
                        sender.sendMessage(Helpers.prefix + Helpers.Colors(" &cusage: /freeze <player>"));
                        return;
                    }
                    Player target = null;//werk aan de winkel DX
                    for (Player pp : Bukkit.getOnlinePlayers()) {
                        if (pp.getName().equalsIgnoreCase(args[0])) {
                            target = pp;
                        }
                    }
                    if (target == null) {
                        p.sendMessage(Helpers.prefix + Helpers.Colors(" &cplayer not found"));
                        return;
                    }
                    if (config.getBoolean("frozenplayers." + target.getUniqueId())) {
                        config.set("frozenplayers." + target.getUniqueId(), false);
                        saveConfig();
                        sender.sendMessage(Helpers.prefix + Helpers.Colors(" &6" + target.getName() + "&3 has been unfrozen"));
                        target.sendMessage(Helpers.prefix + Helpers.Colors(" &3you're unfrozen"));
                    } else {
                        config.set("frozenplayers." + target.getUniqueId(), true);
                        saveConfig();
                        sender.sendMessage(Helpers.prefix + Helpers.Colors(" &6" + target.getName() + "&3 is now frozen!"));
                        target.sendMessage(Helpers.prefix + Helpers.Colors(" &3you have been frozen"));
                    }
                }
            }
        }
    }
}
