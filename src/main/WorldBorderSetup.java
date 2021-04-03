package main;

import commands.WorldBorderSetupCommand;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

public class WorldBorderSetup extends JavaPlugin {

    @Override
    public void onEnable() {
        sendMessage(ChatColor.GREEN + "WorldBorderSetup enabled!");
        registerCommand("wbsetup", new WorldBorderSetupCommand());
    }

    public void onDisable() {
        sendMessage(ChatColor.RED + "WorldBorderSetup disabled!");
    }

    private void sendMessage(String s) {
        getServer().getConsoleSender().sendMessage(s);
    }

    private void registerCommand(String cmd, CommandExecutor executor) {
        getCommand(cmd).setExecutor(executor);
    }
}
