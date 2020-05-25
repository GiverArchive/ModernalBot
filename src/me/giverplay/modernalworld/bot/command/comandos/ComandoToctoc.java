package me.giverplay.modernalworld.bot.command.comandos;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import me.giverplay.modernalworld.bot.command.Command;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;

public class ComandoToctoc implements Command
{
	@Override
	public boolean execute(Message msg, User sender, TextChannel ch, String[] args)
	{
		BufferedImage tmp = null;
		
		try
		{
			tmp = ImageIO.read(getClass().getResource("/porta.png"));
		} 
		catch (IOException e)
		{
			e.printStackTrace();
			return false;
		}
		
		Graphics g = tmp.getGraphics();
		g.setColor(Color.BLACK);
		g.setFont(new Font("3D Hand Drawns", Font.PLAIN, 11));
		
		FontMetrics metrics = g.getFontMetrics(g.getFont());
		
		int x = (tmp.getWidth() - metrics.stringWidth("Toctoc")) / 2;
		
		g.drawString("Toctoc", x, 180);
		
		final ByteArrayOutputStream output = new ByteArrayOutputStream() 
		{
			@Override
			public synchronized byte[] toByteArray() 
			{
				return this.buf;
			}
		};
		
		try
		{
			ImageIO.write(tmp, "png", output);
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		ch.sendFile(output.toByteArray(), "porta.png").queue();
		
		return true;
	}
}
