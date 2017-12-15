package me.toxicmushroom.pixelbungeecore.commands;

import me.toxicmushroom.pixelbungeecore.Helper;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Commandsc extends Command {

    public Commandsc(String name) {
        super(name);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (sender instanceof ProxiedPlayer) {
            ProxiedPlayer player = (ProxiedPlayer) sender;
            if (player.hasPermission(Helper.permission + "staff")) {
                for (ProxiedPlayer staff : Helper.staff) {
                    staff.sendMessage(Helper.Colors(Helper.prefix + " &a" + player.getName() + "&7: &6" + Helper.stringlistToString(args, 0)));
                }
            }
        } else {
            for (ProxiedPlayer staff : Helper.staff) {
                staff.sendMessage(Helper.Colors(Helper.prefix + " &5CONSOLE&7: &6" + Helper.stringlistToString(args, 0)));
            }
        }
    }
}
