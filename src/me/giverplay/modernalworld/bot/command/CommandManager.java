package me.giverplay.modernalworld.bot.command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import org.jetbrains.annotations.Nullable;

import me.giverplay.modernalworld.bot.Modernal;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class CommandManager extends ListenerAdapter
{
	private List<Command> commands = new ArrayList<>();
	
	private Modernal modernal;
	private String prefix;
	private JDA bot;
	
	public CommandManager(Modernal main)
	{
		modernal = main;
		prefix = modernal.getConfig().getString("prefix");
		
		bot = main.getJDA();
		bot.addEventListener(this);
		
		registerCommands();
	}
	
	public void registerCommands()
	{
		
	}
	
	public void addComando(Command cmd)
	{
		if(commands.stream().anyMatch((c) -> c.getName().equalsIgnoreCase(cmd.getName())))
			throw new IllegalArgumentException("This command name is already registered");
		
		commands.add(cmd);
	}
	
	@Nullable
	public Command getCommand(String name)
	{
		String nameL = name.toLowerCase();
		
		synchronized (this)
		{
			for(Command cmd : commands)
			{
				if(cmd.getName().equals(nameL) || cmd.getAliases().contains(nameL))
					return cmd;
			}
		}
		
		return null;
	}
	
	@Override
	public void onGuildMessageReceived(GuildMessageReceivedEvent event)
	{
		Message msg = event.getMessage();
		
		if(msg.getAuthor().isBot() || msg.isWebhookMessage()) return;
		
		String[] split = event.getMessage().getContentRaw()
				.replaceFirst("(?i)" + Pattern.quote(prefix), "")
				.split("\\s+");
		
		Command cmd = this.getCommand(split[0].toLowerCase());
		
		if (cmd != null) 
		{
			TextChannel ch = event.getChannel();
			ch.sendTyping().queue();
			List<String> args = Arrays.asList(split).subList(1, split.length);
			
			boolean b = cmd.execute(msg, msg.getAuthor(), ch, args);
			
			if(!b)
			{
				System.out.println("Command " + cmd.getName() + " returned false");
			}
		}
	}
}
