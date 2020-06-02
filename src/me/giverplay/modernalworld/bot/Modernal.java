package me.giverplay.modernalworld.bot;

import me.giverplay.modernalworld.bot.command.CommandManager;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

public class Modernal
{
	private static JDA jda;
	private static String token = "null";

	public static void main(String[] args)
	{
		try
		{
			jda = new JDABuilder()
							.setToken(token)
							.build()
							.awaitReady();
		}
		catch (LoginException e)
		{
			System.out.println("Erro de login: Token fornecido é inválido ou a conexão está limitada");
			System.exit(0);
		}
		catch (InterruptedException e)
		{
			System.out.println("Programa foi forçado a fechar (InterrupedException)");
			System.exit(0);
		}

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
