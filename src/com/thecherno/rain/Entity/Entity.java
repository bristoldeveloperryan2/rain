package com.thecherno.rain.Entity;

import java.util.Random;

import com.thecherno.rain.Graphics.Screen;
import com.thecherno.rain.Level.Level;

public abstract class Entity {

	public int x, y;
	private boolean removed = false;
	protected Level level;
	protected final Random random = new Random();
	
	
	public void update(){
		//
	}
	
	public void render(Screen screen){
		//
	}
	
	public void remove(){
		//remove from level
		this.removed = true;
	}
	
	public boolean isRemoved(){
		return removed;
	}
	
}
