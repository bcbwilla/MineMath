package net.electronexchange.minemath.commands;

import net.electronexchange.minemath.util.MMUtil;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import expr.expr.Variable;


public class VariableCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		if(args.length < 3 || args.length > 4){
			MMUtil.commandHelp("variable", cmd, sender);
			return false;
		} else if(args.length == 3 && args[0].equalsIgnoreCase("set")) {
			setVariable(sender, args);
			return true;
		} else if(args.length == 2 && args[0].equalsIgnoreCase("echo")) {
			echoVariable(sender, args);
			return true;
		}
		return false;
	}
	
	public void setVariable(CommandSender sender, String[] args) {	
		String variableName = MMUtil.userVariableName(sender.getName(), args[1]);
		final Variable var = Variable.make(variableName);
		var.setValue(Double.valueOf(args[2]));
		sender.sendMessage(args[1] + " = " + args[2]);
	}
	
	public void echoVariable(CommandSender sender, String[] args) {	
		String variableName = MMUtil.userVariableName(sender.getName(), args[1]);
		final Variable var = Variable.make(variableName);
		sender.sendMessage(args[1] + " = " + Double.toString(var.value()));
	}
}

