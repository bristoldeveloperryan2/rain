package com.thecherno.rain.Level.Tile;

import com.thecherno.rain.Graphics.Screen;
import com.thecherno.rain.Graphics.Sprite;

public class VoidTile extends Tile {

	protected boolean solid = false;
	public Sprite sprite;
	public String name = "VoidTile";
	
	public VoidTile(Sprite sprite) {
		super(sprite);
	}
	
	public void render(int x, int y, Screen screen){
		screen.renderTile(x << 4, y << 4, this);
	}
	
}
