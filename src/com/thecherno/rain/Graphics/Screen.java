package com.thecherno.rain.Graphics;

import java.util.Random;

import com.thecherno.rain.Entity.Mob.Player;
import com.thecherno.rain.Level.Tile.Tile;

public class Screen {
	
	public int width, height;
	public int[] pixels;
	public final int MAP_SIZE = 64;
	public final int MAP_SIZE_MASK = MAP_SIZE - 1;
	public int[] tiles = new int[MAP_SIZE * MAP_SIZE];
	public String screenTitle = "";
	
	public int xOffset, yOffset;
	
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
	
	public void renderTile(int xp, int yp, Tile tile){
		xp -= xOffset;
		yp -= yOffset;
		for (int y=0; y < tile.sprite.SIZE; y++){
			int ya = y + yp; //ya is absolute y value, yp is offset
			for (int x=0; x < tile.sprite.SIZE; x++){
				int xa = x + xp;
				if (xa < 0 - tile.sprite.SIZE || xa >= width || ya < 0 || ya >= height) break; //if it's off the screen, don't render it
				if (xa < 0){ xa = 0; }
				pixels [xa + ya * width] = tile.sprite.pixels[x+y*tile.sprite.SIZE];
			}
		}
	}
	
	
	public void renderPlayer(int xp, int yp, Sprite sprite){
		xp -= xOffset;
		yp -= yOffset;
		for (int y=0; y < sprite.SIZE; y++){
			int ya = y + yp; //ya is absolute y value, yp is offset
			for (int x=0; x < sprite.SIZE; x++){
				int xa = x + xp;
				if (xa < 0 - sprite.SIZE || xa >= width || ya < 0 || ya >= height) break; //if it's off the screen, don't render it
				if (xa < 0){ xa = 0; }
				int col = sprite.pixels [x + y * sprite.SIZE];
				if (col != 0x00FFFFFF){ //the first 00 is to deal with alpha being 00
					pixels [xa + ya * width] = sprite.pixels[x+y*sprite.SIZE];
				}
			}
		}
	}
	
	
	public void setOffset(int xOffset, int yOffset){
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
}
