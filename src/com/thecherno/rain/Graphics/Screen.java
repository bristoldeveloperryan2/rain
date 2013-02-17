package com.thecherno.rain.Graphics;

import java.util.Random;

import com.thecherno.rain.Level.Tile.Tile;

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
			int yp = y + yOffset;
			if (yp < 0 || yp >= this.height) continue;
			for (int x = 0; x < this.width; x++){
				int xp = x + xOffset;
				if (xp < 0 || xp >= width) continue;
				pixels[xp + yp * width] = Sprite.grass.pixels[(x&15) + (y&15) * Sprite.grass.SIZE];
			}
		}
	}
	
	
	public void renderTile(int xp, int yp, Tile tile){
		for (int y=0; y < tile.sprite.SIZE; y++){
			int ya = y + yp; //ya is absolute y value, yp is offset
			for (int x=0; x < tile.sprite.SIZE; x++){
				int xa = x + xp;
				if (xa < 0 || xa >= width || ya < 0 || ya >= height) break; //if it's off the screen, don't render it
				pixels [xa + ya * width] = tile.sprite.pixels[x+y*tile.sprite.SIZE];
			}
		}
	}
	
	
}
