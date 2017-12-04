package be.pixelnetwork.core.scoreboards;

import org.bukkit.event.Listener;

public class Hub implements Listener {
/*
    public Hub(Main main) {
    }

    @EventHandler
    public void onjoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        addhub(p);
    }

    public void addhub(Player p) {
        Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective obj = board.registerNewObjective("Scoreboard", "dummy");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        obj.setDisplayName(Helpers.Colors("&bPixelated&6Source"));
        Score score = obj.getScore(Helpers.Colors("ip: &6play.&bpixel&6network.be"));
        score.setScore(1);
        Score name = obj.getScore(Helpers.Colors("&9name: " + p.getName()));
        name.setScore(2);
        int opl = 0;
        for (Player op : Bukkit.getOnlinePlayers()) {
            opl++;
        }
        Team players = board.registerNewTeam("players");
        players.addEntry(ChatColor.DARK_AQUA + "");
        players.setPrefix(ChatColor.GOLD + "players: ");
        players.setSuffix(ChatColor.YELLOW + "0/100");
        obj.getScore(ChatColor.DARK_AQUA + "").setScore(0);
        Score rank = obj.getScore(Helpers.Colors("Rank: " + Main.getChat().getGroupPrefix(p.getWorld(), Main.getPermission().getPrimaryGroup(p))));
        rank.setScore(3);
        board.getTeam("players").setSuffix(Helpers.Colors("&6" + "just keis"));
        p.setScoreboard(board);
    }

    public void addpvp(Player p) {
        Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective obj = board.registerNewObjective("Scoreboard", "dummy");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);

        Score score = obj.getScore(ChatColor.AQUA + "ip: play.pixelnetwork.be");
        score.setScore(1);

        Score spacer = obj.getScore("§f");
        spacer.setScore(2);

        Team deaths = board.registerNewTeam("deaths");
        deaths.addEntry(ChatColor.DARK_GRAY + "");
        deaths.setPrefix(ChatColor.RED + "Deaths: ");
        deaths.setSuffix(ChatColor.YELLOW + "0");
        obj.getScore(ChatColor.DARK_GRAY + "").setScore(4);

        Team kills = board.registerNewTeam("kills");
        kills.addEntry(ChatColor.DARK_AQUA + "");
        kills.setPrefix(ChatColor.GREEN + "Kills: ");
        kills.setSuffix(ChatColor.YELLOW + "0");
        obj.getScore(ChatColor.DARK_AQUA + "").setScore(5);

        Team killstreak = board.registerNewTeam("killstreak");
        killstreak.addEntry(ChatColor.GREEN + "");
        killstreak.setPrefix(Colors("&bKillstreak: "));
        killstreak.setSuffix("0");
        obj.getScore(ChatColor.GREEN + "").setScore(6);

        Team topkillstreak = board.registerNewTeam("topkillstreak");
        topkillstreak.addEntry(ChatColor.BLACK + "");
        topkillstreak.setPrefix(Colors("&3Topkillstreak"));
        topkillstreak.setSuffix(Helpers.Colors("&3: 0"));
        obj.getScore(ChatColor.BLACK + "").setScore(7);

        Team kdr = board.registerNewTeam("kdr");
        kdr.addEntry(ChatColor.RED + "");
        kdr.setPrefix(Colors("&5KDR: "));
        kdr.setSuffix(Colors("&30"));
        obj.getScore(ChatColor.RED + "").setScore(3);

        Score spacer2 = obj.getScore("§r");
        spacer2.setScore(8);


        board.getTeam("kdr").setSuffix(Colors("&3") + MySQL.getKDR(p.getUniqueId().toString()));
        board.getTeam("kills").setSuffix(Colors("&3") + MySQL.getKills(p.getUniqueId().toString()));
        board.getTeam("deaths").setSuffix(Colors("&3") + MySQL.getDeaths(p.getUniqueId().toString()));
        board.getTeam("killstreak").setSuffix(Colors("&3") + MySQL.getKillstreak(p.getUniqueId().toString()));
        board.getTeam("topkillstreak").setSuffix(Colors(": &3") + MySQL.getTopkillstreak(p.getUniqueId().toString()));


        new BukkitRunnable() {

            @Override
            public void run() {


                board.getTeam("kdr").setSuffix(Colors("&3") + MySQL.getKDR(p.getUniqueId().toString()));
                board.getTeam("kills").setSuffix(Colors("&3") + MySQL.getKills(p.getUniqueId().toString()));
                board.getTeam("deaths").setSuffix(Colors("&3") + MySQL.getDeaths(p.getUniqueId().toString()));
                board.getTeam("killstreak").setSuffix(Colors("&3") + MySQL.getKillstreak(p.getUniqueId().toString()));
                board.getTeam("topkillstreak").setSuffix(Colors("&3: &3") + MySQL.getTopkillstreak(p.getUniqueId().toString()));


                if (obj.getDisplayName().equalsIgnoreCase("Scoreboard") || obj.getDisplayName().equalsIgnoreCase(Colors("&b&lPixel&6&lNetwork"))) {
                    obj.setDisplayName(Colors("&lP"));

                } else if (obj.getDisplayName().equalsIgnoreCase(Colors("&lP"))) {
                    obj.setDisplayName(Colors("P&li"));


                } else if (obj.getDisplayName().equalsIgnoreCase(Colors("P&li"))) {
                    obj.setDisplayName(Colors("Pi&lx"));

                } else if (obj.getDisplayName().equalsIgnoreCase(Colors("Pi&lx"))) {
                    obj.setDisplayName(Colors("Pix&le"));

                } else if (obj.getDisplayName().equalsIgnoreCase(Colors("Pix&le"))) {
                    obj.setDisplayName(Colors("Pixe&ll"));

                } else if (obj.getDisplayName().equalsIgnoreCase(Colors("Pixe&ll"))) {
                    obj.setDisplayName(Colors("Pixel&lN"));

                } else if (obj.getDisplayName().equalsIgnoreCase(Colors("Pixel&lN"))) {
                    obj.setDisplayName(Colors("PixelN&le"));

                } else if (obj.getDisplayName().equalsIgnoreCase(Colors("PixelN&le"))) {
                    obj.setDisplayName(Colors("PixelNe&lt"));

                } else if (obj.getDisplayName().equalsIgnoreCase(Colors("PixelNe&lt"))) {
                    obj.setDisplayName(Colors("PixelNet&lw"));

                } else if (obj.getDisplayName().equalsIgnoreCase(Colors("PixelNet&lw"))) {
                    obj.setDisplayName(Colors("PixelNetw&lo"));

                } else if (obj.getDisplayName().equalsIgnoreCase(Colors("PixelNetw&lo"))) {
                    obj.setDisplayName(Colors("PixelNetwo&lr"));

                } else if (obj.getDisplayName().equalsIgnoreCase(Colors("PixelNetwo&lr"))) {
                    obj.setDisplayName(Colors("PixelNetwor&lk"));

                } else if (obj.getDisplayName().equalsIgnoreCase(Colors("PixelNetwor&lk"))) {
                    obj.setDisplayName(Colors("&b&lPixel&6&lNetwork"));

                }
            }


        }.runTaskTimerAsynchronously(Main.getInstance(), 40, 40);
        p.setScoreboard(board);
    }

    public static String Colors(String text) {
        return text.replaceAll("&", "§");
    }
    */
}
