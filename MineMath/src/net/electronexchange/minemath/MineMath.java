package net.electronexchange.minemath;

import org.bukkit.plugin.java.JavaPlugin;

public class MineMath extends JavaPlugin {
	public void onEnable(){
		getCommand("calc").setExecutor(new CalcCommand());
		getCommand("math").setExecutor(new MathCommand());
		getCommand("integrate").setExecutor(new IntegrateCommand());
		getCommand("derivative").setExecutor(new DerivativeCommand());
	}
}
