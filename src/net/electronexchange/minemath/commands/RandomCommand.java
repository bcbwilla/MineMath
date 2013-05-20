package net.electronexchange.minemath.commands;

import java.util.Random;

import net.electronexchange.minemath.util.MMUtil;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class RandomCommand implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){	
		
		if (cmd.getName().equalsIgnoreCase("coinflip")){
			if(args.length > 0){
				MMUtil.commandHelp("coinflip", cmd, sender);
				return false;
			}else{
				sender.sendMessage(coinFlip());
				return true;
			}
		}else if (cmd.getName().equalsIgnoreCase("rolldie")){
			if(args.length == 0 || args.length > 1){
				MMUtil.commandHelp("rolldie", cmd, sender);
				return false;
			}else{
				int n = Integer.valueOf(args[0]);
				sender.sendMessage("You rolled a "+String.valueOf(rollDice(n)));
				return true;
			}
		}
		return false;
	}
	
	/**
	 * flips coin
	 * @return
	 */
	private String coinFlip() {
		Random generator = new Random();
		if(generator.nextInt(2) == 1){
			return "Heads";
		}else{
			return "Tails";
		}
	}
	
	/**
	 * rolls n sided die
	 * @param n number of die sides
	 * @return
	 */
	private int rollDice(int n) {
		Random generator = new Random();
		return generator.nextInt(n) + 1;
	}
}


