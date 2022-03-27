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
            if (stamina >= placeholder && placeholder > stamina / 2) {
                barMessage = "<GREEN>[" + barMessage + "<GREEN>]";
            }
            if (stamina / 2 >= placeholder && placeholder > stamina / 4) {
                barMessage = "<YELLOW>[" + barMessage + "<YELLOW>]";
            }
            if (stamina / 4 >= placeholder && placeholder >= 0) {
                barMessage = "<RED>[" + barMessage + "<RED>]";
            }
        }
        return barMessage;
    }

}
