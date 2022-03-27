package me.lojosho.rpgsprint.util;

import me.clip.placeholderapi.PlaceholderAPI;
import me.lojosho.rpgsprint.RPGSprint;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.entity.Player;

public class UpdateActionBar {

    public static void updateActionBar(Player player, Boolean sprinting) {
        String baseMessage;
        if (sprinting) {
            baseMessage = RPGSprint.getInstance().getConfig().getString("actionBar.sprinting");
        } else {
            baseMessage = RPGSprint.getInstance().getConfig().getString("actionBar.walking");
        }
        baseMessage = PlaceholderAPI.setPlaceholders(player, baseMessage);
        Component message = MiniMessage.miniMessage().deserialize(baseMessage);
        player.sendActionBar(message);
    }
}
