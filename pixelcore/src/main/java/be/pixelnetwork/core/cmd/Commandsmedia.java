package be.pixelnetwork.core.cmd;

import be.pixelnetwork.core.ConfigMangager;
import be.pixelnetwork.core.Main;
import be.pixelnetwork.core.Helpers;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commandsmedia {

    private ConfigMangager cfmg = ConfigMangager.getInstance();
    public void execute(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            //player
            Player p = (Player) sender;
            if (label.equalsIgnoreCase("yt") || label.equalsIgnoreCase("youtube")) {
                p.sendMessage(Helpers.prefix + " " + ChatColor.DARK_RED + cfmg.getSettings().getString("PixelCore.yt"));
            }
            if (label.equalsIgnoreCase("site") || label.equalsIgnoreCase("forum")) {
                p.sendMessage(Helpers.prefix + " " + ChatColor.GREEN + cfmg.getSettings().getString("PixelCore.site"));
            }
            if (label.equalsIgnoreCase("twitter")) {
                p.sendMessage(Helpers.prefix + " " + ChatColor.AQUA + cfmg.getSettings().getString("PixelCore.twitter"));
            }
            if (label.equalsIgnoreCase("discord")) {
                p.sendMessage(Helpers.prefix + " " + ChatColor.DARK_PURPLE + cfmg.getSettings().getString("PixelCore.discord"));
            }
        } else {
            if (label.equalsIgnoreCase("yt") || label.equalsIgnoreCase("youtube")) {
                Bukkit.getServer().getConsoleSender().sendMessage(Helpers.prefix + " " + ChatColor.DARK_RED + cfmg.getSettings().getString("PixelCore.yt"));
            }
            if (label.equalsIgnoreCase("site") || label.equalsIgnoreCase("forum")) {
                Bukkit.getServer().getConsoleSender().sendMessage(Helpers.prefix + " " + ChatColor.GREEN + cfmg.getSettings().getString("PixelCore.site"));
            }
            if (label.equalsIgnoreCase("twitter")) {
                Bukkit.getServer().getConsoleSender().sendMessage(Helpers.prefix + " " + ChatColor.AQUA + cfmg.getSettings().getString("PixelCore.twitter"));
            }
            if (label.equalsIgnoreCase("discord")) {
                Bukkit.getServer().getConsoleSender().sendMessage(Helpers.prefix + " " + ChatColor.DARK_PURPLE + cfmg.getSettings().getString("PixelCore.discord"));
            }
        }
    }
}
