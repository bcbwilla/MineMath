package net.electronexchange.minemath.commands;


import net.electronexchange.minemath.math.Function;
import net.electronexchange.minemath.math.SimpsonsIntegrator;
import net.electronexchange.minemath.util.MMUtil;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import expr.expr.Expr;
import expr.expr.Parser;
import expr.expr.SyntaxException;
import expr.expr.Variable;

public class IntegrateCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){			
		//argument checks
		if(args.length < 4 || args.length > 5){
			MMUtil.commandHelp("integrate", cmd, sender);
			return false;
		} else {
			return doIntegral(sender, args);
		}
	}
	
	/**
	 * Calculates integral using Simpson's method
	 * @param sender user who sent command to do integral
	 * @param args list of command arguments
	 * @return
	 */
	private boolean doIntegral(CommandSender sender, String[] args){
		final Expr expr;
		final Expr lowerLimitExpr;  //lower bound on integral
		final Expr upperLimitExpr;  //upper bound on integral
		try {
		    expr = Parser.parse(args[0]); 
			lowerLimitExpr = Parser.parse(args[2]);
			upperLimitExpr = Parser.parse(args[3]);
		} catch (SyntaxException e) {
			sender.sendMessage(String.valueOf(e.explain()));
		    return true;
		}
		
		//variable of which the int. is with respect to	
		final Variable var = Variable.make(args[1]); 
		
		//function to integrate
		Function integrand = new Function() {
			public double at(double xval) {
				var.setValue(xval);
				return expr.value();
			}
		};		
					
		double lowerLimit = lowerLimitExpr.value();
		double upperLimit = upperLimitExpr.value();
		final int stepSize = 10000; //number of bits to break the integral into
		
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


