package me.lojosho.rpgsprint.commands;

import me.lojosho.rpgsprint.RPGSprint;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class CommandRPGSprint implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 1) {
            switch (args[0]) {
                case "reload":
                    if (sender.hasPermission("RPGSprint.reload")) {
                        RPGSprint.getInstance().setupPlugin();
                        sender.sendMessage(Component.text("Successfully Reloaded RPGSprint"));
                        return true;
                    } else {
                        sender.sendMessage(Component.text("No Permission!").color(NamedTextColor.RED));
                    }
                    break;
            }
        } else {
            sender.sendMessage("Do /rpgsprint reload");
        }
        return false;
    }
}
