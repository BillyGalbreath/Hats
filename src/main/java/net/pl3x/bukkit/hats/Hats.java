package net.pl3x.bukkit.hats;

import net.pl3x.bukkit.hats.command.CmdHat;
import net.pl3x.bukkit.hats.command.CmdHats;
import net.pl3x.bukkit.hats.configuration.Config;
import net.pl3x.bukkit.hats.configuration.Lang;
import net.pl3x.bukkit.hats.hat.Hat;
import net.pl3x.bukkit.hats.listener.BukkitListener;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class Hats extends JavaPlugin {
    private static Hats instance;

    public Hats() {
        instance = this;
    }

    @Override
    public void onEnable() {
        Config.reload(this);
        Lang.reload(this);

        Hat.values(); // init the enum

        getServer().getPluginManager().registerEvents(new BukkitListener(), this);

        registerCommand("hat", new CmdHat());
        registerCommand("hats", new CmdHats(this));
    }

    private void registerCommand(String name, CommandExecutor executor) {
        PluginCommand command = getCommand(name);
        if (command != null) {
            command.setExecutor(executor);
        }
    }

    public static Hats getInstance() {
        return instance;
    }
}
