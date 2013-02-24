package net.electronexchange.minemath;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class MathCommand implements CommandExecutor {	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){						
		if(cmd.getName().equalsIgnoreCase("math")){
			sender.sendMessage("math");
			return true;		
		}
		return false; 
	}
}


