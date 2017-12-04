package be.pixelnetwork.core.events;

import be.pixelnetwork.core.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBurnEvent;
import org.bukkit.event.block.BlockSpreadEvent;

public class FireSpreadListener implements Listener {

    public FireSpreadListener(Main main) {
    }

    @EventHandler
    public void onBlockBurn(BlockBurnEvent event)
    {
        event.setCancelled(true);
    }

    @EventHandler
    public void onBlockSpread(BlockSpreadEvent event)
    {
        if ((event.getBlock().getTypeId() != 2) || (event.getBlock().getTypeId() != 3)) {
            event.setCancelled(true);
        }
    }
}
