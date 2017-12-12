package me.toxicmushroom.pixelbungeecore.commands;

import me.toxicmushroom.pixelbungeecore.Helper;
import me.toxicmushroom.pixelbungeecore.PixelCore;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

import java.io.IOException;
import java.net.InetAddress;

public class Commandping extends Command {

    public Commandping(String name) {
        super(name);
    }

    @Override
    public void execute(CommandSender sender, String[] strings) {
        if (sender instanceof ProxiedPlayer) {
            ProxiedPlayer p = (ProxiedPlayer) sender;
            sender.sendMessage(Helper.Colors(Helper.prefix + " &bPing: &c" + p.getPing()));
        } else {
            long currentTime = System.currentTimeMillis();
            boolean isPinged = false; // 2 seconds
            try {
                isPinged = InetAddress.getByName("www.google.com").isReachable(9000);
            } catch (IOException e) {
                e.printStackTrace();
            }
            currentTime = System.currentTimeMillis() - currentTime;
            if(isPinged) {
                PixelCore.getInstance().getLogger().info("pinged successfully in " + ChatColor.AQUA + currentTime + "millisecond");
            } else {
                System.out.println("Ping is over " + ChatColor.RED + "9000ms.");
            }
        }
    }
}
