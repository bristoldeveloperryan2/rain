package com.thecherno.rain.Level.Tile;

import com.thecherno.rain.Graphics.Screen;
import com.thecherno.rain.Graphics.Sprite;

public class RockTile extends Tile {

	protected boolean solid = true;
	public Sprite sprite;
	public String name = "RockTile";

	
	public RockTile(Sprite sprite) {
		super(sprite);
	}
	
	public void render(int x, int y, Screen screen){
		screen.renderTile(x << 4, y << 4, this);
	}
	
}
