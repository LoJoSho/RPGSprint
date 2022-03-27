package me.lojosho.rpgsprint.util;

import me.lojosho.rpgsprint.RPGSprint;

public class GetChracters {
    public static char getChracter(Integer size) {
        String a = RPGSprint.getInstance().getConfig().getString("stamina.text");
        char[] ch = new char[a.length()];
        for (int i = 0; i < a.length(); i++) {
            ch[i] = a.charAt(i);
        }
        return ch[size];
    }
}
