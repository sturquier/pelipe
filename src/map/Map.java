package map;

import org.newdawn.slick.Color;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;
import org.newdawn.slick.Image;

public class Map 
{
	private TiledMap map;
	
	public void init() throws SlickException
	{
		this.map = new TiledMap("assets/maps/forest.tmx");
	}
	
	public void renderBackground()
	{
	    this.map.render(0, 0, 0);
	    this.map.render(0, 0, 1);
	    
	 }
	
	public void renderForeground()
	{
		this.map.render(0, 0, 2);
	}
	
	public boolean isCollision(float x, float y) 
	{
	    int tileW = this.map.getTileWidth();
	    int tileH = this.map.getTileHeight();
	    int logicLayer = this.map.getLayerIndex("logic");
	    Image tile = this.map.getTileImage((int) x / tileW, (int) y / tileH, logicLayer);
	    boolean collision = tile != null;
	    if (collision) {
	        Color color = tile.getColor((int) x % tileW, (int) y % tileH);
	        collision = color.getAlpha() > 0;
	    }
	    return collision;
	}
}
