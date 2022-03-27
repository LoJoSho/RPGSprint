package me.lojosho.rpgsprint.util;

import me.lojosho.rpgsprint.RPGSprint;
import org.bukkit.entity.Player;

public class ParsedSprintMessage {

    public static String parsedSprintMessage(Player player) {

        double amtPerSymbol;
        int progress;
        int stamina = RPGSprint.getInstance().getStamina();
        double max = stamina;
        int length = RPGSprint.getInstance().getConfig().getString("stamina.text").length();
        double placeholder = RPGSprint.getInstance().getPlayerSprint().get(player);
        int barLength = 0;


        StringBuilder bar = new StringBuilder();
        amtPerSymbol = max / length;
        progress = (int) Math.floor(placeholder / amtPerSymbol);
        while (barLength < progress) {
            bar.append(GetColor.getColorCompleted(stamina, placeholder, barLength));
            barLength++;
        }
        while (barLength < length) {
            bar.append(GetColor.getColorRemaining(stamina, placeholder, barLength));
            barLength++;
        }
        String barMessage = bar.toString();
        if (RPGSprint.getInstance().getConfig().getBoolean("stamina.bars")) {

            String highStart = RPGSprint.getInstance().getConfig().getString("bars.highStart");
            String highEnd = RPGSprint.getInstance().getConfig().getString("bars.highEnd");

            String mediumStart = RPGSprint.getInstance().getConfig().getString("bars.mediumStart");
            String mediumEnd = RPGSprint.getInstance().getConfig().getString("bars.mediumEnd");

            String lowStart = RPGSprint.getInstance().getConfig().getString("bars.lowStart");
            String lowEnd = RPGSprint.getInstance().getConfig().getString("bars.lowEnd");

            if (stamina >= placeholder && placeholder > stamina / 2) {
                barMessage = highStart + barMessage + highEnd;
            }
            if (stamina / 2 >= placeholder && placeholder > stamina / 4) {
                barMessage = mediumStart + barMessage + mediumEnd;
            }
            if (stamina / 4 >= placeholder && placeholder >= 0) {
                barMessage = lowStart + barMessage + lowEnd;
            }
        }
        return barMessage;
    }

}
