package be.pixelnetwork.core.events;

import be.pixelnetwork.core.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class DamageEvent implements Listener {

    private FileConfiguration config = Main.getInstance().getConfig();
    public DamageEvent(Main main) {
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onHit(EntityDamageEvent e) {
        if (e.getEntity() instanceof Player) {
            Player p = (Player) e.getEntity();
            if (config.get("godlist." + p.getUniqueId()) != null) {
                if (config.getBoolean("godlist." + p.getUniqueId())) {
                    e.setCancelled(true);
                    p.setHealth(p.getMaxHealth());
                    p.setFoodLevel(20);
                }
            }
        }
    }
}
