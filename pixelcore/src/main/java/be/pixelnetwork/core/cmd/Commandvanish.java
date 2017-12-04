package be.pixelnetwork.core.cmd;

import be.pixelnetwork.core.Helpers;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;


public class Commandvanish {

    public static ArrayList<Player> vanished = new ArrayList<Player>();
    public void execute(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("PixelNetwork.vanish") || p.isOp()) {
                if (!vanished.contains(p)) {
                    for (Player pl : Bukkit.getOnlinePlayers()) {
                        if (!pl.hasPermission("pixelnetwork.seevanish")) {
                            pl.hidePlayer(p);
                        }
                    }
                    p.setAllowFlight(true);
                    p.setFlying(true);
                    vanished.add(p);
                    p.sendMessage(Helpers.prefix + Helpers.Colors(" &3you are now hidden"));
                } else {
                    for (Player pl : Bukkit.getOnlinePlayers()) {
                        pl.showPlayer(p);
                    }
                    p.setAllowFlight(false);
                    p.setFlying(false);
                    vanished.remove(p);
                    p.sendMessage(Helpers.prefix + Helpers.Colors(" &3your are now unhidden"));
                }
            }
        }
    }
}
