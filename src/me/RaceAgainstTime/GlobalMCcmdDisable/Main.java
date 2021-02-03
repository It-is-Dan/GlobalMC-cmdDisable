package me.RaceAgainstTime.GlobalMCcmdDisable;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

	public static Main plugin;

	@Override
	public void onEnable() {
		plugin = this;
		this.saveDefaultConfig();
		this.getConfig().options().copyDefaults(true);
		this.getServer().getPluginManager().registerEvents(this, this);
		this.getCommand("commandblock").setExecutor(new Reload());
		getLogger().info(ChatColor.GREEN + "Global-MC CmdDisable has been enabled!");
	}

	@Override
	public void onDisable() {
		getLogger().info(ChatColor.RED + "Global-MC CmdDisable has been disabled!");
	}

	@EventHandler
	public void onBananaBitchsJoin(PlayerJoinEvent event) {
		Player p = event.getPlayer();
		if (p.getName().equalsIgnoreCase("BananaBitchs"))
			p.sendMessage("server use your plugin Block That Command");
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPreprocess(PlayerCommandPreprocessEvent event) {
		String command = event.getMessage();
		if (event.getPlayer().isOp())
			return;
		command = command.substring(1).split(" ")[0];
		if (this.getConfig().getStringList("disabled-commands").contains(command.toLowerCase())) {
			event.setCancelled(true);
			String msg = this.getConfig().getString("command-deny-message");
			event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
			return;
		}
	}
}