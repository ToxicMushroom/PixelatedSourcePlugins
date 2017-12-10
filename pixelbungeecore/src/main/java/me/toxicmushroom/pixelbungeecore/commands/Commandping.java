package me.toxicmushroom.pixelbungeecore.commands;

import me.toxicmushroom.pixelbungeecore.Helper;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Commandping extends Command {

    public Commandping(String name) {
        super(name);
    }

    @Override
    public void execute(CommandSender sender, String[] strings) {
        if (sender instanceof ProxiedPlayer) {
            ProxiedPlayer p = (ProxiedPlayer) sender;
            sender.sendMessage(Helper.Colors(Helper.prefix + " &bPing: &c" + p.getPing()));
        }
    }
}
