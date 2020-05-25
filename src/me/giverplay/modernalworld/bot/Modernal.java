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
		System.out.println("Insira seu Token para continuar:");
		Scanner s = new Scanner(System.in);
		boolean sair = false;
		String token;
		
		while(!sair){
			token = s.nextLine();
			
			try
			{
				jda = new JDABuilder().setToken(token).build();
				sair = true;
			} 
			catch (LoginException e)
			{
				System.out.println("Falha ao logar no Discord, verifique se esse é o token correto");
				System.out.println("Digite novamente:");
			}
		}
		
		s.close();
		
		System.out.println("\n\nMuito bem, podemos começar");
		System.out.println("Ignore as mensagens de vermelho, aquilo é normal");
		
		
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
