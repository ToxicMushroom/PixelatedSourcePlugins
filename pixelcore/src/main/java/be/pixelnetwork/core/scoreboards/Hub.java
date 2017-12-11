package be.pixelnetwork.core.scoreboards;

import be.pixelnetwork.core.Helpers;
import be.pixelnetwork.core.Main;
import org.json.JSONObject;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.*;

import java.io.IOException;

public class Hub {

    public void addhub(Player p) {
        JSONObject serverstats = null;
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
            players.setSuffix(ChatColor.YELLOW + serverstats.getJSONObject("players").get("now").toString() + "0/100");
        else
            players.setSuffix(ChatColor.YELLOW + "r.i.p");
        obj.getScore(ChatColor.DARK_AQUA + "").setScore(0);
        Score rank = obj.getScore(Helpers.Colors("Rank: " + Main.getChat().getGroupPrefix(p.getWorld(), Main.getPermission().getPrimaryGroup(p))));
        rank.setScore(3);
        board.getTeam("players").setSuffix(Helpers.Colors("&6" + "just keis"));
        p.setScoreboard(board);
    }

    public static String Colors(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }
}
