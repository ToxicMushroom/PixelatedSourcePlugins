package me.toxicmushroom.pixelbungeecore;

import me.toxicmushroom.pixelbungeecore.commands.*;
import me.toxicmushroom.pixelbungeecore.dbs.MySQL;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;

public class PixelCore extends Plugin {
    public static MySQL mySQL = new MySQL();
    private static PixelCore instance;
    public static PixelCore getInstance() {
        return instance;
    }
    @Override
    public void onEnable() {
        instance = this;
        Config.setup();
        Configuration config = Config.configuration;
        mySQL.connect(config.getString("mysql.ipadress"), config.getString("mysql.database"), config.getString("mysql.username"), config.getString("mysql.password"));
        Config.saveConfig();
        Helper.initstaffGroups();
        getProxy().getPluginManager().registerCommand(this, new Commandping("ping"));
        getProxy().getPluginManager().registerCommand(this, new Commandmsg("msg"));
        getProxy().getPluginManager().registerCommand(this, new Commandreply("reply"));
        getProxy().getPluginManager().registerCommand(this, new Commandstafflist("stafflist"));
        getProxy().getPluginManager().registerCommand(this, new Commandr("r"));
        getLogger().info("Registerd all commands..");
    }
}
