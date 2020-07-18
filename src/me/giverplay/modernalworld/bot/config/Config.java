package me.giverplay.modernalworld.bot.config;

public interface Config
{
	public String getString(String path);
	
	public int getInt(String path, int def);
	
	public long getLong(String path, long def);
	
	public boolean getBoolean(String path);
}
