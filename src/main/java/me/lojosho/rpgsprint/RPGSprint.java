package me.lojosho.rpgsprint;

import lombok.Getter;
import me.lojosho.rpgsprint.hooks.RPGSprintExpansion;
import me.lojosho.rpgsprint.listener.PlayerJoinListener;
import me.lojosho.rpgsprint.util.PlayerChecker;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public final class RPGSprint extends JavaPlugin {

    private static RPGSprint instance;
    @Getter
    private HashMap<Player, Integer> playerSprint = new HashMap<>();
    @Getter
    private int stamina;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        this.saveDefaultConfig();
        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            new RPGSprintExpansion(this).register();
        } else {
            getLogger().severe("Could not find PlaceholderAPI! This plugin is required!");
            Bukkit.getPluginManager().disablePlugin(this);
        }
        stamina = getConfig().getInt("stamina.amount");
        Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(), this);
        PlayerChecker.playerChecker();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        playerSprint.clear();
    }

    public static RPGSprint getInstance() {
        return instance;
    }
}
