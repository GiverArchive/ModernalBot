package me.giverplay.modernalworld.bot.config;

public class JSONConfig implements Config
{
	private String name;
	
  public JSONConfig(String configName)
	{
  	this.name = configName;
	}
  
  public String getConfigName()
  {
  	return this.name;
  }
  
	@Override
	public String getString(String path)
	{
		return null;
	}

	@Override
	public int getInt(String path, int def)
	{
		return def;
	}

	@Override
	public long getLong(String path, long def)
	{
		return def;
	}

	@Override
	public boolean getBoolean(String path)
	{
		return false;
	}
}
