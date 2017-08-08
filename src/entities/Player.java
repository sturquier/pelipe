package entities;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Player
{
	
	private float x = 200, y = 300;
	private int direction = 2;
	private boolean moving = false;
	private Animation[] animations = new Animation[8];
	
	public void init(GameContainer gc) throws SlickException
	{
		SpriteSheet spriteSheet = new SpriteSheet("assets/sprites/hero/archer_walk.png", 64, 64);
		
		this.animations[0] = loadAnimation(spriteSheet, 0, 1, 0);
		this.animations[1] = loadAnimation(spriteSheet, 0, 1, 1);
		this.animations[2] = loadAnimation(spriteSheet, 0, 1, 2);
		this.animations[3] = loadAnimation(spriteSheet, 0, 1, 3);
		this.animations[4] = loadAnimation(spriteSheet, 1, 9, 0);
		this.animations[5] = loadAnimation(spriteSheet, 1, 9, 1);
		this.animations[6] = loadAnimation(spriteSheet, 1, 9, 2);
		this.animations[7] = loadAnimation(spriteSheet, 1, 9, 3);
	}
	
	public void render(GameContainer container, Graphics g) throws SlickException
	{
		g.setColor(new Color(0, 0, 0, .5f));
	    g.fillOval(x - 16, y - 8, 32, 16);
	    g.drawAnimation(animations[direction + (moving ? 4 : 0)], x-32, y-60);
	}
	
	public void update(GameContainer container, int delta) throws SlickException 
	{
	    if (this.moving) {
	        switch (this.direction) {
	            case 0: 
	            	this.y -= .1f * delta;
	            	break;
	            case 1:
	            	this.x -= .1f * delta;
	            	break;
	            case 2:
	            	this.y += .1f * delta;
	            	break;
	            case 3:
	            	this.x += .1f * delta;
	            	break;
	        }
	    }
	}
	
	private Animation loadAnimation(SpriteSheet spriteSheet, int startX, int endX, int y)
	{
		Animation animation = new Animation();
		
		for (int x = startX; x < endX; x++) {
			animation.addFrame(spriteSheet.getSprite(x, y), 100);
		}
		
		return animation;
	}
	
	public int getDirection()
	{
		return this.direction;
	}
	
	public boolean isMoving()
	{
		return this.moving;
	}
	
	public void setDirection(int direction)
	{
		this.direction = direction;
	}
	
	public void setMoving(boolean moving)
	{
		this.moving = moving;
	}
}
