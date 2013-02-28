package net.electronexchange.minemath.commands;

import java.util.List;
import java.util.Map;

import net.electronexchange.minemath.MineMath;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.PluginDescriptionFile;

public class MineMathCommand implements CommandExecutor {
	
	private MineMath plugin;
	 
	public MineMathCommand(MineMath plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		PluginDescriptionFile descriptionFile = plugin.getDescription();
		List<String> authors = descriptionFile.getAuthors();
		String authorsString = "";
		for(String author : authors){
			authorsString = author + " " + authorsString;
		}		
		if(args.length == 0 || args.length > 1){
			sender.sendMessage(ChatColor.GOLD+"--------------------------------");
			sender.sendMessage(" " +ChatColor.DARK_GREEN + descriptionFile.getFullName());
			sender.sendMessage(" by "+ ChatColor.ITALIC + authorsString);
			sender.sendMessage(" " + ChatColor.LIGHT_PURPLE + descriptionFile.getWebsite());
			sender.sendMessage(ChatColor.GOLD +"--------------------------------");
			sender.sendMessage(" " + descriptionFile.getDescription());
			sender.sendMessage(" To see available commands, type /minemath commands");
			return true;
		} else if(args[0].equalsIgnoreCase("help") || args[0].equalsIgnoreCase("commands")){
			sender.sendMessage(" " + ChatColor.BLUE+"Available commands:");
			Map<String, Map<String,Object>> commands = descriptionFile.getCommands();
			for(Map.Entry<String,Map<String,Object>> entry : commands.entrySet()) {
				String command = entry.getKey();
				if(!command.equalsIgnoreCase("minemath")){
					sender.sendMessage("/"+command);
				}
			}
			return true;
		}

		return false;
	}

}
