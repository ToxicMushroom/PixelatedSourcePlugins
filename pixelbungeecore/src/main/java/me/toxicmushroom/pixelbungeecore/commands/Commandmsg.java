package me.toxicmushroom.pixelbungeecore.commands;

import me.toxicmushroom.pixelbungeecore.Helper;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

import java.util.Arrays;

public class Commandmsg extends Command{
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
                        Helper.msg(localProxiedPlayer1, localProxiedPlayer2, Arrays.toString(args));
                    } else {
                        localProxiedPlayer1.sendMessage(Helper.Colors(Helper.prefix + " &cCouldn't find player: &7" + args[0]));
                    }
                } else {
                    localProxiedPlayer1.sendMessage(Helper.Colors(Helper.prefix + " &cUsage: /msg [player] [message]"));
                }
            }
    }
}
