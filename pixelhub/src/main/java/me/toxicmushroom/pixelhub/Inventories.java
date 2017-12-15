package me.toxicmushroom.pixelhub;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Inventories {


    private FileConfiguration config = PixelHub.getInstace().getConfig();

    public Inventory home() {
        Inventory home = Bukkit.createInventory(null, 36, Helper.Colors("&3&lHome"));
        ItemStack particles = new ItemStack(Material.POTION, 1);
        PotionMeta particlesmeta = (PotionMeta) particles.getItemMeta();
        particlesmeta.addCustomEffect(new PotionEffect(PotionEffectType.BLINDNESS, 21, 69), true);
        particlesmeta.setDisplayName(Helper.Colors("&c&lParticles"));
        particles.setItemMeta(particlesmeta);
        home.setItem(11, particles);
        return home;
    }

    public Inventory particles(Player p) {
        Inventory particles = Bukkit.createInventory(null, 18, Helper.Colors("&c&lParticles"));
        ItemStack item = new ItemStack(Material.APPLE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.RED + "Hartjes");
        item.setItemMeta(meta);
        particles.setItem(1, item);

        ItemStack item2 = new ItemStack(Material.FLINT_AND_STEEL);
        ItemMeta meta2 = item2.getItemMeta();
        meta2.setDisplayName(ChatColor.GOLD + "vuurtjes");
        item2.setItemMeta(meta2);
        particles.setItem(3, item2);

        ItemStack item3 = new ItemStack(Material.LAVA_BUCKET);
        ItemMeta meta3 = item3.getItemMeta();
        meta3.setDisplayName(ChatColor.DARK_RED + "lava druppels");
        item3.setItemMeta(meta3);
        particles.setItem(5, item3);

        ItemStack item4 = new ItemStack(Material.WATER_BUCKET);
        ItemMeta meta4 = item4.getItemMeta();
        meta4.setDisplayName(ChatColor.BLUE + "water druppels");
        item4.setItemMeta(meta4);
        particles.setItem(7, item4);

        ItemStack item5 = new ItemStack(Material.STICK);
        ItemMeta meta5 = item5.getItemMeta();
        meta5.setDisplayName(ChatColor.DARK_PURPLE + "Witch crit");
        item5.setItemMeta(meta5);
        particles.setItem(11, item5);

        ItemStack item6 = new ItemStack(Material.MILK_BUCKET);
        ItemMeta meta6 = item6.getItemMeta();
        meta6.setDisplayName(ChatColor.WHITE + "wolkje melk hha");
        item6.setItemMeta(meta6);
        particles.setItem(13, item6);
        if (config.getBoolean("particles." + p.getUniqueId() + ".show")) {
            ItemStack item70 = new ItemStack(Material.WOOL, 1, (short) 5);
            ItemMeta meta70 = item70.getItemMeta();
            meta70.setDisplayName(ChatColor.GREEN + "Particles AAN");
            item70.setItemMeta(meta70);
            particles.setItem(9, item70);
        } else {
            ItemStack item80 = new ItemStack(Material.WOOL, 1, (short) 14);
            ItemMeta meta80 = item80.getItemMeta();
            meta80.setDisplayName(ChatColor.DARK_RED + "Particles UIT");
            item80.setItemMeta(meta80);
            particles.setItem(9, item80);
        }
        return particles;
    }
}
