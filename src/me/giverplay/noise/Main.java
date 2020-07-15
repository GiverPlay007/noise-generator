package me.giverplay.noise;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Main extends JPanel
{
	public static final int IMPROVED_NOISE = 0;
	public static final int RANDOM_NOISE = 1;
	
	public static final int WIDTH = 720;
	public static final int HEIGHT = 480;
	
	private static final long serialVersionUID = 1L;
	
	private Timer timer = new Timer(80, e -> repaint());
	private Random random = new Random();
	private JFrame frame;
	
	private int alg;
	
	public static void main(String[] args)
	{
		new Main(IMPROVED_NOISE);
	}
	
	protected void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		
		BufferedImage image = getNoiseImage();
		g.drawImage(image, 0, 0, this);
	}
	
	public Main(int algorithm)
	{
		this.alg = algorithm;
		setupFrame();
		timer.start();
	}
	
	public void setupFrame()
	{
		frame = new JFrame("Noise");
		frame.add(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
	}
	
	
	private BufferedImage getNoiseImage()
	{
		if(alg == RANDOM_NOISE)
		{
			return RandomNoise.getNoiseImage(random);
		}
		
		if(alg == IMPROVED_NOISE)
		{
			return ImprovedNoise.getNoiseImage();
		}
		
		return null;
	}
}
