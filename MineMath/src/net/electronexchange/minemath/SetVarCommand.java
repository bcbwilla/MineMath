package net.electronexchange.minemath;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import expr.expr.Variable;



public class SetVarCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){			
		
		if(args.length != 2){
			sender.sendMessage("Nope.");
			return false;
		}
		else if(args[0].equalsIgnoreCase("pi")){
			sender.sendMessage("You want to redifine pi? Are you CRAZY?!? No! Nope.avi");
			return false;
		} else {
			Variable var = Variable.make(args[0]);		
			var.setValue(Double.valueOf(args[1]));
			sender.sendMessage(var.toString()+" = "+String.valueOf(var.value()));			
			return true;
		 }
	}
}

