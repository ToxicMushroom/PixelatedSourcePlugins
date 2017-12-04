package be.pixelnetwork.core;

import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import net.minecraft.server.v1_8_R3.PlayerConnection;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Merlijn on 3/07/2017.
 */
public class Helpers {

    public static String perm = "pixelcore.cmd.";
    public static String GamemodeS = Colors("&3Your gamemode has been changed to SURVIVAL.");
    public static String GamemodeSP = Colors("&3Your gamemode has been changed to SPECTATOR.");
    public static String GamemodeC = Colors("&3Your gamemode has been changed to CREATIVE.");
    public static String GamemodeA = Colors("&3Your gamemode has been changed to ADVENTURE.");

    public static String GamemodeSotherChanger = Colors("&3You've changed has been changed to SURVIVAL.");
    public static String GamemodeSPotherChanger = Colors("&3You've gamemode has been changed to SPECTATOR.");
    public static String GamemodeCotherChanger = Colors("&3You've gamemode has been changed to CREATIVE.");
    public static String GamemodeAOtherChanger = Colors("&3You've gamemode has been changed to ADVENTURE.");

    public static String prefix = Colors("&f[&b&lP&6&lS&f]");
    public static String noperms = prefix + Colors(" &cyou do not have permission to use this command");

    public static String Colors(String text) {

        return ChatColor.translateAlternateColorCodes('&', text);

    }
    public static boolean isInt(String str)
    {
        try
        {
            Integer.parseInt(str);
        }
        catch (NumberFormatException e)
        {
            return false;
        }
        return true;
    }

    public static boolean hasFullInventory(Player player)
    {
        ItemStack[] arrayOfItemStack;
        int j = (arrayOfItemStack = player.getInventory().getContents()).length;
        for (int i = 0; i < j; i++)
        {
            ItemStack is = arrayOfItemStack[i];
            if ((is == null) || (is.getType() == Material.AIR)) {
                return false;
            }
        }
        return true;
    }
    public static void sendTitle(Player player, String title, String subtitle, int fadeIn, int stay, int fadeOut) {
        CraftPlayer craftplayer = (CraftPlayer) player;
        PlayerConnection connection = craftplayer.getHandle().playerConnection;
        IChatBaseComponent titleJSON = IChatBaseComponent.ChatSerializer.a("{'text': '" + title + "'}");
        IChatBaseComponent subtitleJSON = IChatBaseComponent.ChatSerializer.a("{'text': '" + subtitle + "'}");
        PacketPlayOutTitle titlePacket = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, titleJSON, fadeIn, stay, fadeOut);
        PacketPlayOutTitle subtitlePacket = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE, subtitleJSON);
        connection.sendPacket(titlePacket);
        connection.sendPacket(subtitlePacket);
    }

}
