package be.pixelnetwork.core;

import be.pixelnetwork.core.databases.MongoDB;
import be.pixelnetwork.core.events.*;
import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.permission.Permission;
import org.apache.commons.lang.UnhandledException;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;
import java.util.List;

public class Main extends JavaPlugin implements Listener, TabCompleter {
    private ConfigMangager cfmg;
    private org.bukkit.permissions.Permission fly = new org.bukkit.permissions.Permission("PixelNetwork.*");
    private static Main plugin;
    private PluginManager pm = Bukkit.getPluginManager();
    private static Permission perms = null;
    private static Chat chat = null;

    public static Main getInstance() {
        return plugin;
    }

    private void loadConfigManager() {
        cfmg = new ConfigMangager();
        cfmg.setup();
    }

    private void setupPermission() {
        RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
        perms = rsp.getProvider();
    }

    private void setupChat() {
        RegisteredServiceProvider<Chat> rsp = getServer().getServicesManager().getRegistration(Chat.class);
        chat = rsp.getProvider();
    }

    public static Permission getPermission() {
        return perms;
    }

    public static Chat getChat() {
        return chat;
    }

    public String getPrimaryGroup(String world, OfflinePlayer player) {
        try {
            return perms.getPrimaryGroup(world, player);
        } catch (UnhandledException e) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "No permission plugin.");
            return "default";
        }
    }

    @Override
    public void onEnable() {
        plugin = this;
        saveDefaultConfig();
        loadConfigManager();
        setupPermission();
        setupChat();
        MongoDB mongo = new MongoDB();
        mongo.mongoConnect("mongodb://root:RfjIfYDkgD6VOYDA@mongodb-shard-00-00-kl7ns.mongodb.net:27017,mongodb-shard-00-01-kl7ns.mongodb.net:27017,mongodb-shard-00-02-kl7ns.mongodb.net:27017/admin?replicaSet=MongoDB-shard-0&ssl=true");
        CommandHandler commands = new CommandHandler(this);
        getCommand("fly").setExecutor(commands);
        getCommand("freeze").setExecutor(commands);
        getCommand("gm").setExecutor(commands);
        getCommand("gm").setTabCompleter(this::onTabComplete);
        getCommand("gmc").setExecutor(commands);
        getCommand("gmsp").setExecutor(commands);
        getCommand("gms").setExecutor(commands);
        getCommand("gma").setExecutor(commands);
        getCommand("nv").setExecutor(commands);
        getCommand("nightvision").setExecutor(commands);
        getCommand("v").setExecutor(commands);
        getCommand("tp").setExecutor(commands);
        getCommand("tpa").setExecutor(commands);
        getCommand("tpyes").setExecutor(commands);
        getCommand("tpdeny").setExecutor(commands);
        getCommand("tphere").setExecutor(commands);
        getCommand("heal").setExecutor(commands);
        getCommand("god").setExecutor(commands);
        getCommand("kill").setExecutor(commands);
        getCommand("eat").setExecutor(commands);
        getCommand("ext").setExecutor(commands);
        getCommand("craft").setExecutor(commands);
        getCommand("invsee").setExecutor(commands);
        getCommand("armorsee").setExecutor(commands);
        getCommand("more").setExecutor(commands);
        getCommand("top").setExecutor(commands);
        getCommand("up").setExecutor(commands);
        getCommand("spawn").setExecutor(commands);
        getCommand("setspawn").setExecutor(commands);
        getCommand("speed").setExecutor(commands);
        getCommand("speed").setTabCompleter(this);
        getCommand("time").setExecutor(commands);
        getCommand("storm").setExecutor(commands);
        getCommand("rain").setExecutor(commands);
        getCommand("dry").setExecutor(commands);
        getCommand("site").setExecutor(commands);
        getCommand("discord").setExecutor(commands);
        getCommand("twitter").setExecutor(commands);
        getCommand("yt").setExecutor(commands);
        getCommand("nick").setExecutor(commands);

        pm.registerEvents(this, this);
        pm.registerEvents(new DamageEvent(this), this);
        pm.registerEvents(new InventoryListener(this), this);
        pm.registerEvents(new MoveEvent(this), this);
        pm.registerEvents(new JoinListener(this), this);
        pm.registerEvents(new VapeListener(this), this);
        pm.registerEvents(new FireSpreadListener(this), this);
        pm.registerEvents(new ChatListener(this), this);

        pm.addPermission(fly);
        getLogger().info(ChatColor.DARK_PURPLE + "----||-=+PIXELCORE ENABLED+=-||----");
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("gm") && args.length == 1) return Arrays.asList("1", "2", "3", "s", "c", "a", "sp");
        if (label.equalsIgnoreCase("speed"))
            if (args.length == 1) return Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
            else if (args.length == 2) return Arrays.asList("walk", "fly");
        return null;
    }
}
