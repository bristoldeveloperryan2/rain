package com.thecherno.rain.Level;

import com.thecherno.rain.Graphics.Screen;

public class Level {
	
	private int width, height;
	private int[] tiles;
	
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
	
	private void generateLevel(){
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

	public void render(int xScroll, int yScroll, Screen screen){
		//
	}
	
}//class
