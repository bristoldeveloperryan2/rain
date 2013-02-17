package com.thecherno.rain.Graphics;

import java.util.Random;

public class Screen {
	
	private int width, height;
	public int[] pixels;
	public final int MAP_SIZE = 64;
	public final int MAP_SIZE_MASK = MAP_SIZE - 1;
	public int[] tiles = new int[MAP_SIZE * MAP_SIZE];
	public String screenTitle = "";
	
	private Random random = new Random();
	
	
	public Screen (int width, int height){
		this.width = width;
		this.height = height;
		pixels = new int[width*height]; //1 int for each pixel on the screen
		for (int i = 0; i < MAP_SIZE*MAP_SIZE; i++){
			tiles[i] = random.nextInt(0xffffff); //generate a random tile colour and put it in the index
		}
	}

	
	public void clear(){
		for (int i = 0; i < pixels.length; i++){
			pixels[i] = 0;
		}
	}
	
	public void render(int xOffset, int yOffset){
		for (int y = 0; y < this.height; y++){
			int yy = y + yOffset;
			for (int x = 0; x < this.width; x++){
				int xx = x + xOffset;
				int tileIndexX = ((xx >> 4) & MAP_SIZE_MASK);
				int tileIndexY = ((yy >> 4) & MAP_SIZE_MASK);
				int tileIndex = tileIndexX + (tileIndexY * MAP_SIZE);
				pixels[x + (y*width)] = tiles[tileIndex]; //0x tells it hexadecimal.. then the rest can be hex.. binary would be 0b but only in j7
			}
		}
	}
	
}
