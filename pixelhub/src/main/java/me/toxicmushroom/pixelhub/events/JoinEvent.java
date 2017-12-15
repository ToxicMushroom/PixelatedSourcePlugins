package me.toxicmushroom.pixelhub.events;

import me.toxicmushroom.pixelhub.Helper;
import me.toxicmushroom.pixelhub.PixelHub;
import net.minecraft.server.v1_8_R3.EnumParticle;
import net.minecraft.server.v1_8_R3.PacketPlayOutWorldParticles;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Collection;

public class JoinEvent implements Listener {

    private FileConfiguration config = PixelHub.getInstace().getConfig();

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        ItemStack selector = new ItemStack(Material.NETHER_STAR, 1);
        ItemMeta mselecotr = selector.getItemMeta();
        mselecotr.setDisplayName(Helper.Colors("&3&lCosmetics"));
        mselecotr.spigot().setUnbreakable(true);
        selector.setItemMeta(mselecotr);
        if (!p.getInventory().contains(selector))
            p.getInventory().setItem(9, selector);
        if (!PixelHub.getInstace().getConfig().isConfigurationSection("particles." + p.getUniqueId() + ".show"))
            PixelHub.getInstace().getConfig().set("particles." + p.getUniqueId() + ".show", false);
        PixelHub.getInstace().saveConfig();
        repeat(p);
    }

    private void repeat(Player p) {
        String id = p.getUniqueId().toString();
        new BukkitRunnable() {
            int i = 1;
            public void run() {
                EnumParticle e = null;
                if (!p.isOnline()) cancel();
                if (config.getBoolean("particles." + id + ".show")) {
                    switch (config.getString("particles." + id + ".selected")) {
                        case "FLAME":
                            e = EnumParticle.FLAME;
                            break;
                        case "HEART":
                            e = EnumParticle.HEART;
                            break;
                        case "DRIP_LAVA":
                            e = EnumParticle.DRIP_LAVA;
                            break;
                        case "DRIP_WATER":
                            e = EnumParticle.DRIP_WATER;
                            break;
                        case "CRIT_MAGIC":
                            e = EnumParticle.CRIT_MAGIC;
                            break;
                        case "CLOUD":
                            e = EnumParticle.CLOUD;
                            break;
                        default:
                            break;
                    }
                    switch (i) {
                        case 1:
                            spawnParticle(e, p.getLocation().add(0.5D, 2.0D, 0.0D), Bukkit.getOnlinePlayers());
                            break;
                        case 2:
                            spawnParticle(e, p.getLocation().add(0.4D, 2.0D, 0.4D), Bukkit.getOnlinePlayers());
                            break;
                        case 3:
                            spawnParticle(e, p.getLocation().add(0.0D, 2.0D, 0.5D), Bukkit.getOnlinePlayers());
                            break;
                        case 4:
                            spawnParticle(e, p.getLocation().add(-0.4D, 2.0D, 0.4D), Bukkit.getOnlinePlayers());
                            break;
                        case 5:
                            spawnParticle(e, p.getLocation().add(-0.5D, 2.0D, 0.0D), Bukkit.getOnlinePlayers());
                            break;
                        case 6:
                            spawnParticle(e, p.getLocation().add(-0.4D, 2.0D, -0.4D), Bukkit.getOnlinePlayers());
                            break;
                        case 7:
                            spawnParticle(e, p.getLocation().add(0.0D, 2.0D, -0.5D), Bukkit.getOnlinePlayers());
                            break;
                        case 8:
                            spawnParticle(e, p.getLocation().add(0.4D, 2.0D, -0.4D), Bukkit.getOnlinePlayers());
                            break;
                        default:
                            i = 0;
                            break;
                    }
                    i++;
                }
            }
        }.runTaskTimerAsynchronously(PixelHub.getInstace(), 1, 3);
    }

    private void spawnParticle(EnumParticle particle, Location loc, Collection<? extends Player> collection) {
        PacketPlayOutWorldParticles pp = new PacketPlayOutWorldParticles(particle, true,
                (float) loc.getX(), (float) loc.getY(), (float) loc.getZ(), 0.0F, 0.0F, 0.0F, 0.0F, 1);
        for (Player p : collection) {
            ((CraftPlayer) p).getHandle().playerConnection.sendPacket(pp);
        }
    }
}
