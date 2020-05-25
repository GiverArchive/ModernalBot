package me.giverplay.modernalworld.bot;

import java.util.Scanner;

import javax.security.auth.login.LoginException;

import me.giverplay.modernalworld.bot.command.CommandManager;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

public class Modernal
{
	private static JDA jda;
	
	public static void main(String[] args)
	{
		System.out.println("Insira seu Token para continuar:\n");
		Scanner s = new Scanner(System.in);
		
		String token = s.nextLine();
		s.close();
		
		try
		{
			jda = new JDABuilder().setToken(token).build().awaitReady();
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
