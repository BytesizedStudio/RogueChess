package com.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.framework.GameState;
import com.game.Board;

public abstract class Interactables extends Sprite{
	protected int xPos, yPos, x, y;
	protected Texture texture;
	protected SpriteBatch batch;
	
	public Interactables(int c, int r) {
		xPos = c;
		yPos = r;
		x = c * 32;
		y = r * 32;
	}
	
	public void setPos(int c, int r) {
		if(!Board.isFirstRoom)
			Board.getBoard().getSpaces()[xPos][yPos].setEntity(null);
		xPos = c;
		yPos = r;
		if(!Board.isFirstRoom)
			Board.getBoard().getSpaces()[xPos][yPos].setEntity(this);
		x = c * 32;
		y = r * 32;
	}

	public void render(SpriteBatch batch, float delta) {
		update(delta);
		batch.draw(texture, x, y + 8);
	}
	
	public void update(float delta) {
		if(x > xPos * 32)
			x -= 2;
		if(x < xPos * 32)
			x += 2;
		if(y > yPos * 32)
			y -= 2;
		if(y < yPos * 32)
			y += 2;
	}
	
	public void setXCord(int n) {
		x = n;
	}
	
	public void setYCord(int n) {
		y = n;
	}
	
	public int getXCord() {
		return x;
	}

	public int getYCord() {
		return y;
	}

	public int getxPos() {
		return xPos;
	}

	public int getyPos() {
		return yPos;
	}

	
	
	
}
