package net.electronexchange.minemath;


import net.electronexchange.minemath.math.FivePointStencil;
import net.electronexchange.minemath.math.Function;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import expr.expr.Expr;
import expr.expr.Parser;
import expr.expr.SyntaxException;
import expr.expr.Variable;



public class DerivativeCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){			
		
		if(args.length != 3){
			sender.sendMessage("Derivative of what?");
			return false;
		} else {
			final Expr expr;	
			final Expr posExpr;
			try {
			    expr = Parser.parse(args[0]); 
			    posExpr = Parser.parse(args[2]); 
			} catch (SyntaxException e) {
				sender.sendMessage(String.valueOf(e.explain()));
			    return true;
			}
			
			final Variable x = Variable.make(args[1]);		
			
			Function func = new Function() {
				public double at(double xval) {
					x.setValue(xval);
					return expr.value();
				}
			};		
			final double pos = posExpr.value();
		
			FivePointStencil derivative = new FivePointStencil(func);
			String outString = "Derivative of "+args[0]+" at "+pos+":";
			String answer = String.valueOf(derivative.derivative(pos));
			sender.sendMessage(outString);
			sender.sendMessage(answer);
			return true;
		 }
			

	}
}


