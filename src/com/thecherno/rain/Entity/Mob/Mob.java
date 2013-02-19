package com.thecherno.rain.Entity.Mob;

import com.thecherno.rain.Entity.Entity;
import com.thecherno.rain.Graphics.Sprite;

public abstract class Mob extends Entity {
	
	protected Sprite sprite;
	protected int dir = 0; //direction 0n, 1s, 2e, 3w etc
	protected boolean moving = false;
	
	public void move(int xa, int ya){ //the movement in each dir
		if (xa > 0){ dir = 1; }
		if (xa < 0){ dir = 3; }
		if (ya > 0){ dir = 2; }
		if (ya < 0){ dir = 0; }
		
		if (!collision()){
			x += xa;
			y += ya;
		}
	}
	
	public void update(){
		//
	}
	
	private boolean collision(){
		return false;
	}
	
	public void render(){
		
	}
	
}
