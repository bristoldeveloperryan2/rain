package com.thecherno.rain.Graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {

	private String path;
	private final int SIZE;
	public int[] pixels;
	private boolean loaded = false;
	
	public SpriteSheet(String path, int size){
		this.path = path;
		this.SIZE = size;
		this.pixels = new int [this.SIZE * this.SIZE];
		load();
	}
	
	private void load(){
		try {
			BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));
			int w = image.getWidth();
			int h = image.getHeight();
			image.getRGB(0, 0, w, h, pixels, 0, w); //scansize is horizontal width.. weird
			loaded = true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
