package me.lojosho.rpgsprint.hooks;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import me.lojosho.rpgsprint.RPGSprint;
import me.lojosho.rpgsprint.util.ParsedSprintMessage;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class RPGSprintExpansion extends PlaceholderExpansion {
    private final RPGSprint plugin;

    public RPGSprintExpansion(RPGSprint plugin) {
        this.plugin = plugin;
    }


    @Override
    public @NotNull String getIdentifier() {
        return "rpgsprint";
    }

    @Override
    public @NotNull String getAuthor() {
        return "lojosho";
    }

    @Override
    public @NotNull String getVersion() {
        return "1.0.0";
    }

    @Override
    public boolean persist() {
        return true; // This is required or else PlaceholderAPI will unregister the Expansion on reload
    }

    @Override
    public String onRequest(OfflinePlayer offlinePlayer, String params) {
        if (params.equalsIgnoreCase("sprint")) {
            return ParsedSprintMessage.parsedSprintMessage(offlinePlayer.getPlayer());
        }

        if (params.equalsIgnoreCase("sprintraw")) {
            return RPGSprint.getInstance().getPlayerSprint().get(offlinePlayer.getPlayer()).toString();
        }
        return null;
    }
}
