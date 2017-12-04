package be.pixelnetwork.core.cmd;

import be.pixelnetwork.core.Helpers;
import be.pixelnetwork.core.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Commandnightvision {

    private FileConfiguration config = Main.getInstance().getConfig();
    public void execute(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (label.equalsIgnoreCase("nv") || label.equalsIgnoreCase("nightvision")) {
                if (p.hasPermission("PixelNetwork.nv") || p.isOp() || p.isFlying() || config.get("PixelNetwork.perms." + p.getName() + ".bypass") == Boolean.TRUE) {
                    if (args.length == 0) {
                        if (p.hasPotionEffect(PotionEffectType.NIGHT_VISION)) {
                            p.removePotionEffect(PotionEffectType.NIGHT_VISION);
                            p.sendMessage(Helpers.prefix + Helpers.Colors(" &3night vision disabled!"));
                        } else {
                            p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 100000, 2));
                            p.sendMessage(Helpers.prefix + Helpers.Colors(" &3night vision enabled!"));
                        }
                    } else if (args.length == 1) {
                        if (p.hasPermission("PixelNetwork.givenv") || p.isOp() || config.get("PixelNetwork.perms." + p.getName() + ".bypass") == Boolean.TRUE) {
                            Player target = null;
                            for (Player pp : Bukkit.getOnlinePlayers()) {
                                if (pp.getName().equalsIgnoreCase(args[0])) target = Bukkit.getPlayer(pp.getUniqueId());
                            }
                            if (target == null) {
                                p.sendMessage(Helpers.prefix + Helpers.Colors(" &cthat player isn't online"));
                            } else {
                                if (!target.hasPotionEffect(PotionEffectType.NIGHT_VISION)) {
                                    target.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 100000, 2));
                                    p.sendMessage(Helpers.prefix + Helpers.Colors(" &3night vision for &6" + args[0] + " &3enabled!"));
                                    target.sendMessage(Helpers.prefix + Helpers.Colors(" &3night vision enabled!"));
                                } else {
                                    target.removePotionEffect(PotionEffectType.NIGHT_VISION);
                                    p.sendMessage(Helpers.prefix + Helpers.Colors(" &3night vision for &6" + args[0] + " &3disabled!"));
                                    target.sendMessage(Helpers.prefix + Helpers.Colors(" &3night vision disabled!"));
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
}
