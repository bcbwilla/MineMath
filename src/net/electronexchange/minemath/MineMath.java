package net.electronexchange.minemath;

import net.electronexchange.minemath.commands.CalculateCommand;
import net.electronexchange.minemath.commands.DerivativeCommand;
import net.electronexchange.minemath.commands.IntegrateCommand;
import net.electronexchange.minemath.commands.MineMathCommand;
import net.electronexchange.minemath.commands.RandomCommand;

import org.bukkit.plugin.java.JavaPlugin;

public class MineMath extends JavaPlugin {
	@Override
	public void onEnable(){
		getLogger().info("0.999... = 1");
		getCommand("minemath").setExecutor(new MineMathCommand(this));
		getCommand("calculate").setExecutor(new CalculateCommand());
		getCommand("integrate").setExecutor(new IntegrateCommand());
		getCommand("derivative").setExecutor(new DerivativeCommand());
		getCommand("coinflip").setExecutor(new RandomCommand());
		getCommand("rolldice").setExecutor(new RandomCommand());
	}
	@Override
	public void onDisable(){
		getLogger().info("0.999... is still equal to 1");
	}
}
