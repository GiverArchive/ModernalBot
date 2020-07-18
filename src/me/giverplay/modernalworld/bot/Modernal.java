package me.giverplay.modernalworld.bot;

import javax.security.auth.login.LoginException;

import me.giverplay.modernalworld.bot.command.CommandManager;
import me.giverplay.modernalworld.bot.config.Config;
import me.giverplay.modernalworld.bot.config.JSONConfig;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

public class Modernal
{
	private static Modernal instance;
	
	private Config config;
	private String token;
	private JDA jda;
	
	public static void main(String[] args)
	{
		new Modernal();
	}
	
	private Modernal()
	{
		instance = this;
		setup();
	}
	
	private void setup()
	{
		config = new JSONConfig("bot");
		token = config.getString("token");
		
		try
		{
			jda = new JDABuilder()
					.setToken(token)
					.build()
					.awaitReady();
		}
		catch(LoginException e)
		{
			System.out.println("Token inválida ou erro de conexão");
			System.exit(0);
		}
		catch(InterruptedException e)
		{
			System.out.println("Interrupeted Exception");
		}
		
		new CommandManager(this);
	}
	
	public JDA getJDA()
	{
		return this.jda;
	}
	
	public Config getConfig()
	{
		return this.config;
	}
	
	public static Modernal getInstance()
	{
		return instance;
	}
}
