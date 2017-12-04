package be.pixelnetwork.core;

import be.pixelnetwork.core.cmd.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandHandler implements CommandExecutor {

    private Commandarmorsee armorsee = new Commandarmorsee();
    private Commandcraft craft = new Commandcraft();
    private Commanddry dry = new Commanddry();
    private Commandeat eat = new Commandeat();
    private Commandextinguish extinguish = new Commandextinguish();
    private Commandfly fly = new Commandfly();
    private Commandfreeze freeze = new Commandfreeze();
    private Commandgamemode gamemode = new Commandgamemode();
    private Commandgod god = new Commandgod();
    private Commandheal heal = new Commandheal();
    private Commandinvsee invsee = new Commandinvsee();
    private Commandkill kill = new Commandkill();
    private Commandmore more = new Commandmore();
    private Commandnightvision nightvision = new Commandnightvision();
    private Commandrain rain = new Commandrain();
    private Commandsetspawn setspawn = new Commandsetspawn();
    private Commandsmedia media = new Commandsmedia();
    private Commandspawn spawn = new Commandspawn();
    private Commandspeed speed = new Commandspeed();
    private Commandstorm storm = new Commandstorm();
    private Commandstp tp = new Commandstp();
    private Commandtime time = new Commandtime();
    private Commandtop top = new Commandtop();
    private Commandup up = new Commandup();
    private Commandvanish vanish = new Commandvanish();
    private Commandnick nick = new Commandnick();

    public CommandHandler(Main main) {

    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        switch (label) {
            case "gmc":
                gamemode.execute(sender, cmd, label, args);
                break;
            case "gms":
                gamemode.execute(sender, cmd, label, args);
                break;
            case "gmsp":
                gamemode.execute(sender, cmd, label, args);
                break;
            case "gma":
                gamemode.execute(sender, cmd, label, args);
                break;
            case "gm":
                gamemode.execute(sender, cmd, label, args);
                break;
            case "fly":
                fly.execute(sender, cmd, label, args);
                break;
            case "freeze":
                freeze.execute(sender, cmd, label, args);
                break;
            case "vanish":
                vanish.execute(sender, cmd, label, args);
                break;
            case "v":
                vanish.execute(sender, cmd, label, args);
                break;
            case "eat":
                eat.execute(sender, cmd, label, args);
                break;
            case "kill":
                kill.execute(sender, cmd, label, args);
                break;
            case "extinguish":
                extinguish.execute(sender, cmd, label, args);
                break;
            case "ext":
                extinguish.execute(sender, cmd, label, args);
                break;
            case "craft":
                craft.execute(sender, cmd, label, args);
                break;
            case "god":
                god.execute(sender, cmd, label, args);
                break;
            case "invsee":
                invsee.execute(sender, cmd, label, args);
                break;
            case "armorsee":
                armorsee.execute(sender, cmd, label, args);
                break;
            case "speed":
                speed.execute(sender, cmd, label, args);
                break;
            case "setspawn":
                setspawn.execute(sender, cmd, label, args);
                break;
            case "spawn":
                spawn.execute(sender, cmd, label, args);
                break;
            case "up":
                up.execute(sender, cmd, label, args);
                break;
            case "top":
                top.execute(sender, cmd, label, args);
                break;
            //MEDIA S
            case "youtube":
                media.execute(sender, cmd, label, args);
                break;
            case "yt":
                media.execute(sender, cmd, label, args);
                break;
            case "site":
                media.execute(sender, cmd, label, args);
                break;
            case "forum":
                media.execute(sender, cmd, label, args);
                break;
            case "twitter":
                media.execute(sender, cmd, label, args);
                break;
            case "discord":
                media.execute(sender, cmd, label, args);
                break;
            case "nightvision":
                nightvision.execute(sender, cmd, label, args);
                break;
            case "nv":
                nightvision.execute(sender, cmd, label, args);
                break;
            case "time":
                time.execute(sender, cmd, label, args);
                break;
            case "dry":
                dry.execute(sender, cmd, label, args);
                break;
            case "rain":
                rain.execute(sender, cmd, label, args);
                break;
            case "storm":
                storm.execute(sender, cmd, label, args);
                break;
            case "tp":
                tp.execute(sender, cmd, label, args);
                break;
            case "tpa":
                tp.execute(sender, cmd, label, args);
                break;
            case "tpyes":
                tp.execute(sender, cmd, label, args);
                break;
            case "tpdeny":
                tp.execute(sender, cmd, label, args);
                break;
            case "tphere":
                tp.execute(sender, cmd, label, args);
                break;
            case "more":
                more.execute(sender, cmd, label, args);
                break;
            case "heal":
                heal.execute(sender, cmd, label, args);
                break;
            case "nick":
                nick.execute(sender, cmd, label, args);
                break;
            case "nickname":
                nick.execute(sender, cmd, label, args);
                break;
            default:
                break;
        }
        return false;
    }
}
