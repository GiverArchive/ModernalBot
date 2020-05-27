package me.giverplay.modernalworld.bot;

import java.util.Scanner;

import javax.security.auth.login.LoginException;
import javax.swing.JFrame;

import me.giverplay.modernalworld.bot.command.CommandManager;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

public class Modernal extends JFrame
{
	private static final long serialVersionUID = 1L;
	
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
		
		
	}
	
	public Modernal()
	{
		setupFrame();
		setup();
	}
	
	private void setupFrame()
	{
		setTitle("Modernal Bot Manager");
		add(this);
		setResizable(false);
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
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
