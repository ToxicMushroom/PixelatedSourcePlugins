package be.pixelnetwork.core.cmd;

import be.pixelnetwork.core.Helpers;
import be.pixelnetwork.core.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Commandtime {

    public static Inventory timeinv = Bukkit.createInventory(null, 27, "Time");
    public void execute(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (label.equalsIgnoreCase("time")) {
                if (p.hasPermission("pixelnetwork.time")) {
                    p.openInventory(timeinv);
                } else {
                    p.sendMessage(Helpers.noperms);
                }
            }
        }
    }
    public Commandtime() {
        ItemStack hour1 = new ItemStack(Material.STAINED_CLAY,1, DyeColor.BLACK.getData());
        ItemStack hour2 = new ItemStack(Material.STAINED_CLAY,2, DyeColor.BLACK.getData());
        ItemStack hour3 = new ItemStack(Material.STAINED_CLAY,3, DyeColor.BLACK.getData());
        ItemStack hour4 = new ItemStack(Material.STAINED_CLAY,4, DyeColor.BLACK.getData());
        ItemStack hour5 = new ItemStack(Material.STAINED_CLAY,5, DyeColor.BLACK.getData());
        ItemStack hour6 = new ItemStack(Material.STAINED_CLAY,6, DyeColor.GRAY.getData());
        ItemStack hour7 = new ItemStack(Material.STAINED_CLAY,7, DyeColor.RED.getData());
        ItemStack hour8 = new ItemStack(Material.STAINED_CLAY,8, DyeColor.BLUE.getData());
        ItemStack hour9 = new ItemStack(Material.STAINED_CLAY,9, DyeColor.BLUE.getData());
        ItemStack hour10 = new ItemStack(Material.STAINED_CLAY,10, DyeColor.LIGHT_BLUE.getData());
        ItemStack hour11 = new ItemStack(Material.STAINED_CLAY,11, DyeColor.LIGHT_BLUE.getData());
        ItemStack hour12 = new ItemStack(Material.STAINED_CLAY,12, DyeColor.YELLOW.getData());
        ItemStack hour13 = new ItemStack(Material.STAINED_CLAY,13, DyeColor.YELLOW.getData());
        ItemStack hour14 = new ItemStack(Material.STAINED_CLAY,14, DyeColor.YELLOW.getData());
        ItemStack hour15 = new ItemStack(Material.STAINED_CLAY,15, DyeColor.LIGHT_BLUE.getData());
        ItemStack hour16 = new ItemStack(Material.STAINED_CLAY,16, DyeColor.LIGHT_BLUE.getData());
        ItemStack hour17 = new ItemStack(Material.STAINED_CLAY,17, DyeColor.BLUE.getData());
        ItemStack hour18 = new ItemStack(Material.STAINED_CLAY,18, DyeColor.BLUE.getData());
        ItemStack hour19 = new ItemStack(Material.STAINED_CLAY,19, DyeColor.RED.getData());
        ItemStack hour20 = new ItemStack(Material.STAINED_CLAY,20, DyeColor.GRAY.getData());
        ItemStack hour21 = new ItemStack(Material.STAINED_CLAY,21, DyeColor.GRAY.getData());
        ItemStack hour22 = new ItemStack(Material.STAINED_CLAY,22, DyeColor.GRAY.getData());
        ItemStack hour23 = new ItemStack(Material.STAINED_CLAY,23, DyeColor.BLACK.getData());
        ItemStack hour24 = new ItemStack(Material.STAINED_CLAY,24, DyeColor.BLACK.getData());
        ItemMeta mhour1 = hour1.getItemMeta();
        ItemMeta mhour2 = hour2.getItemMeta();
        ItemMeta mhour3 = hour3.getItemMeta();
        ItemMeta mhour4 = hour4.getItemMeta();
        ItemMeta mhour5 = hour5.getItemMeta();
        ItemMeta mhour6 = hour6.getItemMeta();
        ItemMeta mhour7 = hour7.getItemMeta();
        ItemMeta mhour8 = hour8.getItemMeta();
        ItemMeta mhour9 = hour9.getItemMeta();
        ItemMeta mhour10 = hour10.getItemMeta();
        ItemMeta mhour11 = hour11.getItemMeta();
        ItemMeta mhour12 = hour12.getItemMeta();
        ItemMeta mhour13 = hour13.getItemMeta();
        ItemMeta mhour14 = hour14.getItemMeta();
        ItemMeta mhour15 = hour15.getItemMeta();
        ItemMeta mhour16 = hour16.getItemMeta();
        ItemMeta mhour17 = hour17.getItemMeta();
        ItemMeta mhour18 = hour18.getItemMeta();
        ItemMeta mhour19 = hour19.getItemMeta();
        ItemMeta mhour20 = hour20.getItemMeta();
        ItemMeta mhour21 = hour21.getItemMeta();
        ItemMeta mhour22 = hour22.getItemMeta();
        ItemMeta mhour23 = hour23.getItemMeta();
        ItemMeta mhour24 = hour24.getItemMeta();
        mhour1.setDisplayName(ChatColor.BLACK + "1h (1 AM)");
        mhour2.setDisplayName(ChatColor.BLACK + "2h (2 AM)");
        mhour3.setDisplayName(ChatColor.BLACK + "3h (3 AM)");
        mhour4.setDisplayName(ChatColor.BLACK + "4h (4 AM)");
        mhour5.setDisplayName(ChatColor.BLACK + "5h (5 AM)");
        mhour6.setDisplayName(ChatColor.GRAY + "6h (6 AM)");
        mhour7.setDisplayName(ChatColor.RED + "7h (7 AM)");
        mhour8.setDisplayName(ChatColor.BLUE + "8h (8 AM)");
        mhour9.setDisplayName(ChatColor.BLUE + "9h (9 AM)");
        mhour10.setDisplayName(ChatColor.AQUA + "10h (10 AM)");
        mhour11.setDisplayName(ChatColor.AQUA + "11h (11 AM)");
        mhour12.setDisplayName(ChatColor.YELLOW + "12h (12 AM)");
        mhour13.setDisplayName(ChatColor.YELLOW + "13h (1 PM)");
        mhour14.setDisplayName(ChatColor.YELLOW + "14h (2 PM)");
        mhour15.setDisplayName(ChatColor.AQUA + "15h (3 PM)");
        mhour16.setDisplayName(ChatColor.AQUA + "16h (4 PM)");
        mhour17.setDisplayName(ChatColor.BLUE + "17h (5 PM)");
        mhour18.setDisplayName(ChatColor.BLUE + "18h (6 PM)");
        mhour19.setDisplayName(ChatColor.RED + "19h (7 PM)");
        mhour20.setDisplayName(ChatColor.GRAY + "20h (8 PM)");
        mhour21.setDisplayName(ChatColor.GRAY + "21h (9 PM)");
        mhour22.setDisplayName(ChatColor.GRAY + "22h (10 PM)");
        mhour23.setDisplayName(ChatColor.BLACK + "23h (11 PM)");
        mhour24.setDisplayName(ChatColor.BLACK + "24h (12 PM)");
        hour1.setItemMeta(mhour1);
        hour2.setItemMeta(mhour2);
        hour3.setItemMeta(mhour3);
        hour4.setItemMeta(mhour4);
        hour5.setItemMeta(mhour5);
        hour6.setItemMeta(mhour6);
        hour7.setItemMeta(mhour7);
        hour8.setItemMeta(mhour8);
        hour9.setItemMeta(mhour9);
        hour10.setItemMeta(mhour10);
        hour11.setItemMeta(mhour11);
        hour12.setItemMeta(mhour12);
        hour13.setItemMeta(mhour13);
        hour14.setItemMeta(mhour14);
        hour15.setItemMeta(mhour15);
        hour16.setItemMeta(mhour16);
        hour17.setItemMeta(mhour17);
        hour18.setItemMeta(mhour18);
        hour19.setItemMeta(mhour19);
        hour20.setItemMeta(mhour20);
        hour21.setItemMeta(mhour21);
        hour22.setItemMeta(mhour22);
        hour23.setItemMeta(mhour23);
        hour24.setItemMeta(mhour24);
        timeinv.setItem(1,hour1);
        timeinv.setItem(2,hour2);
        timeinv.setItem(3,hour3);
        timeinv.setItem(4,hour4);
        timeinv.setItem(5,hour5);
        timeinv.setItem(6,hour6);
        timeinv.setItem(7,hour7);
        timeinv.setItem(8,hour8);
        timeinv.setItem(9,hour9);
        timeinv.setItem(10,hour10);
        timeinv.setItem(11,hour11);
        timeinv.setItem(12,hour12);
        timeinv.setItem(13,hour13);
        timeinv.setItem(14,hour14);
        timeinv.setItem(15,hour15);
        timeinv.setItem(16,hour16);
        timeinv.setItem(17,hour17);
        timeinv.setItem(18,hour18);
        timeinv.setItem(19,hour19);
        timeinv.setItem(20,hour20);
        timeinv.setItem(21,hour21);
        timeinv.setItem(22,hour22);
        timeinv.setItem(23,hour23);
        timeinv.setItem(24,hour24);
    }
}
