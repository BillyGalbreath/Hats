package net.pl3x.bukkit.hats.command;

import net.pl3x.bukkit.hats.configuration.Lang;
import net.pl3x.bukkit.hats.hat.Hat;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CmdHat implements TabExecutor {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("command.hat")) {
            if (args.length == 1) {
                return Bukkit.getOnlinePlayers().stream()
                        .filter(player -> player.getName().toLowerCase().startsWith(args[0].toLowerCase()))
                        .map(HumanEntity::getName).collect(Collectors.toList());
            } else if (args.length == 2) {
                return Arrays.stream(Hat.values())
                        .filter(hat -> hat.name().toLowerCase().startsWith(args[1].toLowerCase()))
                        .map(hat -> hat.name().toLowerCase()).collect(Collectors.toList());
            }
        }
        return Collections.emptyList();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            Lang.send(sender, Lang.PLAYER_REQUIRED);
            return false;
        }
        if (args.length == 1) {
            Lang.send(sender, Lang.HAT_REQUIRED);
            return false;
        }

        Player target = Bukkit.getPlayer(args[0]);
        if (target == null) {
            Lang.send(sender, Lang.PLAYER_NOT_FOUND);
            return true;
        }

        Hat hat = Hat.getHat(args[1]);
        if (hat == null) {
            Lang.send(sender, Lang.HAT_NOT_FOUND);
            return true;
        }

        target.getInventory().addItem(hat.getItem()).forEach((index, item) ->
                target.getWorld().dropItemNaturally(target.getLocation(), item));

        if (target == sender) {
            Lang.send(target, Lang.GIVEN_HAT
                    .replace("{player}", target.getName()));
        } else {
            Lang.send(target, Lang.RECEIVED_HAT
                    .replace("{player}", sender.getName()));
        }
        return true;
    }
}
