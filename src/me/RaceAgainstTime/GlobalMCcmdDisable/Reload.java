package me.RaceAgainstTime.GlobalMCcmdDisable;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Reload implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (label.equalsIgnoreCase("commandblock")) {
			if (!sender.hasPermission("commandblock.reload")) {
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
						"&cYou don't have permission to use this command!"));
				return true;
			}
			if (args.length == 0) {
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
						"&7Available Commands:" + "\n" + "&a/commandblock reload"));
			}
			if (args.length > 0) {
				if (args[0].equalsIgnoreCase("reload")) {
					sender.sendMessage(ChatColor.GREEN + "" + "Plugin Configuration Reloaded");
					Main.plugin.reloadConfig();
					return true;
				}
			}

		}
		return true;
	}

}
