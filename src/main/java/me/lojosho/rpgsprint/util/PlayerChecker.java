package me.lojosho.rpgsprint.util;

import me.lojosho.rpgsprint.RPGSprint;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerChecker {

    public static void playerChecker() {
        new BukkitRunnable() {
            @Override
            public void run() {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    int b;
                    int a = RPGSprint.getInstance().getPlayerSprint().get(player);
                    if (player.isSprinting()) {
                        b = a - 1;
                        UpdateActionBar.updateActionBar(player, true);
                    } else {
                        UpdateActionBar.updateActionBar(player, false);
                        if (a < RPGSprint.getInstance().getStamina()) {
                            b = a + 3;
                        } else {
                            b = RPGSprint.getInstance().getStamina();
                        }
                    }
                    if (b >= 0) {
                        RPGSprint.getInstance().getPlayerSprint().put(player, b);
                    }
                    RPGSprint.getInstance().getLogger().info(player.getName() + " has " + b);

                    int c;
                    if (b < RPGSprint.getInstance().getStamina()/4) {
                        c = player.getFoodLevel() - 3;
                        //plugin.getLogger().info(player.getName() + " sub " + c);
                    } else {
                        if (player.getFoodLevel() <= 21) {
                            c = player.getFoodLevel() + 4;
                        } else {
                            c = player.getFoodLevel();
                        }
                    }
                    //plugin.getLogger().info(player.getName() + " has this amount of hunger " + c);
                    if (c > 0) {
                        player.setFoodLevel(c);
                    }
                }
            }
        }.runTaskTimer(RPGSprint.getInstance(), 20, 20);
    }

}
