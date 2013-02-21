package com.thecherno.rain.Level.Tile;

import com.thecherno.rain.Graphics.Screen;
import com.thecherno.rain.Graphics.Sprite;

public class Tile {

	public int x, y; //position
	public Sprite sprite;
	protected boolean solid = false;

	public static Tile grass = new GrassTile(Sprite.grass);
	public static Tile rock = new RockTile(Sprite.rock);
	public static Tile flower = new GrassTile(Sprite.flower);
	public static Tile orangeGrass = new GrassTile(Sprite.orangeGrass);
	public static Tile voidTile = new VoidTile(Sprite.voidSprite);
	public String name = "Tile";
	
	public Tile (Sprite sprite){
		this.sprite = sprite;
	}
	
	
	public void render(int x, int y, Screen screen){
		//
	}
	
	public boolean solid(){
		return solid;
	}
	
}
