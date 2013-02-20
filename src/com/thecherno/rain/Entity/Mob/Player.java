package com.thecherno.rain.Entity.Mob;

import com.thecherno.rain.Graphics.Screen;
import com.thecherno.rain.Graphics.Sprite;
import com.thecherno.rain.Input.Keyboard;

public class Player extends Mob {

	private Keyboard input;
	private Sprite sprite;
	
	public Player(Keyboard input){
		this.input = input;
		sprite = Sprite.player_forward;
	}
	
	public Player(int x, int y, Keyboard input){
		this.x = x;
		this.y = y;
		this.input = input;
		sprite = Sprite.player_forward;
	}
	
	public void update(){
		int xa=0, ya=0;
		if (input.up){ ya--; }
		if (input.down){ ya++; }
		if (input.left){ xa--; }
		if (input.right){ xa++; }
		if (xa != 0 || ya != 0){
			move (xa, ya);
			System.out.println("Dir: " + dir);
		}
	}
	
	public void render(Screen screen){
		int xx = x - 16;
		int yy = y - 16;
		
		if (dir == 0) sprite = Sprite.player_forward;
		if (dir == 1) sprite = Sprite.player_right;
		if (dir == 2) sprite = Sprite.player_backward;
		if (dir == 3) sprite = Sprite.player_left;
		screen.renderPlayer(xx, yy, sprite);
	}
	
}
