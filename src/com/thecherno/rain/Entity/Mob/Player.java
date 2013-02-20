package com.thecherno.rain.Entity.Mob;

import com.thecherno.rain.Graphics.Screen;
import com.thecherno.rain.Graphics.Sprite;
import com.thecherno.rain.Input.Keyboard;

public class Player extends Mob {

	private Keyboard input;
	private Sprite sprite;
	private int anim = 0;
	private boolean walking;
	private int anim_wait = 10;
	
	public Player(Keyboard input){
		this.input = input;
		sprite = Sprite.player_forward_1;
	}
	
	public Player(int x, int y, Keyboard input){
		this.x = x;
		this.y = y;
		this.input = input;
		sprite = Sprite.player_forward_1;
	}
	
	public void update(){
		if (walking){
			anim++;
		}
		if (anim > anim_wait * 4){
			anim = 0;
		}
		
		int xa=0, ya=0;
		if (input.up){ ya--; }
		if (input.down){ ya++; }
		if (input.left){ xa--; }
		if (input.right){ xa++; }
		if (xa != 0 || ya != 0){
			move (xa, ya);
			walking = true;
		} else {
			walking = false;
		}
	}
	
	public void render(Screen screen){
		int xx = x - 16;
		int yy = y - 16;
		
		if (anim < anim_wait){
			if (dir == 0) sprite = Sprite.player_forward_1;
			if (dir == 1) sprite = Sprite.player_right_1;
			if (dir == 2) sprite = Sprite.player_backward_1;
			if (dir == 3) sprite = Sprite.player_left_1;
		} else if (anim < anim_wait * 2) {
			if (dir == 0) sprite = Sprite.player_forward_2;
			if (dir == 1) sprite = Sprite.player_right_2;
			if (dir == 2) sprite = Sprite.player_backward_2;
			if (dir == 3) sprite = Sprite.player_left_2;
		} else if (anim < anim_wait * 3) {
			if (dir == 0) sprite = Sprite.player_forward_1;
			if (dir == 1) sprite = Sprite.player_right_1;
			if (dir == 2) sprite = Sprite.player_backward_1;
			if (dir == 3) sprite = Sprite.player_left_1;
		} else if (anim < anim_wait * 4) {
			if (dir == 0) sprite = Sprite.player_forward_3;
			if (dir == 1) sprite = Sprite.player_right_3;
			if (dir == 2) sprite = Sprite.player_backward_3;
			if (dir == 3) sprite = Sprite.player_left_3;
		}
		screen.renderPlayer(xx, yy, sprite);
	}
	
}
