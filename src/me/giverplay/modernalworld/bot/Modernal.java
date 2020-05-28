package me.giverplay.modernalworld.bot;

import me.giverplay.modernalworld.bot.command.CommandManager;
import net.dv8tion.jda.api.JDA;

public class Modernal
{
	private static JDA jda;
	
	public static void main(String[] args)
	{
		new Modernal();
	}
	
	public Modernal()
	{
		setup();
	
	}
	
	private void setup()
	{
		new CommandManager();
	}
	
	public static JDA getJDA()
	{
		return jda;
	}
}
