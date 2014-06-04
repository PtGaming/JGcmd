package co.justgame.jgcmd;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class jgcmd extends JavaPlugin implements Listener {
	FileConfiguration config;
	File cfile;

	public void onEnable() {
		config = getConfig();
		config.options().copyDefaults(true);
		saveConfig();
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
		Bukkit.getServer().getLogger().info("JGCMD successfully enabled!");
	}

	public void onDisable() {
		Bukkit.getServer().getLogger().info("JGCMD disabled!");
	}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		org.bukkit.entity.Player p = e.getPlayer();
		String motd = getConfig().getString("Welcome");
		motd = motd.replaceAll("&", "§");
		for (String welcoming : config.getStringList("Welcome")) {
			welcoming = welcoming.replaceAll("&", "§");
			p.sendMessage(welcoming);
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onCommandPreProcess(PlayerCommandPreprocessEvent event) {
		if (event.getMessage().toLowerCase().startsWith("/help")) {
			event.setCancelled(true);
				for (String help : config.getStringList("Help")) {
					help = help.replaceAll("&", "§");
					event.getPlayer().sendMessage(help);
			}
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onCommandPreProcess1(PlayerCommandPreprocessEvent event) {
		if (event.getMessage().toLowerCase().startsWith("/?")) {
			event.setCancelled(true);
			for (String help : config.getStringList("Help")) {
				help = help.replaceAll("&", "§");
				event.getPlayer().sendMessage(help);
			}
		}
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onCommandPreProcess2(PlayerCommandPreprocessEvent event) {
		if (event.getMessage().toLowerCase().startsWith("/chat")) {
			event.setCancelled(true);
			for (String chat : config.getStringList("Chat")) {
				chat = chat.replaceAll("&", "§");
				event.getPlayer().sendMessage(chat);
			}
		}
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onCommandPreProcess4(PlayerCommandPreprocessEvent event) {
		if (event.getMessage().toLowerCase().startsWith("/message")) {
			event.setCancelled(true);
			for (String chat : config.getStringList("Chat")) {
				chat = chat.replaceAll("&", "§");
				event.getPlayer().sendMessage(chat);
			}
		}
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onCommandPreProcess5(PlayerCommandPreprocessEvent event) {
		if (event.getMessage().toLowerCase().startsWith("/msg")) {
			event.setCancelled(true);
			for (String chat : config.getStringList("Chat")) {
				chat = chat.replaceAll("&", "§");
				event.getPlayer().sendMessage(chat);
			}
		}
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onCommandPreProcess6(PlayerCommandPreprocessEvent event) {
		if (event.getMessage().toLowerCase().startsWith("/tell")) {
			event.setCancelled(true);
			for (String chat : config.getStringList("Chat")) {
				chat = chat.replaceAll("&", "§");
				event.getPlayer().sendMessage(chat);
			}
		}
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onCommandPreProcess7(PlayerCommandPreprocessEvent event) {
		if (event.getMessage().toLowerCase().startsWith("/whisper")) {
			event.setCancelled(true);
			for (String chat : config.getStringList("Chat")) {
				chat = chat.replaceAll("&", "§");
				event.getPlayer().sendMessage(chat);
			}
		}
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onCommandPreProcess8(PlayerCommandPreprocessEvent event) {
		if (event.getMessage().toLowerCase().startsWith("/pm")) {
			event.setCancelled(true);
			for (String chat : config.getStringList("Chat")) {
				chat = chat.replaceAll("&", "§");
				event.getPlayer().sendMessage(chat);
			}
		}
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onCommandPreProcess10(PlayerCommandPreprocessEvent event) {
		if (event.getMessage().toLowerCase().startsWith("/reply")) {
			event.setCancelled(true);
			for (String chat : config.getStringList("Chat")) {
				chat = chat.replaceAll("&", "§");
				event.getPlayer().sendMessage(chat);
			}
		}
	}

	public boolean onCommand(CommandSender sender, Command cmd,
			String commandLabel, String[] args) {
		if (cmd.getName().equalsIgnoreCase("account")) {
			if (!sender.hasPermission("jgcmd.account")) {
				sender.sendMessage(ChatColor.RED
						+ "You do not have permission to use this command.");
				return true;
			}
			String motd = getConfig().getString("Account");
			motd = motd.replaceAll("&", "§");
			for (String acc : config.getStringList("Account")) {
				acc = acc.replaceAll("&", "§");
				sender.sendMessage(acc);
			}
			return true;
		}
		if (cmd.getName().equalsIgnoreCase("help")) {
			if (args.length != 0) {
				sender.sendMessage(ChatColor.GREEN + "Your request has been sent.");
				return true;
			}
		}
		if (cmd.getName().equalsIgnoreCase("claim")) {
			if (!sender.hasPermission("jgcmd.claim")) {
				sender.sendMessage(ChatColor.RED
						+ "You do not have permission to use this command.");
				return true;
			}
			String motd = getConfig().getString("Claim");
			motd = motd.replaceAll("&", "§");
			for (String claims : config.getStringList("Claim")) {
				claims = claims.replaceAll("&", "§");
				sender.sendMessage(claims);
			}
			return true;
		}
		if (cmd.getName().equalsIgnoreCase("chat")) {
			if (!sender.hasPermission("jgcmd.chat")) {
				sender.sendMessage(ChatColor.RED
						+ "You do not have permission to use this command.");
				return true;
			}
			String motd = getConfig().getString("Chat");
			motd = motd.replaceAll("&", "§");
			for (String chatting : config.getStringList("Chat")) {
				chatting = chatting.replaceAll("&", "§");
				sender.sendMessage(chatting);
			}
			return true;
		}
		if (cmd.getName().equalsIgnoreCase("navigation")) {
			if (!sender.hasPermission("jgcmd.navigation")) {
				sender.sendMessage(ChatColor.RED
						+ "You do not have permission to use this command.");
				return true;
			}
			String motd = getConfig().getString("Navigation");
			motd = motd.replaceAll("&", "§");
			for (String nav : config.getStringList("Navigation")) {
				nav = nav.replaceAll("&", "§");
				sender.sendMessage(nav);
			}
			return true;
		}
		if (cmd.getName().equalsIgnoreCase("website")) {
			if (!sender.hasPermission("jgcmd.website")) {
				sender.sendMessage(ChatColor.RED
						+ "You do not have permission to use this command.");
				return true;
			}
			String motd = getConfig().getString("Website");
			motd = motd.replaceAll("&", "§");
			for (String web : config.getStringList("Website")) {
				web = web.replaceAll("&", "§");
				sender.sendMessage(web);
			}
			return true;
		}
		if (cmd.getName().equalsIgnoreCase("rules")) {
			if (!sender.hasPermission("jgcmd.rules")) {
				sender.sendMessage(ChatColor.RED
						+ "You do not have permission to use this command.");
				return true;
			}
			String motd = getConfig().getString("Rules");
			motd = motd.replaceAll("&", "§");
			for (String rule : config.getStringList("Rules")) {
				rule = rule.replaceAll("&", "§");
				sender.sendMessage(rule);
			}
			return true;
		}
		if (cmd.getName().equalsIgnoreCase("vote")) {
			if (!sender.hasPermission("jgcmd.vote")) {
				sender.sendMessage(ChatColor.RED
						+ "You do not have permission to use this command.");
				return true;
			}
			String motd = getConfig().getString("Vote");
			motd = motd.replaceAll("&", "§");
			for (String votes : config.getStringList("Vote")) {
				votes = votes.replaceAll("&", "§");
				sender.sendMessage(votes);
			}
		}
		if (cmd.getName().equalsIgnoreCase("welcome")) {
			if (!sender.hasPermission("jgcmd.welcome")) {
				sender.sendMessage(ChatColor.RED
						+ "You do not have permission to use this command.");
				return true;
			}
			String motd = getConfig().getString("Welcome");
			motd = motd.replaceAll("&", "§");
			for (String welcoming : config.getStringList("Welcome")) {
				welcoming = welcoming.replaceAll("&", "§");
				sender.sendMessage(welcoming);
			}
		}
		return true;
	}
}
