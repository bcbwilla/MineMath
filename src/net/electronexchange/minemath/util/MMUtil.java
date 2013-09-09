package net.electronexchange.minemath.util;

import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class MMUtil {

	public static void commandHelp(String command, Command cmd, CommandSender sender){
		String description = cmd.getDescription();
		List<String> aliases = cmd.getAliases();

		sender.sendMessage(ChatColor.BLUE + "Description:");
		sender.sendMessage(description);
		sender.sendMessage(ChatColor.BLUE + "Aliases:");
		for(String alias : aliases){
			sender.sendMessage(alias);
		}
		sender.sendMessage(ChatColor.BLUE + "Usage:");
	}
	
	public static String userVariableName(String username, String variable){
		final String RAND = "_623894723_";
		return username + RAND + variable;
	}
}
