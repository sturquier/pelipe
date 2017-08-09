package entities;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import map.Map;

public class Player
{
	
	private float x = 200, y = 300;
	private int direction = 2;
	private boolean moving = false;
	private boolean running = false;
	private Animation[] animations = new Animation[8];
	private Map map;
	
	public Player(Map map)
	{
		this.map = map;
	}
	
	public void init() throws SlickException
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
	
	public void render(Graphics g) throws SlickException
	{
		g.setColor(new Color(0, 0, 0, .5f));
	    g.fillOval(x - 16, y - 8, 32, 16);
	    g.drawAnimation(animations[direction + (moving ? 4 : 0)], x-32, y-60);
	}
	
	public void update(int delta) throws SlickException 
	{
		if (this.moving) {
	        float futurX = getFuturX(delta);
	        float futurY = getFuturY(delta);
	        boolean collision = this.map.isCollision(futurX, futurY);
	        if (collision) {
	            this.moving = false;
	        } else {
	            this.x = futurX;
	            this.y = futurY;
	        }
	    }
	}
	
	private float getFuturX(int delta) 
	{
	    float futurX = this.x;
	    float speed = this.running ? .2f : .1f;
	    
	    switch (this.direction) {
	    	case 1: 
	    		futurX = this.x - speed * delta; 
	    		break;
	    	case 3: 
	    		futurX = this.x + speed * delta; 
	    		break;
	    }
	    
	    return futurX;
	}

	private float getFuturY(int delta)
	{
	    float futurY = this.y;
	    float speed = this.running ? .2f : .1f;
	    
	    switch (this.direction) {
	    	case 0: 
	    		futurY = this.y - speed * delta;
	    		break;
	    	case 2: 
	    		futurY = this.y + speed * delta;
	    		break;
	    }
	    
	    return futurY;
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
	
	public void setDirection(int direction)
	{
		this.direction = direction;
	}
	
	public boolean isMoving()
	{
		return this.moving;
	}
	
	public void setMoving(boolean moving)
	{
		this.moving = moving;
	}

	public boolean isRunning()
	{
		return running;
	}

	public void setRunning(boolean running)
	{
		this.running = running;
	}
}
