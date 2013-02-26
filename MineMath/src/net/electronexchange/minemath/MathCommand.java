package net.electronexchange.minemath;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class MathCommand implements CommandExecutor {	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){						
		sender.sendMessage("is pretty neat");
		return true;
	}
}


