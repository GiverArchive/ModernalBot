package me.giverplay.modernalworld.bot;

import java.util.HashMap;

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
	}
	
	public void registerCommands()
	{
		// AQUI EU REGISTRO OS COMANDOS
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
				
				for(int i = 1; i < cmd.length(); i++)
				{
					argPreSplit += cmd.split(" ")[i];
					argPreSplit += "";
				}
				
				boolean sucess = commands.get(cmd).execute(msg, msg.getAuthor(), msg.getTextChannel(), 
																			argPreSplit.trim().split(" "));
				
				if(!sucess) System.out.println("CommandManager.onGuildMessageReceived() -> returned false");
				return;
			}

			String resp = "<@%id> Comando desconhecido";
			msg.getTextChannel().sendMessage(resp.replace("%id", msg.getAuthor().getId())).queue();
		}
	}
}
