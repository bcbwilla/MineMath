package net.electronexchange.minemath.commands;


import java.util.Map;

import net.electronexchange.minemath.MineMath;
import net.electronexchange.minemath.math.Function;
import net.electronexchange.minemath.math.SimpsonsIntegrator;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import expr.expr.Expr;
import expr.expr.Parser;
import expr.expr.SyntaxException;
import expr.expr.Variable;

public class IntegrateCommand implements CommandExecutor {
	
	private MineMath plugin;
	 
	public IntegrateCommand(MineMath plugin) {
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){			
		
		if(args.length < 4 || args.length > 5){
			Map<String, Object> commandInfo = plugin.getDescription().getCommands().get("integrate");
			String description = (String) commandInfo.get("description");
			sender.sendMessage(ChatColor.BLUE + "Description:");
			sender.sendMessage(description);
			sender.sendMessage(ChatColor.BLUE + "Usage:");
			return false;
		} else {
			final Expr expr;
			final Expr lowerLimitExpr;
			final Expr upperLimitExpr;
			try {
			    expr = Parser.parse(args[0]); 
				lowerLimitExpr = Parser.parse(args[2]);
				upperLimitExpr = Parser.parse(args[3]);
			} catch (SyntaxException e) {
				sender.sendMessage(String.valueOf(e.explain()));
			    return true;
			}
			
			final Variable var = Variable.make(args[1]);		
			
			Function integrand = new Function() {
				public double at(double xval) {
					var.setValue(xval);
					return expr.value();
				}
			};		
						
			double lowerLimit = lowerLimitExpr.value();
			double upperLimit = upperLimitExpr.value();
			int stepSize = 10000;
			
			SimpsonsIntegrator integral = new SimpsonsIntegrator(integrand);
			double answer = integral.integrate(lowerLimit, upperLimit, stepSize);
			
			//store in specific variable if supplied
			if(args.length == 5){
				Variable result = Variable.make(args[4]);
				result.setValue(answer);
			}
			//always store in "last" variable
			Variable last = Variable.make("last");
			last.setValue(answer);
					
			String outString = "Integral of "+args[0]+" from "+lowerLimit+" to "+upperLimit+":";
			sender.sendMessage(outString);
			sender.sendMessage(String.valueOf(answer));
			return true;
		 }
			

	}
}


