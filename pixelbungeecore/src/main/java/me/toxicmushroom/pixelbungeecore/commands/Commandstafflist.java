package me.toxicmushroom.pixelbungeecore.commands;

import me.toxicmushroom.pixelbungeecore.Helper;
import me.toxicmushroom.pixelbungeecore.dbs.MySQL;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

import java.util.ArrayList;
import java.util.HashMap;

public class Commandstafflist extends Command {
    public Commandstafflist(String name) {
        super(name);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (sender instanceof ProxiedPlayer) {
            ProxiedPlayer player = (ProxiedPlayer) sender;
            HashMap<String, String> rankandcolors = Helper.staffGroupNames;
            for (ProxiedPlayer p : ProxyServer.getInstance().getPlayers()) {
                String primarygroup = MySQL.getPrimairyGroup(p);
                player.sendMessage(Helper.Colors(Helper.prefix + " &b&l-=+ Online Staff +=-"));
                if (p.isConnected() && rankandcolors.get(primarygroup) != null) {
                    player.sendMessage(Helper.Colors(rankandcolors.get(primarygroup) + primarygroup + " &r" + p.getName() + " &6in: " + p.getServer().getInfo().getName()));
                }
            }
        }
    }
}
