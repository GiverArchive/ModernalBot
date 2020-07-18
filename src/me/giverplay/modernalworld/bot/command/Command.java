package me.giverplay.modernalworld.bot.command;

import java.util.List;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;

public abstract class Command
{
	private List<String> aliases;
	private String name;
	
	public Command(@NotNull String name, List<String> aliases)
	{
		this.name = name;
		this.aliases = aliases;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	@Nullable
	public List<String> getAliases()
	{
		return this.aliases;
	}
	
	public abstract boolean execute(@NotNull Message msg, @NotNull User sender, @NotNull TextChannel ch, @NotNull final List<String> args);
}
