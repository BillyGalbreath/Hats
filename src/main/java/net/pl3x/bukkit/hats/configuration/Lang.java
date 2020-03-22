package net.pl3x.bukkit.hats.configuration;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

public class Lang {
    public static String COMMAND_NO_PERMISSION = "&cYou do not have permission for that command!";
    public static String PLAYER_REQUIRED = "&cPlayer required";
    public static String HAT_REQUIRED = "&cHat required";
    public static String PLAYER_NOT_FOUND = "&cPlayer not found";
    public static String HAT_NOT_FOUND = "&cHat not found";
    public static String GIVEN_HAT = "&dHat given to {player}";
    public static String RECEIVED_HAT = "&dYou were given a hat by {player}";

    private static void init() {
        COMMAND_NO_PERMISSION = getString("command-no-permission", COMMAND_NO_PERMISSION);
        PLAYER_REQUIRED = getString("player-required", PLAYER_REQUIRED);
        HAT_REQUIRED = getString("hat-required", HAT_REQUIRED);
        PLAYER_NOT_FOUND = getString("player-not-found", PLAYER_NOT_FOUND);
        HAT_NOT_FOUND = getString("hat-not-found", HAT_NOT_FOUND);
        GIVEN_HAT = getString("given-hat", GIVEN_HAT);
        RECEIVED_HAT = getString("received-hat", RECEIVED_HAT);
    }

    // ############################  DO NOT EDIT BELOW THIS LINE  ############################

    public static void reload(Plugin plugin) {
        File configFile = new File(plugin.getDataFolder(), Config.LANGUAGE_FILE);
        config = new YamlConfiguration();
        try {
            config.load(configFile);
        } catch (IOException ignore) {
        } catch (InvalidConfigurationException ex) {
            plugin.getLogger().log(Level.SEVERE, "Could not load " + Config.LANGUAGE_FILE + ", please correct your syntax errors", ex);
            throw new RuntimeException(ex);
        }
        config.options().header("This is the main language file for " + plugin.getName());
        config.options().copyDefaults(true);

        Lang.init();

        try {
            config.save(configFile);
        } catch (IOException ex) {
            plugin.getLogger().log(Level.SEVERE, "Could not save " + configFile, ex);
        }
    }

    private static YamlConfiguration config;

    private static String getString(String path, String def) {
        config.addDefault(path, def);
        return config.getString(path, config.getString(path));
    }

    public static void send(CommandSender recipient, String message) {
        if (recipient != null) {
            for (String part : colorize(message).split("\n")) {
                recipient.sendMessage(part);
            }
        }
    }

    public static String colorize(String str) {
        if (str == null) {
            return "";
        }
        str = ChatColor.translateAlternateColorCodes('&', str);
        if (ChatColor.stripColor(str).isEmpty()) {
            return "";
        }
        return str;
    }
}
