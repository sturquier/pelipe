package states;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

import controllers.PlayerController;
import entities.Player;

public class MapState extends BasicGame 
{
	private GameContainer container;
	private TiledMap map;

	private Player hero = new Player();
	
	public MapState()
	{
		super("Pelipe");
	}
	
	@Override
	public void init(GameContainer container) throws SlickException
	{
		this.container = container;
		this.map = new TiledMap("assets/maps/forest.tmx");
		
		this.hero.init(container);
		
		PlayerController playerController = new PlayerController(this.hero);
		container.getInput().addKeyListener(playerController);
	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException
	{
		this.map.render(0, 0);
		
		this.hero.render(container, g);
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException
	{
		this.hero.update(container, delta);
	}

}
