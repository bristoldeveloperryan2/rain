package com.thecherno.rain.Graphics;

import java.awt.Color;

public class Sprite {

	public final int SIZE;
	private int x, y;
	public int[] pixels;
	private SpriteSheet sheet;
	
	public static Sprite grass = new Sprite(16, 0,0, SpriteSheet.tiles); //this is bad. Temp, don't do it again.
	public static Sprite voidSprite = new Sprite(16, 0xFFFFFF);
	
	public Sprite(int size, int x, int y, SpriteSheet sheet){
		this.SIZE = size;
		this.pixels = new int[this.SIZE * this.SIZE];
		this.x = x * this.SIZE; //ie we pass the sprite x (5th sprite accross 7th down, but here we store pixel location)
		this.y = y * this.SIZE;
		this.sheet = sheet;
		load();
	}
	
	public Sprite(int size, int colour){
		SIZE = size;
		pixels = new int[SIZE*SIZE];
		setColour(colour);
	}
	
	public void setColour(int colour){
		for (int i = 0; i < SIZE * SIZE; i++){
			pixels[i] = colour;
		}
	}
	
	private void load(){
		for (int y = 0; y < SIZE; y++){
			for (int x = 0; x < SIZE; x++){
				pixels [x + y * SIZE] = sheet.pixels[(x+this.x) + (y + this.y) * sheet.SIZE]; //bodmas y * size then + x
			}
		}
	}
	
}
