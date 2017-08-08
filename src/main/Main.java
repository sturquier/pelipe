package main;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

import states.MapState;

public class Main 
{

	public static void main(String[] args) throws SlickException
	{
		new AppGameContainer(new MapState(), 640, 480, false).start();
	}

}
