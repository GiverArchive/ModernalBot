package me.giverplay.modernalworld.bot.command;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;

public interface Command
{
	public boolean execute(Message msg, User sender, TextChannel ch, String[] args);
}
