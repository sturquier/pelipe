package controllers;

import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;

import entities.Player;

public class PlayerController implements KeyListener
{

	private Player player;
	
	public PlayerController(Player player) 
	{
		this.player = player;
	}
	
	@Override
	public boolean isAcceptingInput() 
	{
		return true;
	}
	
	@Override
	public void keyPressed(int key, char c) 
	{
		switch(key) {
			case Input.KEY_UP:
				this.player.setDirection(0);
				this.player.setMoving(true);
				break;
			case Input.KEY_LEFT:
				this.player.setDirection(1);
				this.player.setMoving(true);
				break;
			case Input.KEY_DOWN:
				this.player.setDirection(2);
				this.player.setMoving(true);
				break;
			case Input.KEY_RIGHT:
				this.player.setDirection(3);
				this.player.setMoving(true);
				break;
			case Input.KEY_SPACE:
				if (this.player.isMoving()) {
					this.player.setRunning(true);
				}
			}
	}

	@Override
	public void keyReleased(int key, char c)
	{
		switch(key) {
			case Input.KEY_UP:
				this.player.setMoving(false);
				break;
			case Input.KEY_LEFT:
				this.player.setMoving(false);
				break;
			case Input.KEY_DOWN:
				this.player.setMoving(false);
				break;
			case Input.KEY_RIGHT:
				this.player.setMoving(false);
				break;
			case Input.KEY_SPACE:
				this.player.setRunning(false);
		}
	}
	
	@Override
	public void inputEnded() {}

	@Override
	public void inputStarted() {}

	@Override
	public void setInput(Input input) {}	
}
