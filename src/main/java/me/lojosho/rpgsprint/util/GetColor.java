package me.lojosho.rpgsprint.util;

public class GetColor {

    public static String getColorCompleted(Integer stamina, Double placeholder, Integer barLength) {
        String completed = "<GREEN>";

        if (stamina >= placeholder && placeholder > stamina/2) {
            completed = "<GREEN>" + GetChracters.getChracter(barLength);
        }
        if (stamina/2 >= placeholder && placeholder > stamina/4) {
            completed = "<YELLOW>" + GetChracters.getChracter(barLength);
        }
        if (stamina/4 >= placeholder && placeholder >= 0) {
            completed = "<RED>" + GetChracters.getChracter(barLength);
        }
        return completed;
    }
    public static String getColorRemaining(Integer stamina, Double placeholder, Integer barLength) {
        String remaining = "<GRAY>";

        if (stamina >= placeholder && placeholder > stamina/2) {
            remaining = "<GRAY>" + GetChracters.getChracter(barLength);
        }
        if (stamina/2 >= placeholder && placeholder > stamina/4) {
            remaining = "<GRAY>" + GetChracters.getChracter(barLength);
        }
        if (stamina/4 >= placeholder && placeholder >= 0) {
            remaining = "<RED>" + GetChracters.getChracter(barLength);
        }
        return remaining;
    }
}
