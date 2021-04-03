package commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.WorldBorder;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WorldBorderSetupCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("wbsetup")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("Only players can use that command!");
                return true;
            }
            Player player = (Player) sender;
            if (args.length == 1) {
                int wbSize = Integer.parseInt(args[0]);
                createWorldBorder(wbSize, player);
                return true;
            } else if (args.length == 0) {
                createWorldBorder(500, player);
                return true;
            } else {
                sender.sendMessage(ChatColor.RED + "Invalid usage");
                return false;
            }

        }
        return true;
    }

    private void createWorldBorder(int wbSize, Player player) {
        World world = Bukkit.getWorld("world");
        WorldBorder wb = world.getWorldBorder();

        wb.setCenter(player.getLocation());
        wb.setSize(wbSize);
        wb.setDamageAmount(1);
    }
}
