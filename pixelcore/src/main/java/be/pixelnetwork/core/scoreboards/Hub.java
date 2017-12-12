package be.pixelnetwork.core.scoreboards;

import be.pixelnetwork.core.Helpers;
import be.pixelnetwork.core.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.scoreboard.*;
import org.json.JSONObject;

import java.io.IOException;

public class Hub {
    private JSONObject serverstats = null;

    public void addhub(Player p) {
        try {
            serverstats = Helpers.readJsonFromUrl("https://mcapi.us/server/status?ip=mc.dhcnet.be&port=25565");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective obj = board.registerNewObjective("Scoreboard", "dummy");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        obj.setDisplayName(Helpers.Colors("&bPixelated&6Source"));
        Score score = obj.getScore(Helpers.Colors("ip: &6play.&bpixel&6network.be"));
        score.setScore(1);
        Score name = obj.getScore(Helpers.Colors("&9name: " + p.getName()));
        name.setScore(2);

        Team players = board.registerNewTeam("players");
        players.addEntry(ChatColor.DARK_AQUA + "");
        players.setPrefix(ChatColor.GOLD + "players: ");
        if (serverstats != null)
            players.setSuffix(ChatColor.YELLOW + serverstats.getJSONObject("players").get("now").toString() + "/100");
        else
            players.setSuffix(ChatColor.YELLOW + "r.i.p");
        obj.getScore(ChatColor.DARK_AQUA + "").setScore(0);
        Score rank = obj.getScore(Helpers.Colors("Rank: " + Main.getChat().getGroupPrefix(p.getWorld(), Main.getPermission().getPrimaryGroup(p))));
        rank.setScore(3);
        p.setScoreboard(board);


        new BukkitRunnable() {
            public void run() {
                if (!p.isOnline())
                    cancel();
                try {
                    serverstats = Helpers.readJsonFromUrl("https://mcapi.us/server/status?ip=mc.dhcnet.be&port=25565");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (serverstats != null)
                    players.setSuffix(ChatColor.YELLOW + serverstats.getJSONObject("players").get("now").toString() + "/100");
                else
                    players.setSuffix(ChatColor.YELLOW + "r.i.p");
            }
        }.runTaskTimerAsynchronously(Main.getInstance(), 0, 10);
    }

    public static String Colors(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }

    public void stopScheduler(int i) {
        Bukkit.getServer().getScheduler().cancelTask(i);
    }
}
