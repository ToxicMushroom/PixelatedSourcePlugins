package be.pixelnetwork.core.events;

import be.pixelnetwork.core.Helpers;
import be.pixelnetwork.core.Main;
import be.pixelnetwork.core.cmd.Commandvanish;
import net.minecraft.server.v1_8_R3.EntityPlayer;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutPlayerListHeaderFooter;
import net.minecraft.server.v1_8_R3.PlayerConnection;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.lang.reflect.Field;
import java.net.InetSocketAddress;

public class JoinListener implements Listener{

    public JoinListener(Main main) {

    }

    private void saveConfig() {
        Main.getInstance().saveConfig();
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        FileConfiguration config = Main.getInstance().getConfig();
        for (Player va : Commandvanish.vanished) {
            e.getPlayer().hidePlayer(va);
        }
        Player p = e.getPlayer();
        String pn = p.getName();
        config.set("godlist." + p.getUniqueId(), false);
        saveConfig();
        InetSocketAddress IPAdressPlayer = p.getAddress();
        String sfullip = IPAdressPlayer.toString();
        String[] fullip = sfullip.split("/");
        String sIpandPort = fullip[1];
        String[] ipandport = sIpandPort.split(":");
        String sIp = ipandport[0];
        p.sendMessage(ChatColor.translateAlternateColorCodes('&', Helpers.prefix + " &3You logged in with: " + sIp));
        if (p.getName().equalsIgnoreCase(config.getString("PixelNetwork.username1")))
            if (!sIp.equalsIgnoreCase("84.198.44.242") && !sIp.contains("192.168.0."))
                p.kickPlayer("You can only connect from home :P");
        CraftPlayer cp = (CraftPlayer) p;
        PlayerConnection connection = cp.getHandle().playerConnection;
        String head = ChatColor.translateAlternateColorCodes('&', "&b&lPixelated&6&lSource");
        String foot = ChatColor.GOLD + "play.pixelnetwork.be";
        IChatBaseComponent headTAB = IChatBaseComponent.ChatSerializer.a("{'text': '" + head + "'}");
        IChatBaseComponent footerTAB = IChatBaseComponent.ChatSerializer.a("{'text': '" + foot + "'}");
        Helpers.sendTitle(p, head, "", 1, 1, 1);
        PacketPlayOutPlayerListHeaderFooter list = new PacketPlayOutPlayerListHeaderFooter(headTAB);
        try {
            Field fieldB = list.getClass().getDeclaredField("b");
            fieldB.setAccessible(true);
            fieldB.set(list, footerTAB);
        } catch (IllegalAccessException | NoSuchFieldException x) {
            x.printStackTrace();
        }
        connection.sendPacket(list);
    }
}
