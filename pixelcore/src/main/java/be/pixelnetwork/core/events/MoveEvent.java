package be.pixelnetwork.core.events;

import be.pixelnetwork.core.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class MoveEvent implements Listener{
    private Main instance;
    public MoveEvent(Main main) {
        this.instance = main;
    }
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        if (instance.getConfig().getBoolean("frozenplayers." + p.getUniqueId())) {
            if (e.getFrom().getBlockY() != e.getTo().getBlockY() || e.getFrom().getBlockX() != e.getTo().getBlockX() || e.getFrom().getBlockZ() != e.getTo().getBlockZ())
                p.teleport(e.getFrom());
        }
    }
}
