package net.electronexchange.minemath.commands;


import java.util.Map;

import net.electronexchange.minemath.MineMath;
import net.electronexchange.minemath.math.FivePointStencil;
import net.electronexchange.minemath.math.Function;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import expr.expr.Expr;
import expr.expr.Parser;
import expr.expr.SyntaxException;
import expr.expr.Variable;



public class DerivativeCommand implements CommandExecutor {
	
	private MineMath plugin;
	 
	public DerivativeCommand(MineMath plugin) {
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){			
		
		if(args.length < 3 || args.length > 4){
			Map<String, Object> commandInfo = plugin.getDescription().getCommands().get("derivative");
			String description = (String) commandInfo.get("description");
			sender.sendMessage(ChatColor.BLUE + "Description:");
			sender.sendMessage(description);
			sender.sendMessage(ChatColor.BLUE + "Usage:");
			return false;
		} else {
			final Expr expr;	//mathematical expression
			final Expr posExpr; //position of derivative
			try {
			    expr = Parser.parse(args[0]); 
			    posExpr = Parser.parse(args[2]); 
			} catch (SyntaxException e) {
				sender.sendMessage(String.valueOf(e.explain()));
			    return true;
			}
			
			final Variable var = Variable.make(args[1]); //variable of which derivative is with respect to
			
			//Define function from expression to evaluate using Function interface
			Function func = new Function() {
				public double at(double xval) {
					var.setValue(xval);
					return expr.value();
				}
			};		
			double pos = posExpr.value();
			
			//Calculate derivative
			FivePointStencil derivative = new FivePointStencil(func);
			Double answer = derivative.derivative(pos);
			
			//store in specific variable if supplied
			if(args.length == 4){
				Variable result = Variable.make(args[3]);
				result.setValue(answer);
			}			
			//always store in last variable
			Variable last = Variable.make("last");
			last.setValue(answer);	
			
			String outString = "Derivative of "+args[0]+" at "+pos+":";
			sender.sendMessage(outString);
			sender.sendMessage(String.valueOf(answer));
			return true;
		 }
	}
}


