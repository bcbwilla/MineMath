package net.electronexchange.minemath.commands;


import net.electronexchange.minemath.util.MMUtil;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import expr.expr.Expr;
import expr.expr.Parser;
import expr.expr.SyntaxException;
import expr.expr.Variable;

public class VariableCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){					
		if(args.length < 2 || args.length > 3){			
			MMUtil.commandHelp("variable", cmd, sender);
			return false;
		} else if(args[1].equalsIgnoreCase("pi")){
				sender.sendMessage("You want to redifine pi? Are you CRAZY?!? No! Nope.avi");
			return true;
		} else if(args[0].equalsIgnoreCase("set")){
			
			Variable var = Variable.make(args[1]);	
			var.setValue(Double.valueOf(args[2]));
			sender.sendMessage(var.toString()+" = "+String.valueOf(var.value()));			
			return true;		
		} else if(args[0].equalsIgnoreCase("echo")){
			Expr variable;
			try {
			    variable = Parser.parse(args[1]); 
			} catch (SyntaxException e) {
			    sender.sendMessage(String.valueOf(e.explain()));
			    return true;
			}
			sender.sendMessage(variable.toString()+" = "+String.valueOf(variable.value()));			
			return true;		
		 }
		return false;
	}
}

