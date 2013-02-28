package net.electronexchange.minemath.commands;



import java.util.Map;

import net.electronexchange.minemath.MineMath;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import expr.expr.Expr;
import expr.expr.Parser;
import expr.expr.SyntaxException;



public class CalculateCommand implements CommandExecutor {
	
	private MineMath plugin;
	 
	public CalculateCommand(MineMath plugin) {
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){					
		if(args.length == 0){
			Map<String, Object> commandInfo = plugin.getDescription().getCommands().get("calculate");
			String description = (String) commandInfo.get("description");
			sender.sendMessage(ChatColor.BLUE + "Description:");
			sender.sendMessage(description);
			sender.sendMessage(ChatColor.BLUE + "Usage:");
			return false;
		} else if(args.length >= 1){
			Expr expr;
			try {
			    expr = Parser.parse(args[0]); 
			} catch (SyntaxException e) {
			    sender.sendMessage(String.valueOf(e.explain()));
			    return true;
			}
			String answer = String.valueOf(expr.value());
			if(answer.equalsIgnoreCase("infinity")||answer.equalsIgnoreCase("-infinity")){
				answer = "NaN";
			}
		    sender.sendMessage(String.valueOf(args[0])+" = "+answer);
		    return true;			 
		}
		return false; 
	}
}


