package me.giverplay.modernalworld.bot.command;

import java.util.HashMap;

import me.giverplay.modernalworld.bot.Modernal;
import me.giverplay.modernalworld.bot.command.comandos.ComandoToctoc;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class CommandManager extends ListenerAdapter
{
	private HashMap<String, Command> commands = new HashMap<>();
	private JDA bot;
	
	public CommandManager()
	{
		bot = Modernal.getJDA();
		bot.addEventListener(this);
		
		registerCommands();
	}
	
	public void registerCommands()
	{
		// AQUI EU REGISTRO OS COMANDOS
		addComando("toctoc", new ComandoToctoc());
	}
	
	public void addComando(String nome, Command cmd)
	{
		commands.put(nome, cmd);
	}
	
	@Override
	public void onGuildMessageReceived(GuildMessageReceivedEvent event)
	{
		Message msg = event.getMessage();
		
		if(msg.getAuthor().isBot()) return; // Evitar msg de bot etc etc etc
		
		String content = msg.getContentRaw();
		
		if(content.startsWith("+"))
		{
			String cmd = content.split(" ")[0].replace("+", "").trim();
			if(commands.containsKey(cmd))
			{
				String argPreSplit = "";
				String[] array;
				
				try
				{
					for(int i = 1; i < cmd.length(); i++)
					{
						argPreSplit += cmd.split(" ")[i];
						argPreSplit += "";
					}
					
					array = argPreSplit.split(" ");
				}
				catch(ArrayIndexOutOfBoundsException e)
				{
					array = new String[1];
				}
				
				boolean sucess = commands.get(cmd).execute(msg, msg.getAuthor(), msg.getTextChannel(), array);
				
				if(!sucess) System.out.println("CommandManager.onGuildMessageReceived() -> returned false");
				return;
			}
			
			msg.getTextChannel().sendMessage(msg.getAuthor().getAsMention() + " Comando desconhecido").queue();
		}
	}
}
