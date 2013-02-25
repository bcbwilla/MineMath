package net.electronexchange.minemath;


import net.electronexchange.minemath.math.Function;
import net.electronexchange.minemath.math.SimpsonsIntegrator;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import expr.expr.Expr;
import expr.expr.Parser;
import expr.expr.SyntaxException;
import expr.expr.Variable;



public class IntegrateCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){			
		
		if(args.length != 4){
			sender.sendMessage("Integrate what?");
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
			
			final Variable x = Variable.make(args[1]);		
			
			Function integrand = new Function() {
				public double at(double xval) {
					x.setValue(xval);
					return expr.value();
				}
			};		
			final double lowerLimit = lowerLimitExpr.value();
			final double upperLimit = upperLimitExpr.value();
			final int stepSize = 10000;
			
			SimpsonsIntegrator integral = new SimpsonsIntegrator(integrand);
			String outString = "Integral of "+args[0]+" from "+lowerLimit+" to "+upperLimit+":";
			String answer = String.valueOf(integral.integrate(lowerLimit, upperLimit, stepSize));
			sender.sendMessage(outString);
			sender.sendMessage(answer);
			return true;
		 }
			

	}
}


