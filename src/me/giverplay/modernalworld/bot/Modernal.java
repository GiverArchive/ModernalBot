package me.giverplay.modernalworld.bot;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

public class Modernal
{
	private static JDA jda;
	
	public static void main(String[] args)
	{
		try
		{
			jda = new JDABuilder().setToken(Constantes.TOKEN).build().awaitReady();
		} 
		catch (LoginException e)
		{
			System.out.println("Falha ao logar no Discord");
			e.printStackTrace();
		} 
		catch (InterruptedException e)
		{
			System.out.println("Programa foi forçado a fechar, cacete, o tal do usuário é o bicho mais burro já inventado");
			e.printStackTrace();
		}
		
		setup();
	}
	
	private static void setup()
	{
		new CommandManager();
	}
	
	public static JDA getJDA()
	{
		return jda;
	}
}
