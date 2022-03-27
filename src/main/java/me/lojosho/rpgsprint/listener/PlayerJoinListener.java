package me.lojosho.rpgsprint.listener;

import me.lojosho.rpgsprint.RPGSprint;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {


    @EventHandler
    public void getPlayerJoin(PlayerJoinEvent event) {
        if (!RPGSprint.getInstance().getPlayerSprint().containsKey(event.getPlayer())) {
            RPGSprint.getInstance().getPlayerSprint().put(event.getPlayer(), RPGSprint.getInstance().getStamina());
            event.getPlayer().setFoodLevel(20);
        } else {
            // do nothing
        }
    }
}
