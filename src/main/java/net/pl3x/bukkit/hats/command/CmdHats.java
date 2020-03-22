package net.pl3x.bukkit.hats.command;

import net.pl3x.bukkit.hats.Hats;
import net.pl3x.bukkit.hats.configuration.Config;
import net.pl3x.bukkit.hats.configuration.Lang;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;

import java.util.Collections;
import java.util.List;

public class CmdHats implements TabExecutor {
    private final Hats plugin;

    public CmdHats(Hats plugin) {
        this.plugin = plugin;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("command.hats")) {
            if (args.length == 1 && "reload".startsWith(args[0].toLowerCase())) {
                return Collections.singletonList("reload");
            }
        }
        return Collections.emptyList();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String response = "&d" + plugin.getName() + " v" + plugin.getDescription().getVersion();

        if (args.length > 0 && args[0].equalsIgnoreCase("reload")) {
            Config.reload(plugin);
            Lang.reload(plugin);

            response += " reloaded";
        }

        Lang.send(sender, response);
        return true;
    }
}
