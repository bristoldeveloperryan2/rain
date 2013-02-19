package com.thecherno.rain.Level;

import com.thecherno.rain.Graphics.Screen;
import com.thecherno.rain.Level.Tile.Tile;

public class Level {
	
	protected int width, height;
	protected int[] tiles;
	
	/**
	 * Generate a random level
	 * @param width
	 * @param height
	 */
	public Level(int width, int height){
		this.width = width;
		this.height = height;
		tiles = new int[width*height];
		generateLevel();
	}
	
	/*
	 * Load a level from file
	 */
	public Level (String path){
		loadLevel(path);
	}
	
	protected void generateLevel(){
		//
	}
	
	private void loadLevel(String path){
		//
	}
	
	public void update(){
		//things like AI, moving platforms, etc
	}

	private void time(){
		//manage time etc
	}

	/**
	 * Scroll value deals with units of 1 tile
	 * @param xScroll
	 * @param yScroll
	 * @param screen
	 */
	public void render(int xScroll, int yScroll, Screen screen){
		//Define render region
		screen.setOffset(xScroll, yScroll);
		int x0, x1, y0, y1; //corner pins (ie x0,y0 = top left of screen, x1,y1 = bottom right of screen
		x0 = xScroll >> 4; // / 16 so we get the pixel number from the tile number xScroll provides
		x1 = (xScroll + screen.width + 16) >> 4; //right shift makes smaller, left shift makes bigger
		y0 = yScroll >> 4;
		y1 = (yScroll + screen.height + 16) >> 4; 
		//end define render region

		for (int y = y0; y < y1; y++){
			for (int x = x0; x < x1; x++){
				getTile(x, y).render(x, y, screen);
			}
		}
	}
	
	/**
	 * Using tile precision level, not pixel precision, for x and y
	 * @param x
	 * @param y
	 * @return
	 */
	public Tile getTile(int x, int y){ //position of tile
		//wouldn't a switch case be better?
		if (x < 0 || y < 0 || x >= this.width || y >= this.height){
			return Tile.voidTile;
		}
		int tileID = tiles[x+y*width];
		if (tileID == 0){
			return Tile.grass;
		}
		return Tile.voidTile;
	}
	
}//class
