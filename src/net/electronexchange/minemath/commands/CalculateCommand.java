package net.electronexchange.minemath.commands;

import net.electronexchange.minemath.util.MMUtil;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import expr.expr.Expr;
import expr.expr.Parser;
import expr.expr.SyntaxException;


public class CalculateCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){					
		if(args.length == 0){
			MMUtil.commandHelp("calculate", cmd, sender);
			return false;
		} else if(args.length >= 1){
			return calculate(sender, args[0]);
		}
		return false; 
	}
	
	private boolean calculate(CommandSender sender, String mathExpression){
		Expr expr;
		try {
		    expr = Parser.parse(mathExpression); 
		} catch (SyntaxException e) {
		    sender.sendMessage(String.valueOf(e.explain()));
		    return true;
		}
		String answer = String.valueOf(expr.value());
		//ad hoc catch of the inaccurate IEEE 754 division by zero response.  1/0 is NOT infinity!
		if(answer.equalsIgnoreCase("infinity") || answer.equalsIgnoreCase("-infinity")){
			answer = "NaN";
		}
	    sender.sendMessage(String.valueOf(mathExpression)+" = "+answer);
	    return true;	
	}
}


