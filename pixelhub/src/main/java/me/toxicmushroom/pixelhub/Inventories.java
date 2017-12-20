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

import java.util.Collections;

public class Inventories {


    private FileConfiguration config = PixelHub.getInstance().getConfig();

    public Inventory home() {
        Inventory home = Bukkit.createInventory(null, 36, Helper.Colors("&3&lHome"));
        ItemStack particles = itemCrafter(Material.POTION, 1, "&c&lParticles", "Click here to configure your particles!", 0);
        PotionMeta particlesmeta = (PotionMeta) particles.getItemMeta();
        particlesmeta.addCustomEffect(new PotionEffect(PotionEffectType.BLINDNESS, 21, 69), true);
        particles.setItemMeta(particlesmeta);
        home.setItem(11, particles);
        return home;
    }

    public Inventory particles(Player p) {
        Inventory particles = Bukkit.createInventory(null, 18, Helper.Colors("&c&lParticles"));
        particles.setItem(1, itemCrafter(Material.APPLE, 1, "&dLove", "Click here to select Hearths!", 0));
        particles.setItem(3, itemCrafter(Material.FLINT_AND_STEEL, 1, "&cFire", "Click here to select Fire!", 0));
        particles.setItem(5, itemCrafter(Material.LAVA_BUCKET, 1, "&4Baklava", "Click here to select Lava Drips!", 0));
        particles.setItem(7, itemCrafter(Material.WATER_BUCKET, 1, "&1Magikarp use splash", "Click here to select Water Drips!", 0));
        particles.setItem(11, itemCrafter(Material.STICK, 1, "&5Witch Crits", "Click here to select Witch Crits!", 0));
        particles.setItem(13, itemCrafter(Material.MILK_BUCKET, 1, "&fMilky Way", "Click here to select Clouds!", 0));
        particles.setItem(14, itemCrafter(Material.NOTE_BLOCK, 1, "&aMusic Notes", "Click here to select Music Notes!", 0));
        particles.setItem(15, itemCrafter(Material.DRAGON_EGG, 1, "&5Dragon Breath", "Click here to select Dragon Breath!", 0));
        if (config.getBoolean("particles." + p.getUniqueId() + ".show"))
            particles.setItem(9, itemCrafter(Material.WOOL, 1, "&aParticles enabled!", "Click here to disable particles.", 5));
        else
            particles.setItem(9, itemCrafter(Material.WOOL, 1, "&4Particles disabled!", "Click here to enable particles.", 14));
        return particles;
    }

    private ItemStack itemCrafter(Material material, int amount, String displayname, String lore, int data) {
        ItemStack toreturn = data == 0 ? new ItemStack(material, amount) : new ItemStack(material, amount, (short) data);
        ItemMeta metareturn = toreturn.getItemMeta();
        if (displayname != null)
            metareturn.setDisplayName(displayname);
        if (lore != null)
            metareturn.setLore(Collections.singletonList(lore));
        toreturn.setItemMeta(metareturn);
        return toreturn;
    }
}
