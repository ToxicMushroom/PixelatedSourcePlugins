package me.toxicmushroom.pixelbungeecore.commands;

import me.toxicmushroom.pixelbungeecore.Helper;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

import java.util.Arrays;

public class Commandr extends Command {

    public Commandr(String name) {
        super(name);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (sender instanceof ProxiedPlayer) {
            ProxiedPlayer player = (ProxiedPlayer) sender;
            if (args.length > 0) {
                ProxiedPlayer player1 = Helper.getConversation(player);
                if (player1 == null) {
                    player.sendMessage(Helper.Colors(Helper.prefix + " &cThere is nobody to reply to."));
                    return;
                }
                Helper.msg(player, player1, Arrays.toString(args));
            } else {
                player.sendMessage(Helper.Colors(Helper.prefix + " &cUsage: /r <message>"));
            }
        }
    }
}
