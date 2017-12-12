package me.toxicmushroom.pixelbungeecore.commands;

import com.google.common.collect.ImmutableSet;
import me.toxicmushroom.pixelbungeecore.Helper;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.TabExecutor;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Commandmsg extends Command implements TabExecutor {
    public Commandmsg(String name) {
        super(name);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if ((sender instanceof ProxiedPlayer)) {
            ProxiedPlayer localProxiedPlayer1 = (ProxiedPlayer) sender;
            if (args.length > 1) {
                ProxiedPlayer localProxiedPlayer2 = ProxyServer.getInstance().getPlayer(args[0]);
                if (localProxiedPlayer2 != null) {
                    Helper.msg(localProxiedPlayer1, localProxiedPlayer2, Helper.stringlistToString(args, 1));
                } else {
                    localProxiedPlayer1.sendMessage(Helper.Colors(Helper.prefix + " &cCouldn't find player: &7" + args[0]));
                }
            } else {
                localProxiedPlayer1.sendMessage(Helper.Colors(Helper.prefix + " &cUsage: /msg [player] [message]"));
            }
        }
    }

    @Override
    public Iterable<String> onTabComplete(CommandSender sender, String[] args) {
        if (args.length > 2 || args.length == 0) {
            return ImmutableSet.of();
        }

        Set<String> matches = new HashSet<>();
        if (args.length == 1) {
            String search = args[0].toLowerCase();
            for (ProxiedPlayer player : ProxyServer.getInstance().getPlayers()) {
                if (player.getName().toLowerCase().startsWith(search)) {
                    matches.add(player.getName());
                }
            }
        }
        return matches;
    }
}
