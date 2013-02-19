package com.thecherno.rain.Entity.Mob;

import com.thecherno.rain.Entity.Entity;
import com.thecherno.rain.Graphics.Sprite;

public abstract class Mob extends Entity {
	
	protected Sprite sprite;
	protected int dir = 0; //direction 0n, 1s, 2e, 3w etc
	protected boolean moving = false;
	
	public void move(){
		//
	}
	
	public void update(){
		//
	}
	
	private boolean collision(){
		return false;
	}
	
}
