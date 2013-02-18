package com.thecherno.rain.Level.Tile;

import com.thecherno.rain.Graphics.Screen;
import com.thecherno.rain.Graphics.Sprite;

public class Tile {

	public int x, y; //position
	public Sprite sprite;
	protected boolean solid = false;

	public static Tile grass = new GrassTile(Sprite.grass);
	public static Tile voidTile = new VoidTile(Sprite.voidSprite);
	
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
