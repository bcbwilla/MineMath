package net.electronexchange.minemath;



import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import expr.expr.Expr;
import expr.expr.Parser;
import expr.expr.SyntaxException;


public class CalcCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){					
		if(args.length == 0){
			sender.sendMessage("Calculate what?");
			return false;
		} else if(args.length >= 1){
			Expr expr;
			try {
			    expr = Parser.parse(args[0]); 
			} catch (SyntaxException e) {
			    sender.sendMessage(String.valueOf(e.explain()));
			    return true;
			}			
		    sender.sendMessage(String.valueOf(args[0])+" = "+String.valueOf(expr.value()));
		    return true;			 
		}
		return false; 
	}
}


