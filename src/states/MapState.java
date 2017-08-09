package states;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import controllers.PlayerController;
import entities.Player;
import map.Map;

public class MapState extends BasicGame 
{
	private GameContainer container;
	private Map map = new Map();
	private Player hero = new Player(map);
	
	public MapState()
	{
		super("Pelipe");
	}
	
	@Override
	public void init(GameContainer container) throws SlickException
	{
		this.container = container;
		this.map.init();
		this.hero.init();
		
		PlayerController playerController = new PlayerController(this.hero);
		container.getInput().addKeyListener(playerController);
	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException
	{	
		this.map.renderBackground();
		this.hero.render(g);
		this.map.renderForeground();
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException
	{
		this.hero.update(delta);
	}

}
