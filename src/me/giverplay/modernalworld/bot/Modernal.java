package me.giverplay.modernalworld.bot;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import me.giverplay.modernalworld.bot.command.CommandManager;
import net.dv8tion.jda.api.JDA;

public class Modernal extends JFrame
{
	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 1080;
	private static final int HEIGHT = 640;
	
	private static JDA jda;
	
	private JPanel panel;
	private JLabel T1;
	
	public static void main(String[] args)
	{
		new Modernal();
	}
	
	public Modernal()
	{
		setupFrame();
		setupAssets();
		loadInfo();
		//setup();
		
		/*
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
		*/
	}
	
	private void setupFrame()
	{
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setTitle("Modernal Bot Manager");
		setResizable(false);
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private void setupAssets()
	{
		panel = new JPanel();
		setContentPane(panel);
		
		T1 = new JLabel();
		T1.setFont(new Font("3D Hand Drawns", Font.PLAIN, 30));
		T1.setBackground(Color.WHITE);
		T1.setHorizontalAlignment(SwingConstants.CENTER);
		T1.setBounds(20, 20, 1040, 70);
		T1.setOpaque(false);
		
		panel.add(T1);
	}
	
	public void loadInfo()
	{
		T1.setText("Modernal Bot Manager");
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
