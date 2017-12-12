package be.pixelnetwork.core.cmd;

import be.pixelnetwork.core.Helpers;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Commandmore {

    public void execute(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (label.equalsIgnoreCase("more")) {
                if (p.hasPermission(Helpers.perm + "more")) {
                    if (p.getItemInHand().getType() != Material.AIR) {
                        ItemStack hand = p.getItemInHand();
                        hand.setAmount(64);
                        p.setItemInHand(hand);
                        p.sendMessage(Helpers.prefix + Helpers.Colors(" &3You have gained 64x " + hand.getType()));
                    }
                } else {
                    p.sendMessage(Helpers.noperms);
                }
            }
        }
    }
}
