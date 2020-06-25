package me.giverplay.noise;

import java.awt.image.BufferedImage;
import java.util.Random;

public class RandomNoise
{
	private static BufferedImage image = new BufferedImage(Main.WIDTH, Main.HEIGHT, BufferedImage.TYPE_INT_RGB);
	
	public static BufferedImage getNoiseImage(Random random)
	{
		for (int x = 0; x < Main.WIDTH; x++)
		{
			for (int y = 0; y < Main.HEIGHT; y++)
			{
				image.setRGB(x, y, random.nextInt(0xFFFFFF));
			}
		}
		
		return image;
	}
}
