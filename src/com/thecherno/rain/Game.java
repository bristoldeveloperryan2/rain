package com.thecherno.rain;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import com.thecherno.rain.Graphics.Screen;
import com.thecherno.rain.Input.Keyboard;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = 5313041543210236193L;
	public static int width = 300;
	public static int height = width * 9 / 16; //168px
	public static int scale = 3;

	private Thread thread;
	private JFrame frame;
	private Keyboard key;
	private boolean running = false;
	private static String title = "rain";

	private Screen screen;
	
	private BufferedImage image = new BufferedImage(width, height,
			BufferedImage.TYPE_INT_RGB); // the final view we plan to render
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData(); //converting image into array of integers
	
	int x = 0;
	int y = 0;
	
	public Game() {
		Dimension size = new Dimension(width * scale, height * scale);
		setPreferredSize(size); // Canvas - setPreferredSize
		screen = new Screen(width, height); //set up a screen object, pass it details of the size of our screen
		frame = new JFrame();
		key = new Keyboard();
		addKeyListener(key);
	}

	/**
	 * Main starter.. synchronized keeps multiple threads in check, no overlaps
	 * of instructions etc.
	 */
	public synchronized void start() {
		running = true;
		thread = new Thread(this, "Display"); // attach this object to thread
												// and give it a name
		thread.start();
	}

	public synchronized void stop() {
		running = false;
		try {
			thread.join(); // join the threads up and stop them nice and cleanly
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * We implement runnable, new thread is this, so when thread is created we
	 * run this.
	 */
	@Override
	public void run() {
		requestFocus(); //from component, so we don't have to click to get focus
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0; //ensures it's 60 fps
		double delta = 0;
		int frames = 0;
		int updates = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1){
				update(); // some people call it tick
				updates++;
				delta--; //reset delta back again
			}
			render();
			frames++;
			if (System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println("Updates " + updates + ", FPS " + frames);
				frame.setTitle(title + " : " + frames + " fps - " + screen.screenTitle);
				frames = 0;
				updates = 0;
			}
//			frame.setTitle(title + " - " + screen.screenTitle);
		}
		stop();
	}// run

	public void update() {
		key.update();
		if (key.left){
			x--;
		}
		if (key.right){
			x++;
		}
		if (key.up){
			y--;
		}
		if (key.down){
			y++;
		}
	}

	public void render() {
		BufferStrategy bs = getBufferStrategy(); // get buffer strategy from
													// canvas
		if (bs == null) { // if it hasn't been created yet, create a
							// triple-buffer, exit ready for next render
			createBufferStrategy(3);
			/*
			 * triple-buffer is better than double-buffering - don't have to
			 * wait for screen to be ready to render
			 * https://www.youtube.com/watch?v=-nNQiO_32yY 17:00 for
			 * explanation.
			 */
			return;
		}
		
		screen.clear(); //otherwise animations will leave trails
		screen.render(x, y);
		for (int i = 0; i < this.pixels.length; i++){
			this.pixels[i] = screen.pixels[i];
		}
		
		Graphics g = bs.getDrawGraphics(); // Get a graphic area in which to
											// draw from the buffer

		// graphics happen here
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		
		g.dispose();// cleans things up, gets rid of graphics and releases
					// system resources
		bs.show(); // blit the buffer visible (ie make the most recent one
					// appear)
	}

	/**
	 * When we run the program, this is what happens first. Static so we haven't
	 * loaded the object.. instead we need to use this to run method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Game game = new Game();
		game.frame.setResizable(false);
		game.frame.setTitle(title);
		game.frame.add(game); // add the game (canvas) to the frame
		game.frame.pack(); // size up frame to match component
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // just close
																	// the app
																	// if you
																	// close the
																	// window
		game.frame.setLocationRelativeTo(null); // centre the window
		game.frame.setVisible(true);
		game.start();
	}

}
