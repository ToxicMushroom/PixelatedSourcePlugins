package me.toxicmushroom.pixelbungeecore;

import me.toxicmushroom.pixelbungeecore.commands.*;
import me.toxicmushroom.pixelbungeecore.dbs.MySQL;
import me.toxicmushroom.pixelbungeecore.events.JoinEvent;
import me.toxicmushroom.pixelbungeecore.events.LeaveEvent;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;

public class PixelCore extends Plugin {
    private static PixelCore instance;
    public static PixelCore getInstance() {
        return instance;
    }
    @Override
    public void onEnable() {
        instance = this;
        Config.setup();
        Config.saveConfig();
        Helper.initstaffGroups();
        getProxy().getPluginManager().registerListener(this, new JoinEvent());
        getProxy().getPluginManager().registerListener(this, new LeaveEvent());
        getProxy().getPluginManager().registerCommand(this, new Commandsc("sc"));
        getProxy().getPluginManager().registerCommand(this, new Commandping("ping"));
        getProxy().getPluginManager().registerCommand(this, new Commandmsg("msg"));
        getProxy().getPluginManager().registerCommand(this, new Commandreply("reply"));
        getProxy().getPluginManager().registerCommand(this, new Commandstafflist("stafflist"));
        getProxy().getPluginManager().registerCommand(this, new Commandr("r"));
        getLogger().info("Registerd all commands..");
    }
}
