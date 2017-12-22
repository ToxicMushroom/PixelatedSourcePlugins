package me.toxicmushroom.pixelhub.events;

import me.toxicmushroom.pixelhub.Helper;
import me.toxicmushroom.pixelhub.PixelHub;
import me.toxicmushroom.pixelhub.dbs.MySQL;
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

    private FileConfiguration config = PixelHub.getInstance().getConfig();
    private MySQL mySQL = new MySQL();

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
        if (config.get("particles." + p.getUniqueId() + ".show") == null)
            config.set("particles." + p.getUniqueId() + ".show", false);
        if (config.get("particles." + p.getUniqueId().toString() + ".selected") == null)
            config.set("particles." + p.getUniqueId() + ".selected", "FLAME");
        Helper.time.put(p.getUniqueId().toString(), 0.0);
        PixelHub.getInstance().saveConfig();
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
                        case "NOTE":
                            e = EnumParticle.NOTE;
                            break;
                        case "SPELL_WITCH":
                            e = EnumParticle.SPELL_WITCH;
                        default:
                            break;
                    }
                    if (Helper.time.get(p.getUniqueId().toString()) == 0) {
                        switch (i) {
                            case 1:
                                spawnParticle(e, p.getLocation().add(0.5D, 2.0D, 0.0D), p);
                                break;
                            case 2:
                                spawnParticle(e, p.getLocation().add(0.4D, 2.0D, 0.4D), p);
                                break;
                            case 3:
                                spawnParticle(e, p.getLocation().add(0.0D, 2.0D, 0.5D), p);
                                break;
                            case 4:
                                spawnParticle(e, p.getLocation().add(-0.4D, 2.0D, 0.4D), p);
                                break;
                            case 5:
                                spawnParticle(e, p.getLocation().add(-0.5D, 2.0D, 0.0D), p);
                                break;
                            case 6:
                                spawnParticle(e, p.getLocation().add(-0.4D, 2.0D, -0.4D), p);
                                break;
                            case 7:
                                spawnParticle(e, p.getLocation().add(0.0D, 2.0D, -0.5D), p);
                                break;
                            case 8:
                                spawnParticle(e, p.getLocation().add(0.4D, 2.0D, -0.4D), p);
                                break;
                            default:
                                i = 0;
                                break;
                        }
                    } else spawnParticle(e, p.getLocation(), p);
                    if (Helper.time.get(p.getUniqueId().toString()) != 0)
                        Helper.time.put(p.getUniqueId().toString(), Helper.time.get(p.getUniqueId().toString()) - 0.5);
                    i++;
                }
            }
        }.runTaskTimerAsynchronously(PixelHub.getInstance(), 1, 2);
    }

    private void spawnParticle(EnumParticle particle, Location loc, Player p) {
        PacketPlayOutWorldParticles pp = new PacketPlayOutWorldParticles(particle, true,
                (float) loc.getX(), (float) loc.getY(), (float) loc.getZ(), 0.0F, 0.0F, 0.0F, 0.0F, 1);
        if (mySQL.isVanishedPlayer(p))
            for (Player p2 : Bukkit.getOnlinePlayers()) {
                if (p2.hasPermission(Helper.perm + "seevanished"))
                    ((CraftPlayer) p2).getHandle().playerConnection.sendPacket(pp);
            }
        else for (Player p2 : Bukkit.getOnlinePlayers()) {
            ((CraftPlayer) p2).getHandle().playerConnection.sendPacket(pp);
        }
    }
}
